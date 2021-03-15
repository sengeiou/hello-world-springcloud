package com.user.swan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonOrderService {

    @Autowired
    RestTemplate restTemplate;

    public String index() {
        return restTemplate.getForObject("http://swan-order/order/index", String.class);
    }
}
