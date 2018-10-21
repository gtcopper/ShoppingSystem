package cn.copper.domain.requestpPojo;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * 修改购物车项数量主体类
 * @author haojie
 * @date 2018/10/18
 */
public class UpdateCartItemSumBody {
    /**
     * 商品id
     */
    private Integer goodsId;
    /**
     * 商品数量
     */
    private Integer goodsSum;
    /**
     * 购物车项id
     */
    private Integer cartItemId;

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

    public Integer getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Integer cartItemId) {
        this.cartItemId = cartItemId;
    }
}
