package com.ai.aso.common.sequence;

import com.ai.aso.common.db.dao.SequenceConfMapper;
import com.ai.aso.common.db.model.SequenceConf;
import com.ai.aso.common.sequence.exception.SeqNumException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
@Component
public class RedisSequenceHelper {

	Logger logger = LoggerFactory.getLogger(RedisSequenceHelper.class);

	@Resource(name = "redisTemplate")
	private RedisTemplate<String, String> redisTemplate;

	@Resource(name = "redisTemplate")
	private ValueOperations<String, Object> valueOps;

	@Resource(name = "sequenceConfMapper")
	private SequenceConfMapper seqConfDao;

	public boolean initRedisCache(String seqKey, Long initVal) {
		if (redisTemplate.hasKey(seqKey)) {
			logger.info("序列【{}】已缓存在Redis中", seqKey);
			return false;
		}
		logger.info("在Redis中初始化序列【{}:{}】", seqKey, initVal);
		valueOps.set(seqKey, initVal.toString());
		return true;
	}

	/**
	 * 获取redis中的序列
	 * 
	 * @param seqKey
	 * @return
	 */
	public Long increment(String seqKey, int n) {
		if (!redisTemplate.hasKey(seqKey)) {
			logger.error("该序列不存在，尝试从持久库中装载！");
			throw new SeqNumException();
		}
		return valueOps.increment(seqKey, n);
	}

	/**
	 * 持久化当前值
	 * 
	 * @param currentVal
	 */
	public void saveCacheVal(String seqKey, Long currentVal, Integer cachedNum) {
		SequenceConf seqConf = seqConfDao.selectByPrimaryKey(seqKey);
		if (seqConf == null) {
			logger.warn("持久库中未获取到该序列【{}】！", seqKey);
			return;
		}
		if (seqConf.getCurrentVal() <= currentVal) {
			SequenceConf newConf = new SequenceConf();
			newConf.setSeqKey(seqKey);
			newConf.setCurrentVal(currentVal + cachedNum);
			newConf.setVer(seqConf.getVer());
			if (seqConfDao.saveNumberVal(newConf) != 1) {
				logger.warn("当前数字序列为【{}】，持久化失败", currentVal);
			}
		}
	}

}
