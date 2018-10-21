package cn.copper.mapper;

import cn.copper.pojo.Cart;
import cn.copper.pojo.CartItem;

import java.util.List;

/**
 * 购物车dao
 * @author haojie
 * @date 2018/10/07
 */
public interface CartMapper {
    /**
     * 插入购物车
     * @param cart
     * @return
     */
    int insertToCart(Cart cart);

    /**
     * 通过用户id查询购物车
     * @param userId
     * @return
     */
    Cart selectCartByUseId(Integer userId);

    /**
     * 通过cartId查询CartItem
     * @param cartId
     * @return
     */
    List<CartItem> selectCartItemByCartId(Integer cartId);
    /**
     * 通过cartItemId查询CartItem
     * @param cartItemId
     * @return
     */
    CartItem selectCartItemByCartItemId(Integer cartItemId);
    /**
     * 加入购物车项
     * @param cartItem 购物车项
     * @return
     */
    int insertToCartItem(CartItem cartItem);

    /**
     * 修改购物车商品数量
     * @param cartItem 购物车项
     * @return
     */
    int updateCartItemByCartItemId(CartItem cartItem);

    /**
     * 查询当前用户所有购物车项
     * @return
     */
     List<CartItem> selectAllCartItem();

    /**
     * 通过购物车项id删除购物车项
     * @param cartItemId
     * @return
     */
     int deleteCartItemById(Integer cartItemId);
}
