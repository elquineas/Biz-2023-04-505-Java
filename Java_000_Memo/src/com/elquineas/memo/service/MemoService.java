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

public interface MemoService {
//	public void startMemo();
	public void selectAll();
	public void memoListView(List<MemoDto> memoList);
	public void viewMemo(String strNum);
	
	public void insert();
	public void update();
	public void delete();
	public void serch();
	
}
