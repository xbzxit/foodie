package com.xbzxit.foodie.enums;

/**
 * @author HFZJ
 * @version 1.0
 * @create 2024-03-15-20:12
 * @company www.nuzarsurf.com
 */

public enum YesOrNo {

    Yes(1, "是"),
    No(0, "否");

    public final Integer type;
    public final String value;

    YesOrNo(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
