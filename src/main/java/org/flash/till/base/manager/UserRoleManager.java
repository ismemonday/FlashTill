package org.flash.till.base.manager;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.flash.till.base.persistent.entity.RbacRoleEntity;
import org.flash.till.base.persistent.entity.RbacUserEntity;
import org.flash.till.base.persistent.repo.RbacRoleRepo;
import org.flash.till.base.persistent.repo.RbacUserRepo;
import org.flash.till.base.persistent.repo.RbacUserRoleRelationRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户角色管理
 */
@Component
@AllArgsConstructor
@Slf4j
public class UserRoleManager implements UserDetailsService {
    private final RbacUserRepo userRepo;
    private final RbacRoleRepo roleRepo;
    private final RbacUserRoleRelationRepo userRoleRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.endsWith("@app")) {
            username = username.replace("@app", "");
        }
        RbacUserEntity userDO = userRepo.lambdaQuery().eq(RbacUserEntity::getUsername, username).oneOpt()
                .orElseThrow(() -> new UsernameNotFoundException("用户名或密码错误"));
        List<RbacRoleEntity> rbacRoleList = getRoleListByUserId(userDO);
        return new AdminUserDetails(userDO, rbacRoleList);
    }

    public List<RbacRoleEntity> getRoleListByUserId(RbacUserEntity user) {
        List<Integer> roleIds = roleRepo.lambdaQuery()
                .eq(RbacRoleEntity::getUserCount, userDO.getId())
                .select(RbacUserRoleRelationDO::getRoleId)
                .list()
                .stream()
                .map(RbacUserRoleRelationDO::getRoleId)
                .collect(Collectors.toList());
        return CollUtil.isEmpty(roleIds) ? ListUtil.empty() : rbacRoleRepository.listByIds(roleIds);
    }
}
