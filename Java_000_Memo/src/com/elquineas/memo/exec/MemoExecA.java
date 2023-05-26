package com.elquineas.memo.exec;

import org.apache.ibatis.session.SqlSession;

import com.elquineas.memo.config.DBConnection;
import com.elquineas.memo.mapper.MemoDao;
import com.elquineas.memo.service.MemoService;

public class MemoExecA {
	public static void main(String[] args) {
		MemoService mService = new MemoService();
		mService.startMemo();
	}
}
