package model.book;

import java.io.Serializable;

public class ProgrammingBook extends Book implements Serializable {
    private String language;
    private String framework;

    public ProgrammingBook() {
    }

    public ProgrammingBook(String language, String framework) {
        this.language = language;
        this.framework = framework;
    }

    public ProgrammingBook(String bookId, String bookNamme, String author, int publishYear, int amount, int price, String language, String framework) {
        super(bookId, bookNamme, author, publishYear, amount, price);
        this.language = language;
        this.framework = framework;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFramework() {
        return framework;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", language='" + language + '\'' +
                ", framework='" + framework + '\'' +
                '}';
    }
}
