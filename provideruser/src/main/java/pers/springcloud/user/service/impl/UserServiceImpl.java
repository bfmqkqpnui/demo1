package pers.springcloud.user.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import pers.springcloud.common.ReturnDTO;
import pers.springcloud.user.dao.UserDaoImpl;
import pers.springcloud.user.entity.User;
import pers.springcloud.user.service.IUserService;
import pers.springcloud.utils.CommonUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component(value = "UserService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDaoImpl userDao;

    /**
     * 用于批处理
     */
    @PersistenceContext
    protected EntityManager em;

    /**
     * 根据用户编号查询
     *
     * @param uId
     * @return
     */
    public ReturnDTO queryByUserId(String uId) {
        ReturnDTO dto = new ReturnDTO();
        dto.setSuccess(false);
        if (StringUtils.isNotBlank(uId)) {
            User user = userDao.queryByUserId(uId);
            if (null != user) {
                dto.setSuccess(true);
                dto.setResCode("200");
                dto.setObj(user);
            } else {
                dto.setResCode("404");
                dto.setErrMsg("该编号[" + uId + "]所查询的用户不存在,请确认。");
            }
        } else {
            dto.setResCode("400");
            dto.setErrMsg("查询的用户编号不能为空");
        }
        return dto;
    }

    /**
     * 分页查询
     *
     * @return
     */
    public ReturnDTO queryByPage(int currentPage, int pageSize) {
        ReturnDTO dto = new ReturnDTO();
        dto.setSuccess(false);
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(currentPage, pageSize, sort);
        Page<User> page = userDao.findAll(pageable);
        if (null != page && page.getSize() > 0) {
            List<User> users = new ArrayList<User>();
            Iterator it = page.iterator();
            while (it.hasNext()) {
                User user = (User) it.next();
                if (null != user) {
                    users.add(user);
                }
            }

            if (CommonUtils.isExist(users)) {
                dto.setSuccess(true);
                dto.setResCode("200");
                dto.setObj(users);
            } else {
                dto.setResCode("404");
                dto.setErrMsg("没有相应的数据");
            }
        }
        return dto;
    }

    /**
     * 根据用户编号更新用户信息
     *
     * @param user
     * @return
     */
    public ReturnDTO updateUserInfo(User user) {
        ReturnDTO dto = new ReturnDTO();
        dto.setSuccess(false);
        return null;
    }

    /**
     * 根据用户编号删除用户信息(逻辑删除)
     *
     * @param uId
     * @return
     */
    public ReturnDTO deleteUserInfoById(String uId) {
        ReturnDTO dto = new ReturnDTO();
        dto.setSuccess(false);
        return null;
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    public ReturnDTO addUser(User user) {
        ReturnDTO dto = new ReturnDTO();
        dto.setSuccess(false);
        User u = userDao.save(user);
        if (null != u) {
            dto.setSuccess(true);
            dto.setResCode("200");
        }
        return null;
    }

    /**
     * 批量添加用户信息
     *
     * @param users
     * @return
     */
    public ReturnDTO addUsers(List<User> users) {
        ReturnDTO dto = new ReturnDTO();
        dto.setSuccess(false);
        if (CommonUtils.isExist(users)) {
            for (int i = 0; i < users.size(); i++) {
                em.persist(users.get(i));
                if (i % 30 == 0) {
                    em.flush();
                    em.clear();
                }
            }
            dto.setSuccess(true);
            dto.setResCode("200");
        }

        return dto;
    }
}
