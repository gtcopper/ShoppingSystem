package cn.copper.domain.responsePojo;

import cn.copper.domain.requestpPojo.RegisterBody;
import cn.copper.pojo.User;
import cn.copper.util.MD5;

import java.sql.Timestamp;

public class UpdateUser {
    public static User updateUser(User user, RegisterBody registerBody){
        user.setPassword(MD5.generateMD5(registerBody.getPassword()));
        user.setEmail(registerBody.getEmail());
        user.setPhone(registerBody.getPhone());
        user.setAddress(registerBody.getAddress());
        user.setUserUpdateTime(new Timestamp(System.currentTimeMillis()));
        return user;
    }
}
