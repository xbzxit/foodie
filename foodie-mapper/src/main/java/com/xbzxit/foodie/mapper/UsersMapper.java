package com.xbzxit.foodie.mapper;

import com.xbzxit.foodie.my.mapper.MyMapper;
import com.xbzxit.foodie.pojo.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersMapper extends MyMapper<Users> {
}
