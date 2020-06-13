package com.huawei.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.huawei.service.DubboxService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @Reference
    private DubboxService dubboxService;

    @RequestMapping("/testDubboxConsumer")
    @ResponseBody
    public String testDubboxConsumer() {
        return dubboxService.testService();
    }
}
