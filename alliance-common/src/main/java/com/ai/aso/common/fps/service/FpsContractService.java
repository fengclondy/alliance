package com.ai.aso.common.fps.service;

public interface FpsContractService {

    /**
     * 查询已使用额度
     * @param contId
     * @return
     */
    public long getAmountUsed(String contId);

    public String getContractState(String contId);

    public void synProContractInfo();
}
