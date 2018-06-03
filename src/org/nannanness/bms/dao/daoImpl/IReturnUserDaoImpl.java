package org.nannanness.bms.dao.daoImpl;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.nannanness.bms.dao.IReturnUserDao;
import org.nannanness.bms.domain.RegisterUser;
import org.nannanness.bms.domain.User;
import org.nannanness.bms.tools.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * 管理员界面的获取用户信息的界面
 */
public class IReturnUserDaoImpl implements IReturnUserDao {
    QueryRunner qur = new QueryRunner(JDBCUtils.getDataSource());

    @Override
    public List<User> getReturnUserByAll() {
        String sql = "select * FROM \"USER\" where \"ID\" <> 20151001";
        List<User> list = null;
        try {
            list = qur.query(sql,new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(User user : list){
            System.out.println(user);
        }
        return list;
    }
    @Override
    public List<User> getReturnUserByUserName(String username) {
        String sql = "select * FROM \"USER\" WHERE \"USERNAME\" = ?";
        List<User> list = null;
        try {
            list = qur.query(sql,new BeanListHandler<User>(User.class),username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void insertUser(User user) {
        String sql = "insert into \"USER\" VALUES(?,?,?,?)";
    }

    @Override
    public void deleteUser(int id) {
        String sql = "delete from \"USER\" where \"ID\" = ?";
        try {
            qur.update(sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getPage(int userid, String username, int currentPage, int pageSize) throws SQLException {
        List<User> list = null;
        String sql = "select * from \"USER\"";
        if(userid == 0 && username == null){
            list = qur.query(JDBCUtils.PagenationSql(sql,currentPage,pageSize),new BeanListHandler<User>(User.class));
        }else if(userid == 0 && username != null){
            sql += " WHERE \"USERNAME\" = ?";
            list = qur.query(JDBCUtils.PagenationSql(sql,currentPage,pageSize),new BeanListHandler<User>(User.class),username);
        }else if(userid != 0 && username == null){
            sql += " WHERE \"ID\" = ?";
            list = qur.query(JDBCUtils.PagenationSql(sql,currentPage,pageSize),new BeanListHandler<User>(User.class),userid);
        }
        return list;
    }

    @Override
    public int getSumCount(int userid, String username) throws SQLException {
        int SumCount = 0;
        String sql = "select count(*) from \"USER\"";
        if(userid == 0 && username == null){
            SumCount = Integer.parseInt(qur.query(sql,new ScalarHandler<>(1)).toString());
        }else if(userid == 0 && username != null){
            sql += " WHERE \"USERNAME\" = ?";
            SumCount = Integer.parseInt(qur.query(sql,new ScalarHandler<>(1),username).toString());
        }else if(userid != 0 && username == null){
            sql += " WHERE \"USERID\" = ?";
            SumCount = Integer.parseInt(qur.query(sql,new ScalarHandler<>(1),userid).toString());
        }
        return SumCount;
    }

    @Override
    public List<User> getReturnUserByUserId(int userid) {
        String sql = "select * FROM \"USER\" WHERE \"ID\" = ?";
        List<User> list = null;
        try {
            list = qur.query(sql,new BeanListHandler<User>(User.class),userid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
