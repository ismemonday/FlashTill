package org.flash.till.base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FTException extends RuntimeException {
    private int errorCode = 500;
    private String errorMsg = "FlashTill异常";

    public static FTException exception(String message) {
        FTException ftException = new FTException();
        ftException.setErrorMsg(message);
        return ftException;
    }
}
