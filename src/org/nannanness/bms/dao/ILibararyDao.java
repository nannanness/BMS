package org.nannanness.bms.dao;


import org.nannanness.bms.domain.Libarary;

import java.util.List;

public interface ILibararyDao {
    //通过选则下拉框的值查询出相对应的list集合
    public List getNameWhereService();
    public List<Libarary> getAll();
}
