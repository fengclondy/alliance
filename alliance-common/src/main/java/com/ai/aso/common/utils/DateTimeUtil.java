package com.ai.aso.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.util.Assert;

/**
 * 
 * <p>
 * Title: DateTimeUtil
 * </p>
 * <p>
 * Description: DateTimeUtil
 * </p>
 * <p>
 * Copyright: Copyright (c) 2013-9-22
 * </p>
 * <p>
 * Company: ASIAINFO
 * </p>
 * 
 * @author YUSX
 * @version 1.0
 * @Comment 日期公用类
 */

public class DateTimeUtil {

	public static Date addDate(Date sDate, int i, int calendarType) {
		Assert.notNull(sDate, "日期不能为空");
		Calendar localDate = new GregorianCalendar();
		localDate.setTime(sDate);
		localDate.add(calendarType, i);
		return localDate.getTime();
	}

	/*
	 * 返回指定天数后的日期
	 * 
	 * @param sDate 指定日期
	 * 
	 * @param iDay 需要增加的天数
	 * 
	 * @return 返回指定天数后的日期
	 */
	public static Date addDay(Date sDate, int iDay) {
		return DateTimeUtil.addDate(sDate, iDay, Calendar.DAY_OF_MONTH);
	}

	/*
	 * 返回指定小时后的日期
	 * 
	 * @param sDate 指定日期
	 * 
	 * @param iDay 需要增加的小时数
	 * 
	 * @return 返回指定小时数后的日期
	 */
	public static Date addHOUR(Date sDate, int iHOUR) {
		return DateTimeUtil.addDate(sDate, iHOUR, Calendar.HOUR_OF_DAY);
	}

	/*
	 * 返回指定分钟后的日期
	 * 
	 * @param sDate 指定日期
	 * 
	 * @param iDay 需要增加的分钟数
	 * 
	 * @return 返回指定分钟数后的日期
	 */
	public static Date addMINUTE(Date sDate, int iMINUTE) {
		return DateTimeUtil.addDate(sDate, iMINUTE, Calendar.MINUTE);
	}

	/*
	 * 返回指定秒后的日期
	 * 
	 * @param sDate 指定日期
	 * 
	 * @param iDay 需要增加的秒数
	 * 
	 * @return 返回指定秒数后的日期
	 */
	public static Date addSECOND(Date sDate, int iSECOND) {
		return DateTimeUtil.addDate(sDate, iSECOND, Calendar.SECOND);
	}

	/*
	 * 返回某天的初始时间
	 * 
	 * @param sDate 指定日期
	 * 
	 * @return 返回某天的初始时间
	 */
	public static Date getBeginDate(Date sDate) {
		Assert.notNull(sDate, "日期不能为空");
		Calendar localDate = new GregorianCalendar();
		localDate.setTime(sDate);
		localDate.set(Calendar.HOUR_OF_DAY, 0);
		localDate.set(Calendar.MINUTE, 0);
		localDate.set(Calendar.SECOND, 0);
		localDate.set(Calendar.MILLISECOND, 0);
		return localDate.getTime();
	}

	/*
	 * 返回某天的结束时间
	 * 
	 * @param sDate 指定日期
	 * 
	 * @return 返回某天的初始时间
	 */
	public static Date getEndDate(Date sDate) {
		Assert.notNull(sDate, "日期不能为空");
		Calendar localDate = new GregorianCalendar();
		localDate.setTime(sDate);
		localDate.set(Calendar.HOUR_OF_DAY, 23);
		localDate.set(Calendar.MINUTE, 59);
		localDate.set(Calendar.SECOND, 59);
		localDate.set(Calendar.MILLISECOND, 0);
		return localDate.getTime();
	}

	/**
	 * 返回年月日
	 * 
	 * @return yyyyMMdd
	 */
	public static String getTodayChar8() {
		return DateFormatUtils.format(new Date(), "yyyyMMdd");
	}


	/**
	 * 返回 年月日小时分秒
	 * 
	 * @return
	 */
	public static String getTodayChar14() {
		return DateFormatUtils.format(new Date(), "yyyyMMddHHmmss");
	}

	/**
	 * 返回 2位年月日小时分
	 * 
	 * @return yyMMddHHmmss
	 */
	public static String getTodayChar12Short() {
		return DateFormatUtils.format(new Date(), "yyMMddHHmmss");
	}

