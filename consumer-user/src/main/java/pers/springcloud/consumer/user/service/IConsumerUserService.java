package pers.springcloud.consumer.user.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pers.springcloud.common.ReturnDTO;

@FeignClient("provider-user")
public interface IConsumerUserService {

    @RequestMapping(value = "/user/find/{id}", method = RequestMethod.GET)
    ReturnDTO findUserInfoByConsumer(@PathVariable("id") String uId);
}
