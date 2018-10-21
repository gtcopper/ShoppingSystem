package cn.copper.pojo;

import java.util.Date;

/**
 * 商品订单关系
 * @author haojie
 * @date 2018/10/02
 */
public class OrderItem {
    /**
     * 商品订单id
     */
    private Integer orderItemId;
    /**
     * 订单id
     */
    private Integer orderId;
    /**
     * 商品id
     */
    private Integer goodsId;
    /**
     * 商品数量
     */
    private Integer goodsSum;
    /**
     * 商品价格
     */
    private Float goodsPrice;
    /**
     * 商品项创建时间
     */
    private Date orderItemCreateTime;
    /**
     * 商品项更新时间
     */
    private Date orderItemUpdateTime;

    public Integer getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsSum() {
        return goodsSum;
    }

    public void setGoodsSum(Integer goodsSum) {
        this.goodsSum = goodsSum;
    }

    public Float getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Float goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Date getOrderItemCreateTime() {
        return orderItemCreateTime;
    }

    public void setOrderItemCreateTime(Date orderItemCreateTime) {
        this.orderItemCreateTime = orderItemCreateTime;
    }

    public Date getOrderItemUpdateTime() {
        return orderItemUpdateTime;
    }

    public void setOrderItemUpdateTime(Date orderItemUpdateTime) {
        this.orderItemUpdateTime = orderItemUpdateTime;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderItemId=" + orderItemId +
                ", orderId=" + orderId +
                ", goodsId=" + goodsId +
                ", goodsSum=" + goodsSum +
                ", goodsPrice=" + goodsPrice +
                ", orderItemCreateTime=" + orderItemCreateTime +
                ", orderItemUpdateTime=" + orderItemUpdateTime +
                '}';
    }
}