	/**
	 * 返回 年月日小时分秒 毫秒
	 * 
	 * @return
	 */
	public static String getTodayChar17() {
		return DateFormatUtils.format(new Date(), "yyyyMMddHHmmssS");
	}

	/**
	 * 返回 年月日小时分秒
	 * 
	 * @return
	 */
	public static String getTodayChar14En() {
		return DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 比较两个时间间隔的小时数
	 * 
	 * @param args
	 */
	public static Long compareDays(Date dateAfter, Date dateBefore) {
		long diff = dateAfter.getTime() - dateBefore.getTime();
		long hours = diff / (1000 * 60 * 60);
		return hours;
	}

	/**
	 * 返回2099-12-30 23:59:59
	 *
	 */
	public static Date getDefaultExpDate() {
		Calendar localDate = new GregorianCalendar();
		localDate.set(2099, 12, 30, 23, 59, 59);
		return localDate.getTime();
	}
	
	public static String getAccountPeriod() {
		Date date=new Date();
		
		SimpleDateFormat sf=new SimpleDateFormat("yyMM");
		String str=sf.format(date);
		StringBuffer sb=new StringBuffer();
		sb.append("1");
		sb.append(str);
		return sb.toString();
	}
	
	

	
	public static String getDateString12(Date date) {
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strDate=sf.format(date);
		return strDate;
	}
	
	public static String getDateString10(Date date) {
		SimpleDateFormat sf=new SimpleDateFormat("yyyy年M月dd日");
		String strDate=sf.format(date);
		return strDate;
	}
	
	public static boolean isValidDate(String str) {
		boolean convertSuccess=true;
		// 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
        	// 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
        	format.setLenient(false);
        	format.parse(str);
        } catch (ParseException e) {
        	// e.printStackTrace();
        	// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            convertSuccess=false;
        } 
        return convertSuccess;
	}
	
	
	public static Date string8ToDate(String str) throws ParseException
	{
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=sf.parse(str);
		return date;
	}
	
	public static String dateToString14(Date date) throws ParseException
	{
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strDate=sf.format(date);
		return strDate;
	}
	
	
	public static String dateToString8(Date date) throws ParseException
	{
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		String strDate=sf.format(date);
		return strDate;
	}


	/**
	 * 比较两个时间间隔的指定类型数
	 * @param dateAfter
	 * @param dateBefore
	 * @param dateType
	 * @return
	 */
	public static int compareDate(Date dateAfter, Date dateBefore, int dateType) {
		Calendar caAfter = Calendar.getInstance();
		caAfter.setTime(dateAfter);
		
		Calendar caBefore = Calendar.getInstance();
		caBefore.setTime(dateBefore);
		
		int rs = 0;
		
		if(dateType == Calendar.YEAR){
			rs = caAfter.get(Calendar.YEAR) - caBefore.get(Calendar.YEAR);
			if(caAfter.get(Calendar.MONTH) - caBefore.get(Calendar.MONTH) > 0){
				rs++;
			}
		}else if(dateType == Calendar.MONTH){
			rs = caAfter.get(Calendar.MONTH) - caBefore.get(Calendar.MONTH);
			if(caAfter.get(Calendar.DAY_OF_MONTH) - caBefore.get(Calendar.DAY_OF_MONTH) > 0){
				rs++;
			}
		}else if(dateType == Calendar.DAY_OF_MONTH){
			rs = caAfter.get(Calendar.DAY_OF_MONTH) - caBefore.get(Calendar.DAY_OF_MONTH);
		}else if(dateType == Calendar.DAY_OF_YEAR){
			rs = caAfter.get(Calendar.DAY_OF_YEAR) - caBefore.get(Calendar.DAY_OF_YEAR);
		}
		
		return rs;
	}
	
	
	public static long delayDay(Date dateAfter, Date dateBefore){
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		String d1=df.format(dateAfter);
		String d2=df.format(dateBefore);
		long remainDay=0l;
		try {
			remainDay = (df.parse(d1).getTime()- df.parse(d2).getTime())/(1000 * 60 * 60 * 24);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return remainDay;
		
	}
public static void main(String[] args) throws ParseException {
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
	
	System.out.println(DateTimeUtil.compareDate(df.parse("2018-06-15"), df.parse("2017-06-05"), Calendar.YEAR));
}
}
