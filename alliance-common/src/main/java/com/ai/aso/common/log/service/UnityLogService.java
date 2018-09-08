/**
 * 系统日志入库统一入口
 */
/**
 * @author wuqiang6
 *
 */

package com.ai.aso.common.log.service;

import com.ai.aso.common.db.model.UserLoginLog;
import com.ai.aso.common.db.model.UserOperLog;

public interface UnityLogService {
	
	/**
	 * 登录日志入库
	 */
	public Integer longinLogInsertSelective(UserLoginLog userLoginLog);
	
	/**
	 * 操作日志入库
	 */
	public Integer operLogInsertSelective(UserOperLog userOperLog);
	
	/**
	 * 操作日志更新
	 */
	public Integer operLogUpdate(UserOperLog userOperLog);
}
