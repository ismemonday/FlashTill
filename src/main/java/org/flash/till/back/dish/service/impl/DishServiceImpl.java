package org.flash.till.back.dish.service.impl;

import io.swagger.v3.oas.annotations.servers.Server;
import lombok.extern.slf4j.Slf4j;
import org.flash.till.back.dish.dto.CreateDishDTO;
import org.flash.till.back.dish.service.DishService;
import org.flash.till.base.persistent.entity.DishEntity;
import org.flash.till.base.persistent.repo.DishRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

@Server
@Slf4j
public class DishServiceImpl implements DishService {
    @Autowired
    private DishRepo dishRepo;

    @Override
    public DishEntity create(CreateDishDTO dto) {
        DishEntity dishEntity = new DishEntity();
        BeanUtils.copyProperties(dto, dishEntity);
        dishRepo.save(dishEntity);
        return dishEntity;
    }
}
