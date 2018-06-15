package com.test.cloud.api;

import com.test.cloud.vo.UserVo;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Ryan Miao at 2018-06-15 19:52
 **/
@RequestMapping("/api/v1/users")
public interface UserApi {

    @GetMapping("/")
    List<UserVo> list();
}
