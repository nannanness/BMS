package org.nannanness.bms.dao;

import org.nannanness.bms.domain.User;

import javax.sql.DataSource;
import java.sql.SQLException;

public interface IUserDao {
    public User getUsernameAndPassword(String username,String password) throws SQLException;
    public void insertUser(User user);
}
