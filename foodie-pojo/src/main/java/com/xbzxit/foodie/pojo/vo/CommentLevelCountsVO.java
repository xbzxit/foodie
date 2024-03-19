package com.xbzxit.foodie.pojo.vo;

/**
 * 用于展示商品评价数量的vo
 *
 * @author HFZJ
 * @version 1.0
 * @create 2024-03-19-10:30
 * @company www.nuzarsurf.com
 */

public class CommentLevelCountsVO {

    /**
     * 评价总数
     */
    public Integer totalCounts;
    /**
     * 好评数
     */
    public Integer goodCounts;
    /**
     * 一般数
     */
    public Integer normalCounts;
    /**
     * 差评数
     */
    public Integer badCounts;

    public Integer getTotalCounts() {
        return totalCounts;
    }

    public void setTotalCounts(Integer totalCounts) {
        this.totalCounts = totalCounts;
    }

    public Integer getGoodCounts() {
        return goodCounts;
    }

    public void setGoodCounts(Integer goodCounts) {
        this.goodCounts = goodCounts;
    }

    public Integer getNormalCounts() {
        return normalCounts;
    }

    public void setNormalCounts(Integer normalCounts) {
        this.normalCounts = normalCounts;
    }

    public Integer getBadCounts() {
        return badCounts;
    }

    public void setBadCounts(Integer badCounts) {
        this.badCounts = badCounts;
    }
}
