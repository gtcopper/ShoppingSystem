package cn.copper.domain.resultTemplate;

/**
 * 生成json数据
 * @author haojie
 * @date 2018/10/18
 */
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static ResultJson genSuccessResult() {
        return new ResultJson()
                .setStatus(ResultCode.SUCCESS)
                .setMsg(DEFAULT_SUCCESS_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    public static <T> ResultJson<T> genSuccessResult(T data) {
        return new ResultJson<T>()
                .setStatus(ResultCode.SUCCESS)
                .setMsg(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static ResultJson genFailureResult(String message) {
        return genFailureResult(message , ResultCode.FAILUER);
    }

    public static ResultJson genUnauthorizedResult(String message) {
        return genFailureResult(message , ResultCode.UNAUTHORIZED);
    }

    public static ResultJson genFailureResult(String message , ResultCode resultCode) {
        return new ResultJson()
                .setStatus(resultCode)
                .setMsg(message);
    }
}
