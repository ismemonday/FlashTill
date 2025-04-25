package org.flash.till.base;

import java.util.Collection;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2023/3/2 下午3:11
 */
public class FTAssert {
    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw FTException.exception(message);
        }
    }

    public static void isFalse(boolean expression, String message) {
        if (expression) {
            throw FTException.exception(message);
        }
    }

    public static void notNull(Object object, String message) {
        if (object == null) {
            throw FTException.exception(message);
        }
    }

    public static void isBlank(String value, String message) {
        if (value != null && !value.isEmpty()) {
            throw FTException.exception(message);
        }
    }

    public static void notBlank(String value, String message) {
        if (value == null || value.isEmpty()) {
            throw FTException.exception(message);
        }
    }

    public static void isEmpty(Collection<Object> array, String message) {
        if (!array.isEmpty()) {
            throw FTException.exception(message);
        }
    }

    public static void notEmpty(Collection<Object> array, String message) {
        if (array.isEmpty()) {
            throw FTException.exception(message);
        }
    }
}
