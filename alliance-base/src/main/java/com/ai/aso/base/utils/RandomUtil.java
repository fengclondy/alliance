package com.ai.aso.base.utils;

public class RandomUtil {
	
	private static final String _NUMBER = "0123456789";
	private static final String _LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
	private static final String _UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static final int NUMBER = 1;
	public static final int LOWERCASE = 10;
	public static final int UPPERCASE = 100;
	public static final int NUMBER_LOWERCASE = 11;
	public static final int NUMBER_UPPERCASE = 101;
	public static final int LOWER_UPPER_CASE = 110;
	public static final int MIX_ALL = 111;
	
	/**
	 * 
	 * @param mixStyle RandomUtil[NUMBER-纯数字型, LOWERCASE-小写字母, UPPERCASE-大写字母, MIX_ALL-混合型...]
	 * @param length 所需长度
	 * @return
	 */
	public static String createRandom(int mixStyle, int length) {
		String retStr = "";
		String strTable = "1234567890abcdefghijkmnpqrstuvwxyz";
		
		switch (mixStyle) {
			case NUMBER:
				strTable = _NUMBER; break;
			case LOWERCASE:
				strTable = _LOWERCASE; break;
			case UPPERCASE:
				strTable = _UPPERCASE; break;
			case NUMBER_LOWERCASE:
				strTable = _NUMBER + _LOWERCASE; break;
			case NUMBER_UPPERCASE:
				strTable = _NUMBER + _UPPERCASE; break;
			case LOWER_UPPER_CASE:
				strTable = _LOWERCASE + _UPPERCASE; break;
			case MIX_ALL:
				strTable = _NUMBER + _LOWERCASE + _UPPERCASE; break;
			default:
				strTable = _NUMBER + _LOWERCASE + _UPPERCASE;
		}
		
		int len = strTable.length();
		boolean bDone = true;
		do {
			retStr = "";
			int count = 0;
			for (int i = 0; i < length; i++) {
				double dblR = Math.random() * len;
				int intR = (int) Math.floor(dblR);
				char c = strTable.charAt(intR);
				if (('0' <= c) && (c <= '9')) {
					count++;
				}
				retStr += strTable.charAt(intR);
			}
			if (count >= 2) {
				bDone = false;
			}
		} while (bDone);

		return retStr;
	}
}
