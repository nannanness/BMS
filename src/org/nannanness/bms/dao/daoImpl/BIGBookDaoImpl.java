package org.nannanness.bms.dao.daoImpl;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.nannanness.bms.dao.IBIGBookDao;
import org.nannanness.bms.domain.BIGBOOK;
import org.nannanness.bms.tools.JDBCUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 将图书类别，图书简介，图书库存都放在一个big_panel中
 */
public class BIGBookDaoImpl implements IBIGBookDao {
    @Override
    public List<BIGBOOK> getBookType(BIGBOOK bigbook) {
        List<BIGBOOK> list = new ArrayList<>();
        QueryRunner qur = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from BIGBOOK";
        try {
            list = qur.query(sql,new BeanListHandler<BIGBOOK>(BIGBOOK.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
