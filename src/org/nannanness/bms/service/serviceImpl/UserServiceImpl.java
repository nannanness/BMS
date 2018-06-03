package org.nannanness.bms.service.serviceImpl;

import org.nannanness.bms.dao.daoImpl.UserDaoImpl;
import org.nannanness.bms.domain.User;
import org.nannanness.bms.service.IUserService;

import java.sql.SQLException;

public class UserServiceImpl implements IUserService {
    private UserDaoImpl userDao = new UserDaoImpl();
    // 登录方法
    @Override
    public User login(String username, String password){
        User user = null;
        try {
            user = userDao.getUsernameAndPassword(username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void insertDemo(User user) {
        userDao.insertUser(user);
    }
}
