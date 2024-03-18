package com.xbzxit.foodie.service.impl;

import com.xbzxit.foodie.mapper.ItemsImgMapper;
import com.xbzxit.foodie.mapper.ItemsMapper;
import com.xbzxit.foodie.mapper.ItemsParamMapper;
import com.xbzxit.foodie.mapper.ItemsSpecMapper;
import com.xbzxit.foodie.pojo.Items;
import com.xbzxit.foodie.pojo.ItemsImg;
import com.xbzxit.foodie.pojo.ItemsParam;
import com.xbzxit.foodie.pojo.ItemsSpec;
import com.xbzxit.foodie.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author HFZJ
 * @version 1.0
 * @create 2024-03-18-14:22
 * @company www.nuzarsurf.com
 */

@Service
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    ItemsMapper itemsMapper;
    @Autowired
    ItemsImgMapper itemsImgMapper;
    @Autowired
    ItemsParamMapper itemsParamMapper;
    @Autowired
    ItemsSpecMapper itemsSpecMapper;


    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Items queryItemById(String itemId) {
        return itemsMapper.selectByPrimaryKey(itemId);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<ItemsImg> queryItemImgList(String itemId) {
        Example example = new Example(ItemsImg.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("itemId", itemId);
        return itemsImgMapper.selectByExample(example);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public ItemsParam queryParamList(String itemId) {
        Example example = new Example(ItemsParam.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("itemId", itemId);
        return itemsParamMapper.selectOneByExample(example);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<ItemsSpec> queryItemSpecList(String itemId) {
        Example example = new Example(ItemsSpec.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("itemId", itemId);
        return itemsSpecMapper.selectByExample(example);
    }
}
