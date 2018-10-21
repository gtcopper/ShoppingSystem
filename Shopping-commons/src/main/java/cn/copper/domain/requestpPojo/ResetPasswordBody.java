package cn.copper.domain.requestpPojo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 重置密码主体信息
 * @author haojei
 * @date 2018/10/06
 */
public class ResetPasswordBody {
    /**
     * 用户名
     */
    @NotNull
    @Size(max = 6 , min = 2)
    private String userName;
    /**
     * 用户密码
     */
    @NotNull
    @Size(max = 12 , min = 6)
    private String password;
    /**
     * 用户手机号
     */
    @NotNull
    @Pattern(regexp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$")
    private String phone;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
