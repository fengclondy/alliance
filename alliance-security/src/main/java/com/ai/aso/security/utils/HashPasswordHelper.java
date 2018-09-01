package com.ai.aso.security.utils;

import com.ai.aso.security.model.HashPassword;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HashPasswordHelper implements PasswordHelper {

	Logger logger = LoggerFactory.getLogger(HashPasswordHelper.class);

	private static final String DEFAULT_ALGORITHM = "MD5"; // 默认算法

	private static final int DEFAULT_ITERATIONS = 2; // 默认HASH计算次数

	/**
	 * 使用算法，如MD5\SHA-256\SHA-512等
	 */
	private String hashAlgorithm;

	/**
	 * Hash计算次数
	 */
	private int hashIterations;

	/**
	 * 是否使用salt
	 */
	private boolean hashSalted;

	/**
	 * 是否使用16进制(Hex)编码，否则使用base64编码
	 */
	private boolean storedCredentialsHexEncoded;

	public HashPasswordHelper() {
		this(DEFAULT_ALGORITHM, DEFAULT_ITERATIONS, true, false);
	}

	public HashPasswordHelper(String hashAlgorithm, int hashIterations,
			boolean hashSalted, boolean storedCredentialsHexEncoded) {
		this.hashAlgorithm = hashAlgorithm;
		this.hashIterations = hashIterations;
		this.hashSalted = hashSalted;
		this.storedCredentialsHexEncoded = storedCredentialsHexEncoded;
	}

	/**
	 * 对HashPassword中的明文进行加密
	 * 
	 * @param plaintextPassword
	 *            HashPassword对象
	 * @return
	 */
	@Override
	public Object encryptPassword(Object plaintextPassword) {
		if (plaintextPassword instanceof HashPassword) {
			HashPassword hashPassword = (HashPassword) plaintextPassword;
			String plaintext = assertPlaintext(hashPassword.getPlaintext());
			String salt = concatSalt(hashPassword.getPrivateSalt(),
					hashPassword.getPublicSalt());
			hashPassword.setCiphertext(hash(plaintext, salt));
			return hashPassword;
		}
		return null;
	}

	/**
	 * 生成私盐，随机生成一个长度为20的字符串<br>
	 * 1、使用随机数生成器生成一个14个字节的字节组<br>
	 * 2、经过Base64编码后，输出一个20位的字符串
	 * 
	 * @return 长度为20的字符串
	 */
	public static String generatePrivateSalt() {
		RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
		return randomNumberGenerator.nextBytes(14).toBase64();
	}

	/**
	 * 比较两个HashPassword对象的密文是否相同
	 * 
	 * @param aPD
	 * @param bPD
	 * @return
	 */
	public static boolean equals(HashPassword aPD, HashPassword bPD) {
		if (aPD == null || bPD == null || aPD.getCiphertext() == null
				|| bPD.getCiphertext() == null) {
			return false;
		}
		if (aPD.getCiphertext().equals(bPD.getCiphertext())) {
			return true;
		}
		return false;
	}

	/**
	 * 拼接私盐和公盐
	 * 
	 * @param privateSalt
	 * @param publicSalt
	 * @return
	 */
	private String concatSalt(String privateSalt, String publicSalt) {
		String salt = "";
		if (isHashSalted()) {
			if (privateSalt != null) {
				salt = salt.concat(privateSalt);
			}
			if (publicSalt != null) {
				salt = salt.concat(publicSalt);
			}
			logger.debug("私盐：{}，公盐：{}，盐：{}", privateSalt, publicSalt, salt);
		}
		return salt;
	}

	/**
	 * 检测明文是否为空
	 * 
	 * @param plaintext
	 * @return
	 */
	private String assertPlaintext(String plaintext) {
		if (plaintext == null || "".equals(plaintext)) {
			logger.warn("加密明文为空字符串");
			return "";
		}
		return plaintext;
	}

	/**
	 * 实现Hash算法，返回密文
	 * 
	 * @param plaintext
	 *            明文
	 * @param salt
	 *            盐
	 * @return 密文
	 */
	private String hash(String plaintext, String salt) {
		String hashAlgorithmName = assertHashAlgorithmName();
		int hashIterations = assertHashIterationse();
		logger.debug("Hash算法：{}，计算次数：{}次，使用编码：{}", hashAlgorithmName,
				hashIterations, isStoredCredentialsHexEncoded() ? "Hex"
						: "Base64");
		logger.debug("加密明文：{}，salt：{}", plaintext, salt);
		SimpleHash hash = new SimpleHash(hashAlgorithmName, plaintext, salt,
				hashIterations);
		if (isStoredCredentialsHexEncoded()) {
			return hash.toHex();
		} else {
			return hash.toBase64();
		}
	}

	/**
	 * 检查计算次数，如小于1则默认为1。
	 * 
	 * @return 计算次数
	 */
	private int assertHashIterationse() {
		int hashIterations = getHashIterations();
		if (hashIterations < 1) {
			logger.warn("Hash计算次数不合法，默认计算1次");
			hashIterations = DEFAULT_ITERATIONS;
			setHashIterations(DEFAULT_ITERATIONS);
		}
		return hashIterations;
	}

	/**
	 * 检查是否设置Hash算法，默认使用MD5算法。
	 * 
	 * @return Hash算法名称
	 */
	private String assertHashAlgorithmName() {
		String hashAlgorithmName = getHashAlgorithm();
		if (hashAlgorithmName == null || "".equals(hashAlgorithmName)) {
			logger.warn("没有设置Hash算法，默认使用MD5算法！");
			hashAlgorithmName = DEFAULT_ALGORITHM;
			setHashAlgorithm(DEFAULT_ALGORITHM);
		}
		return hashAlgorithmName;
	}

	public String getHashAlgorithm() {
		return hashAlgorithm;
	}

	public void setHashAlgorithm(String hashAlgorithm) {
		this.hashAlgorithm = hashAlgorithm;
	}

	public int getHashIterations() {
		return hashIterations;
	}

	public void setHashIterations(int hashIterations) {
		this.hashIterations = hashIterations;
	}

	public boolean isHashSalted() {
		return hashSalted;
	}

	public void setHashSalted(boolean hashSalted) {
		this.hashSalted = hashSalted;
	}

	public boolean isStoredCredentialsHexEncoded() {
		return storedCredentialsHexEncoded;
	}

	public void setStoredCredentialsHexEncoded(
			boolean storedCredentialsHexEncoded) {
		this.storedCredentialsHexEncoded = storedCredentialsHexEncoded;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// System.out.println(generatePrivateSalt().length());
		HashPasswordHelper helper = new HashPasswordHelper();
		HashPassword pass = new HashPassword();
//		pass.setPlaintext("1234");
//		pass.setPrivateSalt(HashPasswordHelper.generatePrivateSalt());
//		pass.setPrivateSalt("d4ed57d00b24c7f46068c057ecd3d6fe");
//		pass.setPublicSalt("1");JIyAkZfG07G2V2MPUGShVg==
		
		pass.setPlaintext("888888");
		pass.setPublicSalt("000010106");
		pass.setPrivateSalt("V8audOjjEWwKEcenEqY=");
		System.out.println(((HashPassword) helper.encryptPassword(pass))
				.getCiphertext());
		System.out.println(pass.getPrivateSalt());
	}

}
