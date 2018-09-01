package com.ai.aso.base.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CommonUtil {
	/**
	 * 汉字转换位汉语拼音，英文字符不变
	 * 
	 * @param chines 汉字
	 * @return 拼音
	 */
	public static String converterToSpell(String chines) {
		if(null == chines || "".equals(chines)) {
			return null;
		}
		
		String pinyinName = "";
		char[] nameChar = chines.toCharArray();
		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
		defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		defaultFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
		for (int i = 0; i < nameChar.length; i++) {
			if (nameChar[i] > 128) {
				try {
					pinyinName += PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaultFormat)[0];
				} catch (Exception e) {
					pinyinName += nameChar[i];
				}
			} else {
				pinyinName += nameChar[i];
			}
		}
		return pinyinName;
	}
	
	public static String transfer(String keyword) {
		if (null != keyword) {
	        if (keyword.contains("%") 
	        	|| keyword.contains("_")
	        	|| keyword.contains(".")
	        	|| keyword.contains("?")
	        	|| keyword.contains("+")
	        	|| keyword.contains("*")
	        	|| keyword.contains("^")
	        	|| keyword.contains("$")
	        	|| keyword.contains("[")
	        	|| keyword.contains("]")
	        	|| keyword.contains("{")
	        	|| keyword.contains("}")){  
	            keyword = keyword.replaceAll("\\\\", "\\\\\\\\")  
	                             .replaceAll("\\%", "\\\\%")  
	                             .replaceAll("\\_", "\\\\_")
					             .replaceAll("\\.", "\\\\.")	//匹配任意单个字符
					             .replaceAll("\\?", "\\\\?")	//匹配前面的子表达式0次或1次。
					             .replaceAll("\\+", "\\\\+")	//匹配前面的子表达式1次或多次。
					             .replaceAll("\\*", "\\\\*")			//匹配前面的子表达式0次或多次。x*，表示0个或多个x字符；[0-9]*，匹配任何数量的数字。
					             .replaceAll("\\^", "\\\\^")			//表示匹配开始位置。
					             .replaceAll("\\$", "\\\\$")			//表示匹配结束位置。
					             .replaceAll("\\[", "\\\\[")
					             .replaceAll("\\]", "\\\\]")			//表示一个集合。[hi]，表示匹配h或i；[a-d]，表示匹配a、b、c、d中任一个。
					             .replaceAll("\\{", "\\\\{")
					             .replaceAll("\\}", "\\\\}")			//表示重复的次数。8{5}，表示匹配5个8，即88888；[0-9]{5,11}，表示匹配5到11个数字。
					             ;
	        }
		}
		
        return keyword;
    }
}
