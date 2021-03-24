package com.lxm.springcloud.mapper;

import com.lxm.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptMapper {

    List<Dept> queryAll();

    Dept queryById(Long id);

}
