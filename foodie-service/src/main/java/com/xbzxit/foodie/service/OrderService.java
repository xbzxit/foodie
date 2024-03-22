package com.xbzxit.foodie.service;

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

}
