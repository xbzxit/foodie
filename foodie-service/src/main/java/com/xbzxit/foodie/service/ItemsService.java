package com.xbzxit.foodie.service;

import com.xbzxit.foodie.pojo.Items;
import com.xbzxit.foodie.pojo.ItemsImg;
import com.xbzxit.foodie.pojo.ItemsParam;
import com.xbzxit.foodie.pojo.ItemsSpec;
import com.xbzxit.foodie.pojo.vo.CommentLevelCountsVO;
import com.xbzxit.foodie.pojo.vo.ShopcartVO;
import com.xbzxit.foodie.utils.PagedGridResult;

import java.util.List;

/**
 * 商品服务接口
 *
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

    /**
     * 根据商品ID查询商品评价总数
     * @param itemId
     * @return
     */
    CommentLevelCountsVO queryCommentCount(String itemId);

    /**
     * 分页查询商品评论内容
     * @param itemId
     * @param level
     * @param page
     * @param pageSize
     * @return
     */
    PagedGridResult queryPageComments(String itemId, Integer level, Integer page, Integer pageSize);

    /**
     * 根据关键字搜索商品列表
     * @param keywords
     * @param sort
     * @param page
     * @param pageSize
     * @return
     */
    PagedGridResult searchItems(String keywords, String sort, Integer page, Integer pageSize);

    /**
     * 根据分类ID搜索商品列表
     * @param catId
     * @param sort
     * @param page
     * @param pageSize
     * @return
     */
    PagedGridResult searchItems(Integer catId, String sort, Integer page, Integer pageSize);

    /**
     * 根据规格ids查询最新的购物车中商品数据（用于刷新渲染购物车中的商品数据）
     * @param specIds
     * @return
     */
    List<ShopcartVO> queryItemsBySpecIds(String specIds);

    /**
     * 减少库存
     * @param specId
     * @param buyCounts
     */
    void decreaseItemSpecStock(String specId, int buyCounts);

}
