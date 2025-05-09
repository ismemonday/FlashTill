package org.flash.till.back.dish.service;

import org.flash.till.back.dish.dto.CreateDishDTO;
import org.flash.till.base.persistent.entity.DishEntity;

public interface DishService {
    DishEntity create(CreateDishDTO dto);
}
