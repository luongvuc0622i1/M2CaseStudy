package model.book;

import java.io.Serializable;

public class FictionBook extends Book implements Serializable {
    private String category;

    public FictionBook() {
    }

    public FictionBook(String category) {
        this.category = category;
    }

    public FictionBook(String bookId, String bookNamme, String author, int publishYear, int amount, int price, String category) {
        super(bookId, bookNamme, author, publishYear, amount, price);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return super.toString() +
                "category='" + category + '\'' +
                '}';
    }
}
