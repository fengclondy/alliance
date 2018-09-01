package com.ai.aso.common.sequence;

import com.ai.aso.common.db.dao.SequenceConfMapper;
import com.ai.aso.common.db.model.SequenceConf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
public class SequenceFactory {

	Logger logger = LoggerFactory.getLogger(SequenceFactory.class);

	private static final Map<String, ISequence> sequences = new HashMap<>();

	@Autowired
	private SequenceConfMapper seqConfDao;

	@Autowired
	private RedisSequenceHelper redisSeqHelper;

	public void initAll() {
		List<SequenceConf> seqConfList = seqConfDao.selectAll();
		if (null != seqConfList) {
			for (SequenceConf seqConf : seqConfList) {
				String seqKey = seqConf.getSeqKey();
				if (seqKey != null) {
					RedisCacheSequence sequence = new RedisCacheSequence(
							redisSeqHelper, seqConf);
					sequences.put(seqKey, sequence);
				}
			}
		}
	}

	public ISequence getSequence(String name) {
		ISequence sequence = sequences.get(name);
		if (sequence == null) {
			SequenceConf seqConf = seqConfDao.selectByPrimaryKey(name);
			if (seqConf != null && seqConf.getSeqKey() != null) {
				sequence = new RedisCacheSequence(redisSeqHelper, seqConf);
				sequences.put(name, sequence);
			}
		}
		return sequence;
	}

	public String next(String name) {
		return getSequence(name).next();
	}

	public List<String> next(String name, int n) {
		return getSequence(name).next(n);
	}

	public Long nextLong(String name) {
		return Long.parseLong(next(name));
	}

}
