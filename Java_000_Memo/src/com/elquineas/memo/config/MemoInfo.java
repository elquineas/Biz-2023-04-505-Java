package com.elquineas.memo.config;

public class MemoInfo {
	public static final void headerPrint() {
		System.out.println("=".repeat(100));
		System.out.println("메모장 시스템");
		System.out.println("=".repeat(100));
		System.out.println("수행할 업무를 선택하세요.");
		System.out.println("  1. 메모 리스트");
		System.out.println("  2. 메모 작성");
		System.out.println("  3. 메모 수정");
		System.out.println("  4. 메모 삭제");
		System.out.println("  5. 메모 검색");
		System.out.println("  9. 메모장 종료");
		System.out.println("-".repeat(100));
	}
}
