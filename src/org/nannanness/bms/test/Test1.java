package org.nannanness.bms.test;

import org.nannanness.bms.dao.IBookDao;
import org.nannanness.bms.dao.IRecordBookDao;
import org.nannanness.bms.dao.daoImpl.BookDaoImpl;
import org.nannanness.bms.dao.daoImpl.RecordBookDaoImpl;
import org.nannanness.bms.domain.Book;
import org.nannanness.bms.domain.Book2;
import org.nannanness.bms.domain.RecordBook;
import org.nannanness.bms.domain.RegisterUser;
import org.nannanness.bms.service.IReturnUserService;
import org.nannanness.bms.service.IUserService;
import org.nannanness.bms.service.serviceImpl.ReturnUserServiceImpl;
import org.nannanness.bms.service.serviceImpl.UserServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class Test1 {
    public static void main(String[] args) throws SQLException {
        IBookDao bookDao = new BookDaoImpl();
//        List<Book2> list = bookDao.getPageByBook2("科幻小说",2,20);
//        for(Book2 book : list){
//            System.out.println(book);
//        }
//        int count = bookDao.getSumCountByBook2("科幻小说");
//        System.out.println(count);

//        bookDao.addByTypeName("上海堡垒","江南","读取现代文学","文学艺术");


//        IReturnUserService user = new ReturnUserServiceImpl();
//        List<RegisterUser> list = user.getPage(null,null,1,10);
//        for(RegisterUser r :list){
//            System.out.println(r);
//        }
//        int count = user.getSumCount(null,null);
//        System.out.println(count);

    }
}
