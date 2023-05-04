package com.callor.scanner.exec;

import com.callor.scanner.service.PrimeServiceV1;

public class ScannerC {
	
	public static void main(String[] args) {
		PrimeServiceV1 pServ = new PrimeServiceV1();
		while(true) {
			int pNum = pServ.getNum();
			if(pNum < 0) {
				System.out.println("!!! GAME OVER !!!");
				return;
			}
			
			int result = pServ.primeYesNo(pNum);
			
			if(result > 0) {
				System.out.println(pNum + "은(는) 소수입니다.");
			}else {
				System.err.println(pNum + "은(는) 소수가 아닙니다.");
			}
		}
	}
}
