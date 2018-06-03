package org.nannanness.bms.domain;

import java.util.Date;
import java.util.Objects;

public class BorrowReplay {
    private int userId;
    private String bookName;
    private String borrowDate;
    private String author;
    private String bookType;
    private String active;

    public BorrowReplay(int userId, String bookName, String borrowDate, String author, String bookType, String active) {
        this.userId = userId;
        this.bookName = bookName;
        this.borrowDate = borrowDate;
        this.author = author;
        this.bookType = bookType;
        this.active = active;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public BorrowReplay() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BorrowReplay that = (BorrowReplay) o;
        return userId == that.userId &&
                Objects.equals(bookName, that.bookName) &&
                Objects.equals(borrowDate, that.borrowDate) &&
                Objects.equals(author, that.author) &&
                Objects.equals(bookType, that.bookType) &&
                Objects.equals(active, that.active);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, bookName, borrowDate, author, bookType, active);
    }

    @Override
    public String toString() {
        return "BorrowReplay{" +
                "userId=" + userId +
                ", bookName='" + bookName + '\'' +
                ", borrowDate='" + borrowDate + '\'' +
                ", author='" + author + '\'' +
                ", bookType='" + bookType + '\'' +
                ", active='" + active + '\'' +
                '}';
    }
}
