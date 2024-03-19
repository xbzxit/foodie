package com.xbzxit.foodie.enums;

/**
 *  商品评价等级 枚举
 *
 * @author HFZJ
 * @version 1.0
 * @create 2024-03-19-10:37
 * @company www.nuzarsurf.com
 */

public enum CommentLevel {

    GOOD(2, "好评"),
    NORMAL(2, "中评"),
    BAD(3, "差评");

    public final Integer type;
    public final String value;

    CommentLevel(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
