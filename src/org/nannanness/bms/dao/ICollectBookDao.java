package org.nannanness.bms.dao;

import org.nannanness.bms.domain.CollectBook;

import java.sql.SQLException;
import java.util.List;

public interface ICollectBookDao {
    // 插入收藏的图书
    public void insertCollectBook(CollectBook collectBook) throws SQLException;

    // 查询收藏的图书
    public List<CollectBook> getCollectBookList(int id) throws SQLException;
}
