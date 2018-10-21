package cn.copper.service.impl;


import cn.copper.domain.responsePojo.OrderItemBody;
import cn.copper.mapper.CartMapper;
import cn.copper.mapper.GoodsMapper;
import cn.copper.mapper.OrderMapper;
import cn.copper.pojo.*;
import cn.copper.service.OrderService;
import cn.copper.util.OrderNumberGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单事务实现s
 * @author haojie
 * @date 2018/10/13
 */
@Transactional (rollbackFor = Exception.class)
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired (required = false)
    private GoodsMapper goodsMapper;

    @Autowired (required = false)
    private OrderMapper orderMapper;

    @Autowired (required = false)
    private CartMapper cartMapper;

    @Autowired (required = false)
    private HttpSession session;


    @Override
    public boolean generateOrder(Integer[] cartItemId) {
        Order order = new Order();
        User user= (User)session.getAttribute("user");
        order.setUserId(user.getUserId());
        String orderNumber = OrderNumberGenerate.generateOrderNuber();
        order.setOrderNumber(orderNumber);
        order.setOrderPrice(countOrderTotalPrice(cartItemId));
        order.setPayStatus(0);
        order.setOrderCreateTime(new Timestamp(System.currentTimeMillis()));
        order.setOrderUpdateTime(new Timestamp(System.currentTimeMillis()));
        int orderId = orderMapper.insertOrder(order);
        Order orderTemp = orderMapper.selectOrderByOrderNumber(orderNumber);
        if (orderId > 0){
            List<OrderItem> orderItemList = listOrderItems(cartItemId);
            List<OrderItemBody> orderItemBodyLists = new ArrayList<>();
            for (OrderItem orderItem:
                 orderItemList) {
                orderItem.setOrderId(orderTemp.getOrderId());
                orderMapper.insertOrderItem(orderItem);
                OrderItemBody orderItemBody = new OrderItemBody();
                Goods goods = goodsMapper.selectGooodsById(orderItem.getGoodsId());
                orderItemBody.setOrderId(orderTemp.getOrderId());
                orderItemBody.setGoods(goods);
                orderItemBody.setGoodsSum(orderItem.getGoodsSum());
                orderItemBody.setSingleGoodsPrice(goods.getGoodsPrice()*orderItem.getGoodsSum());
                orderItemBodyLists.add(orderItemBody);
            }
            session.setAttribute("orderId",orderTemp.getOrderId());
            session.setAttribute("orderItemBodyLists",orderItemBodyLists);
            session.setAttribute("totalPrice",countOrderTotalPrice(cartItemId));
            return true;
        }
        return false;
    }

    @Override
    public Order selectOrderByOrderId(Integer orderId) {
        return orderMapper.selectOrderByOrderId(orderId);
    }

    @Override
    public Order selectOrderByOrderNumber(String orderNumber) {
        return orderMapper.selectOrderByOrderNumber(orderNumber);
    }

    @Override
    public List<OrderItem> listOrderItems(Integer[] cartItemId) {
        List<OrderItem> orderItemList = new ArrayList<>();
        for (int i = 0; i < cartItemId.length; i++) {
            OrderItem orderItem = new OrderItem();
            Goods goods;
            CartItem cartItem = cartMapper.selectCartItemByCartItemId(cartItemId[i]);
            goods = goodsMapper.selectGooodsById(cartItem.getGoodsId());
            orderItem.setGoodsId(cartItem.getGoodsId());
            orderItem.setGoodsSum(cartItem.getGoodsSum());
            orderItem.setGoodsPrice(goods.getGoodsPrice());
            orderItem.setOrderItemCreateTime(new Timestamp(System.currentTimeMillis()));
            orderItem.setOrderItemUpdateTime(new Timestamp(System.currentTimeMillis()));
            orderItemList.add(orderItem);
        }
        return orderItemList;
    }

    @Override
    public Float countOrderTotalPrice(Integer[] cartItemId) {
        Float orderTotalPrice = 0F;
        for (int i = 0; i < cartItemId.length; i++) {
            Goods goods;
            CartItem cartItem = cartMapper.selectCartItemByCartItemId(cartItemId[i]);
            goods = goodsMapper.selectGooodsById(cartItem.getGoodsId());
            orderTotalPrice += (goods.getGoodsPrice() * cartItem.getGoodsSum());
        }
        return orderTotalPrice;
    }

    @Override
    public boolean deleteCartItemsByCartItemIds(Integer[] cartItemId) {
        for (int i = 0; i < cartItemId.length; i++) {
            cartMapper.deleteCartItemById(cartItemId[i]);
        }
        return true;
    }

    @Override
    public boolean deleteOrderByOrderId(Integer orderId) {
        int deleteStatus = orderMapper.deleteOrderByOrderId(orderId);
        if (deleteStatus > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteOrderItemByOrderId(Integer orderId) {
        int deleteStatus = orderMapper.deleteOrderItemByOrderId(orderId);
        if (deleteStatus > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updatePayStatusByOrderId(Integer orderId) {
        int updatePayStatusByOrderId = orderMapper.updatePayStatusByOrderId(orderId);
        if (updatePayStatusByOrderId > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<Order> showMyOrder() {
        User user = (User)session.getAttribute("user");
        List<Order> orders = orderMapper.selectOrderByUserId(user.getUserId());
        session.setAttribute("orders",orders);
        return orders;
    }

    @Override
    public List<OrderItem> showOrderDetail(Integer orderId) {
        Order order = selectOrderByOrderId(orderId);
        List<OrderItem> orderItems = orderMapper.selectOrderItemByOrdrId(orderId);
        List<OrderItemBody> orderItemBodyLists = new ArrayList<>();
        Float totalPrice = 0F;
        for (OrderItem orderItem :
                orderItems) {
            totalPrice += (orderItem.getGoodsPrice()*orderItem.getGoodsSum());
            OrderItemBody orderItemBody = new OrderItemBody();
            Goods goods = goodsMapper.selectGooodsById(orderItem.getGoodsId());
            orderItemBody.setOrderId(orderId);
            orderItemBody.setGoods(goods);
            orderItemBody.setGoodsSum(orderItem.getGoodsSum());
            orderItemBody.setSingleGoodsPrice(orderItem.getGoodsPrice() * orderItem.getGoodsSum());
            orderItemBodyLists.add(orderItemBody);
        }
        session.setAttribute("orderNumber",order.getOrderNumber());
        session.setAttribute("orderCreateTime",order.getOrderCreateTime());
        session.setAttribute("orderItemBodyLists",orderItemBodyLists);
        session.setAttribute("totalPrice",totalPrice);
        return orderItems;
    }
}
