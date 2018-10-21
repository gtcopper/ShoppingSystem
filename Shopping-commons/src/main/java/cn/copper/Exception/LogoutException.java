package cn.copper.Exception;

/**
 * 用户登出异常
 * spring 对于 RuntimeException 异常才会进行事务回滚
 * @author haojie
 * @date 2018/10/04
 */
public class LogoutException extends RuntimeException{
    /**
     * 错误码
     */
    private String code;
    /**
     * 错误信息
     */
    private String message;

    public LogoutException(){
        super();
    }

    public LogoutException(String message){
        super(message);
        this.message = message;
    }

    public LogoutException(String code,String message){
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
