package pers.springcloud.user.dao;

import pers.springcloud.user.entity.User;

import java.util.List;

public interface UserBatchDao<T> {

    void batchAddUser(List<User> users);

    void batchUpdateUser(List<User> users);

    void batchDelUser(List<User> users);

}
