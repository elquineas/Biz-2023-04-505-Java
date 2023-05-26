package com.elquineas.bank.config;

public class BankInfo {
	public static final void headerPrint() {
		System.out.println("=".repeat(100));
		System.out.println("대한은행 고객관리 시스템");
		System.out.println("=".repeat(100));
		System.out.println("수행할 업무를 선택하세요.");
		System.out.println("  1. 고객 추가");
		System.out.println("  2. 고객 정보 수정");
		System.out.println("  3. 고객 정보 삭제");
		System.out.println("  4. 고객 리스트");
		System.out.println("  5. 고객 검색");
		System.out.println("  6. 고객 정보(계좌) 조회");
		System.out.println("  7. 계좌 생성");
		System.out.println("  9. 업무 종료");
		System.out.println("-".repeat(100));
		System.out.print(">> ");
	}
}
