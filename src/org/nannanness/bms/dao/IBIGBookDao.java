package org.nannanness.bms.dao;


import org.nannanness.bms.domain.BIGBOOK;

import java.util.List;

public interface IBIGBookDao {
    //查询全部图书类别的信息
    public List<BIGBOOK> getBookType(BIGBOOK bigbook);
}
