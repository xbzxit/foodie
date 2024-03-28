package com.xbzxit.foodie.service.center;

import com.xbzxit.foodie.pojo.Users;
import com.xbzxit.foodie.pojo.bo.CenterUserBO;

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

    /**
     * 修改用户信息
     * @param userId
     * @param centerUserBO
     * @return
     */
    Users updateUserInfo(String userId, CenterUserBO centerUserBO);

    /**
     * 用户头像更新
     * @param userId
     * @param faceUrl
     * @return
     */
    Users updateUserFace(String userId, String faceUrl);
}
