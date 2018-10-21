package cn.copper.domain.responsePojo;

import cn.copper.pojo.CartItem;
import cn.copper.pojo.Goods;

/**
 * 商品详细信息和商品数量
 * @author haojie
 * @date 2018/10/16
 */
public class CartItemBody {
    /**
     * 商品详细信息
     */
    private Goods goods;
    /**
     * 购物车项id
     */
    private Integer cartItemId;
    /**
     * 商品数量
     */
    private Integer goodsSum;
    /**
     * 单项商品总价
     * @return
     */
    private Float totalPrice;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Integer cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Integer getGoodsSum() {
        return goodsSum;
    }

    public void setGoodsSum(Integer goodsSum) {
        this.goodsSum = goodsSum;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }
}
