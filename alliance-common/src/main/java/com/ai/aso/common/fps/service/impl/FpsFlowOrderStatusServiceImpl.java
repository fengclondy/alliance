package com.ai.aso.common.fps.service.impl;/**
 * Created by DK on 2017/10/25.
 */

import com.ai.aso.common.bo.DataRecBo;
import com.ai.aso.common.constants.ResultMsg;
import com.ai.aso.common.db.dao.DataRecMapper;
import com.ai.aso.common.db.dao.FlowOrderLogMapper;
import com.ai.aso.common.db.dao.ext.FlowOrderLogExtMapper;
import com.ai.aso.common.db.model.FlowOrderLog;
import com.ai.aso.common.fps.service.FpsFlowOrderStatusService;
import com.ai.aso.common.fps.webService.exception.FpsExInfoEnum;
import com.ai.aso.common.fps.webService.exception.FpsInterfaceException;
import com.ai.aso.common.fps.webService.model.FlowOrderStatus;
import com.ai.aso.common.fps.webService.model.FlowOrderStatusResult;
import com.ai.aso.common.fps.webService.service.impl.FlowOrderInterfaceImpl;
import com.ai.aso.common.service.DistributionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author dk
 * @create 2017-10-25-16:21
 **/
@Service
public class FpsFlowOrderStatusServiceImpl implements FpsFlowOrderStatusService {

    @Autowired
    private FlowOrderInterfaceImpl flowOrderInterface;
    @Autowired
    private FlowOrderLogExtMapper flowOrderLogExtMapper;
    @Autowired
    private FlowOrderLogMapper flowOrderLogMapper;
    @Autowired
    private DataRecMapper dataRecMapper;
    @Autowired
    private DistributionService distributionService;

    private Logger log = LoggerFactory.getLogger("FlowOrder");
    @Override
    public void flowOrderStatusQuery() {
        List<FlowOrderLog> list = flowOrderLogExtMapper.queryOutTime();
        if (null != list && list.size() > 0) {
            //调用查询接口查询
            for(FlowOrderLog orderLog : list){
                FlowOrderStatus status = new FlowOrderStatus();
                status.setRequest_no(orderLog.getRequestNo());
                status.setPhone_id(orderLog.getPhoneId());
                FlowOrderStatusResult result = flowOrderInterface.flowOrderStatus(status);

                DataRecBo dataRecBo = new DataRecBo();
                DataRecBo bo = dataRecBo.convert(dataRecMapper.selectByPrimaryKey(orderLog.getRequestNo()), dataRecBo);
                bo.setResultCode(result.getResult_code());
                bo.setResultMesg(result.getResult_desc());

                try {
                    bo.setEndDate(new SimpleDateFormat("yyyyMMddHHmmss").parse(result.getOrder_time()));
                } catch (ParseException e) {
                    log.error("入参order_time时间格式错误！");
                    throw new FpsInterfaceException(FpsExInfoEnum.FLOW_ORDER_STATE_INFO_REQ_ERROR);
                }

                if ("0".equals(result.getResult_code())){
                    //订购成功
                    orderLog.setState(ResultMsg.FPS_FLOWORDER_SUCCESS);
                    flowOrderLogMapper.updateByPrimaryKeySelective(orderLog);
                    log.debug("商品订购成功！流水号"+result.getRequest_no());
                    bo.setState((short) DistributionService.State.ST_SUCCESS);
                    bo.setBillSerial("");
                    distributionService.crmSuccResult(bo);
                }else {
                    //订购失败
                    //更新状态为订购失败
                    orderLog.setState(ResultMsg.FPS_FLOWORDER_ERROR);
                    log.debug("商品订购失败！流水号"+result.getRequest_no());
                    bo.setState((short)DistributionService.State.ST_FAILD);
                    bo.setBillSerial("");
                    distributionService.crmFieldResult(bo);
                }
            }
        }

    }
}
