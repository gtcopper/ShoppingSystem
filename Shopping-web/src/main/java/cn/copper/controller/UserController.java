package cn.copper.controller;

import cn.copper.Exception.LogoutException;
import cn.copper.Exception.RegisterException;
import cn.copper.domain.requestpPojo.LoginBody;
import cn.copper.domain.requestpPojo.RegisterBody;
import cn.copper.domain.requestpPojo.ResetPasswordBody;
import cn.copper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @RestController 不会解析jsp视图，他会写入response中,所以使用@Controller
 */
@Controller
@RequestMapping( value = "/user")
/**
 * 用户模块
 * @author haojie
 * @date 2018/10/02
 */
public class UserController {
    /**
     *  绑定用户事务
     */
    @Autowired(required = false)
    private UserService userService;

    /**
     * 转发请求到注册页面
     * @return 注册页面视图
     */
    @RequestMapping(value = "/registerPrompt")
    public String registerPrompt(){
        return "biz/register";
    }

    /**
     * 处理注册请求
     * @param registerBody 注册信息
     * @param request 请求封装信息
     * @param errors 错误
     * @return 注册成功返回登录视图或失败返回注册视图
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@ModelAttribute @Validated RegisterBody registerBody, HttpServletRequest request, RedirectAttributes redirectAttributes, Errors errors){
        if (errors.hasErrors()){
           request.setAttribute("errorMessage","输入参数格式错误");
           throw new RegisterException("400","数据格式不正确,注册异常");
       }
       int userId = userService.registerUser(registerBody);
       if (userId > 0){
           return "redirect:loginPrompt";
       }
       redirectAttributes.addFlashAttribute("errorMessage","* 账号: "+registerBody.getUserName()+" 已经被注册");
       return "redirect:registerPrompt";
    }

    /**
     * 请求转发到登录页面
     * @return 登录页面视图
     */
    @RequestMapping(value = "/loginPrompt")
    public String loginPrompt(){
        return "biz/login";
    }

    /**
     * 处理登录请求
     * @param loginBody 登录信息
     * @param errors 错误
     * @return 登录请求成功返回成功视图，失败重定向到登录请求页面
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@ModelAttribute @Validated LoginBody loginBody,HttpServletRequest request,RedirectAttributes redirectAttributes,  Errors errors){
        if (errors.hasErrors()){
            redirectAttributes.addFlashAttribute("errorMessage","输入参数格式错误");
            return "redirect:loginPrompt";
        }
        boolean loginStatus = userService.login(loginBody);
        if (loginStatus){
            return "redirect:/";
        }
        redirectAttributes.addFlashAttribute("errorMessage","* 账号或密码错误");
        return "redirect:loginPrompt";
    }

    /**
     * 退出系统
     * @return 主页面
     */
    @RequestMapping(value = "/logout")
    public String logout(){
        int logoutStatus = userService.logout();
        if (logoutStatus != 0){
            return "redirect:/";
        }
        throw new LogoutException("用户未登录,不能退出登录");
    }

    /**
     * 将页面转发到重置密码页面
     * @return
     */
    @RequestMapping(value = "resetPasswordPrompt")
    public String resetPasswordPrompt(){
        return "biz/reset_password";
    }

    /**
     * 处理用户重置密码请求
     * @param resetPasswordBody
     * @param request
     * @return
     */
    @RequestMapping(value = "resetPassword",method = RequestMethod.POST)
    public String resetPassword(@ModelAttribute @Validated ResetPasswordBody resetPasswordBody,RedirectAttributes redirectAttributes, HttpServletRequest request){
        boolean resetStaus = userService.resetPassword(resetPasswordBody);
        if (resetStaus){
            redirectAttributes.addFlashAttribute("loginSuccess","重置成功");
            return "redirect:loginPrompt";
        }
        redirectAttributes.addFlashAttribute("errorMessage","* 重置失败,用户名或手机号不正确");
        return "redirect:resetPasswordPrompt";
    }

    /**
     * 返回更新用户信息的视图
     * @return
     */
    @RequestMapping(value = "updateUserInfoPrompt")
    public String updateUserInfoPrompt(){
        return "biz/update_userInfo";
    }

    /**
     * 处理用户请求更新数据的请求
     * @return
     */
    @RequestMapping(value = "updateUserInfo",method = RequestMethod.POST)
    public String updateUserInfo(@ModelAttribute @Validated RegisterBody registerBody,RedirectAttributes redirectAttributes,HttpServletRequest request){
        int updateStatus = userService.updateUser(registerBody);
        if (updateStatus == 0){
            redirectAttributes.addFlashAttribute("errorMessage","距离上次修改用户名时间不足1天，无法修改用户名,其他项已修改");
            return "redirect:showUserInfo";
        }else if (updateStatus == 1){
            return "redirect:showUserInfo";
        }
        redirectAttributes.addFlashAttribute("errorMessage","修改的用户名已经存在");
        return "redirect:updateUserInfoPrompt";
    }

    @RequestMapping(value = "showUserInfo")
    public String showUserInfo(){
        return "biz/show_userInfo";
    }

}
