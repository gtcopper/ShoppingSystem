package cn.copper.service.impl;

import cn.copper.domain.requestpPojo.LoginBody;
import cn.copper.domain.requestpPojo.RegisterBody;
import cn.copper.domain.requestpPojo.ResetPasswordBody;
import cn.copper.domain.responsePojo.UpdateUser;
import cn.copper.mapper.UserMapper;
import cn.copper.pojo.User;
import cn.copper.service.UserService;
import cn.copper.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Transactional(rollbackFor = Exception.class)//当你的方法中抛出异常时，它会将事务回滚
@Service
/**
 * 用户事务
 * @author haojie
 * @date 2018/10/02
 */
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private UserMapper userMapper;

    @Autowired
    private HttpSession session;


    @Override
    public int registerUser(RegisterBody registerBody) {
        LoginBody loginBody = new LoginBody();
        loginBody.setUserName(registerBody.getUserName());
        loginBody.setPassword(registerBody.getPassword());
        User user = userMapper.selectUserByUserName(loginBody);
        if (user != null){
            return 0;
        }
        user = new User();
        user.setUserName(registerBody.getUserName());
        user.setPassword(MD5.generateMD5(registerBody.getPassword()));
        user.setEmail(registerBody.getEmail());
        user.setPhone(registerBody.getPhone());
        user.setAddress(registerBody.getAddress());
        user.setUserCreateTime(new Timestamp(System.currentTimeMillis()));
        user.setUserUpdateTime(new Timestamp(System.currentTimeMillis()));
        return userMapper.insertUser(user);
    }

    @Override
    public boolean login(LoginBody loginBody) {
        User user = userMapper.selectUserByUserName(loginBody);
        if (user != null){
            if (Objects.equals(user.getUserName(),loginBody.getUserName()) && MD5.validateMD5(user.getPassword(),loginBody.getPassword())){
                session.setAttribute("user",user);
                System.out.println(user.getUserCreateTime());
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public int logout() {
        User user = (User)session.getAttribute("user");
        if (user != null){
            session.removeAttribute("user");
            return 1;
        }
        return 0;
    }

    @Override
    public boolean resetPassword(ResetPasswordBody resetPasswordBody) {
        LoginBody loginBody = new LoginBody();
        loginBody.setUserName(resetPasswordBody.getUserName());
        loginBody.setPassword(resetPasswordBody.getPassword());
        User user = userMapper.selectUserByUserName(loginBody);
        System.out.println(user);
        if (user != null){
            if (Objects.equals(user.getPhone(),resetPasswordBody.getPhone())){
                user.setPassword(MD5.generateMD5(loginBody.getPassword()));
                user.setUserUpdateTime(new Date(System.currentTimeMillis()));
                int resetStatus = userMapper.updateUserPassword(user);
                if (resetStatus > 0){
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    /**
     * 返回更新内容状态, -1 : 更新失败 ;1 : 更新成功(包含用户名); 0 :更新成功(不更新用户名)
     * @param registerBody 更改后的用户信息实体
     * @return
     */
    @Override
    public int updateUser(RegisterBody registerBody) {
        User user = (User)session.getAttribute("user");
        long currentTime = System.currentTimeMillis();
        //用户上次更新信息的时间
        long userUpdateTime = user.getUserUpdateTime().getTime();
        //一天时间的毫秒值
        long oneDay = 24*3600*100;
        int updateStatus ;
        LoginBody loginBody = new LoginBody();
        loginBody.setUserName(registerBody.getUserName());
        loginBody.setPassword(user.getPassword());
        User userExist = userMapper.selectUserByUserName(loginBody);
        //数据库中有该用户,不能使用该用户名
        if ( (currentTime - userUpdateTime) > oneDay){
            if (userExist != null && !Objects.equals(userExist.getUserName(),user.getUserName())){
                return -1;
            }
            //天数大于1天并且用户名未更改
            if (userExist != null && Objects.equals(userExist.getUserName(),user.getUserName())) {
                user = UpdateUser.updateUser(user,registerBody);
                updateStatus = userMapper.updateUserInfoExceptUserName(user);
                if (updateStatus > 0) {
                    session.setAttribute("user", user);
                    return 1;
                }
            }
            //用户名修改
            user.setUserName(registerBody.getUserName());
            user = UpdateUser.updateUser(user,registerBody);
            updateStatus = userMapper.updateUserInfo(user);
            if (updateStatus > 0){
                session.setAttribute("user",user);
                return 1;
            }
        }else if (userExist == null ) {
                user = UpdateUser.updateUser(user,registerBody);
                updateStatus = userMapper.updateUserInfoExceptUserName(user);
                if (updateStatus > 0) {
                    session.setAttribute("user", user);
                    return 0;
                }
        } else if (userExist != null && Objects.equals(userExist.getUserName(),user.getUserName())) {
                user = UpdateUser.updateUser(user,registerBody);
                updateStatus = userMapper.updateUserInfoExceptUserName(user);
                if (updateStatus > 0) {
                    session.setAttribute("user", user);
                    return 1;
                }
        }
        return -1;
    }
}
