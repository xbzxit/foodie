package com.xbzxit.foodie.pojo.vo;

import java.util.Date;

/**
 * 用于展示商品评价的VO
 *
 * @author HFZJ
 * @version 1.0
 * @create 2024-03-19-11:20
 * @company www.nuzarsurf.com
 */

public class ItemCommentVO {

    /**
     * 评价等级
     */
    private Integer commentLevel;
    /**
     * 评价内容
     */
    private String content;
    /**
     * 规格名
     */
    private String specName;
    /**
     * 评价时间
     */
    private Date createdTime;
    /**
     * 用户图像
     */
    private String userFace;
    /**
     * 用户昵称
     */
    private String nickname;

    public Integer getCommentLevel() {
        return commentLevel;
    }

    public void setCommentLevel(Integer commentLevel) {
        this.commentLevel = commentLevel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUserFace() {
        return userFace;
    }

    public void setUserFace(String userFace) {
        this.userFace = userFace;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
