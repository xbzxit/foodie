package com.xbzxit.foodie.service;

import com.xbzxit.foodie.pojo.Users;
import com.xbzxit.foodie.pojo.bo.UserBO;

/**
 * 用户管理服务接口
 *
 * @author HFZJ
 * @version 1.0
 * @create 2024-03-14-13:29
 * @company www.nuzarsurf.com
 */

public interface UserService {

    /**
     * 查询用户是否存在
     * @param username
     * @return
     */
    boolean queryUsernameIsExist(String username);

    /**
     * 用户注册
     * @param userBO
     * @return
     */
    Users createUser(UserBO userBO);

    /**
     * 用户登录
     * @param userBO
     * @return
     */
    Users queryUserForLogin(String username, String password);
}
