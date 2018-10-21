package cn.copper.mapper;

import cn.copper.domain.requestpPojo.LoginBody;
import cn.copper.pojo.User;

/**
 * User的mapper
 * @author haojie
 * @date 2018/10/02
 */
public interface UserMapper {
    /**
     * 插入用户
     * @param user 用户实体
     */
    int insertUser(User user);

    /**
     * 通过用户名查询用户,并校验密码是否正确
     * @param loginBody 登录实体(username,password)
     * @return
     */
    User selectUserByUserName(LoginBody loginBody);

    /**
     * 重置用户密码
     * @param user
     * @return User
     */
    int updateUserPassword(User user);
    /**
     * 更新用户信息(可修改用户名情况)
     * @param user 用户更新信息的实体
     * @return 返回1(或者>=1,正常情况为1)则修改成功,返回0则修改失败
     */
    int updateUserInfo(User user);

    /**
     * 更新用户信息(不可更改用户名情况)
     * @param user 用户更新信息的实体
     * @return 返回1(或者>=1,正常情况为1)则修改成功,返回0则修改失败
     */
    int updateUserInfoExceptUserName(User user);
}
