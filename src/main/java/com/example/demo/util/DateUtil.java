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
		}catch (ParseException e) {
			formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
			date = (Date) formatter.parse(str);
		}
		return date;
	}

}
