package org.nannanness.bms.dao.daoImpl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.nannanness.bms.dao.ICollectBookDao;
import org.nannanness.bms.domain.CollectBook;
import org.nannanness.bms.tools.JDBCUtils;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class CollectBookDaoImpl implements ICollectBookDao {
    DataSource ds = JDBCUtils.getDataSource();
    QueryRunner runner = new QueryRunner(ds);
    @Override
    public void insertCollectBook(CollectBook cBook) throws SQLException {
        String sql = "insert into \"COLLECTBOOK\" values(? , ? , ? , ? , ?)";
        runner.update(sql,cBook.getBookName(),cBook.getAuthor(),cBook.getPress(),cBook.getBookType(),cBook.getUserId());
    }

    @Override
    public List<CollectBook> getCollectBookList(int id) throws SQLException {
        String sql = "select * from \"COLLECTBOOK\" where \"USERID\" = ?";
        List<CollectBook> cBooks = runner.query(sql,new BeanListHandler<CollectBook>(CollectBook.class),id);
        return cBooks;
    }
}
