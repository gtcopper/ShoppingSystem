package cn.copper.handler;

import cn.copper.Exception.RegisterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理器
 * @ControllerAdvice定义统一的异常处理类
 * @ExceptionHandler用来定义函数针对的异常类型
 * 将Exception对象和请求URL映射到error.jsp
 * @author haojie
 * @date 2018/10/05
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = RegisterException.class)
    public String defaultErrorHandler(HttpServletRequest request, RegisterException e) throws Exception {
        request.setAttribute("Exception", e);
        request.setAttribute("url", request.getRequestURL());
        return DEFAULT_ERROR_VIEW;
    }
}
