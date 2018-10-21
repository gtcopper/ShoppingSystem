package cn.copper.domain.resultTemplate;

/**
 * 返回状态码枚举类
 * @author haojie
 * @date 2018/10/18
 */
public enum ResultCode {
    /**
     *200 成功
     */
    SUCCESS(200),
    /**
     *
     */
    /**
     * 400 失败
     */
    FAILUER(400),
    /**
     * 401 未认证（签名错误）
     */
    UNAUTHORIZED(401),
    /**
     * 404 接口不存在
     */
    NOT_FOUND(404),
    /**
     * 服务器内部错误
     */
    INTERNAL_SERVER_ERROR(500)
    ;

    private final int code;
    ResultCode(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

}
