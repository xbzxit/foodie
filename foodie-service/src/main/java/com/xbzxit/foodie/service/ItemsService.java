package com.xbzxit.foodie.service;

import com.xbzxit.foodie.pojo.Items;
import com.xbzxit.foodie.pojo.ItemsImg;
import com.xbzxit.foodie.pojo.ItemsParam;
import com.xbzxit.foodie.pojo.ItemsSpec;

import java.util.List;

/**
 * @author HFZJ
 * @version 1.0
 * @create 2024-03-18-14:21
 * @company www.nuzarsurf.com
 */

public interface ItemsService {


    /**
     * 根据商品ID查询详情
     * @param itemId
     * @return
     */
    Items queryItemById(String itemId);


    /**
     * 根据商品ID查询商品图片列表
     * @param itemId
     * @return
     */
    List<ItemsImg> queryItemImgList(String itemId);

    /**
     * 根据商品ID查询商品参数列表
     * @param itemId
     * @return
     */
    ItemsParam queryParamList(String itemId);

    /**
     * 根据商品ID查询商品规格列表
     * @param itemId
     * @return
     */
    List<ItemsSpec> queryItemSpecList(String itemId);

}
