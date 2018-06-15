package com.test.cloud.client;

import com.test.cloud.api.UserApi;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author Ryan Miao at 2018-06-15 10:31
 **/
@FeignClient("provider-demo")
public interface UserClient extends UserApi {

}
