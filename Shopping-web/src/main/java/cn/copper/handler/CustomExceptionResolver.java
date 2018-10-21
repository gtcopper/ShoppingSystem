package cn.copper.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.copper.Exception.CustomException;
import cn.copper.Exception.LoginException;
import cn.copper.Exception.RegisterException;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理器
 * @author haojie
 * @date 2018/10/5
 */

public class CustomExceptionResolver implements HandlerExceptionResolver{

    private RegisterException registerException = null;
    private LoginException loginException = null;
    private BindException bindException = null;
    /**
     * 处理系统抛出的异常
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {
        //handler就是处理器适配器要执行的Handler对象(只有method)
        //解析出异常类型。

        if(ex instanceof RegisterException){
            registerException=(RegisterException)ex;
            //错误信息
            String code = registerException.getCode();
            String message=registerException.getMessage();

            ModelAndView modelAndView=new ModelAndView();

            //将错误信息传到页面
            modelAndView.addObject("code",code);
            modelAndView.addObject("message",message);

            //指向到错误界面
            modelAndView.setViewName("error/error");

            return modelAndView;
        }else if (ex instanceof LoginException){
            loginException = (LoginException)ex;

            //错误信息
            String code = loginException.getCode();
            String message=loginException.getMessage();

            ModelAndView modelAndView=new ModelAndView();

            //将错误信息传到页面
            modelAndView.addObject("code",code);
            modelAndView.addObject("message",message);

            //指向到错误界面
            modelAndView.setViewName("error/error");
            return modelAndView;
        }else if (ex instanceof BindException){
            bindException = (BindException)ex;

            //错误信息
            String message=bindException.getMessage();

            ModelAndView modelAndView=new ModelAndView();

            //将错误信息传到页面
            modelAndView.addObject("message",message);

            //指向到错误界面
            modelAndView.setViewName("error/error");
            return modelAndView;
        } else{
            ex = new CustomException("未知错误");

            //错误信息
            String message=ex.getMessage();

            ModelAndView modelAndView=new ModelAndView();

            //将错误信息传到页面
            modelAndView.addObject("message",message);

            //指向到错误界面
            modelAndView.setViewName("error/error");
            return modelAndView;
        }

    }

}

