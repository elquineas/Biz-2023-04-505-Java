package com.elquineas.memo.exec;

import com.elquineas.memo.service.MainService;

public class MemoExecA {
	public static void main(String[] args) {
		MainService mService = new MainService();
		mService.startMemo();
	}
}
