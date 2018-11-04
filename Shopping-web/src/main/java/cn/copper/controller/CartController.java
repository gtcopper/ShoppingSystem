package cn.copper.controller;

import cn.copper.domain.requestpPojo.AddToCartBody;
import cn.copper.domain.requestpPojo.UpdateCartItemSumBody;
import cn.copper.domain.responsePojo.CartItemBody;
import cn.copper.domain.resultTemplate.ResultCode;
import cn.copper.domain.resultTemplate.ResultGenerator;
import cn.copper.domain.resultTemplate.ResultJson;
import cn.copper.pojo.CartItem;
import cn.copper.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;

/**
 * 购物车控制器
 * @author haojie
 * @date 2018/10/07
 */
@Controller
@RequestMapping(value = "cart")
public class CartController {

    @Autowired (required = false)
    private CartService cartService;

    /**
     * 添加商品到购物车
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addToCart")
    public ResultJson<String> addToCart(@RequestBody AddToCartBody addToCartBody){
        if (addToCartBody != null){
            CartItem cartItem = new CartItem();
            cartItem.setGoodsId(addToCartBody.getGoodsId());
            cartItem.setGoodsSum(addToCartBody.getGoodsSum());
            int addStatus = cartService.addToCart(cartItem);
            if (addStatus > 0){
                return ResultGenerator.genSuccessResult("加入购物车成功");
            }
        }
        return ResultGenerator.genFailureResult("加入购物车失败",ResultCode.FAILUER);
    }

    @ResponseBody
    @RequestMapping(value = "/updateCartItemSum")
    public ResultJson<Integer> updateCartItemSum(@RequestBody UpdateCartItemSumBody updateCartItemSumBody){
        if (updateCartItemSumBody != null){
            CartItem cartItem = new CartItem();
            cartItem.setGoodsId(updateCartItemSumBody.getGoodsId());
            cartItem.setGoodsSum(updateCartItemSumBody.getGoodsSum());
            cartItem.setCartItemId(updateCartItemSumBody.getCartItemId());
            boolean upStatus = cartService.updateGoodsNumToCart(cartItem);
            if (upStatus){
               return ResultGenerator.genSuccessResult(updateCartItemSumBody.getGoodsSum());
            }
        }
        return ResultGenerator.genFailureResult("修改失败", ResultCode.FAILUER);
    }

    @RequestMapping(value = "/user/myCart")
    public String myCart(HttpSession session, HttpServletRequest request){
        List<CartItemBody> cartItemBodies = cartService.selectAllCartItem();
        session.setAttribute("cartItemBodies",cartItemBodies);
        return "biz/show_cart";
    }

    @RequestMapping(value = "/user/myCart/deleteCartItem/{cartItemStringId}")
    public String deleteCartItem(@PathVariable String cartItemStringId,RedirectAttributes redirectAttributes){
        Integer cartItemId = 0;
        if (!"".equals(cartItemStringId) && cartItemStringId != null){
            cartItemId = Integer.parseInt(cartItemStringId);
            boolean deleteStatus = cartService.deleteCartItem(cartItemId);
            if (deleteStatus){
                return "redirect:/cart/user/myCart";
            }
            redirectAttributes.addFlashAttribute("deleteFail","删除失败");
            return "redirect:/cart/user/myCart";
        }
        redirectAttributes.addFlashAttribute("deleteFail","删除失败");
        return "redirect:/cart/user/myCart";
    }

}
