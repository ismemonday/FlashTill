package org.flash.till.base.persistent.repo.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.v3.oas.annotations.servers.Server;
import org.flash.till.base.persistent.entity.RbacUserRoleRelationEntity;
import org.flash.till.base.persistent.mapper.RbacUserRoleRelationMapper;
import org.flash.till.base.persistent.repo.RbacUserRoleRelationRepo;

@Server
public class RbacUserRoleRelationRepoImpl extends ServiceImpl<RbacUserRoleRelationMapper, RbacUserRoleRelationEntity> implements RbacUserRoleRelationRepo {
}
