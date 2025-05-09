package org.flash.till.base.persistent.repo.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.v3.oas.annotations.servers.Server;
import org.flash.till.base.persistent.entity.RbacUserEntity;
import org.flash.till.base.persistent.mapper.RbacUserMapper;
import org.flash.till.base.persistent.repo.RbacUserRepo;

@Server
public class RbacUserRepoImpl extends ServiceImpl<RbacUserMapper, RbacUserEntity> implements RbacUserRepo {
}
