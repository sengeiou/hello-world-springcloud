package com.security.swan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/login")
@RestController()
public class LoginController {

    @RequestMapping("/loginSuccess")
    public String loginSuccess() {
        return "login success";
    }
}
