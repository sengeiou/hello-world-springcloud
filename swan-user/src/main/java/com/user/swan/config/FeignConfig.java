package com.user.swan.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class FeignConfig {

    // period=100 发起当前请求的时间间隔，单位毫秒
    // maxPeriod=1000 发起当前请求的最大时间间隔，单位毫秒
    // maxAttempts=5 最多请求次数，包括第一次
    //默认实现，最大请求次数为5，初始间隔时间为100ms，下次间隔时间1.5倍递增，重试间最大间隔时间为1s
    @Bean
    public Retryer retryer() {
        return new Retryer.Default(100, TimeUnit.SECONDS.toMillis(1L), 3);
    }
}
