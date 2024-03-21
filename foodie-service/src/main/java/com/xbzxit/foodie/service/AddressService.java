package com.xbzxit.foodie.service;

import com.xbzxit.foodie.pojo.UserAddress;

import java.util.List;

/**
 * @author HFZJ
 * @version 1.0
 * @create 2024-03-21-9:47
 * @company www.nuzarsurf.com
 */

public interface AddressService {

    /**
     * 根据用户id查询用户的收货地址列表
     * @param userId
     * @return
     */
    List<UserAddress> queryAll(String userId);
}
