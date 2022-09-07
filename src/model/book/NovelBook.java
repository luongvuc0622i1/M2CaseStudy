package model.book;

import java.io.Serializable;

public class NovelBook extends Book implements Serializable {
    private String original;

    public NovelBook() {
    }

    public NovelBook(String original) {
        this.original = original;
    }

    public NovelBook(String bookId, String bookNamme, String author, int publishYear, int amount, int price, String original) {
        super(bookId, bookNamme, author, publishYear, amount, price);
        this.original = original;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    @Override
    public String toString() {
        return super.toString() +
                "original='" + original + '\'' +
                '}';
    }
}
