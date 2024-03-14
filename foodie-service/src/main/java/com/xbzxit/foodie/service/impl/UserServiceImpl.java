package com.xbzxit.foodie.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.xbzxit.foodie.enums.Sex;
import com.xbzxit.foodie.mapper.UsersMapper;
import com.xbzxit.foodie.pojo.Users;
import com.xbzxit.foodie.pojo.bo.UserBO;
import com.xbzxit.foodie.service.UserService;
import com.xbzxit.foodie.utils.DateUtil;
import com.xbzxit.foodie.utils.MD5Utils;
import org.apache.commons.lang3.time.DateUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

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
    @Autowired
    private Sid sid;

    public static final String USER_FACE = "http://rongcloud-web.qiniudn.com/docs_demo_rongcloud_logo.png";

    @Override
    public boolean queryUsernameIsExist(String username) {
        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andEqualTo("username",username);
        Users users = usersMapper.selectOneByExample(userExample);
        //代码优化users == null ? false : true
        return users != null;
    }

    @Override
    public Users createUser(UserBO userBO) {
        Users user = new Users();
        //user.setId(Sid.next());
        user.setId(IdUtil.getSnowflake().nextId()+"");
        user.setFace(USER_FACE);
        user.setUsername(userBO.getUsername());
        user.setNickname(userBO.getUsername());
        try {
            //user.setPassword(MD5Utils.getMD5Str(userBO.getPassword()));
            user.setPassword(DigestUtil.md5Hex(userBO.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //user.setBirthday(DateUtil.stringToDate("2024-01-01 00:00:00"));
        user.setBirthday(Convert.toDate("2024-01-01 00:00:00"));
        user.setSex(Sex.man.type);
        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());
        usersMapper.insert(user);
        return user;
    }

    @Override
    public Users queryUserForLogin(String username, String password) {
        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();

        userCriteria.andEqualTo("username", username);
        userCriteria.andEqualTo("password", password);

        Users result = usersMapper.selectOneByExample(userExample);
        return result;
    }
}
