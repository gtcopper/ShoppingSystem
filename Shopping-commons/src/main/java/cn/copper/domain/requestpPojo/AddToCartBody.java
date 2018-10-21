package cn.copper.domain.requestpPojo;

/**
 * 加入购物车实体类
 * @author haojie
 * @date 2018/10/18
 */
public class AddToCartBody {
    /**
     * 商品id
     */
    private Integer goodsId;
    /**
     * 商品数量
     */
    private Integer goodsSum;

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
}
