package com.xbzxit.foodie.service;

import com.xbzxit.foodie.pojo.Category;
import com.xbzxit.foodie.pojo.vo.CategoryVO;
import com.xbzxit.foodie.pojo.vo.NewItemsVO;

import java.util.List;

/**
 * @author HFZJ
 * @version 1.0
 * @create 2024-03-16-21:13
 * @company www.nuzarsurf.com
 */

public interface CategoryService {

    /**
     * 查询所有一级分类
     * @return
     */
    List<Category> queryAllRootLevelCat();

    /**
     * 根据一级分类id查询子分类信息
     * @param rootCatId
     * @return
     */
    List<CategoryVO> getSubCatList(Integer rootCatId);

    /**
     * 查询首页每个一级分类下的6条最新商品数据
     * @param rootCatId
     * @return
     */
    List<NewItemsVO> getSixNewItemLazy(Integer rootCatId);
}
