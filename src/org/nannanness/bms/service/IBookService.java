package org.nannanness.bms.service;

import org.nannanness.bms.domain.Book;
import org.nannanness.bms.domain.Book2;

import java.sql.SQLException;
import java.util.List;

public interface IBookService {

    // 检索图书
    public List<Book2> findBooks(String bookName , String author , String bookType);

    // 分页
    public List<Book2> getPage(String bookName , String author , String bookType ,int currentPage, int pageSize);

    // 获得总记录
    public int getSumCount(String bookName , String author , String bookType);

    // 删除
    public void delete(String name);

    //得到详细图书的信息
    public List<Book2> specificBook(String  bookType);

    public void add(String bookname , String bookauthor , String bookdescription,String booktype);

    public List<Book2> getBookType();

    // 分页查询
    public List<Book2> getPageByBook2(String bookType , int currentPage, int pageSize);

    // 总纪录数
    public int getSumCountByBook2(String bookType);
}
