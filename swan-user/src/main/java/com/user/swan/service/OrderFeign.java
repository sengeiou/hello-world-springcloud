package com.user.swan.service;

import com.user.swan.config.FeignConfig;
import com.user.swan.hystrix.HystrixService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "swan-order", configuration = FeignConfig.class, fallback = HystrixService.class)
public interface OrderFeign {

    @PostMapping("/order/index")
    String askIndex(@RequestParam String name);
}
