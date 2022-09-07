package model.book;

import java.io.Serializable;

public abstract class Book implements Serializable {
    private String bookId;
    private String bookNamme;
    private String author;
    private int publishYear;
    private int amount;
    private int price;

    public Book() {
    }

    public Book(String bookId, String bookNamme, String author, int publishYear, int amount, int price) {
        this.bookId = bookId;
        this.bookNamme = bookNamme;
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

    public String getBookNamme() {
        return bookNamme;
    }

    public void setBookNamme(String bookNamme) {
        this.bookNamme = bookNamme;
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
                ", bookNamme='" + bookNamme + '\'' +
                ", author='" + author + '\'' +
                ", publishYear=" + publishYear +
                ", amount=" + amount +
                ", price=" + price;
    }
}
