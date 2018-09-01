package com.ai.aso.common.fps.webService.model;/**
 * Created by DK on 2017/10/23.
 */

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dk
 * @create 2017-10-23-11:17
 **/
public class ContractSync {
    private String transaction_id;//流水号
    private String contract_unit_id;//省内客户合同签约单位，即地市管理员工号
    private String contacts_b;//签约联系人姓名（乙方）
    private String contact_number_b;//签约联系人电话（乙方）
    private String customer_name_a;//客户公司名称（甲方）
    private String certificate_a;//客户公司纳税人识别号（甲方）
    private String contacts_a;//客户联系人姓名（甲方）
    private String contact_number_a;//客户联系人电话（甲方）
    private String contract_name;//客户合同编号（甲方）
    private String contract_amount;//客户合同签约金额（甲方）
    private String begin_date;
    private String end_date;
    private List<OfferInfo> offer_info;
    private String share_ratio;
    private String contract_appendix;

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getContract_unit_id() {
        return contract_unit_id;
    }

    public void setContract_unit_id(String contract_unit_id) {
        this.contract_unit_id = contract_unit_id;
    }

    public String getContacts_b() {
        return contacts_b;
    }

    public void setContacts_b(String contacts_b) {
        this.contacts_b = contacts_b;
    }

    public String getContact_number_b() {
        return contact_number_b;
    }

    public void setContact_number_b(String contact_number_b) {
        this.contact_number_b = contact_number_b;
    }

    public String getCustomer_name_a() {
        return customer_name_a;
    }

    public void setCustomer_name_a(String customer_name_a) {
        this.customer_name_a = customer_name_a;
    }

    public String getCertificate_a() {
        return certificate_a;
    }

    public void setCertificate_a(String certificate_a) {
        this.certificate_a = certificate_a;
    }

    public String getContacts_a() {
        return contacts_a;
    }

    public void setContacts_a(String contacts_a) {
        this.contacts_a = contacts_a;
    }

    public String getContact_number_a() {
        return contact_number_a;
    }

    public void setContact_number_a(String contact_number_a) {
        this.contact_number_a = contact_number_a;
    }

    public String getContract_name() {
        return contract_name;
    }

    public void setContract_name(String contract_name) {
        this.contract_name = contract_name;
    }

    public String getContract_amount() {
        return contract_amount;
    }

    public void setContract_amount(String contract_amount) {
        this.contract_amount = contract_amount;
    }

    public String getBegin_date() {
        return begin_date;
    }

    public void setBegin_date(String begin_date) {
        this.begin_date = begin_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public List<OfferInfo> getOffer_info() {
        return offer_info;
    }

    public void setOffer_info(List<OfferInfo> offer_info) {
        this.offer_info = offer_info;
    }

    public String getShare_ratio() {
        return share_ratio;
    }

    public void setShare_ratio(String share_ratio) {
        this.share_ratio = share_ratio;
    }

    public String getContract_appendix() {
        return contract_appendix;
    }

    public void setContract_appendix(String contract_appendix) {
        this.contract_appendix = contract_appendix;
    }

    @Override
    public String toString() {

        return "transaction_id=" + transaction_id +
                "&contract_unit_id=" + contract_unit_id +
                "&contacts_b=" + contacts_b +
                "&contact_number_b=" + contact_number_b +
                "&customer_name_a=" + customer_name_a +
                "&certificate_a=" + certificate_a +
                "&contacts_a=" + contacts_a +
                "&contact_number_a=" + contact_number_a +
                "&contract_name=" + contract_name +
                "&contract_amount=" + contract_amount +
                "&begin_date=" + begin_date +
                "&end_date=" + end_date +
                "&offer_info=" + JSONObject.toJSONString(offer_info) +
                "&share_ratio=" + share_ratio +
                "&contract_appendix=" + contract_appendix;
    }

    public static void main(String[] args) {
        ContractSync bo = new ContractSync();
        OfferInfo offerInfo1 = new OfferInfo();
        offerInfo1.setOffer_id("111");
        offerInfo1.setDiscount("aaa");
        OfferInfo offerInfo2 = new OfferInfo();
        offerInfo2.setOffer_id("222");
        offerInfo2.setDiscount("bbb");
        List<OfferInfo> list = new ArrayList<>();
        list.add(offerInfo1);
        list.add(offerInfo2);
        bo.setOffer_info(list);
        System.out.println(bo.toString());
    }

}
