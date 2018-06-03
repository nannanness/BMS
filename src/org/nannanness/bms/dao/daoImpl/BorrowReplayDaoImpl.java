package org.nannanness.bms.dao.daoImpl;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.nannanness.bms.dao.IBorrowReplayDao;
import org.nannanness.bms.domain.BorrowReplay;
import org.nannanness.bms.tools.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class BorrowReplayDaoImpl implements IBorrowReplayDao {
    QueryRunner qur = new QueryRunner(JDBCUtils.getDataSource());
    @Override
    public List<BorrowReplay> getBorrowReplayByAll(String active) {
        List<BorrowReplay> list = null;
        String sql = "select * from \"BORROWGIVE\" where \"ACTIVE\" = ?";
        try {
            list = qur.query(sql, new BeanListHandler<BorrowReplay>(BorrowReplay.class), active);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

