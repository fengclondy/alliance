package com.ai.aso.common.sequence;

import com.ai.aso.common.sequence.exception.SeqDateException;
import com.ai.aso.common.sequence.exception.SeqNumException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractSequence implements ISequence {

	@SuppressWarnings("serial")
	protected static final Map<String, String> DATE_FORMAT_MAP = new HashMap<String, String>() {
		{
			put("S14", "yyyyMMddHHmmss");
			put("D8", "yyyyMMdd");
			put("D6", "yyMMdd");
			put("M6", "yyyyMM");
			put("M4", "yyMM");
			put("H10", "yyyyMMddHH");
		}
	};

	Logger logger = LoggerFactory.getLogger(AbstractSequence.class);

	private String name; // 序列器名称

	private Integer numLen; // 数字序列长度

	private Short randomLen; // 随机码长度

	private String dateFormat; // 时间戳的格式

	private String prefix; // 前缀

	private String suffix; // 后缀

	private Long currentNum;

	@Override
	public String next() {

		// 获取数字序列
		Long numVal = 0l;
		if (numLen > 0) {
			numVal = nextNumVal(1);
			if (null == numVal || numVal.intValue() < 0) {
				logger.error("取序列数字失败！");
				throw new SeqNumException();
			}
		}

		// 拼接序列各组成部分
		return appendSequence(numVal);
	}

	@Override
	public List<String> next(final int n) {
		// 获取的
		final int _n = n < 1 ? 1 : n;
		ArrayList<String> seqList = new ArrayList<String>(n);

		// 获取数字序列
		Long numVal = 0l;
		if (numLen > 0) {
			numVal = nextNumVal(_n);
			if (null == numVal || numVal.intValue() < 0) {
				logger.error("取序列数字失败！");
				throw new SeqNumException();
			}
		}

		// 拼接序列各组成部分
		for (int i = 0; i < _n; i++) {
			seqList.add(appendSequence(numVal--));
		}

		return seqList;
	}

	/**
	 * 拼接序列各组成部分
	 * 
	 * @param numVal
	 * @return
	 */
	private String appendSequence(Long numVal) {

		// 添加前缀
		StringBuffer _nextSeq = new StringBuffer();
		if (prefix != null && !"".equals(prefix)) {
			_nextSeq.append(nvl(prefix));
		}

		// 添加时间戳
		if (dateFormat != null && !"".equals(dateFormat)) {
			_nextSeq.append(genDateStr(dateFormat));
		}

		// 添加数字序列
		if (numLen > 0) {
			// 数字序列补全处理
			String numStr = lpad(numVal, numLen);
			if (numStr.length() > numLen) {
				logger.warn("数字序列已超过设定最大长度");
			}
			_nextSeq.append(numStr);
		}

		// 添加随机数
		if (randomLen > 0) {
			_nextSeq.append(genRandomStr(randomLen));
		}

		// 添加后缀
		if (suffix != null && !"".equals(suffix)) {
			_nextSeq.append(nvl(suffix));
		}
		logger.debug("{}序列本次获取的序列为：{}", getName(), _nextSeq.toString());
		return _nextSeq.toString();
	}

	/**
	 * 格式化数字，左补0
	 * 
	 * @param number
	 *            数字
	 * @param len
	 *            格式化长度
	 * @return
	 */
	protected String lpad(Long number, Integer len) {
		String formatStr = "%0".concat(len.toString()).concat("d");
		return String.format(formatStr, number);
	}

	/**
	 * 字符串对象为NULL则转换为""
	 * 
	 * @param str
	 *            字符串对象
	 * @return
	 */
	protected String nvl(String str) {
		return str == null ? "" : str;
	}

	/**
	 * 获取日期字符串
	 * 
	 * @param format
	 * @return
	 */
	protected String genDateStr(String format) {
		if (format == null || "".equals(format)) {
			return "";
		}
		String dateFormat = DATE_FORMAT_MAP.get(format);
		if (dateFormat == null) {
			logger.error("序列中日期格式配置错误！");
			throw new SeqDateException();
		}
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		return formatter.format(new Date());
	}

	/**
	 * 获取随机数字序列
	 * 
	 * @param len
	 * @return
	 */
	protected String genRandomStr(Short len) {
		Short ranLen = len > 5 ? 5 : len;
		Long maxVal = (long) Math.pow(10, ranLen) - 1;
		Long ranVal = (long) (Math.random() * maxVal);
		String ranStr = lpad(ranVal, (int) len);
		return ranStr;
	}

	protected abstract Long nextNumVal(int n);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumLen() {
		return numLen;
	}

	public void setNumLen(Integer numLen) {
		this.numLen = numLen;
	}

	public Short getRandomLen() {
		return randomLen;
	}

	public void setRandomLen(Short randomLen) {
		this.randomLen = randomLen;
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public Long getCurrentNum() {
		return currentNum;
	}

	public void setCurrentNum(Long currentNum) {
		this.currentNum = currentNum;
	}
}
