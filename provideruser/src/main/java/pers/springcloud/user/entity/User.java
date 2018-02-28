package pers.springcloud.user.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 用户表实体映射类
 */
@Entity(name = "t_user")
public class User implements Serializable {
    /**
     * 自增长编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    /**
     * 用户编号
     */
    @Column(nullable = false, unique = true)
    private String userId;
    /**
     * 用户名字
     */
    @Column(nullable = false)
    private String userName;
    /**
     * 出生日期
     */
    @Column(nullable = false)
    private String birthday;
    /**
     * 用户性别
     */
    @Column(nullable = false)
    private String gender;
    /**
     * 用户工资
     */
    @Column(nullable = false)
    private String salary;
    /**
     * 用户奖金
     */
    @Column(nullable = false)
    private String bonus;
    /**
     * 创建日期
     */
    @Column
    private String createDate;
    /**
     * 创建时间
     */
    @Column
    private String createTime;
    /**
     * 更新日期
     */
    @Column
    private String updateDate;
    /**
     * 更新时间
     */
    @Column
    private String updateTime;
    /**
     * 用户状态  0:正常  1:冻结  2:注销  3:删除
     */
    @Column
    private String status = "0";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
