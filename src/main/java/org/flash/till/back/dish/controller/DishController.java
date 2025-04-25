package org.flash.till.back.dish.controller;

import org.flash.till.base.FTAssert;
import org.flash.till.base.resp.ApiResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/dish")
public class DishController {

    @PostMapping("/add")
    public ApiResult<String> add() {
        FTAssert.notBlank("","不能为空啊，老哥");
        return ApiResult.fail("不可能");
    }
}
