package cn.copper.pojo;

import java.util.Date;

/**
 * 商品分类
 * @author haojie
 * @date 2018/10/02
 */
public class GoodsCategory {
    /**
     * 商品分类id
     */
    private Integer categoryId;
    /**
     * 商品分类名称
     */
    private String categoryName;
    /**
     * 商品分类创建时间
     */
    private Date categoryCreateTime;
    /**
     * 商品分类更新时间
     */
    private Date categoryUpdateTime;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Date getCategoryCreateTime() {
        return categoryCreateTime;
    }

    public void setCategoryCreateTime(Date categoryCreateTime) {
        this.categoryCreateTime = categoryCreateTime;
    }

    public Date getCategoryUpdateTime() {
        return categoryUpdateTime;
    }

    public void setCategoryUpdateTime(Date categoryUpdateTime) {
        this.categoryUpdateTime = categoryUpdateTime;
    }

    @Override
    public String toString() {
        return "GoodsCategory{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryCreateTime=" + categoryCreateTime +
                ", categoryUpdateTime=" + categoryUpdateTime +
                '}';
    }
}
