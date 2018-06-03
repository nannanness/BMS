package org.nannanness.bms.service;


import org.nannanness.bms.domain.BorrowReplay;

import java.util.List;

public interface IBorrowReplayService {
    public List<BorrowReplay> getAll(String active);
 }
