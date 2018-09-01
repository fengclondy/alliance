package com.ai.aso.security.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

public class AuthenticationHelper {

	protected static String USER_LOCK_PREFIX = "SECURITY:ACCT:";
	protected static String USER_LOCK_SUFFIX = ":LOCK";
	protected static String FAIL_COUNT_PREFIX = "SECURITY:ACCT:";
	protected static String FAIL_COUNT_SUFFIX = ":FAIL";
	protected static int DEFAULT_VERIFY_INTERVAL = 30;
	protected static int DEFAULT_VERIFY_FAIL_LCOUNT = 5;
	protected static int DEFAULT_LOCK_INTERVAL = 3600;

	private RedisTemplate<String, String> redisOps;

	/**
	 * 密码校验周期，单位秒
	 */
	private int verifyInterval;

	/**
	 * 密码校验周期内，允许失败次数
	 */
	private int verifyFailCount;

	/**
	 * 用户锁定时间，单位秒<br>
	 * 0则表示永久锁定
	 */
	private int lockInterval;

	public AuthenticationHelper() {
		this.verifyInterval = DEFAULT_VERIFY_INTERVAL;
		this.verifyFailCount = DEFAULT_VERIFY_FAIL_LCOUNT;
		this.lockInterval = DEFAULT_LOCK_INTERVAL;
	}

	/**
	 * 判断该用户是否被锁定
	 * 
	 * @param userId
	 * @return
	 */
	public boolean isLocked(String userId) {
		String lockedKey = getUserLockKey(userId);
		if (redisOps.hasKey(lockedKey)) {
			return true;
		}
		return false;
	}

	/**
	 * 锁定用户
	 * 
	 * @param userId
	 */
	public void lockUser(String userId) {
		ValueOperations<String, String> valueOps = opsForValue();
		String lockedKey = getUserLockKey(userId);
		String failCountKey = getFailCountKey(userId);
		long count = valueOps.increment(failCountKey, 1);
		if (count == 1) {
			// N秒内第一次失败验证，设置失效时间
			redisOps.expire(failCountKey, verifyInterval, TimeUnit.SECONDS);
		} else if (count >= verifyFailCount) {
			if (lockInterval < 1) {
				// 失败N次以上，锁定该用户
				valueOps.set(lockedKey, "1");
			} else {
				// 失败N次以上，锁定用户M秒
				valueOps.set(lockedKey, "1", lockInterval, TimeUnit.SECONDS);
			}
		}
	}

	/**
	 * 解锁用户
	 * 
	 * @param userId
	 */
	public void unlockUser(String userId) {
		String lockedKey = getUserLockKey(userId);
		redisOps.delete(lockedKey);
	}

	private String getFailCountKey(String id) {
		return processKey(FAIL_COUNT_PREFIX, id, USER_LOCK_SUFFIX);
	}

	private String getUserLockKey(String id) {
		return processKey(USER_LOCK_PREFIX, id, USER_LOCK_SUFFIX);
	}

	private String processKey(String prefix, String id, String suffix) {
		StringBuffer key = new StringBuffer();
		key.append(prefix).append(id).append(suffix);
		return key.toString();
	}

	private ValueOperations<String, String> opsForValue() {
		return redisOps.opsForValue();
	}

	public RedisTemplate<String, String> getRedisOps() {
		return redisOps;
	}

	public void setRedisOps(RedisTemplate<String, String> redisOps) {
		this.redisOps = redisOps;
	}

	public int getVerifyInterval() {
		return verifyInterval;
	}

	public void setVerifyInterval(int verifyInterval) {
		this.verifyInterval = verifyInterval;
	}

	public int getVerifyFailCount() {
		return verifyFailCount;
	}

	public void setVerifyFailCount(int verifyFailCount) {
		this.verifyFailCount = verifyFailCount;
	}

	public int getLockInterval() {
		return lockInterval;
	}

	public void setLockInterval(int lockInterval) {
		this.lockInterval = lockInterval;
	}

}
