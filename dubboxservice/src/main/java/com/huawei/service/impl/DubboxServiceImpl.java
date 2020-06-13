package com.huawei.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.huawei.service.DubboxService;

@Service
public class DubboxServiceImpl implements DubboxService {
    @Override
    public String testService() {
        return "TEST DUBBOX-SERVICE DEMO SUCCESS";
    }
}
