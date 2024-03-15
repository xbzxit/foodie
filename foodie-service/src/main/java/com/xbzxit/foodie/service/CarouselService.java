package com.xbzxit.foodie.service;

import com.xbzxit.foodie.pojo.Carousel;

import java.util.List;

/**
 * @author HFZJ
 * @version 1.0
 * @create 2024-03-15-20:04
 * @company www.nuzarsurf.com
 */

public interface CarouselService {

    /**
     * 查询所有轮播图列表
     * @param isShow
     * @return
     */
    List<Carousel> queryAll(Integer isShow);
}
