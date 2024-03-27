package com.xbzxit.foodie.service;

import com.xbzxit.foodie.pojo.OrderStatus;
import com.xbzxit.foodie.pojo.bo.SubmitOrderBO;
import com.xbzxit.foodie.pojo.vo.OrderVO;

/**
 * @author HFZJ
 * @version 1.0
 * @create 2024-03-21-17:31
 * @company www.nuzarsurf.com
 */

public interface OrderService {

    /**
     * 用于创建订单相关信息
     * @param submitOrderBO
     */
    OrderVO createOrder(SubmitOrderBO submitOrderBO);

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

    /**
     * 关闭超时未支付订单
     */
    public void closeOrder();
}
