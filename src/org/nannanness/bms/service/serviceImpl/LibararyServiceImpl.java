package org.nannanness.bms.service.serviceImpl;


import org.nannanness.bms.dao.ILibararyDao;
import org.nannanness.bms.dao.daoImpl.LibararyDaoImpl;
import org.nannanness.bms.service.ILibararyService;

import java.util.ArrayList;
import java.util.List;

public class LibararyServiceImpl implements ILibararyService {
    ILibararyDao lidao = new LibararyDaoImpl();
    List list = new ArrayList();
    @Override
    public List getNameWhereService() {
        list = lidao.getNameWhereService();
        return list;
    }

    @Override
    public List getAll() {
        list = lidao.getAll();
        return list;
    }
}
