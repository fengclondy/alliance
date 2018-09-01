package com.ai.aso.base.utils;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.Assert;

/**
 * 
 * <p>
 * Title: StringUtil
 * </p>
 * <p>
 * Description: StringUtil
 * </p>
 * <p>
 * Copyright: Copyright (c) 2013-9-22
 * </p>
 * <p>
 * Company: ASIAINFO
 * </p>
 * 
 * @author YUSX
 * @version 1.0 字符公用类
 */

public class StringUtil {

	/**
	 * 格式化数字为固定长度字符串，不足长度在高位补0
	 * 
	 * @param iNum
	 *            需格式化的数字
	 * @param iLength
	 *            格式化后字符串的长度
	 * @return 格式化后的字符串
	 */
	public static String padZero(int iNum, int iLength) {
		Assert.isTrue(String.valueOf(iNum).length() <= iLength, "需格式化数字长度超长！");
		String format = "%0" + iLength + "d";
		return String.format(format, iNum);
	}

	/**
	 * 校验是否是邮箱
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isMail(String str) {
		try {
			Pattern p = Pattern
					.compile("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\\.([a-zA-Z0-9_-])+)+$");
			Matcher m = p.matcher(str);
			boolean bl = m.matches();
			return bl;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 是否是手机
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isMobile(String str) {
		try {
			Pattern p = Pattern.compile("^(13|15|18|17)[0-9]{9}$");
			Matcher m = p.matcher(str);
			boolean bl = m.matches();
			return bl;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 是否是价格
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isPrice(String str) {
		try {
			Pattern p = Pattern
					.compile("^([1-9]{1}[0-9]{0,}(\\.[0-9]{0,2})?|0(\\.[0-9]{0,2})?|\\.[0-9]{1,2})$");
			Matcher m = p.matcher(str);
			boolean bl = m.matches();
			return bl;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 是否是字母
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isLetter(String str) {
		try {
			Pattern p = Pattern.compile("^[A-Za-z]+$");
			Matcher m = p.matcher(str);
			boolean bl = m.matches();
			return bl;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 是否是电话号码的函数(包括验证国内区号,国际区号,分机号)
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isTel(String str) {
		try {
			Pattern p = Pattern
					.compile("^(([0\\+]\\d{2,3}-)?(0\\d{2,3})-)?(\\d{7,8})(-(\\d{3,}))?$");
			Matcher m = p.matcher(str);
			boolean bl = m.matches();
			return bl;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 是否是邮编
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isZipcode(String str) {
		try {
			Pattern p = Pattern.compile("^\\d{6}$");
			Matcher m = p.matcher(str);
			boolean bl = m.matches();
			return bl;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 功能：屏蔽html字符
	 */
	public static String parseHtml(String str) {

		String tmp;
		if (str == null || str.length() == 0) {
			return str;
		}
		char[] aryToParse = str.toCharArray();
		StringBuffer strBf = new StringBuffer();
		char c;
		for (int i = 0; i < aryToParse.length; i++) {
			c = aryToParse[i];
			switch (c) {
			case '<':
				strBf.append("&lt;");
				break;
			case '>':
				strBf.append("&gt;");
				break;
			case '&':
				strBf.append("&amp;");
				break;
			case '"':
				strBf.append("&quot;");
				break;
			case ' ':
				strBf.append("&nbsp;");
				break;
			default:
				strBf.append(c);
			}
		}
		tmp = strBf.toString();
		tmp = tmp.replaceAll("\n", "<br>");
		tmp = tmp.replaceAll("\t", "   ");
		return tmp;
	}

	/**
	 * 产生由数字和字母组成的指定长度的的无重复的随机数
	 * 
	 * @param length
	 * @return
	 */
	public static String getRandomCode(int length) {
		String returnStr = "";
		Random r = new Random();

		int tempPos;
		char tempChar;
		char send[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
				'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
				'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
				'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
				'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
				'X', 'Y', 'Z' };
		int len = send.length;
		for (int i = 0; i < length; i++) {
			tempPos = Math.abs(r.nextInt()) % len;
			tempChar = send[tempPos];
			returnStr += tempChar;
			send[tempPos] = send[len - 1];
			send[len - 1] = tempChar;
			len--;
		}
		return returnStr;
	}

	/**
	 * 取小数点后面几位数 格式化长数字值
	 * 
	 * @Title: formatDecimalPoint
	 * @Description: TODO
	 * @Param: @param str
	 * @Param: @param num
	 * @Param: @return
	 * @Return: String
	 * @Comment:
	 * @Author: Administrator
	 * @CreateDate: May 16, 2012 5:16:48 PM
	 */
	public static String formatDecimalPoint(String str, int num) {
		String strReturn = "";
		if (null != str) {
			if (str.indexOf(".") > 0) {
				if (str.substring(str.indexOf(".") + 1, str.length()).length() > num) {
					strReturn = str.substring(0, str.indexOf(".") + num + 1);
				} else {
					strReturn = str;
				}
			} else {
				strReturn = str;
			}
		}
		return strReturn;
	}

