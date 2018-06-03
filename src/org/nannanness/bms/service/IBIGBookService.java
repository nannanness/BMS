package org.nannanness.bms.service;


import org.nannanness.bms.domain.BIGBOOK;

import java.util.List;

public interface IBIGBookService {
        //得到bigbook表数据
    public List<BIGBOOK> getBigbookByAll(BIGBOOK bigbook);
}
