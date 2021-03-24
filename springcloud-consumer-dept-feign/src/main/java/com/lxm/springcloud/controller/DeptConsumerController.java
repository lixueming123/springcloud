package com.lxm.springcloud.controller;

import com.lxm.springcloud.pojo.Dept;
import com.lxm.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptConsumerController {

    @Autowired
    DeptClientService deptClientService;
    @GetMapping("/consumer/dept/get/{id}")
    public Dept getOne(@PathVariable("id") Long id) {
        return deptClientService.getById(id);
    }

    @GetMapping("/consumer/dept/list")
    public List<Dept> getAll() {
        return deptClientService.list();
    }

}
