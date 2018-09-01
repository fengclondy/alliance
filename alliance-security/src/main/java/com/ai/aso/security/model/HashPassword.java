package com.ai.aso.security.model;

import java.io.Serializable;

public class HashPassword implements Serializable {

	private static final long serialVersionUID = -723712257112255984L;

	/**
	 * 明文
	 */
	private String plaintext;

	/**
	 * 密文
	 */
	private String ciphertext;

	/**
	 * 私盐
	 */
	private String privateSalt;

	/**
	 * 公盐
	 */
	private String publicSalt;

	public String getPlaintext() {
		return plaintext;
	}

	public void setPlaintext(String plaintext) {
		this.plaintext = plaintext;
	}

	public String getCiphertext() {
		return ciphertext;
	}

	public void setCiphertext(String ciphertext) {
		this.ciphertext = ciphertext;
	}

	public String getPrivateSalt() {
		return privateSalt;
	}

	public void setPrivateSalt(String privateSalt) {
		this.privateSalt = privateSalt;
	}

	public String getPublicSalt() {
		return publicSalt;
	}

	public void setPublicSalt(String publicSalt) {
		this.publicSalt = publicSalt;
	}

}
