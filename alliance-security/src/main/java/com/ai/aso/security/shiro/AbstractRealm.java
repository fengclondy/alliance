package com.ai.aso.security.shiro;

import com.ai.aso.security.constants.SecurityConstants;
import com.ai.aso.security.model.Principal;
import com.ai.aso.security.shiro.exception.UnknownHostException;
import com.ai.aso.security.utils.AuthenticationHelper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;

public abstract class AbstractRealm extends AuthorizingRealm {

	Logger logger = LoggerFactory.getLogger(AbstractRealm.class);

	private AuthenticationHelper authenHelper;

	private boolean hostRestrict = false;

	/**
	 * 获取用户角色及权限列表
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		SimpleAuthorizationInfo info = null;
		Object principal = principals.getPrimaryPrincipal();
		if (principal != null && principal instanceof Principal) {
			String accId = ((Principal) principal).getAccId();
			logger.debug("获取用户拥有权限，用户身份ID为：{}", accId);
			info = new SimpleAuthorizationInfo();
			info.setRoles(findRoles(accId));
			info.setStringPermissions(findPermissions(accId));
		} else {
			logger.warn("principal对象不是User类的实例！");
		}
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = (String) upToken.getPrincipal();
		logger.debug("用户登录输入用户名为：{}", username);
		
		
		Principal user = findUser(username);
		// 用户不存在
		if (user == null) {
			logger.warn("不存在该用户");
			throw new UnknownAccountException("用户名或密码错误！");
		}
		// 用户被禁用
		if (SecurityConstants.LOGIN_ACCT_DISABLED == user.getState()) {
			logger.warn("账号已被禁用，账号名称：{}", user.getUserName());
			throw new DisabledAccountException("用户名或密码错误！");
		}
		// 用户被永久锁定
		if (SecurityConstants.LOGIN_ACCT_LOCKED == user.getState()) {
			logger.warn("账号已被永久锁定，账号名称：{}", user.getUserName());
			throw new LockedAccountException("账号已被锁定，请联系管理员解锁！");
		}
		// 检查用户状态
		if (userIsLocked(user)) {
			logger.warn("账号已被锁定，账号名称：{}", user.getUserName());
			throw new LockedAccountException("账号已被锁定，请等待账号解锁！");
		}
		// 校验客户端IP是否在IP限制列表中
		if (hostRestrict) {
			if (!hostIsValid(user, upToken.getHost())) {
				logger.warn("客户端IP{}，不在允许访问列表内", upToken.getHost());
				throw new UnknownHostException("用户名或密码错误！");
			}
		}
		user.setLoginName(username);
		logger.debug("登录用户身份ID为：{}，用户名为：{}", user.getAccId(),
				user.getUserName());
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,
				user.getPassword(), ByteSource.Util.bytes(user.getHashSalt()),
				this.getName());
		return info;
	}

	/**
	 * 检查用户账号状态
	 * 
	 * @param user
	 * @return
	 */
	protected boolean userIsLocked(Principal user) {
		return authenHelper.isLocked(user.getAccId());
	}

	/**
	 * 校验客户端IP是否在IP限制列表中
	 * 
	 * @param user
	 * @param host
	 * @throws AuthenticationException
	 */
	protected boolean hostIsValid(Principal user, String host) {
		if (host == null || "".equals(host)) {
			logger.error("token中host为空！");
			throw new IllegalArgumentException("host in token is null.");
		}
		List<String> hostList = user.getHostIp();
		if (hostList == null || hostList.isEmpty()) {
			logger.warn("没有配置限定IP列表");
			return false;
		}
		for (String allowHost : hostList) {
			logger.debug("客户端IP为：{}，允许IP为：{}", host, allowHost);
			if (host.equals(allowHost)) {
				return true;
			}
		}
		return false;
	}

	public AuthenticationHelper getAuthenHelper() {
		return authenHelper;
	}

	public void setAuthenHelper(AuthenticationHelper authenHelper) {
		this.authenHelper = authenHelper;
	}

	public boolean isHostRestrict() {
		return hostRestrict;
	}

	public void setHostRestrict(boolean hostRestrict) {
		this.hostRestrict = hostRestrict;
	}

	/**
	 * 根据用户ID查找该用户对应的角色
	 * 
	 * @param userId
	 * @return
	 */
	protected abstract Set<String> findRoles(String userId);

	/**
	 * 根据用户ID查找该用户对应的权限
	 * 
	 * @param userId
	 * @return
	 */
	protected abstract Set<String> findPermissions(String userId);

	/**
	 * 根据用户名查找该用户账号信息
	 * 
	 * @param userName
	 * @return
	 */
	protected abstract Principal findUser(String userName);

}
