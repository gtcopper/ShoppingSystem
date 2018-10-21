package cn.copper.domain.responsePojo;

import cn.copper.pojo.Goods;
import cn.copper.pojo.Order;

/**
 * 订单主体类
 * @author haojie
 * @date 2018/10/19
 */
public class OrderItemBody {
    /**
     * 订单id
     */
    private Integer orderId;
    /**
     * 商品信息
     */
    private Goods goods;
    /**
     * 商品数量
     */
    private Integer goodsSum;

    /**
     * 单项商品总金额
     * @return
     */
    private Float singleGoodsPrice;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getGoodsSum() {
        return goodsSum;
    }

    public void setGoodsSum(Integer goodsSum) {
        this.goodsSum = goodsSum;
    }

    public Float getSingleGoodsPrice() {
        return singleGoodsPrice;
    }

    public void setSingleGoodsPrice(Float singleGoodsPrice) {
        this.singleGoodsPrice = singleGoodsPrice;
    }
}
