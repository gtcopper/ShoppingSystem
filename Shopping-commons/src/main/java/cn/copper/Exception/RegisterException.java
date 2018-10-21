package cn.copper.Exception;

/**
 * 用户注册异常
 * spring 对于 RuntimeException 异常才会进行事务回滚
 * @author haojie
 * @date 2018/10/04
 */
public class RegisterException extends RuntimeException {
    /**
     * 错误码
     */
    private String code;
    /**
     * 错误信息
     */
    private String message;

    public RegisterException(){
        super();
    }

    public RegisterException(String message){
        super(message);
        this.message = message;
    }

    public RegisterException(String code,String message){
        super();
        this.code = code;
        this.message = message;
    }

    public String getCode(){
        return code;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
