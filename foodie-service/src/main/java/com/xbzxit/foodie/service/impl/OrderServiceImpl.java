package com.xbzxit.foodie.service.impl;

import com.xbzxit.foodie.mapper.OrderStatusMapper;
import com.xbzxit.foodie.pojo.OrderStatus;
import com.xbzxit.foodie.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author HFZJ
 * @version 1.0
 * @create 2024-03-22-9:57
 * @company www.nuzarsurf.com
 */

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderStatusMapper orderStatusMapper;


    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    @Override
    public void updateOrderStatus(String orderId, Integer orderStatus) {
        OrderStatus paidStatus = new OrderStatus();
        paidStatus.setOrderId(orderId);
        paidStatus.setOrderStatus(orderStatus);
        paidStatus.setPayTime(new Date());

        orderStatusMapper.updateByPrimaryKeySelective(paidStatus);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public OrderStatus queryOrderStatusInfo(String orderId) {
        return orderStatusMapper.selectByPrimaryKey(orderId);
    }
}
