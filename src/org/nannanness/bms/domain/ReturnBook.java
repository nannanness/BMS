package org.nannanness.bms.domain;

import java.util.Date;
import java.util.Objects;

/*
借阅信息库
 */
public class ReturnBook {
    //用户昵称
    private String userName;
    //借阅图书名称
    private String bookName;
    //借阅日期起
    private Date beginBorrowDate;
    //还书日期
    private Date returnDate;

    public ReturnBook() {
    }

    public ReturnBook(String userName, String bookName, Date beginBorrowDate, Date returnDate) {
        this.userName = userName;
        this.bookName = bookName;
        this.beginBorrowDate = beginBorrowDate;
        this.returnDate = returnDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Date getBeginBorrowDate() {
        return beginBorrowDate;
    }

    public void setBeginBorrowDate(Date beginBorrowDate) {
        this.beginBorrowDate = beginBorrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "ReturnBook{" +
                "userName='" + userName + '\'' +
                ", bookName='" + bookName + '\'' +
                ", beginBorrowDate=" + beginBorrowDate +
                ", returnDate=" + returnDate +
                '}';
    }
}