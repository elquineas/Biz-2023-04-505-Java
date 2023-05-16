package com.callor.student.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.callor.student.models.StudentDto;
import com.callor.student.utils.Config;
import com.callor.student.utils.Line;

public class StudentServiceImplV2 extends StudentServiceImplV1{
	
	@Override
	public void insertStudent() {
//		super.insertStudent();
		while(true) {
			StudentDto stDto = this.inputStudent();
//			if(stDto == null) {
//				break;
//			}else if(stDto.stNum == null){
//				continue;
//			};
			if(stDto == null) {
				break;
			}
			int index = 0;
			for(index = 0; index< stList.size(); index++){
				if(stList.get(index) == stDto) {
					break;
				}
			}
			if(index >= stList.size()) {
				stList.add(stDto);
			}
//			stList.add(stDto);
		}
		
		OutputStream os = null;
		PrintWriter out = null;
		
		try {
			os = new FileOutputStream(Config.STUDENT_FILE);
			out = new PrintWriter(os);
			
			for(StudentDto sDto : stList) {
				out.printf("%s,",sDto.stNum);
				out.printf("%s,",sDto.stName);
				out.printf("%s,",sDto.stDept);
				out.printf("%d,",sDto.stGrade);
				out.printf("%s\n",sDto.stTel);
			}
			out.close();
			os.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void loadStudent() {
		super.loadStudent();
		InputStream is = null;
		Scanner scan = null;
		
		try {
			is = new FileInputStream(Config.STUDENT_FILE);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		scan = new Scanner(is);
		stList = new ArrayList<>();
		while(scan.hasNext()) {
			String line = scan.nextLine();
			String[] student = line.split(",");
			StudentDto stDto = new StudentDto();
			
			stDto.stNum   = student[0];
			stDto.stName  = student[1];
			stDto.stDept  = student[2];
			stDto.stGrade = Integer.valueOf(student[3]);
			stDto.stTel   = student[4];
			stList.add(stDto);
		}
		scan.close();
	}
	@Override
	public void printStudent() {
		super.printStudent();
	}
	
	protected StudentDto inputStudent() {
		System.out.println("학생 정보 추가(종료/QUIT)");
		System.out.println(Line.sLine(60));
		
		String stNum = "";
		String yn = "N";
		int num = 0;
		StudentDto sDto = new StudentDto();
		while(true) {
			yn = "N";
			System.out.print("학번(정수) >> ");
			stNum = scan.nextLine();
			try {
				num = (Integer.valueOf(stNum));
				stNum = String.format("%04d",num);
				
				for(StudentDto dto : stList) {
					if(dto.stNum.equals(stNum)) {
						sDto = dto;
						yn = "Y";
						break;
					}
				}
			} catch (Exception e) {
				if(stNum.toUpperCase().equals("QUIT")) break;
				System.out.println("숫자를 입력해주세요");
			}
			if(num > 0 && num<10000) break;
		}
		if(stNum.toUpperCase().equals("QUIT")) return null;
		
		String stName;
		String stDept;
		String grade;
		String stTel;
		
		if(yn.toUpperCase().equals("Y")) {
			System.out.print("이름("+sDto.stName+") >> ");
			stName = scan.nextLine();
			if(stName.equals("")) {
				stName = sDto.stName;
			}
			if(stName.toUpperCase().equals("QUIT")) return null;
			
			System.out.print("학과("+sDto.stDept+") >> ");
			stDept = scan.nextLine();
			if(stDept.equals("")) {
				stDept = sDto.stDept;
			}
			if(stDept.toUpperCase().equals("QUIT")) return null;
			
			while(true) {
				System.out.print("학년("+sDto.stGrade+") >> ");
				grade = scan.nextLine();
				int grade1 = 0;
				try {
					if(sDto.stGrade != 0 && grade.equals("")) {
						grade1 = sDto.stGrade;
					}else {
						grade1 = (Integer.valueOf(grade));
					}
				} catch (Exception e) {
					System.out.println("숫자를 입력해주세요");
				}
				if(grade.toUpperCase().equals("QUIT") || (grade1 > 0 && grade1 < 5)) break;
				if(grade1 < 1 || grade1 > 4) {
					System.out.println("1~4 사이의 수를 입력해야합니다.");
					continue;
				}
			}
			if(grade.toUpperCase().equals("QUIT")) return null;
			
			System.out.print("전화번호("+sDto.stTel+") >> ");
			stTel = scan.nextLine();
			if(stTel.equals("")) {
				stTel = sDto.stTel;
			}
			if(stTel.toUpperCase().equals("QUIT")) return null;
		}else {
			System.out.print("이름 >> ");
			stName = scan.nextLine();
			if(stName.toUpperCase().equals("QUIT")) return null;
			
			System.out.print("학과 >> ");
			stDept = scan.nextLine();
			if(stDept.toUpperCase().equals("QUIT")) return null;
			
			while(true) {
				System.out.print("학년 >> ");
				grade = scan.nextLine();
				int grade1 = 0;
				try {
					grade1 = (Integer.valueOf(grade));
				} catch (Exception e) {
					System.out.println("숫자를 입력해주세요");
				}
				if(grade.toUpperCase().equals("QUIT") || (grade1 > 0 && grade1 < 5)) break;
				if(grade1 < 1 || grade1 > 4) {
					System.out.println("1~4 사이의 수를 입력해야합니다.");
					continue;
				}
			}
			if(grade.toUpperCase().equals("QUIT")) return null;
			
			System.out.print("전화번호 >> ");
			stTel = scan.nextLine();
			if(stTel.toUpperCase().equals("QUIT")) return null;
		}
		
		sDto.stNum   = stNum;
		sDto.stName  = stName;
		sDto.stDept  = stDept;
		sDto.stGrade = Integer.valueOf(grade);
		sDto.stTel   = stTel;
		
		System.out.println(Line.sLine(60));
		return sDto;
	}
	
	public void deleteStudent() {
		String yn = "N";
		int num = 0;
		int index = 0;
		
		System.out.print("삭제할 학번(Enter : 종료) >> ");
		String stNum = scan.nextLine();
		if(stNum.equals("")) {
			return;
		}
		try {
			num = (Integer.valueOf(stNum));
			stNum = String.format("%04d",num);
			for(StudentDto dto : stList) {
				if(dto.stNum.equals(stNum)) {
					System.out.print("정말 삭제할까요?(Y/N) >>>");
					yn = scan.nextLine();
					break;
				}
				if(index >= stList.size()-1) {
					System.out.println("학번을 확인하세요");
				}
				index++;
			}
		} catch (Exception e) {
			System.out.println("숫자를 입력해주세요");
		}
		
		if(yn.equals("Y")) {
			System.out.printf("%s학번 학생 데이터를 삭제했습니다.",stNum);
			stList.remove(index);
		}		
		
		OutputStream os = null;
		PrintWriter out = null;
		
		try {
			os = new FileOutputStream(Config.STUDENT_FILE);
			out = new PrintWriter(os);
			
			for(StudentDto sDto : stList) {
				out.printf("%s,",sDto.stNum);
				out.printf("%s,",sDto.stName);
				out.printf("%s,",sDto.stDept);
				out.printf("%d,",sDto.stGrade);
				out.printf("%s\n",sDto.stTel);
			}
			out.close();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	protected StudentDto inputStudent() {
//		System.out.println("학생 정보 추가(종료/QUIT)");
//		System.out.println(Line.sLine(60));
//		
//		String stNum = "";
//		String yn = "N";
//		int num = 0;
//		int index = 0;
//		StudentDto sDto = new StudentDto();
//		while(true) {
//			yn = "N";
//			System.out.print("학번(정수) >> ");
//			stNum = scan.nextLine();
//			try {
//				num = (Integer.valueOf(stNum));
//				stNum = String.format("%04d",num);
//				
//				for(StudentDto dto : stList) {
//					if(dto.stNum.equals(stNum)) {
////						System.out.printf("%s\t",dto.stNum);
////						System.out.printf("%s\t",dto.stName);
////						System.out.printf("%s\t",dto.stDept);
////						System.out.printf("%d\t",dto.stGrade);
////						System.out.printf("%s\n",dto.stTel);
////						System.out.println("이미 있는 학번입니다. 수정하시겠습니까?(Y/N)");
//						sDto = dto;
//						yn = "Y";
//						break;
//						// sDto = dto 
//						// list에 있는 dto 주소값을 sDto에 주는 것이므로
//						// sDto를 수정해도 stList의 주소값에 있는 데이터가 수정된다
//					}
//					index++;
//				}
//			} catch (Exception e) {
//				if(stNum.toUpperCase().equals("QUIT")) break;
//				System.out.println("숫자를 입력해주세요");
//			}
//			if(num > 0 && num<10000) break;
//		}
//		if(stNum.toUpperCase().equals("QUIT")) return null;
//		
//		String stName = "";
//		String stDept = "";
//		String grade = "";
//		String stTel = "";
//		if(yn.toUpperCase().equals("Y")) {
//			System.out.print("이름("+sDto.stName+") >> ");
//			stName = scan.nextLine();
//			if(stName.equals("")) {
//				stName = sDto.stName;
//			}
//			if(stName.toUpperCase().equals("QUIT")) return null;
//			
//			System.out.print("학과("+sDto.stDept+") >> ");
//			stDept = scan.nextLine();
//			if(stDept.equals("")) {
//				stDept = sDto.stDept;
//			}
//			if(stDept.toUpperCase().equals("QUIT")) return null;
//			
//			while(true) {
//				System.out.print("학년("+sDto.stGrade+") >> ");
//				grade = scan.nextLine();
//				int grade1 = 0;
//				try {
//					grade1 = (Integer.valueOf(grade));
//					if(grade.equals("")) {
//						grade1 = sDto.stGrade;
//					}
//				} catch (Exception e) {
//					System.out.println("숫자를 입력해주세요");
//				}
//				if(grade.toUpperCase().equals("QUIT") || (grade1 > 0 && grade1 < 5)) break;
//				if(grade1 < 1 || grade1 > 4) {
//					System.out.println("1~4 사이의 수를 입력해야합니다.");
//					continue;
//				}
//			}
//			if(grade.toUpperCase().equals("QUIT")) return null;
//			
//			System.out.print("전화번호("+sDto.stTel+") >> ");
//			stTel = scan.nextLine();
//			if(stTel.equals("")) {
//				stTel = sDto.stTel;
//			}
//			if(stTel.toUpperCase().equals("QUIT")) return null;
//		}else {
//			System.out.print("이름 >> ");
//			stName = scan.nextLine();
//			if(stName.toUpperCase().equals("QUIT")) return null;
//			
//			System.out.print("학과 >> ");
//			stDept = scan.nextLine();
//			if(stDept.toUpperCase().equals("QUIT")) return null;
//			
//			while(true) {
//				System.out.print("학년 >> ");
//				grade = scan.nextLine();
//				int grade1 = 0;
//				try {
//					grade1 = (Integer.valueOf(grade));
//				} catch (Exception e) {
//					System.out.println("숫자를 입력해주세요");
//				}
//				if(grade.toUpperCase().equals("QUIT") || (grade1 > 0 && grade1 < 5)) break;
//				if(grade1 < 1 || grade1 > 4) {
//					System.out.println("1~4 사이의 수를 입력해야합니다.");
//					continue;
//				}
//			}
//			if(grade.toUpperCase().equals("QUIT")) return null;
//			
//			System.out.print("전화번호 >> ");
//			stTel = scan.nextLine();
//			if(stTel.toUpperCase().equals("QUIT")) return null;
//		}
//		
//		if(yn.toUpperCase().equals("Y")) {
//			stList.get(index).stNum = stNum;
//			stList.get(index).stName = stName;
//			stList.get(index).stDept = stDept;
//			stList.get(index).stGrade = Integer.valueOf(grade);
//			stList.get(index).stTel = stTel;
//		}else {
//			sDto.stNum   = stNum;
//			sDto.stName  = stName;
//			sDto.stDept  = stDept;
//			sDto.stGrade = Integer.valueOf(grade);
//			sDto.stTel   = stTel;
//		}
//		
////		stList.add(sDto);
//		System.out.println(Line.sLine(60));
//		return sDto;
//	}
	
//	@Override
//	public void insertStudent() {
//		String studentFile = "src/com/callor/student/student.txt";
//		Scanner scan = new Scanner(System.in);
//		OutputStream os = null;
//		PrintWriter out = null;
//		
//		try {
//			os = new FileOutputStream(studentFile);
//			out = new PrintWriter(os);
//			System.out.println(Line.dLine(60));
//			System.out.println("학생 정보 추가(종료/QUIT)");
//			System.out.println(Line.sLine(60));
//			while(true) {
//				System.out.print("학번 >> ");
//				String stNum = scan.nextLine();
//				if(stNum.equals("QUIT")) break;
//				
//				System.out.print("이름 >> ");
//				String stName = scan.nextLine();
//				if(stName.equals("QUIT")) break;
//				
//				System.out.print("학과 >> ");
//				String stDept = scan.nextLine();
//				if(stDept.equals("QUIT")) break;
//				
//				String grade;
//				while(true) {
//					System.out.print("학년 >> ");
//					grade = scan.nextLine();
//					int grade1 = 0;
//					try {
//						grade1 = (Integer.valueOf(grade));
//					} catch (Exception e) {
//						System.out.println("숫자를 입력해주세요");
//					}
//					if(grade.equals("QUIT") || (grade1 > 0 && grade1 < 5)) break;
//					if(grade1 < 1 || grade1 > 4) {
//						System.out.println("1~4 사이의 수를 입력해야합니다.");
//						continue;
//					}
//				}
//				if(grade.equals("QUIT")) break;
//				
//				System.out.print("전화번호 >> ");
//				String stTel = scan.nextLine();
//				if(stTel.equals("QUIT")) break;
//				
//				StudentDto sDto = new StudentDto();
//				sDto.stNum   = stNum;
//				sDto.stName  = stName;
//				sDto.stDept  = stDept;
//				sDto.stGrade = Integer.valueOf(grade);
//				sDto.stTel   = stTel;
//				stList.add(sDto);
//				System.out.println(Line.sLine(60));
//			}
//			
//			for(StudentDto sDto : stList) {
//				out.printf("%s,",sDto.stNum);
//				out.printf("%s,",sDto.stName);
//				out.printf("%s,",sDto.stDept);
//				out.printf("%s,",sDto.stGrade);
//				out.printf("%s\n",sDto.stTel);
//			}
//			out.close();
//			os.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
}
