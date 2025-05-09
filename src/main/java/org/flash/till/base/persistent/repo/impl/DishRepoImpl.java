package org.flash.till.base.persistent.repo.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.v3.oas.annotations.servers.Server;
import org.flash.till.base.persistent.entity.DishEntity;
import org.flash.till.base.persistent.mapper.DishMapper;
import org.flash.till.base.persistent.repo.DishRepo;

@Server
public class DishRepoImpl extends ServiceImpl<DishMapper, DishEntity> implements DishRepo {
}
