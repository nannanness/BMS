package org.nannanness.bms.dao.daoImpl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.nannanness.bms.dao.IBookDao;
import org.nannanness.bms.domain.Book;
import org.nannanness.bms.domain.Book2;
import org.nannanness.bms.tools.JDBCUtils;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class BookDaoImpl implements IBookDao {
    private DataSource ds = JDBCUtils.getDataSource();
    private QueryRunner runner = new QueryRunner(ds);
    @Override
    public List<Book2> getBookList(String bookName , String author , String bookType) throws SQLException {
        String sql = "select * from \"BOOK\" where";
        List<Book2> list = null;
        if(bookName == null && author == null && bookType != null){
            sql += " \"BOOKTYPE\" = ?";
            list = runner.query(sql , new BeanListHandler<Book2>(Book2.class) , bookType);
        }else if(bookName == null && author != null && bookType != null){
            sql += " \"BOOKAUTHOR\" = ? and \"BOOKTYPE\" = ?";
            list = runner.query(sql , new BeanListHandler<>(Book2.class) , author , bookType);
        }else if(author == null && bookName != null && bookType != null){
            sql += " \"BOOKNAME\" = ? and \"BOOKTYPE\" = ?";
            list = runner.query(sql , new BeanListHandler<>(Book2.class) , bookName , bookType);
        }
        return list;
    }

    @Override
    public List<Book2> getPage(String bookName , String author , String bookType , int currentPage, int pageSize) throws SQLException {
        List<Book2> list = null;
        String sql = "select * from \"BOOK\" where";
        if(bookName == null && author == null && bookType != null){
            sql += " \"BOOKTYPE\" = ?";
            list = runner.query(JDBCUtils.PagenationSql(sql,currentPage,pageSize),new BeanListHandler<Book2>(Book2.class),bookType);
        }else if(bookName == null && author != null && bookType != null){
            sql += " \"BOOKAUTHOR\" = ? and \"BOOKTYPE\" = ?";
            list = runner.query(JDBCUtils.PagenationSql(sql,currentPage,pageSize),new BeanListHandler<Book2>(Book2.class),author,bookType);
        }else if(author == null && bookName != null && bookType != null){
            sql += " \"BOOKNAME\" = ? and \"BOOKTYPE\" = ?";
            list = runner.query(JDBCUtils.PagenationSql(sql,currentPage,pageSize),new BeanListHandler<Book2>(Book2.class),bookName,bookType);
        }
        return list;
    }

    @Override
    public int getSumCount(String bookName , String author , String bookType) throws SQLException {
        int SumCount = 0;
        String sql = "select count(*) from \"BOOK\" where";
        if(bookName == null && author == null && bookType != null){
            sql += " \"BOOKTYPE\" = ?";
            SumCount = Integer.parseInt(runner.query(sql,new ScalarHandler<>(1), bookType).toString());
        }else if(bookName == null && author != null && bookType != null){
            sql += " \"BOOKAUTHOR\" = ? and \"BOOKTYPE\" = ?";
            SumCount = Integer.parseInt(runner.query(sql,new ScalarHandler<>(1),author,bookType).toString());
        }else if(author == null && bookName != null && bookType != null){
            sql += " \"BOOKNAME\" = ? and \"BOOKTYPE\" = ?";
            SumCount = Integer.parseInt(runner.query(sql,new ScalarHandler<>(1),bookName,bookType).toString());
        }
        return SumCount;
    }

    @Override
    public void delete(String bookname) {
        String sql = "delete from \"BOOK\" where \"BOOKNAME\" = ?";
        try {
            runner.update(sql,bookname);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //通过类别查询图书信息
    @Override
    public List<Book2> getTypeBookByTypeName(String  bookType) throws SQLException {
        //QueryRunner对象
        String sql = "select * from \"BOOK\" where \"BOOKTYPE\" = ?";
        List<Book2> list = runner.query(sql, new BeanListHandler<Book2>(Book2.class), bookType);
        return list;
    }
    //根据图书姓名，图书作者，图书类别，图书单价来进行添加功能
    @Override
    public void addByTypeName(String bookname , String bookauthor , String bookdescription,String booktype) {
        String sql = "insert into \"BOOK\"(\"BOOKNAME\",\"BOOKAUTHOR\",\"BOOKDESCRIPTION\",\"BOOKTYPE\") VALUES (?,?,?,?)";
        try {
            runner.update(sql,bookname,bookauthor,bookdescription,booktype);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //查询全部图书类别的信息
    public List<Book2> getBookType() throws SQLException {
        String sql = "SELECT \"BOOKTYPE\" ,\"BOOKDESCRIPTION\" ,\"BOOKTOTAL\" FROM \"BOOK\" GROUP BY \"BOOKTYPE\" , \"BOOKDESCRIPTION\",\"BOOKTOTAL\"";
        List<Book2> list = runner.query(sql,new BeanListHandler<Book2>(Book2.class));
        return list;
    }

    @Override
    public List<Book2> getPageByBook2(String bookType, int currentPage, int pageSize) throws SQLException {
        List<Book2> list = null;
        String sql = "select * from \"BOOK\" ";
        if(bookType != null){
            sql += "where \"BOOKTYPE\" = ?";
            list = runner.query(JDBCUtils.PagenationSql(sql,currentPage,pageSize),new BeanListHandler<Book2>(Book2.class),bookType);
        }
        return list;
    }

    @Override
    public int getSumCountByBook2(String bookType) throws SQLException {
        int SumCount = 0;
        String sql = "select count(*) from \"BOOK\"";
        if(bookType != null){
            sql += " where \"BOOKTYPE\" = ?";
            SumCount = Integer.parseInt(runner.query(sql,new ScalarHandler<>(1), bookType).toString());
        }
        return SumCount;
    }

}