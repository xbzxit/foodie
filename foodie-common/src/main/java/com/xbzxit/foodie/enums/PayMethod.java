package com.xbzxit.foodie.enums;

/**
 * 支付方式 枚举
 *
 * @author HFZJ
 * @version 1.0
 * @create 2024-03-24-17:47
 * @company www.nuzarsurf.com
 */

public enum PayMethod {

    WEIXIN(1, "微信"),
    ALIPAY(2, "支付宝");

    public final Integer type;
    public final String value;

    PayMethod(Integer type, String value){
        this.type = type;
        this.value = value;
    }

}
