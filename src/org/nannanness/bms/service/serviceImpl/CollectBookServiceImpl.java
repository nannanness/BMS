package org.nannanness.bms.service.serviceImpl;

import org.nannanness.bms.dao.ICollectBookDao;
import org.nannanness.bms.dao.daoImpl.CollectBookDaoImpl;
import org.nannanness.bms.domain.CollectBook;
import org.nannanness.bms.service.ICollectBookService;

import java.sql.SQLException;
import java.util.List;

public class CollectBookServiceImpl implements ICollectBookService {
    ICollectBookDao cBookDao = new CollectBookDaoImpl();
    @Override
    public void insertCollectBook(CollectBook collectBook) {
        try {
            cBookDao.insertCollectBook(collectBook);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<CollectBook> queryCollectBooks(int id) {
        List<CollectBook> list = null;
        try {
            list = cBookDao.getCollectBookList(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
