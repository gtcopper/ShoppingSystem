package cn.copper.service.impl;

import cn.copper.domain.requestpPojo.NameAndPage;
import cn.copper.mapper.GoodsMapper;
import cn.copper.pojo.Goods;
import cn.copper.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 商品事务实现
 * @author haojie
 * @date 2018/10/07
 */
@Transactional(rollbackFor = Exception.class)
@Service
public  class GoodsServiceImpl implements GoodsService {
    @Autowired (required = false)
    private GoodsMapper goodsMapper;

    @Autowired (required = false)
    private HttpSession session;

    @Override
    public int countGoods(){
        return goodsMapper.countGoods();
    }

    @Override
    public int countGoodsNumByName(String goodsName) {
        int goodsCount = goodsMapper.countGoodsNumByName(goodsName);
        int pageNum = goodsCount%9==0?(goodsCount/9):(goodsCount/9)+1;
        return pageNum;
    }

    @Override
    public int countPageNum() {
        //设定每个页面只显示9条数据
        int totalGoods = countGoods();
        int pageNum = totalGoods%9==0?totalGoods/9:(totalGoods/9)+1;
        return pageNum;
    }

    @Override
    public List<Goods> listGoods(int page) {
        int currentPageFirstGoodId = (page-1)*9;
        List<Goods> goodsList = goodsMapper.selectGoodsByPageNum(currentPageFirstGoodId);
        return goodsList;
    }

    @Override
    public List<Goods> selectAllGoods() {
        return goodsMapper.selectAllGoods();
    }

    @Override
    public List<Goods> selectGoodsByName(String goodsName) {
        List<Goods> goodsList = goodsMapper.selectGoodsByName(goodsName);
        return goodsList;
    }

    @Override
    public List<Goods> selectGoodsByPageNumAndName(NameAndPage nameAndPage) {
        Integer currentPageFirstGoodId = (nameAndPage.getPage()-1)*9;
        nameAndPage.setPage(currentPageFirstGoodId);
        return goodsMapper.selectGoodsByPageNumAndName(nameAndPage);
    }

    @Override
    public Goods selectGooodsById(Integer goodsId) {
        Goods goods = goodsMapper.selectGooodsById(goodsId);
        return goods;
    }


}
