package cn.copper.pojo;

import java.util.Date;

/**
 * 商品
 * @author haojie
 * @date 2018/10/02
 */
public class Goods {
    /**
     * 商品id
     */
    private Integer goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品价格
     */
    private Float goodsPrice;
    /**
     * 商品图片
     */
    private String goodsImage;
    /**
     * 商品所在的分类id
     */
    private Integer categoryId;
    /**
     * 商品的品牌id
     */
    private Integer brandId;
    /**
     * 商品的创建时间
     */
    private Date goodsCreateTime;
    /**
     * 商品的更新时间
     */
    private Date goodsUpdateTime;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Float getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Float goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Date getGoodsCreateTime() {
        return goodsCreateTime;
    }

    public void setGoodsCreateTime(Date goodsCreateTime) {
        this.goodsCreateTime = goodsCreateTime;
    }

    public Date getGoodsUpdateTime() {
        return goodsUpdateTime;
    }

    public void setGoodsUpdateTime(Date goodsUpdateTime) {
        this.goodsUpdateTime = goodsUpdateTime;
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((goodsName == null) ? 0 : goodsId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj){
        //比较地址
        if (this == obj) {
            return true;
        }
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        Goods goods = (Goods)obj;
        if (!goodsId.equals(goods.getGoodsId())){
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsImage='" + goodsImage + '\'' +
                ", categoryId=" + categoryId +
                ", brandId=" + brandId +
                ", goodsCreateTime=" + goodsCreateTime +
                ", goodsUpdateTime=" + goodsUpdateTime +
                '}';
    }
}
