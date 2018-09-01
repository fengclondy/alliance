package com.ai.aso.common.fps.webService.service.impl;/**
 * Created by DK on 2017/10/23.
 */

import com.ai.aso.base.exception.BusinessException;
import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.common.fps.webService.exception.FpsExInfoEnum;
import com.ai.aso.common.fps.webService.model.ContractSync;
import com.ai.aso.common.fps.webService.model.ContractSyncResult;
import com.ai.aso.common.fps.webService.model.Params;
import com.ai.aso.common.fps.webService.security.AuthManager;
import com.ai.aso.common.fps.webService.service.SynProContractInterface;
import com.ai.aso.common.utils.HttpClientUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dk
 * @create 2017-10-23-10:23
 **/
@Service
public class SynProContractInterfaceImpl implements SynProContractInterface {
    @Autowired
    private AuthManager authManager;

    private static final Logger log = LoggerFactory.getLogger(SynProContractInterfaceImpl.class);

    public ContractSyncResult synProContractInfo(ContractSync contractSync){

        String url = GlobalParamSet.getString(BizConstants.FPS_INTERFACE_URL_CONTRACTSYNC);
        log.debug("入参数据:" + JSONObject.toJSONString(contractSync.toString()));
        Params params = authManager.authorization(JSONObject.toJSONString(contractSync.toString()));
        String reps = HttpClientUtil.post(url, params.toJSONString());
        log.debug("返回数据:" + reps);
        ContractSyncResult result = JSONObject.parseObject(reps,ContractSyncResult.class);
        return result;
    }

    @Override
    public boolean chickDate(ContractSync sync) throws BusinessException{
        if(StringUtils.isBlank(sync.getTransaction_id())||StringUtils.isBlank(sync.getContract_unit_id())
                ||StringUtils.isBlank(sync.getContacts_b())||StringUtils.isBlank(sync.getContact_number_b())
                ||StringUtils.isBlank(sync.getCustomer_name_a())||StringUtils.isBlank(sync.getCertificate_a())
                ||StringUtils.isBlank(sync.getContacts_a())||StringUtils.isBlank(sync.getContact_number_a())
                ||StringUtils.isBlank(sync.getContract_name())||StringUtils.isBlank(sync.getContract_amount())
                ||StringUtils.isBlank(sync.getBegin_date())||StringUtils.isBlank(sync.getEnd_date())
                ||sync.getOffer_info().size()>1||StringUtils.isBlank(sync.getShare_ratio())||StringUtils.isBlank(sync.getContract_appendix())){

            return false;
        }
        return true;
    }


}
