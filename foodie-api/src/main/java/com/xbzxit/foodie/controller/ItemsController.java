package com.xbzxit.foodie.controller;

import com.xbzxit.foodie.pojo.Items;
import com.xbzxit.foodie.pojo.ItemsImg;
import com.xbzxit.foodie.pojo.ItemsParam;
import com.xbzxit.foodie.pojo.ItemsSpec;
import com.xbzxit.foodie.pojo.vo.ItemInfoVO;
import com.xbzxit.foodie.service.ItemsService;
import com.xbzxit.foodie.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author HFZJ
 * @version 1.0
 * @create 2024-03-18-14:59
 * @company www.nuzarsurf.com
 */

@Api(value = "商品接口", tags = {"商品信息展示的相关接口"})
@RestController
@RequestMapping("items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @ApiOperation(value = "查询商品详情", notes = "查询商品详情", httpMethod = "GET")
    @GetMapping("/info/{itemId}")
    public JSONResult info( @ApiParam(name = "itemId", value = "商品id", required = true) @PathVariable String itemId) {
        if (StringUtils.isBlank(itemId)) {
            return JSONResult.errorMsg(null);
        }
        Items items = itemsService.queryItemById(itemId);
        List<ItemsImg> itemsImgs = itemsService.queryItemImgList(itemId);
        List<ItemsSpec> itemsSpecs = itemsService.queryItemSpecList(itemId);
        ItemsParam itemsParam = itemsService.queryParamList(itemId);

        ItemInfoVO itemInfoVO = new ItemInfoVO();
        itemInfoVO.setItem(items);
        itemInfoVO.setItemImgList(itemsImgs);
        itemInfoVO.setItemSpecList(itemsSpecs);
        itemInfoVO.setItemParams(itemsParam);
        return JSONResult.ok(itemInfoVO);
    }

}
