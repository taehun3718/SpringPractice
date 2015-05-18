package com.ktds.mcjang.bbs.common;

import java.util.Calendar;

public class CalendarUtil {
	
	private static CalendarUtil instance = new CalendarUtil();
	private Calendar cal = Calendar.getInstance();
	
	public static CalendarUtil getInstance() {
		return CalendarUtil.instance;
	}
	/**
	 * 현재 날짜의 계산된 포멧을 가져온다. (YYYY-MM-DD)
	 * @return
	 */
	public String getCurrentDateFormat() {
		return getYear() + "-" + getMonth() + "-" + getDay();
	}
	
	public String getYear() {
		return cal.get(Calendar.YEAR) < 10 
					? "0" + Integer.toString(cal.get(Calendar.YEAR)) 
					: Integer.toString(cal.get(Calendar.YEAR));
	}
	
	public String getMonth() {
		return cal.get(Calendar.MONTH)+1 < 10 
				? "0" + Integer.toString(cal.get(Calendar.MONTH)+1) 
				: Integer.toString(cal.get(Calendar.MONTH)+1);
	}
	
	public String getDay() {
		
		return cal.get(Calendar.DAY_OF_MONTH) < 10 
				? "0" + Integer.toString(cal.get(Calendar.DAY_OF_MONTH)) 
				: Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
	}
}