package org.nannanness.bms.service.serviceImpl;


import org.nannanness.bms.dao.IBorrowReplayDao;
import org.nannanness.bms.dao.daoImpl.BorrowReplayDaoImpl;
import org.nannanness.bms.domain.BorrowReplay;
import org.nannanness.bms.service.IBorrowReplayService;

import java.util.List;

public class BorrowReplayServiceImpl implements IBorrowReplayService {
    IBorrowReplayDao borrowreplayDao = new BorrowReplayDaoImpl();
    @Override
    public List<BorrowReplay> getAll(String active) {
        List<BorrowReplay> brList = null;
        brList = borrowreplayDao.getBorrowReplayByAll(active);
        return brList;
    }
}
