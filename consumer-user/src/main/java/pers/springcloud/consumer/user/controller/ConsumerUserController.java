package pers.springcloud.consumer.user.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pers.springcloud.common.ReturnDTO;
import pers.springcloud.consumer.user.service.IConsumerUserService;

@RestController
public class ConsumerUserController {

    @Autowired
    private IConsumerUserService iConsumerUserService;

    @GetMapping("/consumer/find/{id}")
    public ReturnDTO findUserInfoById(@PathVariable String uId) {
        ReturnDTO dto = new ReturnDTO();
        dto.setSuccess(false);
        if (StringUtils.isNotBlank(uId)) {
            dto = iConsumerUserService.findUserInfoByConsumer(uId);
        }
        return dto;
    }
}
