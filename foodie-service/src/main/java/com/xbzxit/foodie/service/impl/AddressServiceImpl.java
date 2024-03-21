package com.xbzxit.foodie.service.impl;

import cn.hutool.core.util.IdUtil;
import com.xbzxit.foodie.enums.YesOrNo;
import com.xbzxit.foodie.mapper.UserAddressMapper;
import com.xbzxit.foodie.pojo.UserAddress;
import com.xbzxit.foodie.pojo.bo.AddressBO;
import com.xbzxit.foodie.service.AddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
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

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public void addNewUserAddress(AddressBO addressBO) {
        Integer isDefault = 0;
        List<UserAddress> list = this.queryAll(addressBO.getUserId());
        if (CollectionUtils.isEmpty(list)) {
            isDefault = 1;
        }
        UserAddress address = new UserAddress();

        BeanUtils.copyProperties(addressBO, address);
        address.setId(IdUtil.getSnowflake().nextId()+"");
        address.setIsDefault(isDefault);
        address.setCreatedTime(new Date());
        address.setUpdatedTime(new Date());
        userAddressMapper.insert(address);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public void updateUserAddress(AddressBO addressBO) {
        String addressId = addressBO.getAddressId();
        UserAddress userAddress = new UserAddress();
        BeanUtils.copyProperties(addressBO,userAddress);
        userAddress.setId(addressId);
        userAddress.setUpdatedTime(new Date());
        userAddressMapper.updateByPrimaryKeySelective(userAddress);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public void deleteUserAddress(String userId, String addressId) {
        UserAddress address = new UserAddress();
        address.setUserId(userId);
        address.setId(addressId);
        userAddressMapper.delete(address);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public void updateUserAddressToBeDefault(String userId, String addressId) {
        UserAddress queryAddress = new UserAddress();
        queryAddress.setUserId(userId);
        queryAddress.setIsDefault(YesOrNo.Yes.type);
        List<UserAddress> list  = userAddressMapper.select(queryAddress);
        for (UserAddress ua : list) {
            ua.setIsDefault(YesOrNo.No.type);
            userAddressMapper.updateByPrimaryKeySelective(ua);
        }

        UserAddress defaultAddress = new UserAddress();
        defaultAddress.setId(addressId);
        defaultAddress.setUserId(userId);
        defaultAddress.setIsDefault(YesOrNo.Yes.type);
        userAddressMapper.updateByPrimaryKeySelective(defaultAddress);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public UserAddress queryUserAddres(String userId, String addressId) {
        UserAddress address = new UserAddress();
        address.setUserId(userId);
        address.setId(addressId);
        return userAddressMapper.selectOne(address);
    }

}
