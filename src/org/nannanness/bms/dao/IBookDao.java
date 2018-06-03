package org.nannanness.bms.dao;

import org.nannanness.bms.domain.Book;
import org.nannanness.bms.domain.Book2;

import java.sql.SQLException;
import java.util.List;

public interface IBookDao {
    // 检索图书
    public List<Book2> getBookList(String bookName , String author , String bookType) throws SQLException;

    // 分页查询
    public List<Book2> getPage(String bookName ,String author ,String bookType , int currentPage, int pageSize) throws SQLException;

    // 总纪录数
    public int getSumCount(String bookName , String author , String bookType) throws SQLException;

    // 删除
    public void delete(String bookname);

    //通过图书类别检索图书
    public List<Book2> getTypeBookByTypeName(String  bookType) throws SQLException;
    //通过图书名称来进行添加功能
    public void addByTypeName(String bookname , String bookauthor , String bookdescription,String booktype);

    //查询全部图书类别的信息
    public List<Book2> getBookType() throws SQLException;

    // 分页查询
    public List<Book2> getPageByBook2(String bookType , int currentPage, int pageSize) throws SQLException;

    // 总纪录数
    public int getSumCountByBook2(String bookType) throws SQLException;
}
