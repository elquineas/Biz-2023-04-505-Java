package com.callor.bank.exec;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateExecA {
	public static void main(String[] args) {
		Date date = new Date(System.currentTimeMillis());
		System.out.println(date.toString());
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		String dateString = dateFormat.format(date);
		String timeString = timeFormat.format(date);
		
		System.out.println(dateString);
		System.out.println(timeString);
		System.out.println();
		// java 1.8 부터 사용하는 날짜 type의 객체
		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDate);
		System.out.println(localTime);
		System.out.println(localDateTime);
		System.out.println();
		
		DateTimeFormatter dateFormat1 = DateTimeFormatter.ofPattern("YYYY-MM-dd");
		DateTimeFormatter dateFormat2 = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		System.out.println(localDateTime.format(dateFormat1));
		System.out.println(localDateTime.format(dateFormat2));
	}
}
