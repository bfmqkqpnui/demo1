package pers.springcloud.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pers.springcloud.feign.vo.ReturnDTO;

@FeignClient(value = "provider-user")
public interface FeignUserService {

    @RequestMapping(value = "/user/queryById/{id}",method = RequestMethod.GET)
    ReturnDTO queryById(@PathVariable("id") String id);
}
