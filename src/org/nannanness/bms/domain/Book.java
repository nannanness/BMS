package org.nannanness.bms.domain;

import java.util.Objects;

public class Book {
    private String bookName;
    private String author;
    private String press;
    private String bookType;
    private int remaining;

    public Book() {
    }

    public Book(String bookName, String author, String press, String bookType, int remaining) {
        this.bookName = bookName;
        this.author = author;
        this.press = press;
        this.bookType = bookType;
        this.remaining = remaining;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public String getPress() {
        return press;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPress(String press) {
        this.press = press;
    }


    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return remaining == book.remaining &&
                Objects.equals(bookName, book.bookName) &&
                Objects.equals(author, book.author) &&
                Objects.equals(press, book.press) &&
                Objects.equals(bookType, book.bookType);
    }

    @Override
    public int hashCode() {

        return Objects.hash(bookName, author, press, bookType, remaining);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", press='" + press + '\'' +
                ", bookType='" + bookType + '\'' +
                ", remaining=" + remaining +
                '}';
    }
}
