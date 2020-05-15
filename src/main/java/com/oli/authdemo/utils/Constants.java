package com.oli.authdemo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Constants {
	
	public static final String UPLOAD_DIR = System.getProperty("user.dir") + "/images";
	
	public static String formatDate(String dateString) {
		SimpleDateFormat dt = new SimpleDateFormat("yyyyy-MM-dd"); 
		try {
			Date date = dt.parse(dateString);
			SimpleDateFormat dt1 = new SimpleDateFormat("dd-MMM-yyyy");
			String myDate = dt1.format(date);
			return myDate;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return "00-JAN-0000";
		
	}

}
