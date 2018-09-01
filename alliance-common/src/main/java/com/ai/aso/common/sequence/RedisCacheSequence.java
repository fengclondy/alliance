package com.ai.aso.common.sequence;

import com.ai.aso.common.db.model.SequenceConf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RedisCacheSequence extends AbstractSequence {

	public static final String CACHE_KEY_PREFIX = "SEQ:KEY:"; // 序列在redis中缓存时的key
	// public static final String PERTS_KEY_PREFIX = "SEQ:PERST:"; //
	// 序列在redis中缓存时的key
	public static final Integer DEFAULT_CACHE_NUM = 100;// 默认数字序列在redis中缓存的数量

	Logger logger = LoggerFactory.getLogger(RedisCacheSequence.class);

	private RedisSequenceHelper redisSeqHelper;

	private Integer cachedNum; // 缓存数量

	private Boolean isPersist; // 是否持久化数字序列

	public RedisCacheSequence(RedisSequenceHelper redisSeqHelper,
			SequenceConf seqConf) {
		this.redisSeqHelper = redisSeqHelper;
		this.setName(seqConf.getSeqKey());
		this.setNumLen(seqConf.getNumberLen());
		this.setRandomLen(seqConf.getRandomLen());
		this.setDateFormat(seqConf.getDateFormat());
		this.setCachedNum(seqConf.getIncrement());
		this.setPrefix(seqConf.getPrefix());
		this.setSuffix(seqConf.getSuffix());
		this.setIsPersist(true);
		initRedisCache(seqConf.getCurrentVal());
	}

	protected void initRedisCache(Long initVal) {
		String key = CACHE_KEY_PREFIX.concat(getName());
		if (this.getNumLen() > 0 && redisSeqHelper.initRedisCache(key, initVal)) {
			saveCacheVal(initVal, 0);
		}
	}

	@Override
	protected synchronized Long nextNumVal(int n) {
		String key = CACHE_KEY_PREFIX.concat(getName());
		Long seqVal = redisSeqHelper.increment(key, n);
		this.setCurrentNum(seqVal);
		logger.debug("【{}】获取的数字序列为：{}", getName(), seqVal);
		if (isPersist) {
			saveCacheVal(seqVal, n);
		}
		return seqVal;
	}

	/**
	 * 持久化当前值
	 * 
	 * @param currentVal
	 */
	protected void saveCacheVal(Long currentVal, int n) {
		Long _val = currentVal % getCachedNum();
		if (n >= getCachedNum() || _val == 0) {
			logger.debug("当前数字序列为【{}】，保存当前数字序列", currentVal);
			redisSeqHelper.saveCacheVal(getName(), currentVal, getCachedNum());
		}
	}

	public RedisSequenceHelper getRedisSeqHelper() {
		return redisSeqHelper;
	}

	public void setRedisSeqHelper(RedisSequenceHelper redisSeqHelper) {
		this.redisSeqHelper = redisSeqHelper;
	}

	public Integer getCachedNum() {
		return cachedNum < 1 ? DEFAULT_CACHE_NUM : cachedNum;
	}

	public void setCachedNum(Integer cachedNum) {
		this.cachedNum = cachedNum;
	}

	public Boolean getIsPersist() {
		return isPersist;
	}

	public void setIsPersist(Boolean isPersist) {
		this.isPersist = isPersist;
	}

}
