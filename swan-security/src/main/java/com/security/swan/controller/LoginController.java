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

    @RequestMapping("/loginFail")
    public String loginFail() {
        return "login fail";
    }

    @RequestMapping("/logoutSuccess")
    public String logoutSuccess() {
        return "logout success";
    }
}
