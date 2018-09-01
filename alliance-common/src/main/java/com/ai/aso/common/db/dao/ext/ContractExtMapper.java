package com.ai.aso.common.db.dao.ext;/**
 * Created by DK on 2017/10/19.
 */

import com.ai.aso.common.fps.webService.model.ContractSync;

import java.util.List;

/**
 * @author dk
 * @create 2017-10-19-17:32
 **/
public interface ContractExtMapper {

    public List<ContractSync> queryNoSyncContract();
}
