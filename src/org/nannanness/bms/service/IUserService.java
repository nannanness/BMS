package org.nannanness.bms.service;

import org.nannanness.bms.dao.IUserDao;
import org.nannanness.bms.dao.daoImpl.UserDaoImpl;
import org.nannanness.bms.domain.User;

import java.sql.SQLException;

public interface IUserService {

    public User login(String username, String password);
    public void insertDemo(User user);
}
