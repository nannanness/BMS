package org.nannanness.bms.service.serviceImpl;


import org.nannanness.bms.dao.IReturnUserDao;
import org.nannanness.bms.dao.daoImpl.IReturnUserDaoImpl;
import org.nannanness.bms.domain.RegisterUser;
import org.nannanness.bms.domain.User;
import org.nannanness.bms.service.IReturnUserService;

import java.sql.SQLException;
import java.util.List;

/**
 * 管理员用户信息查询Service层
 */
public class ReturnUserServiceImpl implements IReturnUserService {
    IReturnUserDao userdao = new IReturnUserDaoImpl();
    List<User> list ;
    RegisterUser use = new RegisterUser();
    @Override
    public List<User> getRegisterUserByAll() {
        list = userdao.getReturnUserByAll();
        return list;
    }

    @Override
    public List<User> getRegisterUserByUserName(String username) {
        list = userdao.getReturnUserByUserName(username);
        return list;
    }

    @Override
    public List<User> getRegisterUserByUserID(int userid) {
        list = userdao.getReturnUserByUserId(userid);
        return list;
    }

    @Override
    public void insert(User user) {
        userdao.insertUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userdao.deleteUser(id);
    }

    @Override
    public List<User> getPage(int userid, String username, int currentPage, int pageSize) throws SQLException {
        List<User> list = userdao.getPage(userid,username,currentPage,pageSize);
        return list;
    }

    @Override
    public int getSumCount(int userid, String username) throws SQLException {
        int count = userdao.getSumCount(userid,username);
        return count;
    }
}
