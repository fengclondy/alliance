/**
 * 
 */
package com.ai.aso.common.service.impl;

import javax.jms.JMSException;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import com.ai.aso.common.fps.service.impl.FpsRechargeMsgReciverImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConverter;

import com.ai.aso.common.bo.DataRecBo;
import com.ai.aso.common.service.RechargeMsgReciver;

/**
 * @ClassName: RechargeMsgListener
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author caiwz
 * @date 2016-10-14 下午3:28:26
 * 
 */

public class RechargeMsgListener implements MessageListener {

	Logger logger = LoggerFactory.getLogger(RechargeMsgListener.class);

	//@Autowired
	//private RechargeMsgReciver rechargeMsgReciver;
	@Autowired
	private FpsRechargeMsgReciverImpl rechargeMsgReciver;
	@Autowired
	private MessageConverter messageConverterRecharge;

	@Override
	public void onMessage(javax.jms.Message message) {
		// TODO Auto-generated method stub
		if (message instanceof ObjectMessage) {
			ObjectMessage objMessage = (ObjectMessage) message;
			try {

				DataRecBo dr = (DataRecBo) messageConverterRecharge
						.fromMessage(objMessage);
				rechargeMsgReciver.useCrmInterface(dr);
			} catch (JMSException e) {
				logger.error("分销记录获取异常！", e);
			} catch (Exception e) {
				logger.error("分销记录获取异常！", e);
			}
		}

	}

}
