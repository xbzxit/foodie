package com.xbzxit.foodie.service;

import com.xbzxit.foodie.pojo.OrderStatus;

/**
 * @author HFZJ
 * @version 1.0
 * @create 2024-03-21-17:31
 * @company www.nuzarsurf.com
 */

public interface OrderService {

    /**
     * 修改订单状态
     * @param orderId
     * @param orderStatus
     */
    void updateOrderStatus(String orderId, Integer orderStatus);

    /**
     * 查询订单状态
     * @param orderId
     * @return
     */
    OrderStatus queryOrderStatusInfo(String orderId);
}
