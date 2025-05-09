package org.flash.till.back.dish.dto;

import lombok.Data;
import org.flash.till.base.persistent.enums.DishCategoryEnum;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CreateDishDTO {
    private long shopId;
    private String name;
    private double inPrice;
    private double outPrice;
    private String desc;
    private MultipartFile img;
    private DishCategoryEnum category;
}
