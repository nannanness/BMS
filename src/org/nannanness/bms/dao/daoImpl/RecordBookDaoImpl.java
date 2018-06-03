package org.nannanness.bms.dao.daoImpl;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.nannanness.bms.dao.IRecordBookDao;
import org.nannanness.bms.domain.BorrowReplay;
import org.nannanness.bms.domain.RecordBook;
import org.nannanness.bms.tools.JDBCUtils;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class RecordBookDaoImpl implements IRecordBookDao {
    DataSource ds = JDBCUtils.getDataSource();
    QueryRunner runner = new QueryRunner(ds);
    @Override
    public void insertBorrowTable(BorrowReplay borrowReplay) throws SQLException {
        String sql = "insert into \"BORROWGIVE\" values(? , ? , ? , ? , ? , ?)";
        runner.update(sql ,borrowReplay.getUserId(), borrowReplay.getBookName(),borrowReplay.getBorrowDate(),borrowReplay.getActive(),borrowReplay.getAuthor(),borrowReplay.getBookType());
    }

    @Override
    public List<BorrowReplay> queryRecordTable(int id) throws SQLException {
        String sql = "select * from \"BORROWGIVE\" where \"USERID\" = ?";
        List<BorrowReplay> list = runner.query(sql , new BeanListHandler<BorrowReplay>(BorrowReplay.class) ,id);
        return list;
    }

    @Override
    public List<BorrowReplay> queryByBookNameOrAuthorOrBookType(String bookName, String author, String bookType, int id) throws SQLException {
        String sql = "select * from \"BORROWGIVE\" where";
        List<BorrowReplay> list = null;
        if(bookName == null && author == null && bookType != null){
            sql += " \"BOOKTYPE\" = ? and \"USERID\" = ?";
            list = runner.query(sql , new BeanListHandler<BorrowReplay>(BorrowReplay.class) , bookType , id);
        }else if(bookName == null && author != null && bookType != null){
            sql += " \"AUTHOR\" = ? and \"BOOKTYPE\" = ? and \"USERID\" = ?";
            list = runner.query(sql , new BeanListHandler<>(BorrowReplay.class) , author , bookType , id);
        }else if(author == null && bookName != null && bookType != null){
            sql += " \"BOOKNAME\" = ? and \"BOOKTYPE\" = ? and \"USERID\" = ?";
            list = runner.query(sql , new BeanListHandler<>(BorrowReplay.class) , bookName , bookType , id);
        }
        return list;
    }

    @Override
    public List<BorrowReplay> getPage(String bookName, String author, String bookType, int id, int currentPage, int pageSize) throws SQLException {
        List<BorrowReplay> list = null;
        String sql = "select * from \"BORROWGIVE\" where";
        if(bookName == null && author == null && bookType != null){
            sql += " \"BOOKTYPE\" = ? and \"USERID\" = ?";
            list = runner.query(JDBCUtils.PagenationSql(sql,currentPage,pageSize),new BeanListHandler<BorrowReplay>(BorrowReplay.class),bookType , id);
        }else if(bookName == null && author != null && bookType != null){
            sql += " \"AUTHOR\" = ? and \"BOOKTYPE\" = ? and \"USERID\" = ?";
            list = runner.query(JDBCUtils.PagenationSql(sql,currentPage,pageSize),new BeanListHandler<BorrowReplay>(BorrowReplay.class),author,bookType , id);
        }else if(author == null && bookName != null && bookType != null){
            sql += " \"BOOKNAME\" = ? and \"BOOKTYPE\" = ? and \"USERID\" = ?";
            list = runner.query(JDBCUtils.PagenationSql(sql,currentPage,pageSize),new BeanListHandler<BorrowReplay>(BorrowReplay.class),bookName,bookType ,id);
        }
        return list;
    }

    @Override
    public int getSumCount(String bookName, String author, String bookType, int id) throws SQLException {
        int SumCount = 0;
        String sql = "select count(*) from \"BORROWGIVE\" where";
        if(bookName == null && author == null && bookType != null){
            sql += " \"BOOKTYPE\" = ? and \"USERID\" = ?";
            SumCount = Integer.parseInt(runner.query(sql,new ScalarHandler<>(1), bookType,id).toString());
        }else if(bookName == null && author != null && bookType != null){
            sql += " \"AUTHOR\" = ? and \"BOOKTYPE\" = ? and \"USERID\" = ?";
            SumCount = Integer.parseInt(runner.query(sql,new ScalarHandler<>(1),author,bookType,id).toString());
        }else if(author == null && bookName != null && bookType != null){
            sql += " \"BOOKNAME\" = ? and \"BOOKTYPE\" = ? and \"USERID\" = ?";
            SumCount = Integer.parseInt(runner.query(sql,new ScalarHandler<>(1),bookName,bookType,id).toString());
        }
        return SumCount;
    }
}
