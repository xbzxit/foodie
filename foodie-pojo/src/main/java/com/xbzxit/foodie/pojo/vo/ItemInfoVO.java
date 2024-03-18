package com.xbzxit.foodie.pojo.vo;

import com.xbzxit.foodie.pojo.Items;
import com.xbzxit.foodie.pojo.ItemsImg;
import com.xbzxit.foodie.pojo.ItemsParam;
import com.xbzxit.foodie.pojo.ItemsSpec;

import java.util.List;

/**
 * 商品详情VO
 *
 * @author HFZJ
 * @version 1.0
 * @create 2024-03-18-15:06
 * @company www.nuzarsurf.com
 */

public class ItemInfoVO {

    private Items item;
    private List<ItemsImg> itemImgList;
    private List<ItemsSpec> itemSpecList;
    private ItemsParam itemParams;

    public Items getItem() {
        return item;
    }

    public void setItem(Items item) {
        this.item = item;
    }

    public List<ItemsImg> getItemImgList() {
        return itemImgList;
    }

    public void setItemImgList(List<ItemsImg> itemImgList) {
        this.itemImgList = itemImgList;
    }

    public List<ItemsSpec> getItemSpecList() {
        return itemSpecList;
    }

    public void setItemSpecList(List<ItemsSpec> itemSpecList) {
        this.itemSpecList = itemSpecList;
    }

    public ItemsParam getItemParams() {
        return itemParams;
    }

    public void setItemParams(ItemsParam itemParams) {
        this.itemParams = itemParams;
    }
}
