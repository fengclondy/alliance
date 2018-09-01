package com.ai.aso.common.log.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.aso.common.log.UnityLogService;
import com.ai.aso.common.log.dao.UserLoginLogMapper;
import com.ai.aso.common.log.dao.UserOperLogMapper;
import com.ai.aso.common.log.model.UserLoginLog;
import com.ai.aso.common.log.model.UserOperLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("unityLogService")
public class UnityLogServiceImpl implements UnityLogService {
	
	private static final Logger logger = LoggerFactory.getLogger(UnityLogServiceImpl.class);
	
	@Autowired
//	@Qualifier("userLoginLogMapper")
	private UserLoginLogMapper userLoginLogMapper;
	
	@Autowired
//	@Qualifier("userOperLogMapper")
	private UserOperLogMapper userOperLogMapper;
	
	/**
	 * 登录日志入库
	 * @param userLoginLog 用于入库的登录日志模型
	 * @return 插入记录的条数
	 */
	@Override
	public Integer longinLogInsertSelective(UserLoginLog userLoginLog) {
		Integer returnValue = 0;
		try{
			returnValue = userLoginLogMapper.insertSelective(userLoginLog);
		}catch(Exception allException){
			try{
				logger.error("登录日志入库失败！", allException);
			}catch(Exception ex){
				
			}
		}
		return returnValue;
	}

	/**
	 * 操作日志入库
	 * @param userOperLog 用于入库的用户操作模型
	 * @return 插入记录的条数
	 */
	@Override
	public Integer operLogInsertSelective(UserOperLog userOperLog) {
		Integer returnValue = 0;
		try{
			returnValue = userOperLogMapper.insertSelective(userOperLog);
		}catch(Exception allException){
			try{
				logger.error("用户操作日志入库失败！", allException);
			}catch(Exception ex){
				
			}
		}
		return returnValue;
	}
	
	
	/**
	 * 操作日志更新
	 * @param userOperLog 用于入库的用户操作模型
	 * @return 插入记录的条数
	 */
	@Override
	public Integer operLogUpdate(UserOperLog userOperLog) {
		Integer returnValue = 0;
		try{
			returnValue = userOperLogMapper.updateByPrimaryKeySelective(userOperLog);
		}catch(Exception allException){
			try{
				logger.error("用户操作日志更新失败！", allException);
			}catch(Exception ex){
				
			}
		}
		return returnValue;
	}
	
}
