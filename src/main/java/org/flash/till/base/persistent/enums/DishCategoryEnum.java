package org.flash.till.base.persistent.enums;

import lombok.Getter;

@Getter
public enum DishCategoryEnum {
    FOOD("FOOD", "食物"),
    DRINK("DRINK", "饮料"),
    ;

    private final String code;
    private final String desc;

    DishCategoryEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
