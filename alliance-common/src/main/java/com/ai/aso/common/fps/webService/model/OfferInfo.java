package com.ai.aso.common.fps.webService.model;/**
 * Created by DK on 2017/10/23.
 */

/**
 * @author dk
 * @create 2017-10-23-13:45
 **/
public class OfferInfo {
    private String offer_id;
    private String discount;

    public String getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(String offer_id) {
        this.offer_id = offer_id;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "offer_id=" + offer_id +
                ", discount=" + discount ;
    }
}
