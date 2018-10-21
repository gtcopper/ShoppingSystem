package cn.copper.pojo;

import java.util.Date;

/**
 * 购物车
 * @author haojie
 * @date 2018/1014
 */
public class Cart {
    /**
     * 用户购物车id
     */
    private Integer cartId;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 购物车创建时间
     */
    private Date cartCreateTime;
    /**
     * 购物车修改时间
     */
    private Date cartUpdateTime;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCartCreateTime() {
        return cartCreateTime;
    }

    public void setCartCreateTime(Date cartCreateTime) {
        this.cartCreateTime = cartCreateTime;
    }

    public Date getCartUpdateTime() {
        return cartUpdateTime;
    }

    public void setCartUpdateTime(Date cartUpdateTime) {
        this.cartUpdateTime = cartUpdateTime;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", userId=" + userId +
                ", cartCreateTime=" + cartCreateTime +
                ", cartUpdateTime=" + cartUpdateTime +
                '}';
    }
}
