package cn.zjcscut.service;

import cn.zjcscut.dao.UserDAO;
import cn.zjcscut.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zjc
 * @version 2016/5/13 1:43
 */
@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public List<User> findUserByAge(int age) {
        return userDAO.selectByAge(age);
    }
}
