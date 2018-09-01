/**
 * 
 */
package com.ai.aso.common.service;

import java.util.List;

import com.ai.aso.common.bo.DataRecBo;

/** 
 * @ClassName: RechargeMsgSender
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author caiwz
 * @date 2016-10-14 下午3:24:29
 *
 */

public interface RechargeMsgSender {
	public void sendMsgToActiveQ(List<DataRecBo> boList);
	
	public void scanOrderTimeout();
}
