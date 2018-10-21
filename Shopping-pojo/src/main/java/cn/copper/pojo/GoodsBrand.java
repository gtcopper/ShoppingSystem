package cn.copper.pojo;

import java.util.Date;

/**
 * 商品品牌
 * @author haojie
 * @date 2018/10/02
 */
public class GoodsBrand {
    /**
     * 品牌id
     */
    private Integer brandId;
    /**
     * 品牌名称
     */
    private String brandName;
    /**
     * 品牌创建时间
     */
    private Date beandCreateTime;
    /**
     * 品牌更新时间
     */
    private Date brandUpdateTime;

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Date getBeandCreateTime() {
        return beandCreateTime;
    }

    public void setBeandCreateTime(Date beandCreateTime) {
        this.beandCreateTime = beandCreateTime;
    }

    public Date getBrandUpdateTime() {
        return brandUpdateTime;
    }

    public void setBrandUpdateTime(Date brandUpdateTime) {
        this.brandUpdateTime = brandUpdateTime;
    }

    @Override
    public String toString() {
        return "GoodsBrand{" +
                "brandId=" + brandId +
                ", brandName='" + brandName + '\'' +
                ", beandCreateTime=" + beandCreateTime +
                ", brandUpdateTime=" + brandUpdateTime +
                '}';
    }
}
