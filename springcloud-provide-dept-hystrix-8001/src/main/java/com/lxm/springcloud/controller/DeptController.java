package com.lxm.springcloud.controller;


import com.lxm.springcloud.pojo.Dept;
import com.lxm.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    DeptService deptService;


    @HystrixCommand(fallbackMethod = "hystrixGet")
    @GetMapping("/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = deptService.getById(id);

        if (dept == null) {
            throw new RuntimeException("id=>" + id + ",用户不存在");
        }

        return dept;
    }

    public Dept hystrixGet(@PathVariable("id") Long id) {

        return new Dept()
                .setId(id)
                .setName("id=>" + id + ",用户不存在--null--@Hystrix")
                .setDbSource("no database in MySQL");
    }

}
