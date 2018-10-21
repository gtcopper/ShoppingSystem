package cn.copper.mapper;

import cn.copper.domain.requestpPojo.NameAndPage;
import cn.copper.pojo.Goods;

import java.util.List;

/**
 * 商品dao层
 * @author haojie
 * @date 2018/10/07
 */
public interface GoodsMapper {
    /**
     * 统计商品数量
     * @return
     */
    int countGoods();

    /**
     * 查找指定位置的商品数据
     * @param page
     * @return
     */
    List<Goods> selectGoodsByPageNum(int page);


    /**
     * 查找指定位置的商品数据
     * @param nameAndPage
     * @return
     */
    List<Goods> selectGoodsByPageNumAndName(NameAndPage nameAndPage);

    /**
     * 统计待查询商品名的数量
     * @param goodsName
     * @return
     */
    int countGoodsNumByName(String goodsName);

    /**
     * 查询所有商品
     * @return
     */
    List<Goods> selectAllGoods();
    /**
     * 通过商品名查询商品
     * @param goodsName
     * @return
     */
    List<Goods> selectGoodsByName(String goodsName);
    /**
     * 通过商品id查询商品
     * @param goodsId
     * @return
     */
    Goods selectGooodsById(Integer goodsId);
}
