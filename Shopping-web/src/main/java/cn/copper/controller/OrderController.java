package cn.copper.controller;

import cn.copper.pojo.Order;
import cn.copper.pojo.OrderItem;
import cn.copper.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单控制器
 * @author haojie
 * @date 2018/10/13
 */
@Controller
@RequestMapping(value = "order")
public class OrderController {

    @Autowired(required = false)
    private OrderService orderService;

    @Autowired(required = false)
    private HttpSession session;

    /**
     * 我的订单
     * @return
     */
    @RequestMapping(value = "/user/myOrder")
    public ModelAndView showMyOrder(){
        List<Order> orders = orderService.showMyOrder();
        return new ModelAndView("biz/show_myOrder");
    }

    @RequestMapping(value = "orderDetails/{orderId}")
    public String orderDetails(@PathVariable String orderId){
        System.out.println(orderId);
        ModelAndView mv = new ModelAndView();
        if (orderId != null && !"".equals(orderId)){
            List<OrderItem> orderItems = orderService.showOrderDetail(Integer.parseInt(orderId));
            if (orderItems != null){
                return "biz/orderDetail";
            }
        }
        return "";
    }

//    @RequestMapping(value = "/showOrderDetail")
//    public String showOrderDetail(){
//        return "biz/orderDetail";
//    }

    @RequestMapping(value = "/generateOrder",method = RequestMethod.POST )
    public String generateOrder(@RequestParam (value = "cartItemId[]") Integer[] cartItemId, HttpServletRequest request)
    {
        if (cartItemId != null){
            boolean orderStatus = orderService.generateOrder(cartItemId);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cartItemId.length; i++) {
                sb.append(cartItemId[i]);
                if (i != cartItemId.length-1){
                    sb.append(",");
                }
            }
            System.out.println(sb.toString());
            if (orderStatus){
                request.setAttribute("cartItemId",sb.toString());
                return "biz/generate_order";
            }
        }
         return  "biz/show_cart";
    }

    /**
     * 确认订单
     * @return
     */
    @RequestMapping(value = "/confirmOrder")
    public ModelAndView confirmOrder(@RequestParam (value = "cartItemId[]") Integer[] cartItemId,@RequestParam (value = "orderId") String orderId){
        ModelAndView mv = new ModelAndView();
        if (cartItemId != null && !"".equals(cartItemId) && orderId != null && !"".equals(orderId)){
            boolean updatePayStatusByOrderId = orderService.updatePayStatusByOrderId(Integer.parseInt(orderId));
            boolean deleteStatus = orderService.deleteCartItemsByCartItemIds(cartItemId);
            if (updatePayStatusByOrderId && deleteStatus) {
                mv.setViewName("redirect:paySuccess");
                return mv;
            }
        }
        mv.setViewName("redirect:payFail");
        return mv;
    }

    /**
     * 支付成功
     * @return
     */
    @RequestMapping (value = "/paySuccess")
    public String paySuccess() {
        return "success/paySuccess";
    }

    /**
     * 支付失败
     * @return
     */
    @RequestMapping (value = "/payFail")
    public String payFail() {
        return "error/payFail";
    }


    /**
     * 取消订单
     * @return
     */
    @RequestMapping(value = "/cancelOrder")
    public ModelAndView cancelOrder(@RequestParam (value = "orderId") String orderId,RedirectAttributes redirectAttributes){
        ModelAndView mv = new ModelAndView();
        if (null != orderId && !"".equals(orderId)){
            System.out.println(orderId+"....");
            boolean deleteStatus1 = orderService.deleteOrderItemByOrderId(Integer.parseInt(orderId));
            if (deleteStatus1){
                boolean deleteStatus2 = orderService.deleteOrderByOrderId(Integer.parseInt(orderId));
                if (deleteStatus2){
                    redirectAttributes.addFlashAttribute("cancelOrder","取消订单成功");
                    mv.setViewName("redirect:cancelOrderSuccess");
                    return mv;
                }
            }
        }
        mv.setViewName("redirect:cancelOrderFail");
        return mv;
    }

    /**
     * 取消订单成功
     * @return
     */
    @RequestMapping (value = "/cancelOrderSuccess")
    public String cancelOrderSuccess() {
        return "success/cancelOrder_Success";
    }

    /**
     * 取消订单失败
     * @return
     */
    @RequestMapping (value = "/cancelOrderFail")
    public String cancelOrderFail() {
        return "error/cancelOrder_fail";
    }

    /**
     * 删除订单
     * @return
     */
    @RequestMapping(value = "deleteOrder")
    public String deleteOrder(@RequestParam (value = "orderId") String orderId){
        ModelAndView mv = new ModelAndView();
        System.out.println(orderId);
        if (!"".equals(orderId) && orderId != null){
            boolean deleteStatus = orderService.deleteOrderItemByOrderId(Integer.parseInt(orderId));
            if (deleteStatus){
                boolean deleteStatus2 = orderService.deleteOrderByOrderId(Integer.parseInt(orderId));
                if (deleteStatus){
                    return "redirect:user/myOrder";
                }
            }
        }
        return "redirect:deleteOrderFail";
    }

    /**
     * 删除订单失败
     * @return
     */
    @RequestMapping (value = "/deleteOrderFail")
    public String deleteOrderFail() {
        return "error/deleteFail";
    }

}
