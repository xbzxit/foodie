package com.xbzxit.foodie.enums;

/**
 * 性别枚举
 * @author HFZJ
 * @version 1.0
 * @create 2024-03-14-16:18
 * @company www.nuzarsurf.com
 */

public enum Sex {
    woman(0, "女"),
    man(1, "男"),
    secret(2, "保密");

    public final Integer type;
    public final String value;

    Sex(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}

