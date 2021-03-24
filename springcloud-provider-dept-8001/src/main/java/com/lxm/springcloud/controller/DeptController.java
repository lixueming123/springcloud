package com.lxm.springcloud.controller;


import com.lxm.springcloud.pojo.Dept;
import com.lxm.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    DeptService deptService;

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/get")
    public List<Dept> getAll() {

        return deptService.getAll();
    }

    @GetMapping("/get/{id}")
    public Dept getOne(@PathVariable Long id) {
        return deptService.getById(id);
    }


    @RequestMapping("/discovery")
    public Object discovery() {

        // 获取微服务列表清单
        List<String> services = discoveryClient.getServices();
        System.out.println("discovery=>" + services);

        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(instance);
        }

        return this.discoveryClient;
    }

}
