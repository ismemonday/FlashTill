package org.flash.till.base.security;

import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Server
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 假设从数据库中加载用户信息
        if ("admin".equals(username)) {
            return User.withUsername(username)
                    .password("{noop}password")
                    .roles("ADMIN") // 角色名称以 ROLE_ 开头
                    .build();
        }
        throw new UsernameNotFoundException("User not found");
    }
}
