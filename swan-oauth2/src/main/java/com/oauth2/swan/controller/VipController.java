package com.oauth2.swan.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RequestMapping("/vip")
@RestController()
public class VipController {


    @RequestMapping("/getAll")
    public String getAll(Authentication authentication) {
        return "success000";
    }
}
