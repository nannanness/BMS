package org.nannanness.bms.dao;


import org.nannanness.bms.domain.BorrowReplay;

import java.util.List;

public interface IBorrowReplayDao {
    public List<BorrowReplay> getBorrowReplayByAll(String active);
}
