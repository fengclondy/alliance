package com.ai.aso.common.fps.webService.model;/**
 * Created by DK on 2017/10/23.
 */

/**
 * @author dk
 * @create 2017-10-23-16:21
 **/
public class ContractSyncResult {
    private String transaction_id;
    private String result_code;

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }
}
