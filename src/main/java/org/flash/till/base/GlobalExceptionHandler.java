package org.flash.till.base;

import lombok.extern.slf4j.Slf4j;
import org.flash.till.base.resp.ApiResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(value = FTException.class)
    @ResponseBody
    public ApiResult<String> exceptionHandler(Exception e) {
        log.error("全局异常>>", e);
        return ApiResult.fail(e.getMessage());
    }

}
