/**
 * 
 */
package com.ai.aso.common.service;

import com.ai.aso.common.bo.DataRecBo;


/** 
 * @ClassName: RechargeMsgReciver
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author caiwz
 * @date 2016-10-14 下午3:25:14
 *
 */

public interface RechargeMsgReciver {

	void useCrmInterface(DataRecBo bo);
	void order(DataRecBo bo);
	void orderNew(DataRecBo bo);
}
