package org.nannanness.bms.service.serviceImpl;


import org.nannanness.bms.dao.IBIGBookDao;
import org.nannanness.bms.dao.daoImpl.BIGBookDaoImpl;
import org.nannanness.bms.domain.BIGBOOK;
import org.nannanness.bms.service.IBIGBookService;

import java.util.List;

public class BIGBookServiceImpl implements IBIGBookService {
    IBIGBookDao dao = new BIGBookDaoImpl();
    List<BIGBOOK> list ;
    @Override
    public List<BIGBOOK> getBigbookByAll(BIGBOOK bigbook) {
        list = dao.getBookType(bigbook);
        return list;
    }
}
