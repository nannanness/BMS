package org.nannanness.bms.dao.daoImpl;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.nannanness.bms.dao.ILibararyDao;
import org.nannanness.bms.domain.Libarary;
import org.nannanness.bms.tools.JDBCUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibararyDaoImpl implements ILibararyDao {
    QueryRunner qur = new QueryRunner(JDBCUtils.getDataSource());
    @Override
    public List getNameWhereService() {
        List list = null;
        String str = "select * from \"LABRARY\"";
        try {
            list = qur.query(str,new BeanListHandler<Libarary>(Libarary.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Libarary> getAll() {
        List list = null;
        String str = "select * from \"LABRARY\"";
        try {
            list = qur.query(str,new BeanListHandler<Libarary>(Libarary.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
