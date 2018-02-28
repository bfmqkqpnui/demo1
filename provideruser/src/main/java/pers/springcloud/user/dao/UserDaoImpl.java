package pers.springcloud.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pers.springcloud.user.entity.User;

import java.io.Serializable;
import java.util.List;

/**
 * JpaRepository接口（SpringDataJPA提供的简单数据操作接口）
 * JpaSpecificationExecutor（SpringDataJPA提供的复杂查询接口）
 * Serializable（序列化接口）
 */
public interface UserDaoImpl extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>,Serializable{
    /**
     * 根据用户编号查询用户
     *
     * @param userId
     * @return
     */
    User queryByUserId(String userId);
}
