package cn.copper.pojo;

import java.util.Date;

/**
 * 订单
 * @author haojie
 * @date 2018/10/02
 */
public class Order {
    /**
     * 订单id
     */
    private Integer orderId;
    /**
     * 订单号
     */
    private String orderNumber;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 订单价格
     */
    private Float orderPrice;
    /**
     * 订单状态
     * 0 : 未支付 ,1 : 已支付
     */
    private Integer payStatus;
    /**
     * 订单创建时间
     */
    private Date  orderCreateTime;
    /**
     * 订单更新时间
     */
    private Date orderUpdateTime;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Float getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Float orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Date getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public Date getOrderUpdateTime() {
        return orderUpdateTime;
    }

    public void setOrderUpdateTime(Date orderUpdateTime) {
        this.orderUpdateTime = orderUpdateTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderNumber='" + orderNumber + '\'' +
                ", userId=" + userId +
                ", orderPrice=" + orderPrice +
                ", payStatus=" + payStatus +
                ", orderCreateTime=" + orderCreateTime +
                ", orderUpdateTime=" + orderUpdateTime +
                '}';
    }
}
