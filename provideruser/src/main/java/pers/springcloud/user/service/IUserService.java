package pers.springcloud.user.service;

import pers.springcloud.common.ReturnDTO;
import pers.springcloud.user.entity.User;

import java.util.List;

public interface IUserService {

    ReturnDTO queryByUserId(String uId);

    ReturnDTO queryUserId(Long id);

    ReturnDTO queryByPage(int currentPage, int pageSize);

    ReturnDTO updateUserInfo(User user);

    ReturnDTO deleteUserInfoById(String uId);

    ReturnDTO addUser(User user);

    ReturnDTO addUsers(List<User> users);


}
