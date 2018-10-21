package cn.copper.domain.requestpPojo;

import javax.validation.constraints.NotNull;

/**
 * 分页查询包含商品名和页数
 * @author haojie
 * @date 2018/10/13
 */
public class NameAndPage {
    /**
     * 商品名
     */
    private String goodsName;
    /**
     * 页数
     */
    @NotNull
    private Integer page;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
