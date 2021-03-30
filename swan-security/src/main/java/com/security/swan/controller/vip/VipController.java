package com.security.swan.controller.vip;

import com.security.swan.mapper.VipMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RequestMapping("/vip")
@RestController()
public class VipController {

    @Resource
    VipMapper vipMapper;

    @RequestMapping("/getAll")
    public String getAll() {
        return vipMapper.Sel(1).toString();
    }
}
