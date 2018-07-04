package com.test.cloud.controller;

import com.google.common.collect.Lists;
import com.test.cloud.api.UserApi;
import com.test.cloud.entity.User;
import com.test.cloud.vo.UserVo;
import io.swagger.annotations.Api;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.RestController;

/**
 * 提供用户信息查询API.
 *
 * @author Ryan Miao at 2018-06-14 15:04
 **/
@Api
@RestController
public class UserController implements UserApi {

    private List<User> users = Lists.newArrayList(
        new User(1, "谭浩强", 100, LocalDate.now()),
        new User(2, "严蔚敏", 120, LocalDate.now()),
        new User(3, "谭浩强", 100, LocalDate.now()),
        new User(4, "James Gosling", 150, LocalDate.now()),
        new User(6, "Doug Lea", 150, LocalDate.now())
    );

    @Override
    public List<UserVo> list() {
        return users.stream()
            .map(u -> new UserVo(u.getId(), u.getName(), u.getAge(), u.getBirth()))
            .collect(Collectors.toList());
    }

    @Override
    public String fallback() {
        Random random = new Random();
        boolean b = random.nextBoolean();
        if (b){
            return "成功返回.";
        }

        throw new RuntimeException("失败, 测试fallback.");
    }
}
