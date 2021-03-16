package com.user.swan.controller;

import com.user.swan.service.OrderFeign;
import com.user.swan.service.RibbonOrderService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
@RefreshScope
@Slf4j
@Data
@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${server.port}")
    private String host;
    @Value("${config.server.user.name}")
    private String name;
    @Value("${config.server.user.port}")
    private String port;


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

    @RequestMapping("/config")
    public String config() {
        log.info("调用失败");
        log.info("name={}", name);
        log.info("port={}", port);
        return name + port;
    }


}
