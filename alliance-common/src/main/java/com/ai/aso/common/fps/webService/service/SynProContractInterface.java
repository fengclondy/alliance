package com.ai.aso.common.fps.webService.service;/**
 * Created by DK on 2017/10/23.
 */

import com.ai.aso.base.exception.BusinessException;
import com.ai.aso.common.fps.webService.model.ContractSync;
import com.ai.aso.common.fps.webService.model.ContractSyncResult;

/**
 * @author dk
 * @create 2017-10-23-10:01
 **/
public interface SynProContractInterface {

    public ContractSyncResult synProContractInfo(ContractSync contractSync);

    public boolean chickDate(ContractSync contractSync) throws BusinessException;
}
