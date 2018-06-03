package org.nannanness.bms.service.serviceImpl;

import org.nannanness.bms.dao.IRecordBookDao;
import org.nannanness.bms.dao.daoImpl.RecordBookDaoImpl;
import org.nannanness.bms.domain.BorrowReplay;
import org.nannanness.bms.domain.RecordBook;
import org.nannanness.bms.service.IRecordBookService;

import java.sql.SQLException;
import java.util.List;

public class RecordBookServiceImpl implements IRecordBookService {
    IRecordBookDao rBookDao = new RecordBookDaoImpl();
    @Override
    public void borrowBookToRecordTable(BorrowReplay borrowReplay) {
        try {
            rBookDao.insertBorrowTable(borrowReplay);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<BorrowReplay> queryRecordTable(int id) {
        List<BorrowReplay> list = null;
        try {
            list = rBookDao.queryRecordTable(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<BorrowReplay> limitQuery(String bookName, String author, String bookType, int id) {
        List<BorrowReplay> list = null;
        try {
            list = rBookDao.queryByBookNameOrAuthorOrBookType(bookName, author, bookType, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<BorrowReplay> getPage(String bookName, String author, String bookType, int id, int currentPage, int pageSize) {
        List<BorrowReplay> list = null;
        try {
            list = rBookDao.getPage(bookName , author , bookType , id , currentPage , pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int getSumCount(String bookName, String author, String bookType, int id) {
        int sumCount = 0;
        try {
            sumCount = rBookDao.getSumCount(bookName , author , bookType , id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sumCount;
    }
}
