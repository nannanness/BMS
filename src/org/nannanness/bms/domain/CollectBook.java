package org.nannanness.bms.domain;

import java.util.Objects;

public class CollectBook {
    private String bookName;
    private String author;
    private String press;
    private String bookType;
    private int userId;

    public CollectBook() {
    }

    public CollectBook(String bookName, String author, String press, String bookType, int userId) {
        this.bookName = bookName;
        this.author = author;
        this.press = press;
        this.bookType = bookType;
        this.userId = userId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollectBook book = (CollectBook) o;
        return userId == book.userId &&
                Objects.equals(bookName, book.bookName) &&
                Objects.equals(author, book.author) &&
                Objects.equals(press, book.press) &&
                Objects.equals(bookType, book.bookType);
    }

    @Override
    public int hashCode() {

        return Objects.hash(bookName, author, press, bookType, userId);
    }

    @Override
    public String toString() {
        return "CollectBook{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", press='" + press + '\'' +
                ", bookType='" + bookType + '\'' +
                ", userId=" + userId +
                '}';
    }
}
