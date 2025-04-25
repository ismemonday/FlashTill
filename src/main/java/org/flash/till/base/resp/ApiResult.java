package org.flash.till.base.resp;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class ApiResult<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 4518290031778225230L;
    private static final int SUCCESS_CODE = 0;
    private static final int FAIL_CODE = 500;
    private int code = 0;
    private String msg;
    private T data;


    private ApiResult() {
    }

    public static <T> ApiResult<T> success(T data) {
        ApiResult<T> apiResult = new ApiResult<T>();
        apiResult.setCode(SUCCESS_CODE);
        apiResult.setMsg("success");
        apiResult.setData(data);
        return apiResult;
    }

    public static <T> ApiResult<T> success() {
        ApiResult<T> apiResult = new ApiResult<T>();
        apiResult.setCode(SUCCESS_CODE);
        apiResult.setMsg("success");
        return apiResult;
    }

    public static <T> ApiResult<T> fail() {
        ApiResult<T> apiResult = new ApiResult<T>();
        apiResult.setCode(FAIL_CODE);
        apiResult.setMsg("fail");
        return apiResult;
    }

    public static <T> ApiResult<T> fail(String msg) {
        ApiResult<T> apiResult = new ApiResult<T>();
        apiResult.setCode(FAIL_CODE);
        apiResult.setMsg(msg);
        return apiResult;
    }
}
