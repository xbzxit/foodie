package com.xbzxit.foodie.mapper;

import com.xbzxit.foodie.pojo.vo.CategoryVO;
import com.xbzxit.foodie.pojo.vo.NewItemsVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author HFZJ
 * @version 1.0
 * @create 2024-03-16-21:30
 * @company www.nuzarsurf.com
 */

@Mapper
public interface CategoryMapperCustom {

    List<CategoryVO> getSubCatList(Integer rootCatId);

    List<NewItemsVO> getSixNewItemsLazy(@Param("paramsMap") Map<String, Object> map);

}
