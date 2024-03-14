package com.xbzxit.foodie.service.impl;

import com.xbzxit.foodie.mapper.UsersMapper;
import com.xbzxit.foodie.pojo.Users;
import com.xbzxit.foodie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author HFZJ
 * @version 1.0
 * @create 2024-03-14-13:32
 * @company www.nuzarsurf.com
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public boolean queryUsernameIsExist(String username) {
        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andEqualTo("username",username);
        Users users = usersMapper.selectOneByExample(userExample);
        //代码优化users == null ? false : true
        return users != null;
    }
}
