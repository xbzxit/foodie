package com.xbzxit.foodie.service.impl.center;

import com.xbzxit.foodie.mapper.UsersMapper;
import com.xbzxit.foodie.pojo.Users;
import com.xbzxit.foodie.pojo.bo.CenterUserBO;
import com.xbzxit.foodie.service.center.CenterUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author HFZJ
 * @version 1.0
 * @create 2024-03-18-17:35
 * @company www.nuzarsurf.com
 */

@Service
public class CenterUserServiceImpl implements CenterUserService {

    @Autowired
    private UsersMapper usersMapper;


    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS)
    @Override
    public Users queryUserInfo(String userId) {
        Users users= usersMapper.selectByPrimaryKey(userId);
        users.setPassword(null);
        return users;
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    @Override
    public Users updateUserInfo(String userId, CenterUserBO centerUserBO) {
        Users updateUsers = new Users();
        BeanUtils.copyProperties(centerUserBO, updateUsers);
        updateUsers.setId(userId);
        updateUsers.setUpdatedTime(new Date());
        usersMapper.updateByPrimaryKey(updateUsers);
        return queryUserInfo(userId);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    @Override
    public Users updateUserFace(String userId, String faceUrl) {
        Users updateUsers = new Users();
        updateUsers.setId(userId);
        updateUsers.setFace(faceUrl);
        updateUsers.setUpdatedTime(new Date());
        usersMapper.updateByPrimaryKey(updateUsers);
        return queryUserInfo(userId);
    }


}
