package cn.copper.pojo;

import java.util.Date;

/**
 * 购物车项
 * @author haojei
 * @date 2018/10/14
 */
public class CartItem {
    /**
     * 购物车项id
     */
    private Integer cartItemId;
    /**
     * 购物车id
     */
    private Integer cartId;
    /**
     * 商品id
     */
    private Integer goodsId;
    /**
     * 商品数量
     */
    private Integer goodsSum;
    /**
     * 用户购物车创建时间
     */
    private Date cartItemCreateTime;
    /**
     * 用户购物车更新时间
     */
    private Date cartItemUpdateTime;

    public Integer getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Integer cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
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


    public Date getCartItemCreateTime() {
        return cartItemCreateTime;
    }

    public void setCartItemCreateTime(Date cartItemCreateTime) {
        this.cartItemCreateTime = cartItemCreateTime;
    }

    public Date getCartItemUpdateTime() {
        return cartItemUpdateTime;
    }

    public void setCartItemUpdateTime(Date cartItemUpdateTime) {
        this.cartItemUpdateTime = cartItemUpdateTime;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "cartItemId=" + cartItemId +
                ", cartId=" + cartId +
                ", goodsId=" + goodsId +
                ", goodsSum=" + goodsSum +
                ", cartItemCreateTime=" + cartItemCreateTime +
                ", cartItemUpdateTime=" + cartItemUpdateTime +
                '}';
    }
}
