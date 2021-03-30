package com.security.swan.security;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义 权限判断
 */
public interface TestAccessHandle {

    boolean isAuthority(HttpServletRequest request, Authentication authentication);
}
