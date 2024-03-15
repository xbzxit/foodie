package com.xbzxit.foodie.service.impl;

import com.xbzxit.foodie.mapper.CarouselMapper;
import com.xbzxit.foodie.pojo.Carousel;
import com.xbzxit.foodie.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author HFZJ
 * @version 1.0
 * @create 2024-03-15-20:04
 * @company www.nuzarsurf.com
 */

@Service
public class CarouselServiceImpl implements CarouselService {

    @Autowired
    CarouselMapper carouselMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Carousel> queryAll(Integer isShow) {
        Example example = new Example(Carousel.class);
        example.orderBy("sort").desc();
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isShow",isShow);
        List<Carousel> result = carouselMapper.selectByExample(example);
        return result;
    }
}
