package cn.copper.service;

import cn.copper.pojo.Order;
import cn.copper.pojo.OrderItem;

import java.util.List;

/**
 * 订单事务
 * @author haojie
 * @date 2018/10/13
 */
public interface OrderService {
    /**
     * 生成订单
     * @param cartItemId
     * @return
     */
    boolean generateOrder(Integer[] cartItemId);

    /**
     * 订单id查询订单
     * @param orderId
     * @return
     */
    Order selectOrderByOrderId(Integer orderId);

    /**
     * 通过订单号查询订单
     * @param orderNumber
     * @return
     */
    Order selectOrderByOrderNumber(String orderNumber);

    /**
     * 支付成功更新订单支付状态
     * @param orderId
     * @return
     */
    boolean updatePayStatusByOrderId(Integer orderId);

    /**
     * 通过购物车id查询并生成OrderItem
     * @param cartItemId
     * @return
     */
    List<OrderItem> listOrderItems(Integer[] cartItemId);

    /**
     * 计算选中商品的总金额
     * @param cartItemId
     * @return
     */
    Float countOrderTotalPrice(Integer[] cartItemId);

    /**
     * 通过购物车项id删除购物车项
     * @param cartItemId
     * @return
     */
    boolean deleteCartItemsByCartItemIds(Integer[] cartItemId);

    /**
     * 通过订单id删除订单
     * @param orderId
     * @return
     */
    boolean deleteOrderByOrderId(Integer orderId);

    /**
     * 通过订单id删除订单项
     * @param orderId
     * @return
     */
    boolean deleteOrderItemByOrderId(Integer orderId);

    /**
     * 查看我的订单
     * @return
     */
    List<Order> showMyOrder();

    /**
     * 通过订单id查询订单项
     * @param orderId
     * @return
     */
    List<OrderItem> showOrderDetail(Integer orderId);
}
