package com.elquineas.memo.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.elquineas.memo.config.DBConnection;
import com.elquineas.memo.config.MemoInfo;
import com.elquineas.memo.mapper.MemoDao;
import com.elquineas.memo.models.MemoDto;
import com.elquineas.memo.utils.AnsiConsol;

public class MemoService {
	private static SqlSession sqlSession;
	private static MemoDao memoDao;
	private static Scanner scan;
	
	public MemoService() {
		sqlSession = DBConnection.getFactory().openSession(true);
		memoDao = sqlSession.getMapper(MemoDao.class);
		scan = new Scanner(System.in);
	}
	
	public void startMemo() {
		while(true) {
			MemoInfo.headerPrint();
			System.out.print(">> ");
			String str = scan.nextLine();
			if(str.equals("1")) {
				selectAll();
			}else if(str.equals("2")) {
				insert();
			}else if(str.equals("3")) {
				update();
			}else if(str.equals("4")) {
				delete();
			}else if(str.equals("5")) {
				serch();
			}else if(str.equals("9")) {
				System.out.println(AnsiConsol.BLUE("종료합니다."));
				return;
			}else {
				System.out.println(AnsiConsol.RED("선택지 번호만 입력해주세요."));
				continue;
			}
		}
	}
	
	
	
	public void memoListView(List<MemoDto> memoList) {
		System.out.println("No\t작성자\t작성일자\t제목");
		System.out.println("-".repeat(100));
		int intNum = 0;
		for(MemoDto dto : memoList) {
			System.out.printf("%s\t",dto.m_seq);
			System.out.printf("%s\t",dto.m_writer);
			System.out.printf("%s\t",dto.m_date);
			System.out.printf("%s\n",dto.m_subject);
			intNum++;
			if(intNum %5 == 0 && intNum >= memoList.size()) {
				System.out.println(".".repeat(100));
			}
		}
		System.out.println("=".repeat(100));
		System.out.print("상세보기할 메모 번호를 입력해주세요 (미입력시 안보기) >>> ");
		String strNum = scan.nextLine();
		if(strNum.equals("")) {
			return;
		}
		viewMemo(strNum);
	}
	
	public void selectAll() {
		List<MemoDto> memoList = memoDao.selectAll();
		System.out.println("=".repeat(100));
		System.out.println("메모 리스트");
		System.out.println("-".repeat(100));
		memoListView(memoList);
	}
	
	public void viewMemo(String strNum) {
		System.out.println("메모 상세보기");
		System.out.println("-".repeat(100));
		List<MemoDto> memoList = memoDao.serch(strNum);
		if(memoList.size() < 1){
			System.out.printf(AnsiConsol.RED("해당번호 메모가 없습니다.(%s)\n"),strNum);
			return;
		}
		MemoDto mDto = memoList.get(0);
		
		System.out.println("=".repeat(100));
		System.out.printf("작성자   : %s\n",mDto.m_writer);
		System.out.printf("작성일자 : %s\n",mDto.m_date);
		System.out.printf("제목     : %s\n",mDto.m_subject);
		System.out.printf("내용     : %s\n",mDto.m_content);
		System.out.println("=".repeat(100));
		
		System.out.println("("+AnsiConsol.YELLOW("엔터")+"를 누르면 넘어갑니다)");
		String temp = scan.nextLine();
		
	}
	
	public void insert() {
		MemoDto mDto = new MemoDto();
		System.out.println("=".repeat(100));
		System.out.println("메모 작성");
		System.out.println("-".repeat(100));
		System.out.printf("작성자   >>> ");
		String strWriter = scan.nextLine();
		String today = getTodayDate();
		System.out.printf("작성일자 >>> %s\n",today);
		System.out.print("제목     >>> ");
		String strSubject = scan.nextLine();
		System.out.print("내용     >>> ");
		String strContent = scan.nextLine();
		System.out.println("-".repeat(100));
		mDto.m_writer  = strWriter;
		mDto.m_date    = today;
		mDto.m_subject = strSubject;
		mDto.m_content = strContent;
		int result = memoDao.insert(mDto);
		if(result > 0) {
			System.out.println(AnsiConsol.BLUE("메모를 작성하였습니다."));
		}else {
			System.out.println(AnsiConsol.RED("메모작성을 실패하였습니다."));
		}
	}
	
