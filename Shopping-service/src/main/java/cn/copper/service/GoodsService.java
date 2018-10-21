package cn.copper.service;

import cn.copper.domain.requestpPojo.NameAndPage;
import cn.copper.pojo.Goods;

import java.util.List;

/**
 * 商品事务
 * @author haojie
 * @date 2018/10/07
 */
public interface GoodsService {
    /**
     * 查找所有商品
     * @return
     */
    List<Goods> selectAllGoods();

    /**
     * 统计商品的数量
     * @return
     */
    int countGoods();

    /**
     * 统计待查询商品名的数量
     * @param goodsName
     * @return
     */
    int countGoodsNumByName(String goodsName);

    /**
     * 统计页数
     * @return
     */
    int countPageNum();
    /**
     * 分页显示查询的商品
     * @param page
     * @return
     */
    List<Goods> listGoods(int page);
    /**
     * 商品名模糊查询商品
     * @param  goodsName
     * @return
     */
    List<Goods> selectGoodsByName(String goodsName);

    /**
     * 查找指定位置的商品数据
     * @param nameAndPage
     * @return
     */
    List<Goods> selectGoodsByPageNumAndName(NameAndPage nameAndPage);

    /**
     *
     * @param goodsId
     * @return
     */
    Goods selectGooodsById(Integer goodsId);
}
