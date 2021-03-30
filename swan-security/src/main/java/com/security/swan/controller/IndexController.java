package com.security.swan.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/index")
@RestController()
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String n = auth.getName();
        String r = auth.getAuthorities().toString();
        log.info("name={}", n);
        log.info("authority={}", r);
        return "app indexController success";
    }

    @RequestMapping("/authority")
    public String authority() {
        return "app indexController success authority";
    }

    @RequestMapping("/authority1")
    public String authority1() {
        return "app indexController success authority1";
    }


    @RequestMapping("/role")
    public String role() {
        return "app indexController success role";
    }

    @RequestMapping("/role1")
    public String role1() {
        return "app indexController success role1";
    }

    @RequestMapping("/access1")
    public String access1() {
        return "app indexController success access1";
    }

    @RequestMapping("/access2")
    public String access2() {
        return "app indexController success access2";
    }

    @RequestMapping("/access3")
    public String access3() {
        return "app indexController success access3";
    }


}
