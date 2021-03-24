package com.lxm.springcloud.service;

import com.lxm.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept getById(Long id) {
                return new Dept().setId(id).setName("id=>" + id + "客户服务降级,该服务已经暂时无法使用").setDbSource("no data!");
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}
