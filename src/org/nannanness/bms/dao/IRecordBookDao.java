package org.nannanness.bms.dao;

import org.nannanness.bms.domain.BorrowReplay;
import org.nannanness.bms.domain.RecordBook;

import java.sql.SQLException;
import java.util.List;

public interface IRecordBookDao {
    // 插入借书表中
    public void insertBorrowTable(BorrowReplay borrowReplay) throws SQLException;

    // 查询借书表
    public List<BorrowReplay> queryRecordTable(int id) throws SQLException;

    // 按条件查询
    public List<BorrowReplay> queryByBookNameOrAuthorOrBookType(String bookName , String author , String bookType , int id) throws SQLException;

    // 分页查询
    public List<BorrowReplay> getPage(String bookName ,String author ,String bookType , int id , int currentPage, int pageSize) throws SQLException;

    // 总纪录数
    public int getSumCount(String bookName , String author , String bookType , int id) throws SQLException;
}
