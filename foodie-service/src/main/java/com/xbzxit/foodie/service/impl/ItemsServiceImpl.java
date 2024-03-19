package com.xbzxit.foodie.service.impl;

import cn.hutool.core.util.DesensitizedUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xbzxit.foodie.enums.CommentLevel;
import com.xbzxit.foodie.mapper.*;
import com.xbzxit.foodie.pojo.*;
import com.xbzxit.foodie.pojo.vo.CommentLevelCountsVO;
import com.xbzxit.foodie.pojo.vo.ItemCommentVO;
import com.xbzxit.foodie.service.ItemsService;
import com.xbzxit.foodie.utils.PagedGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品服务
 *
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
    @Autowired
    ItemsCommentsMapper itemsCommentsMapper;
    @Autowired
    ItemsMapperCustom itemsMapperCustom;


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

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public CommentLevelCountsVO queryCommentCount(String itemId) {
        Integer good = this.getCommentCounts(itemId, CommentLevel.GOOD.type);
        Integer normal = this.getCommentCounts(itemId, CommentLevel.NORMAL.type);
        Integer bad = this.getCommentCounts(itemId, CommentLevel.BAD.type);
        Integer count = good + normal + bad;
        CommentLevelCountsVO countsVO = new CommentLevelCountsVO();
        countsVO.setTotalCounts(count);
        countsVO.setGoodCounts(good);
        countsVO.setNormalCounts(normal);
        countsVO.setBadCounts(bad);
        return countsVO;
    }

//    @Transactional(propagation = Propagation.SUPPORTS)
    Integer getCommentCounts(String itemId, Integer level) {
        ItemsComments condition = new ItemsComments();
        condition.setItemId(itemId);
        if (level != null) {
            condition.setCommentLevel(level);
        }
        return itemsCommentsMapper.selectCount(condition);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public PagedGridResult queryPageComments(String itemId, Integer level, Integer page, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("itemId", itemId);
        map.put("level", level);
        PageHelper.startPage(page, pageSize);
        List<ItemCommentVO> list = itemsMapperCustom.queryItemComments(map);

        for (ItemCommentVO vo : list) {
            vo.setNickname(DesensitizedUtil.chineseName(vo.getNickname()));
        }

        return setPageGrid(list,page);
    }

    /**
     * 封装前端要的数据
     * @param list
     * @param page
     * @return
     */
//    @Transactional(propagation = Propagation.SUPPORTS)
    PagedGridResult setPageGrid(List<ItemCommentVO> list, Integer page) {
        PageInfo<?> pageList = new PageInfo<>(list);
        PagedGridResult grid = new PagedGridResult();
        grid.setPage(page);
        grid.setRows(list);
        grid.setTotal(list.size());
        grid.setRecords(pageList.getTotal());
        return grid;
    }

}
