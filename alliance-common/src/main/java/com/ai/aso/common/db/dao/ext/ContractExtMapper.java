package com.ai.aso.common.db.dao.ext;/**
 * Created by DK on 2017/10/19.
 */

import com.ai.aso.common.fps.webService.model.ContractSync;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author dk
 * @create 2017-10-19-17:32
 **/
@Mapper
public interface ContractExtMapper {

    public List<ContractSync> queryNoSyncContract();
}
