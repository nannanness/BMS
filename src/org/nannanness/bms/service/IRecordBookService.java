package org.nannanness.bms.service;

import org.nannanness.bms.domain.BorrowReplay;
import org.nannanness.bms.domain.RecordBook;

import java.util.List;

public interface IRecordBookService {
    // 预借时将图书插入我的借书记录
    public void borrowBookToRecordTable(BorrowReplay borrowReplay);

    // 查询借书表
    public List<BorrowReplay> queryRecordTable(int id);

    // 条件查询
    public List<BorrowReplay> limitQuery(String bookName , String author , String bookType , int id);

    // 分页
    public List<BorrowReplay> getPage(String bookName , String author , String bookType, int id ,int currentPage, int pageSize);

    // 获得总记录
    public int getSumCount(String bookName , String author , String bookType, int id);
}
