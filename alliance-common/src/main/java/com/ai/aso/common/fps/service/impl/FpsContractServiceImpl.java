package com.ai.aso.common.fps.service.impl;

import com.ai.aso.base.utils.StringUtil;
import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.common.db.dao.ContractItemMapper;
import com.ai.aso.common.db.dao.ContractMapper;
import com.ai.aso.common.db.dao.ContractSynchronizeMapper;
import com.ai.aso.common.db.dao.DataBookaMapper;
import com.ai.aso.common.db.dao.ext.ContractExtMapper;
import com.ai.aso.common.db.model.Contract;
import com.ai.aso.common.db.model.ContractItem;
import com.ai.aso.common.db.model.ContractItemExample;
import com.ai.aso.common.db.model.ContractSynchronize;
import com.ai.aso.common.db.model.DataBooka;
import com.ai.aso.common.db.model.DataBookaExample;
import com.ai.aso.common.fps.service.FpsContractService;
import com.ai.aso.common.fps.webService.model.ContractSync;
import com.ai.aso.common.fps.webService.model.ContractSyncResult;
import com.ai.aso.common.fps.webService.model.OfferInfo;
import com.ai.aso.common.fps.webService.service.SynProContractInterface;
import com.ai.aso.common.param.AttributeSet;
import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.common.utils.ZipUtil;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FpsContractServiceImpl implements FpsContractService {

    @Autowired
    private ContractMapper contractMapper;

    @Autowired
    private DataBookaMapper dataBookaMapper;
    @Autowired
    private ContractExtMapper contractExtMapper;
    @Autowired
    private SynProContractInterface synProContractInterface;
    @Autowired
    private ContractSynchronizeMapper contractSynchronizeMapper;
    @Autowired
    private ContractItemMapper contractItemMapper;

    public static Logger log = LoggerFactory.getLogger(FpsContractServiceImpl.class);

    @Override
    public long getAmountUsed(String contId) {
        long cumuVal = 0;

        DataBookaExample example2 = new DataBookaExample();
        example2.createCriteria().andContIdEqualTo(contId);
        List<DataBooka> dataBookas = dataBookaMapper
                .selectByExample(example2);
        if(null!=dataBookas&&dataBookas.size()>0){
            // 总使用金额
            Long amount = dataBookas.get(0).getCumuVal();
            if(null != amount){
                cumuVal = amount.longValue();
            }
        }
        return cumuVal;
    }

    @Override
    public String getContractState(String contId) {
        Contract contract = contractMapper.selectByPrimaryKey(contId);

        String stateName = null;
        //结果：1. 合同状态为生效前的状态，直接返回状态中文
        //     2. 合同状态为已生效，但超出截止日期
        //     3. 合同状态为已生效，判定子状态
        if (null != contract) {
            if (contract.getState() != GlobalParamSet.getInteger(BizConstants.CONTRACT_STATE_ENABLED)) {
                stateName = AttributeSet.getAttrGroup(BizConstants.ATTR_CONTRACT_STATE).getName(String.valueOf(contract.getState()));
            } else if(new Date().after(contract.getExpDate())) {
                stateName = AttributeSet.getAttrGroup(BizConstants.ATTR_CONTRACT_STATE).getName(GlobalParamSet.getString(BizConstants.CONTRACT_STATE_EXPIRED));
            } else {
                stateName = AttributeSet.getAttrGroup(BizConstants.ATTR_CONTRACT_SUB_STATE).getName(String.valueOf(contract.getSubState()));
            }
        }

        return stateName;
    }

    /**
     * 合同同步
     */
    @Override
    public void synProContractInfo(){

        List<ContractSync> list = contractExtMapper.queryNoSyncContract();
        for(ContractSync contractSync : list){

            String Cont_Copy = contractSync.getContract_appendix();
            if(StringUtil.isEmpty(Cont_Copy)){
                String c = Base64.encodeBase64(ZipUtil.zip(Cont_Copy)).toString();
                contractSync.setContract_appendix(c);
            }
            ContractItemExample itemExample = new ContractItemExample();
            itemExample.createCriteria().andContIdEqualTo(contractSync.getTransaction_id());
            List<ContractItem> items = contractItemMapper.selectByExample(itemExample);
            List<OfferInfo> offerInfos = new ArrayList<>();
            for(ContractItem item : items){
                OfferInfo info = new OfferInfo();
                info.setOffer_id(item.getExt1());
                info.setDiscount(item.getOffRate().toString());
                offerInfos.add(info);
            }
            contractSync.setOffer_info(offerInfos);

            log.debug("合同同步入参："+contractSync.toString());

            if(synProContractInterface.chickDate(contractSync)){

                ContractSyncResult result = synProContractInterface.synProContractInfo(contractSync);
                if(!"00000".equals(result.getResult_code())){
                    log.error("合同同步异常:"+"合同标识"+result.getTransaction_id()+",代码："+result.getResult_code());
                } else {
                    ContractSynchronize synchronize= new ContractSynchronize();
                    synchronize.setContId(contractSync.getTransaction_id());
                    synchronize.setState("1");
                    synchronize.setCreateDate(new Date());
                    contractSynchronizeMapper.insertSelective(synchronize);
                    log.debug("合同同步成功，合同标识"+contractSync.getTransaction_id());
                }
            }else{
                log.error("合同同步异常:"+"合同标识"+contractSync.getTransaction_id()+",代码："+"入参不完整！入参参数："+contractSync.toString());
            }


        }
    }
}
