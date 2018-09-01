package com.ai.aso.security.shiro;

import com.ai.aso.security.model.HashPassword;
import com.ai.aso.security.model.Principal;
import com.ai.aso.security.utils.AuthenticationHelper;
import com.ai.aso.security.utils.HashPasswordHelper;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HashedCredentialsMatcher implements CredentialsMatcher {

	Logger logger = LoggerFactory.getLogger(HashedCredentialsMatcher.class);

	private HashPasswordHelper passwordHelper;

	private AuthenticationHelper authenHelper;

	public HashedCredentialsMatcher() {
		passwordHelper = new HashPasswordHelper();
		authenHelper = new AuthenticationHelper();
	}

	/**
	 * 密码验证，校验用户输入密码是否正确
	 */
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token,
			AuthenticationInfo info) {
		HashPassword tokenCredentials = encryptProvidedCredentials(token, info);
		HashPassword accountCredentials = getCredentials(info);
		if (HashPasswordHelper.equals(tokenCredentials, accountCredentials)) {
			// 校验成功，返回true
			return true;
		}
		// 锁定该账号
		Principal user = getUserFromInfo(info);
		logger.debug("UserId:{}", user.getAccId());
		authenHelper.lockUser(user.getAccId());
		return false;
	}

	/**
	 * 对用户输入密码进行加密
	 * 
	 * @param token
	 * @param info
	 * @return
	 */
	protected HashPassword encryptProvidedCredentials(
			AuthenticationToken token, AuthenticationInfo info) {
		HashPassword password = new HashPassword();
		String tokenPass = new String((char[]) token.getCredentials());
		password.setPlaintext(tokenPass);
		Principal user = getUserFromInfo(info);
		password.setPrivateSalt(user.getHashSalt());
		password.setPublicSalt(user.getAccId());
		return (HashPassword) passwordHelper.encryptPassword(password);
	}

	/**
	 * 获取系统中存储的用户密码密文
	 * 
	 * @param info
	 * @return
	 */
	protected HashPassword getCredentials(AuthenticationInfo info) {
		HashPassword password = new HashPassword();
		Principal user = getUserFromInfo(info);
		password.setCiphertext(user.getPassword());
		return password;
	}

	protected Principal getUserFromInfo(AuthenticationInfo info) {
		return (Principal) info.getPrincipals().getPrimaryPrincipal();
	}

	public HashPasswordHelper getPasswordHelper() {
		return passwordHelper;
	}

	public void setPasswordHelper(HashPasswordHelper passwordHelper) {
		this.passwordHelper = passwordHelper;
	}

	public AuthenticationHelper getAuthenHelper() {
		return authenHelper;
	}

	public void setAuthenHelper(AuthenticationHelper authenHelper) {
		this.authenHelper = authenHelper;
	}
}
