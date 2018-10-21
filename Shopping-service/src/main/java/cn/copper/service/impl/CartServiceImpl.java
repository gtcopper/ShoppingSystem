package cn.copper.service.impl;

import cn.copper.domain.responsePojo.CartItemBody;
import cn.copper.mapper.CartMapper;
import cn.copper.mapper.GoodsMapper;
import cn.copper.pojo.Cart;
import cn.copper.pojo.CartItem;
import cn.copper.pojo.Goods;
import cn.copper.pojo.User;
import cn.copper.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * 购物车事务实现
 * @author haojie
 * @date 2018/10/07
 */
@Transactional (rollbackFor = Exception.class)
@Service
public class CartServiceImpl implements CartService {
    @Autowired (required = false)
    private CartMapper cartMapper;

    @Autowired (required = false)
    private GoodsMapper goodsMapper;

    @Autowired (required = false)
    private HttpSession session;

    @Override
    public int addToCart(CartItem cartItem) {
        User user = (User)session.getAttribute("user");
        Cart cart = cartMapper.selectCartByUseId(user.getUserId());
        int addCartItemStatus = 0;
        int updateCartItemStatus = 0;
        if (cart != null){
            List<CartItem> cartItems = cartMapper.selectCartItemByCartId(cart.getCartId());
            Integer goodsSumTemp = cartItem.getGoodsSum();
            for (CartItem item :
                    cartItems) {
                if (item.getGoodsId().equals(cartItem.getGoodsId())){
                    cartItem.setCartItemId(item.getCartItemId());
                    cartItem.setGoodsSum(cartItem.getGoodsSum()+item.getGoodsSum());
                }
            }
            cartItem.setCartId(cart.getCartId());
            cartItem.setCartItemUpdateTime(new Timestamp(System.currentTimeMillis()));
            if (!cartItem.getGoodsSum().equals(goodsSumTemp)){
                updateCartItemStatus = cartMapper.updateCartItemByCartItemId(cartItem);
                List<CartItemBody> cartItemBodies = selectAllCartItem();
                session.setAttribute("cartItemBodies",cartItemBodies);
                return updateCartItemStatus;
            }else{
                cartItem.setCartItemCreateTime(new Timestamp(System.currentTimeMillis()));
                addCartItemStatus = cartMapper.insertToCartItem(cartItem);
                List<CartItemBody> cartItemBodies = selectAllCartItem();
                session.setAttribute("cartItemBodies",cartItemBodies);
                return addCartItemStatus;
            }
        }else{
            Cart cartTemp = new Cart();
            cartTemp.setUserId(user.getUserId());
            cartTemp.setCartCreateTime(new Timestamp(System.currentTimeMillis()));
            cartTemp.setCartUpdateTime(new Timestamp(System.currentTimeMillis()));
            int insertCartStatus = cartMapper.insertToCart(cartTemp);
            cart = cartMapper.selectCartByUseId(user.getUserId());
            if (insertCartStatus > 0) {
                cartItem.setCartId(cart.getCartId());
                cartItem.setCartItemCreateTime(new Timestamp(System.currentTimeMillis()));
                cartItem.setCartItemUpdateTime(new Timestamp(System.currentTimeMillis()));
                addCartItemStatus = cartMapper.insertToCartItem(cartItem);
                List<CartItemBody> cartItemBodies = selectAllCartItem();
                session.setAttribute("cartItemBodies",cartItemBodies);
                return addCartItemStatus;
            }
        }
        //插入失败
        return 0;
    }

    @Override
    public boolean updateGoodsNumToCart(CartItem cartItem) {
        cartItem.setCartItemUpdateTime(new Timestamp(System.currentTimeMillis()));
        int updateStatus = cartMapper.updateCartItemByCartItemId(cartItem);
        if (updateStatus > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<CartItemBody> selectAllCartItem() {
        User user = (User)session.getAttribute("user");
        Cart cart = cartMapper.selectCartByUseId(user.getUserId());
        if (cart == null) {
            return null;
        }
        List<CartItem> cartItems = cartMapper.selectCartItemByCartId(cart.getCartId());
        List<CartItemBody> cartItemBodies = new ArrayList<>();
        for (CartItem item :
                cartItems) {
            CartItemBody cartItemBody = new CartItemBody();
            Goods goods = goodsMapper.selectGooodsById(item.getGoodsId());
            cartItemBody.setGoods(goods);
            cartItemBody.setCartItemId(item.getCartItemId());
            cartItemBody.setGoodsSum(item.getGoodsSum());
            cartItemBody.setTotalPrice(goods.getGoodsPrice() * item.getGoodsSum());
            cartItemBodies.add(cartItemBody);
        }
        return cartItemBodies;
    }

    @Override
    public boolean deleteCartItem(Integer cartItemId) {
        int deleteStatus = cartMapper.deleteCartItemById(cartItemId);
        if (deleteStatus > 0){
            return true;
        }
        return false;
    }
}
