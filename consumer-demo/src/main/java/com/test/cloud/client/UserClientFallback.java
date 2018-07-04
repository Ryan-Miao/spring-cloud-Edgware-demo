package com.test.cloud.client;

import com.google.common.collect.Lists;
import com.test.cloud.vo.UserVo;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Ryan Miao at 2018-07-04 11:55
 **/
@Component("userClientFallback")
@RequestMapping("/userClientFallback")
public class UserClientFallback implements UserClient {

    @Override
    public List<UserVo> list() {
        UserVo userVo = new UserVo();
        userVo.setAge(1);
        userVo.setBirth(LocalDate.now());
        userVo.setId(1);
        userVo.setName("fallback");
        return Lists.newArrayList(userVo);
    }

    @Override
    public String fallback() {
        return "访问失败后调用此方法，进行服务降级.";
    }
}
