package org.nannanness.bms.service;

import org.nannanness.bms.domain.CollectBook;

import java.util.List;

public interface ICollectBookService {
    // 插入收藏的图书
    public void insertCollectBook(CollectBook collectBook);

    // 查询藏书
    public List<CollectBook> queryCollectBooks(int id);
}
