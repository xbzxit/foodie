package com.xbzxit.foodie.service.center;

import com.xbzxit.foodie.pojo.Users;

/**
 * @author HFZJ
 * @version 1.0
 * @create 2024-03-18-17:33
 * @company www.nuzarsurf.com
 */

public interface CenterUserService {

    /**
     * 根据用户id查询用户信息
     * @param userId
     * @return
     */
    Users queryUserInfo(String userId);
}
