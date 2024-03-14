package com.xbzxit.foodie.my.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 继承自己的MyMapper
 * @author HFZJ
 * @version 1.0
 * @create 2024-03-14-13:13
 * @company www.nuzarsurf.com
 */

public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
