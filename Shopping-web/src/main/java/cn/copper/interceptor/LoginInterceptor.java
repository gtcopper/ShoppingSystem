package cn.copper.interceptor;

import cn.copper.pojo.User;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.FlashMapManager;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * 登录拦截器
 * @author haojie
 * @date 2018/09/29
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 还没发现可以直接配置不拦截的资源，所以在代码里面来排除
     */
    public String[] allowUrls;

    public void setAllowUrls(String[] allowUrls) {
        this.allowUrls = allowUrls;
    }

    /**
     * 登录前拦截器
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //拿到所请求的路径的相对地址
        String requestUrl = httpServletRequest.getRequestURI().replace(httpServletRequest.getContextPath(), "");
        //识别ajax请求
        String requestType = httpServletRequest.getHeader("X-Requested-With");
        final String xmlrequest  = "XMLHttpRequest";
//        PrintWriter out = httpServletResponse.getWriter();
        if(null != allowUrls && allowUrls.length>=1){
            for(String url : allowUrls) {
                if(requestUrl.contains(url)) {
                    return true;
                }
            }
        }
        //设置返回的编码格式
        httpServletResponse.setCharacterEncoding("UTF-8");
        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute("user");
        //实现类似redirectAttributes.addFlashAttribute的功能
        FlashMap flashMap = new FlashMap();
        if (user == null){
            //可以从request域中拿到设置的属性,一次有效
  //          if (requestType != null && xmlrequest.equals(requestType)){
//                out.print("logout");
//                out.flush();
//                return false;
     //       }
            flashMap.put("nologin","* 您还未登录");
            FlashMapManager flashMapManager = RequestContextUtils.getFlashMapManager(httpServletRequest);
            flashMapManager.saveOutputFlashMap(flashMap, httpServletRequest, httpServletResponse);
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/user/loginPrompt");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
