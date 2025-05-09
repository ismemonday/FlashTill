package org.flash.till.back.dish.controller;

import org.flash.till.back.dish.dto.CreateDishDTO;
import org.flash.till.back.dish.service.DishService;
import org.flash.till.base.persistent.entity.DishEntity;
import org.flash.till.base.resp.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/dish")
public class DishController {

    @Autowired
    private DishService dishService;

    @PostMapping("/add")
    @Secured("ROLE_ADMIN")
    public ApiResult<DishEntity> add(CreateDishDTO dto) {
       return ApiResult.success(dishService.create(dto));
    }
}
