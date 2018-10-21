package cn.copper.controller;

import cn.copper.domain.requestpPojo.NameAndPage;
import cn.copper.pojo.Goods;
import cn.copper.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

/**
 * 商品控制器
 * @author haojei
 * @date 2018/10/07
 */
@Controller
@RequestMapping(value = "/goods")
public class GoodsController {
    @Autowired(required = false)
    private GoodsService goodsService;

    /**
     * 展示所有商品(从数据库中拿取9条数据)
     * @return
     */
    @RequestMapping(value = "/showGoods")
    public ModelAndView showGoods(){
        ModelAndView mv = new ModelAndView();
        List<Goods> goodsList = goodsService.selectAllGoods();
        int totalPage = goodsService.countPageNum();
        mv.addObject("goodsList",goodsList);
        mv.setViewName("biz/show_goods");
        return mv;
    }

    /**
     * 分页展示商品列表
     * @return
     */
    @RequestMapping(value = "/listGoods")
    public ModelAndView listGoods(@RequestParam (value = "goodsName") String goodsName,@RequestParam (value = "page") String page){
        ModelAndView mv = new ModelAndView();
        NameAndPage np = new NameAndPage();
        int pageInt = 1;
        int totalPage = 0;
        np.setPage(pageInt);
        np.setGoodsName(goodsName);
        List<Goods> goodsList  = null;
        if (null != page  && !"".equals(page)){
           pageInt = Integer.parseInt(page);
           np.setPage(pageInt);
        }
        if ("".equals(goodsName) || goodsName == null){
            totalPage = goodsService.countPageNum();
            goodsList = goodsService.listGoods(pageInt);
            mv.addObject("goodsList",goodsList);
            mv.addObject("curPage",pageInt);
            mv.addObject("prePage",pageInt>1?pageInt-1:1);
            mv.addObject("nextPage",pageInt!=totalPage?pageInt+1:totalPage);
            mv.addObject("totalPage",totalPage);
            mv.setViewName("biz/show_goods");
            return mv;
        }
        goodsList = goodsService.selectGoodsByPageNumAndName(np);
        totalPage = goodsService.countGoodsNumByName(goodsName);
        mv.addObject("goodsList",goodsList);
        mv.addObject("goodsName",goodsName);
        mv.addObject("curPage",pageInt);
        mv.addObject("prePage",pageInt>1?pageInt-1:1);
        mv.addObject("nextPage",pageInt!=totalPage?pageInt+1:totalPage);
        mv.addObject("totalPage",totalPage);
        mv.setViewName("biz/show_goods");
        return mv;

    }

    /**
     * 搜索商品
     * @return
     */
    @RequestMapping(value = "/searchGoods",method = RequestMethod.GET)
    public ModelAndView searchGoods(@RequestParam (value = "goodsName") String goodsName, HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        NameAndPage np = new NameAndPage();
        int pageInt = 1;
        int totalPage = 0;
        np.setPage(pageInt);
        np.setGoodsName(goodsName);
        List<Goods> goodsList  = null;
        if (Objects.equals(goodsName,"") || goodsName == null){
            goodsList = goodsService.selectAllGoods();
            totalPage = goodsService.countPageNum();
            mv.addObject("goodsList",goodsList);
            mv.addObject("allGoods","全部商品");
            mv.addObject("curPage",pageInt);
            mv.addObject("prePage",pageInt>1?pageInt-1:1);
            mv.addObject("nextPage",pageInt!=totalPage?pageInt+1:totalPage);
            mv.addObject("totalPage",totalPage);
            mv.setViewName("biz/search_goods");
            return mv;
        }
        goodsList = goodsService.selectGoodsByPageNumAndName(np);
        totalPage = goodsService.countGoodsNumByName(goodsName);
        mv.addObject("goodsList",goodsList);
        System.out.println(goodsName);
        mv.addObject("goodsName",np.getGoodsName());
        mv.addObject("curPage",pageInt);
        mv.addObject("prePage",pageInt>1?pageInt-1:1);
        mv.addObject("nextPage",pageInt!=totalPage?pageInt+1:totalPage);
        mv.addObject("totalPage",totalPage);
        mv.setViewName("biz/search_goods");
        return mv;
    }

    /**
     * 展示商品详细信息
     * @return
     */
    @RequestMapping(value = "/showDetails/{goodsId}")
    public ModelAndView showGoodsDetails(@PathVariable String goodsId){
        ModelAndView mv = new ModelAndView();
        Goods goods = goodsService.selectGooodsById(Integer.parseInt(goodsId));
        mv.addObject("goods",goods);
        mv.setViewName("biz/show_details");
        return mv;
    }
}
