package org.nannanness.bms.domain;

import java.util.Date;
import java.util.Objects;
/*
图书信息类
 */
public class Book2 {
    //书名
    private String bookName;
    //图书类别
    private String bookType;
    //图书描述
    private String bookDescription;
    //图书出版社
    private String bookIssueCommunity;
    //图书作者
    private String bookAuthor;
    //图书总量
    private int bookTotal;

    public Book2() {
    }

    public Book2(String bookName, String bookType, String bookDescription, String bookIssueCommunity, String bookAuthor, int bookTotal) {
        this.bookName = bookName;
        this.bookType = bookType;
        this.bookDescription = bookDescription;
        this.bookIssueCommunity = bookIssueCommunity;
        this.bookAuthor = bookAuthor;
        this.bookTotal = bookTotal;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public String getBookIssueCommunity() {
        return bookIssueCommunity;
    }

    public void setBookIssueCommunity(String bookIssueCommuinty) {
        this.bookIssueCommunity = bookIssueCommuinty;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getBookTotal() {
        return bookTotal;
    }

    public void setBookTotal(int bookTotal) {
        this.bookTotal = bookTotal;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", bookType='" + bookType + '\'' +
                ", bookDescription='" + bookDescription + '\'' +
                ", bookIssueCommunity='" + bookIssueCommunity + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookTotal=" + bookTotal +
                '}';
    }
}

