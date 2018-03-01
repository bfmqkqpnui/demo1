package pers.springcloud.feign.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pers.springcloud.feign.service.FeignUserService;
import pers.springcloud.feign.vo.ReturnDTO;

@RestController
public class FeignUserController {

    @Autowired
    private FeignUserService feignUserService;

    private Logger logger = LoggerFactory.getLogger(FeignUserController.class);

    @GetMapping("/fegin/user/{id}")
    public ReturnDTO queryUserByFeign(@PathVariable("id") String uId){
        logger.info("feign 进入 id为["+uId+"]");
        return feignUserService.queryById(uId);
    }
}
