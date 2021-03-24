package com.lxm.springcloud.service.impl;

import com.lxm.springcloud.mapper.DeptMapper;
import com.lxm.springcloud.pojo.Dept;
import com.lxm.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    DeptMapper deptMapper;

    @Override
    public List<Dept> getAll() {
        return deptMapper.queryAll();
    }

    @Override
    public Dept getById(Long id) {
        return deptMapper.queryById(id);
    }
}
