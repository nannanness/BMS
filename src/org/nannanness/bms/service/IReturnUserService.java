package org.nannanness.bms.service;


import org.nannanness.bms.domain.RegisterUser;
import org.nannanness.bms.domain.User;

import java.sql.SQLException;
import java.util.List;

/**
 * 通过用户昵称来获取用户信息弹出在第二个面板中
 */
public interface IReturnUserService{
    public List<User> getRegisterUserByAll();
    public List<User> getRegisterUserByUserName(String username);
    public List<User> getRegisterUserByUserID(int userid);
    public void insert(User user);
    public void deleteUser(int id);
    // 分页查询
    public List<User> getPage(int userid ,String username , int currentPage, int pageSize) throws SQLException;

    // 总纪录数
    public int getSumCount(int userid ,String username) throws SQLException;
}
