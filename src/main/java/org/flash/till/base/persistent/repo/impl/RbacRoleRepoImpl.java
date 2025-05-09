package org.flash.till.base.persistent.repo.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.v3.oas.annotations.servers.Server;
import org.flash.till.base.persistent.entity.RbacRoleEntity;
import org.flash.till.base.persistent.mapper.RbacRoleMapper;
import org.flash.till.base.persistent.repo.RbacRoleRepo;

@Server
public class RbacRoleRepoImpl extends ServiceImpl<RbacRoleMapper, RbacRoleEntity> implements RbacRoleRepo {
}
