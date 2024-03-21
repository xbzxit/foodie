package com.xbzxit.foodie.service.impl;

import com.xbzxit.foodie.mapper.UserAddressMapper;
import com.xbzxit.foodie.pojo.UserAddress;
import com.xbzxit.foodie.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author HFZJ
 * @version 1.0
 * @create 2024-03-21-9:47
 * @company www.nuzarsurf.com
 */

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    UserAddressMapper userAddressMapper;


    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<UserAddress> queryAll(String userId) {
        UserAddress userAddress = new UserAddress();
        userAddress.setUserId(userId);
        return userAddressMapper.select(userAddress);
    }
}
