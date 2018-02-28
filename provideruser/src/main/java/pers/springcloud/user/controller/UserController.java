package pers.springcloud.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.springcloud.common.PageParams;
import pers.springcloud.common.ReturnDTO;
import pers.springcloud.user.service.IUserService;

/**
 * 用户服务入口
 */
@RestController
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private IUserService userService;

    @GetMapping(value = "/user/queryById/{id}")
    public ReturnDTO queryById(@PathVariable String id) {
        logger.info("根据用户的编号查询用户信息 begin");
        long beginTime = System.currentTimeMillis();
        ReturnDTO dto = new ReturnDTO();
        dto.setSuccess(false);
        dto.setResCode("400");
        dto.setErrMsg("未查询到相关信息");

        dto = userService.queryByUserId(id);

        logger.info("根据用户的编号查询用户信息 完成,耗时[" + (System.currentTimeMillis() - beginTime) + "]毫秒");
        return dto;
    }

    @PostMapping(value = "/user/queryList")
    public ReturnDTO queryUserList(@RequestBody PageParams params) {
        logger.info("分页查询用户列表信息 begin");
        long beginTime = System.currentTimeMillis();
        ReturnDTO dto = new ReturnDTO();
        dto.setSuccess(false);
        dto.setResCode("400");
        dto.setErrMsg("未查询到相关信息");

        int page = 0;
        int size = 10;
        if (null != params) {
            Integer currentPage = params.getCurrentPage();
            Integer pageSize = params.getPageSize();
            if (null != currentPage) {
                page = currentPage.intValue();
            }
            if (null != pageSize) {
                size = pageSize.intValue();
            }
        }

        dto = userService.queryByPage(page, size);

        logger.info("分页查询用户列表信息 完成,耗时[" + (System.currentTimeMillis() - beginTime) + "]毫秒");
        return dto;
    }
}