	/**
	 * 对双引号等特殊字符进行JS转码 " 转换 /"
	 * 
	 * @param str
	 * @return
	 */
	public static String parseJsCode(String str) {
		String strReturn = "";
		if (null != str) {

			if (str.indexOf("'") != -1) {
				// 将单引号转义一下，因为JSON串中的字符串类型可以单引号引起来的
				str = str.replaceAll("'", "\\\\'");
			}
			if (str.indexOf("\"") != -1) {
				// 将双引号转义一下，因为JSON串中的字符串类型可以单引号引起来的
				str = str.replaceAll("\"", "\\\\\"");
			}

			if (str.indexOf("\r\n") != -1) {
				// 将回车换行转换一下，因为JSON串中字符串不能出现显式的回车换行
				str = str.replaceAll("\r\n", "\\\\u000d\\u000a");
			}
			if (str.indexOf("\n") != -1) {
				// 将换行转换一下，因为JSON串中字符串不能出现显式的换行
				str = str.replaceAll("\n", "\\\\u000a");
			}
			strReturn = str;
			// "转换
			// strReturn = str.replaceAll("\"","\\\\\"");
			// \"
		}
		return strReturn;
	}

	/**
	 * 取出一个指定长度大小的随机正整数.
	 * 
	 * @param length
	 *            int 设定所取出随机数的长度。length小于11
	 * @return int 返回生成的随机数。
	 */
	public static String buildRandomStr(int length) {
		int num = 1;
		double random = Math.random();
		if (random < 0.1) {
			random = random + 0.1;
		}
		for (int i = 0; i < length; i++) {
			num = num * 10;
		}
		return Integer.toString((int) ((random * num)));
	}

	/**
	 * Check whether a String is Empty.
	 * 
	 * @param str
	 *            the String to be checked.
	 * @return boolean if it is empty(null or empty sstring) then reurn true.
	 */
	public static boolean isEmpty(String str) {
		return str == null || "".equals(str.trim());
	}

	/**
	 * 判断是否不为空
	 * 
	 * @Title: isNotEmpty
	 * @Description: TODO
	 * @Param: @param str
	 * @Param: @return
	 * @Return: boolean
	 * @Comment:
	 * @Author: Administrator
	 * @CreateDate: Feb 21, 2012 2:09:43 PM
	 */
	public static boolean isNotEmpty(String str) {
		return str != null && (!"".equals(str.trim()));
	}
	
	public static boolean isNotEmptyUndefined(String str) {
		return str != null && (!"".equals(str.trim())) && (!"undefined".equalsIgnoreCase(str));
	}
	
	/**
	 * 插入分隔符
	 * @param str
	 * @param symbol
	 * @return
	 */
	public static String insertSpliter(String str, String symbol){
		if(StringUtil.isEmpty(str) || str.length() == 1) return str;
		
		return (str.charAt(0) + symbol + insertSpliter(str.substring(1), symbol));
	}
	
	/**
	 * 插入分隔符
	 * @param str
	 * @param symbol
	 * @param side - 是否在两端插入分隔符
	 * @return
	 */
	public static String insertSpliterBothSide(String str, String symbol){
		if (StringUtil.isEmpty(str)) return "";
		return "%" +insertSpliter(str, symbol) + "%";
	}

	public static void main(String[] args) {
		// String str = String.format("%04d", 2);
		System.out.println(padZero(994, 3));
	}
	/**
	 * 取等号和分号之间的字符串
	 * @param str
	 * @return
	 */

	public static String splitString(String str){
		String[] strs = str.split(";");
		str = strs[0];
		strs=str.split("=");
		str = strs[1];
		return str;
	}
	/**
	 * 转换成16进制编码
	 * @param msg
	 * @return
	 */
	public static String transforHex(String msg) {
		  byte[] bytes = msg.getBytes();
		  StringBuilder sb = new StringBuilder(bytes.length * 2);
		  //转换hex编码
		  for (byte b : bytes) {
		   sb.append(Integer.toHexString(b + 0x800).substring(1));
		  }
		  msg = sb.toString();
		  return msg;
	}
	/**
	 * 16进制编码转换成字符串
	 * @param bytes
	 * @return
	 */
	 public static String decode(String bytes) {
		  String hexString = "0123456789ABCDEFabcdef";
		  bytes = bytes.toUpperCase();
		  ByteArrayOutputStream baos = new ByteArrayOutputStream(bytes.length() / 2);
		  // 将每2位16进制整数组装成一个字节
		  for (int i = 0; i < bytes.length(); i += 2)
		   baos.write((hexString.indexOf(bytes.charAt(i)) << 4 | hexString.indexOf(bytes.charAt(i + 1))));
		  return new String(baos.toByteArray());
		 }
	 
	 /**
	     * string数组装换成List<Long>
	     * @param stringList
	     * @return
	     */
	    public static List<Long> arrayToAssemble(String[] stringList) {
	        List<Long> LongList = new ArrayList<>();
	        for (String string : stringList) {
	            LongList.add(Long.parseLong(string));
	        }
	        return LongList;
	    }
}

