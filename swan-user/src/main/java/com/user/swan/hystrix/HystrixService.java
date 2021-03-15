package com.user.swan.hystrix;

import com.user.swan.service.OrderFeign;
import org.springframework.stereotype.Component;

@Component
public class HystrixService implements OrderFeign {
    @Override
    public String askIndex(String name) {
        return "请求失败，请稍后尝试";
    }
}
