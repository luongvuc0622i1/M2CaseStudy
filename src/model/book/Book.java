package model.book;

import java.io.Serializable;

public abstract class Book implements Serializable, Comparable<Book> {
    private String bookId;
    private String bookName;
    private String author;
    private int publishYear;
    private int amount;
    private int price;

    public Book() {
    }

    public Book(String bookId, String bookNamme, String author, int publishYear, int amount, int price) {
        this.bookId = bookId;
        this.bookName = bookNamme;
        this.author = author;
        this.publishYear = publishYear;
        this.amount = amount;
        this.price = price;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
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

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", publishYear=" + publishYear +
                ", amount=" + amount +
                ", price=" + price;
    }

    @Override
    public int compareTo(Book o) {
        int a = this.getBookId().compareTo(o.getBookId());
        return a;
    }
}
