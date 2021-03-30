package com.security.swan.security.impl;

import com.security.swan.security.TestAccessHandle;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
@Component
public class TestAccessHandleImpl implements TestAccessHandle {
    @Override
    public boolean isAuthority(HttpServletRequest request, Authentication authentication) {
        return true;
    }
}
