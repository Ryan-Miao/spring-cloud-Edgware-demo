package com.test.cloud.controller;

import com.test.cloud.client.UserClient;
import com.test.cloud.service.RibbonDemo;
import com.test.cloud.vo.UserVo;
import io.swagger.annotations.Api;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 提供用户信息查询API.
 *
 * @author Ryan Miao at 2018-06-14 15:04
 **/
@Api
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserClient userClient;
    private final RibbonDemo ribbonDemo;

    @Autowired
    public UserController(UserClient userClient, RibbonDemo ribbonDemo) {
        this.userClient = userClient;
        this.ribbonDemo = ribbonDemo;
    }


    @GetMapping("/feign")
    public List<UserVo> feign() {
        return userClient.list();
    }

    @GetMapping("/feign-fallback")
    public String fallback() {
        return userClient.fallback();
    }

    @GetMapping("/ribbon")
    public List<UserVo> ribbon() throws IOException {
        return ribbonDemo.getUsers();
    }
}
