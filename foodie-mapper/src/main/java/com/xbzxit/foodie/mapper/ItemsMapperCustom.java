package com.xbzxit.foodie.mapper;

import com.xbzxit.foodie.pojo.vo.ItemCommentVO;
import com.xbzxit.foodie.pojo.vo.SearchItemsVO;
import com.xbzxit.foodie.pojo.vo.ShopcartVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * @author HFZJ
 * @version 1.0
 * @create 2024-03-18-14:14
 * @company www.nuzarsurf.com
 */

@Mapper
public interface ItemsMapperCustom {

    List<ItemCommentVO> queryItemComments(@Param("paramsMap") Map<String, Object> map);

    List<SearchItemsVO> searchItems(@Param("paramsMap") Map<String, Object> map);

    List<SearchItemsVO> searchItemsByThirdCat(@Param("paramsMap") Map<String, Object> map);

    List<ShopcartVO> queryItemsBySpecIds(@Param("paramsList") List specIdsList);

    int decreaseItemSpecStock(@Param("specId") String specId, @Param("pendingCounts") int pendingCounts);
}
