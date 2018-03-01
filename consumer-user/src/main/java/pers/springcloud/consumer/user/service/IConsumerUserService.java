package pers.springcloud.consumer.user.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pers.springcloud.consumer.user.vo.ReturnDTO;

@FeignClient(value = "provider-user")
public interface IConsumerUserService {

    @RequestMapping(value = "/user/queryById/{id}", method = RequestMethod.GET)
    ReturnDTO findUserInfoByConsumer(@PathVariable("id") String id);

    @RequestMapping(value = "/user/queryUserId/{id}", method = RequestMethod.GET)
    ReturnDTO findUserInfoByid(@PathVariable("id") Long id);

    @RequestMapping(value = "/user/queryList", method = RequestMethod.POST)
    ReturnDTO findAll();
}
