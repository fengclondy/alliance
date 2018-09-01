/**
 * 
 */
package com.ai.aso.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.ai.aso.common.bo.DataRecBo;
import com.ai.aso.common.db.dao.DataRecMapper;
import com.ai.aso.common.db.model.DataRec;
import com.ai.aso.common.db.model.DataRecExample;
import com.ai.aso.common.service.DistributionService;
import com.ai.aso.common.service.RechargeMsgSender;

/** 
 * @ClassName: RechargeMsgSenderImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author caiwz
 * @date 2016-10-14 下午3:56:56
 *
 */
@Component
public class RechargeMsgSenderImpl implements RechargeMsgSender {

	@Autowired
	private JmsTemplate jmsTemplateRecharge;
	
	@Autowired
	private DataRecMapper dataRecMapper;
	
    public void send(final Object message) {
        
    	try{
    		jmsTemplateRecharge.convertAndSend(message);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    	/*jmsTemplateSms.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });*/
        
    }
	/* (non-Javadoc)
	 * 
	 * 调用次接口向充值队列发送充值消息
	 * @see com.ai.aso.common.service.RechargeMsgSender#sendMsgToActiveQ(java.util.List)
	 */
	@Override
	public void sendMsgToActiveQ(List<DataRecBo> boList) {
		// TODO Auto-generated method stub
		for(DataRecBo bo : boList)
		{
			send(bo);
		}
	}
	
	/**
	 * 
	 * 扫描数据库 
	 * */
	@Override
	public void scanOrderTimeout() {
		// TODO Auto-generated method stub
		DataRecExample example = new DataRecExample();
		example.createCriteria()
			   .andStateEqualTo((short)DistributionService.State.ST_TIMEOUT)
			   .andVerEqualTo(0);
		List<DataRec> list = dataRecMapper.selectByExample(example);
		if( list != null && list.size() != 0 )
		{
			for ( DataRec dr : list )
			{
				DataRecBo bo = new DataRecBo();
				bo.convert(dr, bo);			
				send(bo);
			}
		}
	}

}
