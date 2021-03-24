package com.security.swan.service;


import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if (!("admin".equals(s))) {
            throw new UsernameNotFoundException("用户名查找失败");
        }
        String pass = passwordEncoder.encode("123456");
        return new User("admin", pass, AuthorityUtils.createAuthorityList("admin,normal"));
    }
}
