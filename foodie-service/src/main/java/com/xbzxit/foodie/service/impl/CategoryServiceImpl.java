package com.xbzxit.foodie.service.impl;

import com.xbzxit.foodie.mapper.CategoryMapper;
import com.xbzxit.foodie.pojo.Category;
import com.xbzxit.foodie.pojo.vo.CategoryVO;
import com.xbzxit.foodie.pojo.vo.NewItemsVO;
import com.xbzxit.foodie.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author HFZJ
 * @version 1.0
 * @create 2024-03-16-21:18
 * @company www.nuzarsurf.com
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public List<Category> queryAllRootLevelCat() {
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("type",1);
        List<Category> result = categoryMapper.selectByExample(example);
        return result;
    }

    @Override
    public List<CategoryVO> getSubCatList(Integer rootCatId) {

        return null;
    }

    @Override
    public List<NewItemsVO> getSixNewItemLazy(Integer rootCatId) {
        return null;
    }
}
