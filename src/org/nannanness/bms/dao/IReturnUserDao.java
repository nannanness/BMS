package org.nannanness.bms.dao;

import org.nannanness.bms.domain.RegisterUser;
import org.nannanness.bms.domain.User;

import java.sql.SQLException;
import java.util.List;

/*
信息库--实现图书的借阅信查看用户的信息
对用户的所有功能的实现
 */
public interface IReturnUserDao {
    //检索借阅信息通过用户昵称
    public List<User> getReturnUserByAll();
    //检索用户通过用户id
    public List<User> getReturnUserByUserId(int userid);
    //检索用户通过用户昵称
    public List<User> getReturnUserByUserName(String username);
    //通过用户id，用户昵称，用户邮箱，用户住址来添加
    public void insertUser(User user);
    //
    public void deleteUser(int id);

    // 分页查询
    public List<User> getPage(int userid ,String username , int currentPage, int pageSize) throws SQLException;

    // 总纪录数
    public int getSumCount(int userid ,String username) throws SQLException;
}
