package org.nannanness.bms.dao.daoImpl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.nannanness.bms.dao.IUserDao;
import org.nannanness.bms.domain.User;
import org.nannanness.bms.tools.JDBCUtils;

import javax.sql.DataSource;
import java.sql.SQLException;

public class UserDaoImpl implements IUserDao {
    private DataSource ds = JDBCUtils.getDataSource();
    private QueryRunner runner = new QueryRunner(ds);

    // 传入用户和密码，验证并返回用户
    @Override
    public User getUsernameAndPassword(String username,String password) throws SQLException {
        String sql = "select * from \"USER\" where username = ? and password = ?";
        User user = runner.query(sql,new BeanHandler<User>(User.class),username,password);
        return user;
    }

    @Override
    public void insertUser(User user) {
        String sql = "INSERT INTO \"USER\" VALUES(USER_SEQ.nextval,?,?,?,?,?)";
        try {
            runner.update(sql,user.getUsername(),user.getEmail(),user.getAddress(),user.getPhone(),user.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
