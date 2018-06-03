package org.nannanness.bms.domain;

import java.util.Objects;

public class BIGBOOK {
    private String bookType;
    private String bookDescription;
    private int bookRetain;

    public BIGBOOK() {
    }

    public BIGBOOK(String bookType, String bookDescription, int bookRetain) {
        this.bookType = bookType;
        this.bookDescription = bookDescription;
        this.bookRetain = bookRetain;
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

    public int getBookRetain() {
        return bookRetain;
    }

    public void setBookRetain(int bookRetain) {
        this.bookRetain = bookRetain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BIGBOOK bigbook = (BIGBOOK) o;
        return bookRetain == bigbook.bookRetain &&
                Objects.equals(bookType, bigbook.bookType) &&
                Objects.equals(bookDescription, bigbook.bookDescription);
    }

    @Override
    public int hashCode() {

        return Objects.hash(bookType, bookDescription, bookRetain);
    }

    @Override
    public String toString() {
        return "BIGBOOK{" +
                "bookType='" + bookType + '\'' +
                ", bookDescription='" + bookDescription + '\'' +
                ", bookRetain=" + bookRetain +
                '}';
    }
}
