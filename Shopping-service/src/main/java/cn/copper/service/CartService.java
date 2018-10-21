package cn.copper.service;

import cn.copper.domain.responsePojo.CartItemBody;
import cn.copper.pojo.CartItem;

import java.util.List;

/**
 * 购物车事务
 * @author haojie
 * @date 2018/10/07
 */
public interface CartService {
    /**
     * 加入购物车
     * @param cartItem 购物车项
     * @return
     */
    int addToCart(CartItem cartItem);

    /**
     * 修改购物车商品数量
     * @param cartItem 购物车项
     * @return
     */
    boolean updateGoodsNumToCart(CartItem cartItem);

    /**
     * 查询当前用户所有购物车项
     * @return
     */
    List<CartItemBody> selectAllCartItem();

    /**
     * 通过购物车项id删除购物车项
     * @param cartItemId
     * @return
     */
    boolean deleteCartItem(Integer cartItemId);
}
