package cn.copper.domain.resultTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * json格式数据
 * @param <T>
 */
public class ResultJson<T> {
    private int status;
    private String msg;
    private T data;

    public int getStatus() {
        return status;
    }

    public ResultJson setStatus(ResultCode resultCode) {
        this.status = resultCode.getCode();
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResultJson setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResultJson setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
