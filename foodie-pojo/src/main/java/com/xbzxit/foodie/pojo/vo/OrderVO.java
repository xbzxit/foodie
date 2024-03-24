package com.xbzxit.foodie.pojo.vo;

/**
 * @author HFZJ
 * @version 1.0
 * @create 2024-03-24-17:51
 * @company www.nuzarsurf.com
 */

public class OrderVO {

    private String orderId;
    private MerchantOrdersVO merchantOrdersVO;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public MerchantOrdersVO getMerchantOrdersVO() {
        return merchantOrdersVO;
    }

    public void setMerchantOrdersVO(MerchantOrdersVO merchantOrdersVO) {
        this.merchantOrdersVO = merchantOrdersVO;
    }
}
