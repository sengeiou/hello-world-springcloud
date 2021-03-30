package com.security.swan.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AuthProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        log.info("username={},password={}", username, password);
        //return new UsernamePasswordAuthenticationToken(username,password);
        //throw new UsernameNotFoundException("用户名查找失败");
        return new UsernamePasswordAuthenticationToken(username, password,
                AuthorityUtils.createAuthorityList("app:insert", "ROLE_admin"));
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
