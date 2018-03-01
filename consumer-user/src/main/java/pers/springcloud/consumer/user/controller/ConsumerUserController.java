package pers.springcloud.consumer.user.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.springcloud.consumer.user.service.IConsumerUserService;
import pers.springcloud.consumer.user.vo.ReturnDTO;

@RestController
public class ConsumerUserController {

    @Autowired
    private IConsumerUserService iConsumerUserService;

    private Logger logger = LoggerFactory.getLogger(ConsumerUserController.class);

    @GetMapping(value = "/consumer/find/{id}")
    public ReturnDTO findUserInfoById(@PathVariable String id) {
        ReturnDTO dto = new ReturnDTO();
        dto.setSuccess(false);
        logger.info("查询用户信息入口");
        if (StringUtils.isNotBlank(id)) {
            dto = iConsumerUserService.findUserInfoByConsumer(id);
        }
        logger.info("查询用户信息入口 完成");
        return dto;
    }

    @PostMapping(value = "/consumer/findAll")
    public ReturnDTO findUserList() {
        ReturnDTO dto = new ReturnDTO();
        dto.setSuccess(false);
        logger.info("查询用户列表");
        dto = iConsumerUserService.findAll();
        return dto;
    }

    @GetMapping(value = "/consumer/getId/{id}")
    public ReturnDTO getId(@PathVariable Long id) {
        ReturnDTO dto = new ReturnDTO();
        dto.setSuccess(false);
        logger.info("查询用户信息入口");
        if (null != id) {
            dto = iConsumerUserService.findUserInfoByid(id);
        }
        logger.info("查询用户信息入口 完成");
        return dto;
    }
}
