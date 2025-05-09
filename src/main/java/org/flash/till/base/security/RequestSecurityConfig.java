package org.flash.till.base.security;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configurable
@EnableWebSecurity
@EnableMethodSecurity
public class RequestSecurityConfig {
}
