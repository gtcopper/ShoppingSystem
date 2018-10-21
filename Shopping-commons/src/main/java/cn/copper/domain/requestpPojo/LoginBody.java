package cn.copper.domain.requestpPojo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 登录主体信息
 * @author haojie
 * @date 2018/10/02
 */
public class LoginBody {
    @NotNull
    @Size(max = 6 , min = 2)
    private String userName;
    @NotNull
    @Size(max = 12 , min = 6)
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
