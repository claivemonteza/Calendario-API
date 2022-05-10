package com.example.demo.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date formatStringToDate(String str) throws Exception {
		Date date = null;
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = (Date) formatter.parse(str);
		} catch (ParseException e) {
			  formatter = new SimpleDateFormat("EEE MMM dd yyyy"); 
			  date = (Date)
			  formatter.parse(str);
		}
		return date;
	}

	public static Date formatDate(Date date) {
		try {
			DateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
			String data = formatter.format(date);
			return formatter.parse(data);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String format(Date date) {
		DateFormat formatter = new SimpleDateFormat("EEE MMM dd yyyy");
		String data = formatter.format(date);
		return data;
	}

}
