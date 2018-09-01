package com.ai.aso.common.fps.webService.model;

public class FlowOrder {

    private String request_no;       //请求流水号（长度小于 30），由客户生成并保证唯一
    private String service_code;     //服务编码，本接口为WS0003
    private String contract_name;    //省内平台客户合同编码
    private String phone_id;         //充值手机号码
    private String crm_offer_id;     //省内crm销售品编码，由省内透传
    private String discount;         //销售品折扣

    public String getRequest_no() {
        return request_no;
    }

    public void setRequest_no(String request_no) {
        this.request_no = request_no;
    }

    public String getService_code() {
        return service_code;
    }

    public void setService_code(String service_code) {
        this.service_code = service_code;
    }

    public String getContract_name() {
        return contract_name;
    }

    public void setContract_name(String contract_name) {
        this.contract_name = contract_name;
    }

    public String getPhone_id() {
        return phone_id;
    }

    public void setPhone_id(String phone_id) {
        this.phone_id = phone_id;
    }

    public String getCrm_offer_id() {
        return crm_offer_id;
    }

    public void setCrm_offer_id(String crm_offer_id) {
        this.crm_offer_id = crm_offer_id;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "request_no=" + request_no +
                "&service_code=" + service_code +
                "&contract_name=" + contract_name +
                "&phone_id=" + phone_id +
                "&crm_offer_id=" + crm_offer_id +
                "&discount=" + discount ;
    }
}
