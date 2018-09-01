package com.ai.aso.common.db.dao.ext;/**
 * Created by DK on 2017/10/25.
 */

import com.ai.aso.common.db.model.FlowOrderLog;

import java.util.List;

/**
 * @author dk
 * @create 2017-10-25-16:41
 **/
public interface FlowOrderLogExtMapper {
    List<FlowOrderLog> queryOutTime();
}
