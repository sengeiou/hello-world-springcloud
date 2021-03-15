package com.user.swan.controller;

import com.user.swan.service.OrderFeign;
import com.user.swan.service.RibbonOrderService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
@Slf4j
@Data
@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${server.port}")
    private String host;

    @Autowired
    RibbonOrderService ribbonOrderService;

    @Resource
    OrderFeign orderFeign;

    @RequestMapping("/index")
    public String index() {
        return ribbonOrderService.index();
    }

    @RequestMapping("/ask")
    public String ask() {
        log.info("调用失败");
        return orderFeign.askIndex("hehhe");
    }
}
