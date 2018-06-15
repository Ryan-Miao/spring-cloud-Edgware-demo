package com.test.cloud.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.cloud.vo.UserVo;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 使用RestTemplate 测试Ribbon负载均衡
 *
 * @author Ryan Miao at 2018-06-15 13:39
 **/
@Service
public class RibbonDemo {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public RibbonDemo(RestTemplate restTemplate,
        ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public List<UserVo> getUsers() throws IOException {
        String rs = restTemplate
            .getForObject("http://PROVIDER-DEMO/api/v1/users/", String.class);
        return objectMapper.readValue(rs, new TypeReference<List<UserVo>>() {
        });
    }

}
