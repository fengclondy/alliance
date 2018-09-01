package com.ai.aso.base.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class SequenceUtil {
	public static final int FORMAT_LENGTH_8 = 8;//时间戳为八位长度
	public static final int FORMAT_LENGTH_14 = 14;//时间戳为14位长度
	public static final int FORMAT_LENGTH_6 = 6;//时间戳为6位长度
	public static final Integer FORMAT_FULLLENGTH = 1; //左补零
	public static final Integer FORMAT_FULLLENGTH_R = 2; //右补零
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

	public static String getRandomStr(Short length){
		length = (short) Math.abs(length);
		String returnStr = null;
		if(length > 10){
			length = 10;
		}
		if(null == length || length.equals(Short.valueOf("0"))){
			returnStr = "";
		}else{
			Integer maxRandomValue = (int) Math.pow(10, length)-1;
			Random random = new Random();
			Integer randomValue = random.nextInt(maxRandomValue);
			String randomValueStr = randomValue.toString();
			StringBuffer randomValueBuffStr = new StringBuffer();
			if(randomValueStr.length() < length){
				for(int i=0;i<Math.abs(length-randomValueStr.length());i++){
					randomValueBuffStr.append("0");
				}
			}
			randomValueBuffStr.append(randomValueStr);
			returnStr = randomValueBuffStr.toString();
		}
		return returnStr;
	}
	
	public static String getTimestamp(Integer flag) {
		String timestampStr = null;
		switch (flag){
			case FORMAT_LENGTH_8:
				timestampStr = getYYYYMMDD();
				break;
			case FORMAT_LENGTH_14:
				timestampStr = getYYYYMMDDHHMMSS();
				break;
			case FORMAT_LENGTH_6:
				timestampStr = getYYMMDD();
				break;
			default:
				timestampStr = "";
				break;
		}			
		return timestampStr;
	}
	
	public static String getYYYYMMDD() {
		Date now = new Date();
		String formatedStr = dateFormat.format(now);
		if(null != formatedStr && formatedStr.length() > 0){
			formatedStr = formatedStr.substring(0,8);
		}
		return formatedStr;
	}

	public static String getYYYYMMDDHHMMSS() {
		Date now = new Date();
		String formatedStr = dateFormat.format(now);
		return formatedStr;
	}

	public static String getYYMMDD() {
		Date now = new Date();
		String formatedStr = dateFormat.format(now);
		if(null != formatedStr && formatedStr.length() > 0){
			formatedStr = formatedStr.substring(2,8);
		}
		return formatedStr;
	}
	
	public static String formatValue(String valueStr, Integer formatFlag, Integer sequenceLength){
		StringBuffer currentVlauestrBuff = null;
		if(null == formatFlag){
			return valueStr;
		}
		int zeroNumbers = 0;
		if(valueStr.length() < sequenceLength){
			zeroNumbers = sequenceLength - valueStr.length();
		}
		if(FORMAT_FULLLENGTH.equals(formatFlag) && zeroNumbers > 0){
			currentVlauestrBuff = new StringBuffer();
			for(int i = 0;i<zeroNumbers;i++){
				currentVlauestrBuff.append("0");
			}
			currentVlauestrBuff.append(valueStr);
		}else if(FORMAT_FULLLENGTH_R.equals(formatFlag) && zeroNumbers > 0){
			currentVlauestrBuff = new StringBuffer(valueStr);
			for(int i = 0;i<zeroNumbers;i++){
				currentVlauestrBuff.append("0");
			}
		}
		if(null == currentVlauestrBuff){
			return valueStr;
		}
		return currentVlauestrBuff.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(getRandomStr((short)3));
		System.out.println(new Random().nextInt(100000));
		System.out.println((int)(Math.random() * Math.pow(10, 6)));
	}

}
