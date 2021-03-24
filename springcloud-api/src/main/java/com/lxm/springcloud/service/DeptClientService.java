package com.lxm.springcloud.service;


import com.lxm.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT", fallbackFactory = DeptClientServiceFallBackFactory.class)
@Component
public interface DeptClientService {

    @GetMapping("/get/{id}")
    Dept getById(@PathVariable("id") Long id);

    @GetMapping("/get")
    List<Dept> list();

}
