package org.nannanness.bms.service.serviceImpl;

import org.nannanness.bms.dao.IBookDao;
import org.nannanness.bms.dao.daoImpl.BookDaoImpl;
import org.nannanness.bms.domain.Book;
import org.nannanness.bms.domain.Book2;
import org.nannanness.bms.service.IBookService;

import java.sql.SQLException;
import java.util.List;

public class BookServiceImpl implements IBookService {
    private IBookDao bookDao = new BookDaoImpl();
    @Override
    public List<Book2> findBooks(String bookName , String author , String bookType) {
        List<Book2> list = null;
        try {
            list = bookDao.getBookList(bookName , author , bookType);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Book2> getPage(String bookName , String author , String bookType , int currentPage, int pageSize) {
        List<Book2> list = null;
        try {
            list = bookDao.getPage(bookName , author , bookType , currentPage , pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int getSumCount(String bookName , String author , String bookType) {
        int sumCount = 0;
        try {
            sumCount = bookDao.getSumCount( bookName ,  author ,  bookType);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sumCount;
    }

    @Override
    public void delete(String name) {
        bookDao.delete(name);
    }

    @Override
    public List<Book2> specificBook(String bookType){
        List<Book2> list = null;
        try {
            list = bookDao.getTypeBookByTypeName(bookType);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void add(String bookname, String bookauthor, String bookdescription, String booktype) {
        bookDao.addByTypeName(bookname,bookauthor,bookdescription,booktype);
    }

    @Override
    public List<Book2> getBookType() {
        List<Book2> list = null;
        try {
            list = bookDao.getBookType();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Book2> getPageByBook2(String bookType, int currentPage, int pageSize) {
        List<Book2> list = null;
        try {
            list = bookDao.getPageByBook2(bookType,currentPage,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public int getSumCountByBook2(String bookType) {
        int count = 0;
        try {
            count = bookDao.getSumCountByBook2(bookType);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
