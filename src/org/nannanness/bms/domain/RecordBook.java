package org.nannanness.bms.domain;

import java.util.Objects;

public class RecordBook {
    private String bookName;
    private String author;
    private String bookType;
    private String borrowTime;
    private String state;
    private int userid;

    public RecordBook() {
    }

    public RecordBook(String bookName, String author, String bookType, String borrowTime, String state, int userid) {
        this.bookName = bookName;
        this.author = author;
        this.bookType = bookType;
        this.borrowTime = borrowTime;
        this.state = state;
        this.userid = userid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
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

    public String getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(String borrowTime) {
        this.borrowTime = borrowTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecordBook that = (RecordBook) o;
        return userid == that.userid &&
                Objects.equals(bookName, that.bookName) &&
                Objects.equals(author, that.author) &&
                Objects.equals(bookType, that.bookType) &&
                Objects.equals(borrowTime, that.borrowTime) &&
                Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {

        return Objects.hash(bookName, author, bookType, borrowTime, state, userid);
    }

    @Override
    public String toString() {
        return "RecordBook{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", bookType='" + bookType + '\'' +
                ", borrowTime='" + borrowTime + '\'' +
                ", state='" + state + '\'' +
                ", userid=" + userid +
                '}';
    }
}
