package cn.copper.mapper;

import cn.copper.pojo.Order;
import cn.copper.pojo.OrderItem;

import java.util.List;

/**
 * 订单dao
 * @author haojie
 * @date 2018/10/13
 */
public interface OrderMapper {
    /**
     * 插入订单
     * @param order
     * @return
     */
    int insertOrder(Order order);

    /**
     * 插入订单项
     * @param orderItem
     * @return
     */
    int insertOrderItem(OrderItem orderItem);

    /**
     * 订单id查询订单
     * @param orderId
     * @return
     */
    Order selectOrderByOrderId(Integer orderId);

    /**
     * 通过用户id查询订单
     * @return
     */
    List<Order> selectOrderByUserId(Integer userId);

    /**
     * 通过订单号查询订单
     * @param orderNumber
     * @return
     */
    Order selectOrderByOrderNumber(String orderNumber);

    /**
     * 通过orderId查询订单详细项
     * @param orderId
     * @return
     */
    List<OrderItem> selectOrderItemByOrdrId(Integer orderId);

    /**
     * 通过用户id查询订单项
     * @return
     */
    List<OrderItem> selectOrderItemByUserId();

    /**
     * 通过订单id删除订单
     * @param orderId
     * @return
     */
    int deleteOrderByOrderId(Integer orderId);

    /**
     * 通过订单id删除订单项
     * @param orderId
     * @return
     */
    int deleteOrderItemByOrderId(Integer orderId);

    /**
     * 通过订单id修改订单支付状态
     * @param orderId
     * @return
     */
    int updatePayStatusByOrderId(Integer orderId);

}