	public void update() {
		System.out.println("=".repeat(100));
		System.out.print("수정할 메모 번호 >>> ");
		String strNum = scan.nextLine();
		List<MemoDto> memoList = memoDao.serch(strNum);
		if(memoList.size() < 1){
			System.out.printf(AnsiConsol.RED("해당번호가 다시 맞는지 확인해주세요.(%s)\n"),strNum);
			return;
		}
		MemoDto mDto = memoList.get(0);
		System.out.println("=".repeat(100));
		System.out.println("메모 수정");
		System.out.println("-".repeat(100));
		
		System.out.printf("작성자 (%s)\n",mDto.m_writer);
		System.out.print(">>> ");
		String strWriter = scan.nextLine();
		if(strWriter.equals("")) mDto.m_writer = mDto.m_writer;
		else mDto.m_writer  = strWriter;
		
		System.out.printf("작성일자 (%s)\n",mDto.m_date);
		
		System.out.printf("제목 (%s)\n",mDto.m_subject);
		System.out.print(">>> ");
		String strSubject = scan.nextLine();
		if(strSubject.equals("")) mDto.m_subject = mDto.m_subject+"(수정)";
		else mDto.m_subject  = strSubject+"(수정)";
		
		System.out.printf("내용 (%s)\n",mDto.m_content);
		System.out.print(">>> ");
		String strContent = scan.nextLine();
		if(strContent.equals("")) mDto.m_content = mDto.m_content;
		else mDto.m_content  = strContent;
		System.out.println("-".repeat(100));
		
		int result = memoDao.update(mDto);
		if(result > 0) {
			System.out.println(AnsiConsol.BLUE("메모를 수정하였습니다."));
		}else {
			System.out.println(AnsiConsol.RED("메모수정을 실패하였습니다."));
		}
		
	}
	public void delete() {
		System.out.println("=".repeat(100));
		System.out.println("메모 삭제");
		System.out.println("-".repeat(100));
		System.out.print("삭제할 번호를 입력해주세요 >>> ");
		String strNum = scan.nextLine();
		List<MemoDto> memoList = memoDao.serch(strNum);
		if(memoList.size() < 1){
			System.out.printf(AnsiConsol.RED("해당번호가 다시 맞는지 확인해주세요.(%s)\n"),strNum);
			return;
		}else {
			System.out.print(AnsiConsol.RED("정말로 삭제하시겠습니가?(Y/N) >>> "));
			String strYn = scan.nextLine();
			if(strYn.equals("N")) {
				System.out.println(AnsiConsol.BLUE("삭제를 취소하였습니다."));
				return;
			}else if(strYn.equals("Y")) {
				
			}else {
				System.out.printf(AnsiConsol.RED("메모삭제를 실패하였습니다.")+"(입력 : %s)\n",strYn);
				return;
			}
		}
		int result = memoDao.delete(strNum);
		if(result > 0) {
			System.out.println(AnsiConsol.BLUE("메모를 삭제하였습니다."));
		}else {
			System.out.println(AnsiConsol.RED("메모삭제를 실패하였습니다."));
		}
		
		
	}
	
	public void serch() {
		System.out.println("=".repeat(100));
		System.out.println("입력단어가 포함된 메모를 검색합니다");
		System.out.println("-".repeat(100));
		System.out.print("찾을 단어를 입력해주세요 >>> ");
		String strText = scan.nextLine();
		System.out.println("-".repeat(100));
		List<MemoDto> memoList = memoDao.serchText(strText);
		memoListView(memoList);		
	}
	
	protected String getTodayDate() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat todayFormat = new SimpleDateFormat("YYYY-MM-dd");
		String todayString = todayFormat.format(date);
		return todayString;
	}
	protected String getTodayTime() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat timeFormat  = new SimpleDateFormat("HH:mm:ss");
		String timeString  = timeFormat.format(date);
		return timeString;
	}
	
}
