package com.lxm.springcloud.service;

import com.lxm.springcloud.pojo.Dept;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeptService {
    List<Dept> getAll();

    Dept getById(Long id);
}
