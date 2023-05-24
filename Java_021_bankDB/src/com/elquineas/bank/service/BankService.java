package com.elquineas.bank.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.elquineas.bank.config.DBContract;
import com.elquineas.bank.models.AccDto;
import com.elquineas.bank.models.BuyerDto;
import com.elquineas.bank.service.impl.AccServiceImplV1;
import com.elquineas.bank.service.impl.BuyerServiceImplV1;

public class BankService {
	protected List<BuyerDto> buyerList;
	protected final BuyerService buService;
	protected List<AccDto> accList;
	protected final AccService accService;
	protected final Scanner scan;
	
	public BankService() {
		buyerList  = new ArrayList<>();
		buService  = new BuyerServiceImplV1();
		accList    =  new ArrayList<>();
		accService =  new AccServiceImplV1();
		scan = new Scanner(System.in);
	}
	
	public void printBuyerList() {
		buyerList = buService.selectAll();
		System.out.println("=".repeat(100));
		System.out.println("대한은행 고객 리스트");
		System.out.println("=".repeat(100));
		System.out.println("ID\t이름\t전화번호\t주소\t\t생년월일\t직업");
		System.out.println("-".repeat(100));
		for(BuyerDto bDto : buyerList) {
			System.out.printf("%s\t",bDto.buId);
			System.out.printf("%s\t",bDto.buName);
			System.out.printf("%s\t",bDto.buTel);
			System.out.printf("%s\t",bDto.buAddr);
			System.out.printf("%s\t",bDto.buBirth);
			System.out.printf("%s\n",bDto.buJob);
		}	
		System.out.println("=".repeat(100));
	}
	
	public void findByBuyer() {
		System.out.println("=".repeat(100));
		System.out.println("조회하려는 고객ID를 입력하세요");
		System.out.print("ID >>> ");
		String strId = scan.nextLine();
		BuyerDto buyerDto = buService.findById(strId);
		if(buyerDto == null) {
			System.out.println("조회한 고객ID는 없는 데이터 입니다.");
		}else {
			System.out.println(buyerDto.toString());
		}
	}
	
	public void insertBuyer() {
		System.out.println("=".repeat(100));
		System.out.println("고객정보 등록");
		System.out.println("=".repeat(100));
		
		System.out.print("ID >>> ");
		String strId = scan.nextLine();
		System.out.print("고객명 >>> ");
		String strName = scan.nextLine();
		System.out.print("전화번호 >>> ");
		String strTel = scan.nextLine();
		
		BuyerDto buyerDto = new BuyerDto();
		buyerDto.buId = strId;
		buyerDto.buName = strName;
		buyerDto.buTel = strTel;
		
		buService.insert(buyerDto);
	}
	
	public void deleteBuyer() {
		System.out.println("=".repeat(100));
		System.out.println("삭제할 고객ID를 입력하세요");
		System.out.println("=".repeat(100));
		System.out.print("ID >>> ");
		String strId = scan.nextLine();
		
		BuyerDto buyerDto = buService.findById(strId);
		if(buyerDto == null) {
			System.out.printf("%s 고객ID는 없는 정보입니다.", strId);
		}else {
			System.out.println(buyerDto.toString());
			System.out.println("고객정보를 정말로 삭제할까요? (YES/NO)");
			String strYn = scan.nextLine();
			if(strYn.equals("YES")) {
				int result = buService.delete(strId);
				if(result > 0 ) {
					System.out.println("고객정보를 삭제했습니다.");
				}else {
					System.out.println("고객정보를 삭제하지 못했습니다.");
				}
			}else {
				System.out.println("고객정보 삭제를 취소했습니다.");
			}
		}
	}
	
	public void update() {
		while(true) {
			System.out.println("수정할 고객 ID를 입력하세요(취소 : QUIT)");
			System.out.print(">>> ");
			String strId = scan.nextLine();
			if(strId.equals("QUIT")){
				break;
			}
			BuyerDto buyerDto = buService.findById(strId);
			if(buyerDto == null) {
				System.out.printf("%s 고객ID는 없는 정보입니다.", strId);
				continue;
			}
			System.out.println(buyerDto.toString());
			System.out.printf("고객ID >> %s\n",buyerDto.buId);
			System.out.printf("고객이름(%s) >> ",buyerDto.buName);
			String strName = scan.nextLine();
			if( !strName.equals("") ) { buyerDto.buName = strName; }
			System.out.printf("전화번호(%s) >> ",buyerDto.buTel);
			String strTel = scan.nextLine();
			if( !strTel.equals("") ) { buyerDto.buTel = strTel; }
			System.out.printf("주소(%s) >> ",buyerDto.buAddr);
			String strAddr = scan.nextLine();
			if( !strAddr.equals("") ) { buyerDto.buAddr = strAddr; }
			System.out.printf("생년월일(%s) >> ",buyerDto.buBirth);
			String strBirth = scan.nextLine();
			if( !strBirth.equals("") ) { buyerDto.buBirth = strBirth; }
			System.out.printf("직업(%s) >> ",buyerDto.buJob);
			String strJob = scan.nextLine();
			if( !strJob.equals("") ) { buyerDto.buJob = strJob; }
			
			int result = buService.update(buyerDto);
			if(result > 0 ) System.out.println("변경 성공");
			else System.out.println("변경 실패");
			
		}
	}
	
//=============================================== ACC ===============================================
	
	public void printAccList() {
		accList = accService.selectAll();
		System.out.println("=".repeat(100));
		System.out.println("대한은행 계좌 리스트");
		System.out.println("=".repeat(100));
		printAcc(accList);
		System.out.println("=".repeat(100));
	}
	
