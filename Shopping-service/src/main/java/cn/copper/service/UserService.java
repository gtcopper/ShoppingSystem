package cn.copper.service;

import cn.copper.domain.requestpPojo.LoginBody;
import cn.copper.domain.requestpPojo.RegisterBody;
import cn.copper.domain.requestpPojo.ResetPasswordBody;

/**
 * 用户事务
 * @author haojie
 * @date 2018/10/02
 */
public interface UserService {
    /**
     * 用户注册
     * @param registerBody 用户注册信息主体
     * @return 返回主键id
     */
    int registerUser(RegisterBody registerBody);

    /**
     * 登录
     * @param loginBody 登录主体信息
     * @return 登录成功返回true ,失败返回false
     */
    boolean login(LoginBody loginBody);
    /**
     *退出登录
     * @return 1:登出成功 ,0:登出失败
     */
    int logout();

    /**
     * 重置密码
     * @param resetPasswordBody 重置密码的实体
     * @return
     */
    boolean resetPassword(ResetPasswordBody resetPasswordBody);
    /**
     * 修改用户信息
     * @param registerBody 更改后的用户信息实体
     * @return
     */
    int updateUser(RegisterBody registerBody);
}
