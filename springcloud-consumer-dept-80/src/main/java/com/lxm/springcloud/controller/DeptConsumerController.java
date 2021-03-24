package com.lxm.springcloud.controller;

import com.lxm.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {


    /*
    *   消费者不应该有service层
    *   RestTemplate 提供直接调用就行
    * */

    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = restTemplate.getForObject(REST_URL_PREFIX + "/get/" + id, Dept.class);
        System.out.println(dept);
        return dept;
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/get", List.class);
    }

}