	public void printAcc(List<AccDto> accList) {
		System.out.println("계좌번호\t용도\t아이디\t잔액\t");
		System.out.println("-".repeat(100));
		for(AccDto accDto : accList) {
			System.out.printf("%s\t",accDto.acNum);
			if(accDto.acDiv.equals("1")) System.out.printf("%s\t","입출금");
			else if(accDto.acDiv.equals("2")) System.out.printf("%s\t","적금");
			else if(accDto.acDiv.equals("3")) System.out.printf("%s\t","대출");
			System.out.printf("%s\t",accDto.acBuId);
			System.out.printf("%s\n",accDto.acBalance);
		}
	}
	
	
	public void findByAcc() {
		System.out.println("=".repeat(100));
		System.out.println("조회할 아이디를 입력해주세요.");
		System.out.print(">>>");
		String id = scan.nextLine();
		accList = accService.findById(id);
		
		if(accList == null) {
			System.out.println("조회한 고객ID는 없는 데이터 입니다.");
		}else {
			System.out.println("=".repeat(100));
			System.out.println("ID조회 계좌 리스트");
			System.out.println("=".repeat(100));
			printAcc(accList);
			System.out.println("=".repeat(100));
		}
	}
	
	public void findByUserInfo() {
		System.out.println("=".repeat(100));
		System.out.println("조회하려는 고객ID를 입력하세요");
		System.out.print("ID >>> ");
		String strId = scan.nextLine();
		BuyerDto buyerDto = buService.findById(strId);
		accList = accService.findById(strId);
		if(buyerDto == null) {
			System.out.println("조회한 고객ID는 없는 데이터 입니다.");
			return;
		}else {
			System.out.println("=".repeat(100));
			System.out.println("고객 정보(계좌) 리스트");
			System.out.println("=".repeat(100));
			printUserInfo(buyerDto);
		}
	}

	public void printUserInfo(BuyerDto bDto) {
		System.out.println("ID\t이름\t전화번호\t주소\t\t생년월일\t직업\t계좌번호\t용도\t잔액");
		System.out.println("-".repeat(100));
		if(accList.size() > 0) {
			for(AccDto accDto : accList) {
				System.out.printf("%s\t",bDto.buId);
				System.out.printf("%s\t",bDto.buName);
				System.out.printf("%s\t",bDto.buTel);
				System.out.printf("%s\t",bDto.buAddr);
				System.out.printf("%s\t",bDto.buBirth);
				System.out.printf("%s\t",bDto.buJob);
				System.out.printf("%s\t",accDto.acNum);
				int intDiv = Integer.valueOf(accDto.acDiv);
				System.out.printf("%s\t",DBContract.ACC_DIV[intDiv - 1]);
//				if(accDto.acDiv.equals("1")) System.out.printf("%s\t","입출금");
//				else if(accDto.acDiv.equals("2")) System.out.printf("%s\t","적금");
//				else if(accDto.acDiv.equals("3")) System.out.printf("%s\t","대출");
				System.out.printf("%s\n",accDto.acBalance);
			}
		} else {
			System.out.printf("%s\t",bDto.buId);
			System.out.printf("%s\t",bDto.buName);
			System.out.printf("%s\t",bDto.buTel);
			System.out.printf("%s\t\t",bDto.buAddr);
			System.out.printf("%s\t\t",bDto.buBirth);
			System.out.printf("%s\t",bDto.buJob);
			System.out.printf("-\t\t");
			System.out.printf("-\t");
			System.out.printf("-\n");
		}
		
	}
	
	public void makeAcount() {
		System.out.println("=".repeat(100));
		System.out.println("계좌를 생성하려는 고객ID를 입력하세요");
		System.out.print("ID >>> ");
		String strId = scan.nextLine();
		BuyerDto buyerDto = buService.findById(strId);
		if(buyerDto == null) {
			System.out.println("조회한 고객ID는 없는 데이터 입니다.");
			return;
		}else {
			System.out.println("=".repeat(100));
			System.out.println("계좌를 생성합니다");
			AccDto accDto = new AccDto(); 
			accDto.acNum = getNewAccNum();
			System.out.printf("계좌번호 >>> %s\n",accDto.acNum);
			System.out.print("계좌구분[1.입출금 2.적금 3.대출](1~3 입력) >>> ");
			String strDiv = scan.nextLine();
			System.out.printf("잔액(기본:10000원) >>> ");
			String strBalance = scan.nextLine();
			if(strBalance.equals("")) { strBalance = "10000"; }
			System.out.println("=".repeat(100));
			accDto.acBuId    = strId;
			accDto.acDiv     = strDiv;
			accDto.acBalance = Integer.valueOf(strBalance);
			int result = accService.insert(accDto);
			
			if(result > 0) {
				System.out.println("=".repeat(100));
				System.out.println();
				System.out.println("계좌생성을 완료했습니다");
				System.out.println();
				System.out.println("=".repeat(100));
				
			}
		}
		
		
		
	}
	
	protected String getNewAccNum() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat todayFormat = new SimpleDateFormat("YYYYMMdd");
		String todayString = todayFormat.format(date);
		accList = accService.selectAll();
		
		int maxNum = Integer.valueOf(((AccServiceImplV1)accService).MaxAcNum(todayString));
//		for(AccDto acDto : accList) {
//			String acNum  = acDto.acNum;
//			// 날짜부분 추출
//			String numDate = acNum.substring(0,todayString.length());
//			
//			if(numDate != null && numDate.equals(todayString)){
//				// 일련번호 부분만 추출하기
//				String lastNum = acNum.substring(todayString.length());
//				int intNum = Integer.valueOf(lastNum);
//				if(intNum > maxNum) maxNum = intNum;
//			}
//		}// end for
		
		// maxNum 은 0 또는 최대값
		String newNum = String.format("%s%04d",todayString,maxNum+1);
		return newNum;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
