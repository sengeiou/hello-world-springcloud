package com.order.swan.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Data
@RestController
@RequestMapping("/order")
public class OrderController {


    @Value("${server.port}")
    private String host;

    @RequestMapping("/index")
    public String index(@RequestParam String name) {
        log.info("name={}", name);
        return "hello world order  " + host;
    }
}
