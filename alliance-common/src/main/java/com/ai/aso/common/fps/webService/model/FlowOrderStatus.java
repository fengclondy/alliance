package com.ai.aso.common.fps.webService.model;/**
 * Created by DK on 2017/10/24.
 */

/**
 * @author dk
 * @create 2017-10-24-14:43
 **/
public class FlowOrderStatus {
    private String request_no;
    private String phone_id;

    public String getRequest_no() {
        return request_no;
    }

    public void setRequest_no(String request_no) {
        this.request_no = request_no;
    }

    public String getPhone_id() {
        return phone_id;
    }

    public void setPhone_id(String phone_id) {
        this.phone_id = phone_id;
    }

    @Override
    public String toString() {
        return "request_no=" + request_no+"&phone_id=" + phone_id;
    }
}
