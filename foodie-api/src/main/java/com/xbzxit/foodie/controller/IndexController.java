package com.xbzxit.foodie.controller;

import com.xbzxit.foodie.enums.YesOrNo;
import com.xbzxit.foodie.pojo.Carousel;
import com.xbzxit.foodie.pojo.Category;
import com.xbzxit.foodie.service.CarouselService;
import com.xbzxit.foodie.service.CategoryService;
import com.xbzxit.foodie.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author HFZJ
 * @version 1.0
 * @create 2024-03-15-20:00
 * @company www.nuzarsurf.com
 */

@Api(value = "首页", tags = {"首页展示的相关接口"})
@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    CarouselService carouselService;
    @Autowired
    CategoryService categoryService;

    @ApiOperation(value = "获取首页轮播图列表", notes = "获取首页轮播图列表", httpMethod = "GET")
    @GetMapping("/carousel")
    public JSONResult carousel() {
        List<Carousel> list = carouselService.queryAll(YesOrNo.Yes.type);
        return JSONResult.ok(list);
    }

    @ApiOperation(value = "获取商品分类(一级分类)", notes = "获取商品分类(一级分类)", httpMethod = "GET")
    @GetMapping("/cats")
    public JSONResult cats(){
        List<Category> list = categoryService.queryAllRootLevelCat();
        return JSONResult.ok(list);
    }































}
