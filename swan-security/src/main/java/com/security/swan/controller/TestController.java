package com.security.swan.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController()
public class TestController {

    @PreAuthorize("permitAll()")
    @RequestMapping("/annotationAuthority1")
    public String annotationAuthority1() {
        return "annotationAuthority1";
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/annotationAuthority2")
    public String annotationAuthority2() {
        return "annotationAuthority2";
    }

    @PreAuthorize("hasAuthority('app:insert')")
    @RequestMapping("/annotationAuthority3")
    public String annotationAuthority3() {
        return "annotationAuthority3";
    }

    @PreAuthorize("hasRole('ROLE_admin')")
    @RequestMapping("/annotationAuthority4")
    public String annotationAuthority4() {
        return "annotationAuthority4";
    }
}

