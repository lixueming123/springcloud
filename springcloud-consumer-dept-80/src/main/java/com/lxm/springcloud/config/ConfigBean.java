package com.lxm.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
    // 配置负载均衡配置RestfulTemplate
    // IRule
    // AvailabilityFilteringRule 会过滤掉崩溃的服务, 剩下的进行轮询
    // RoundRobinRule 轮询
    //

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }



}
