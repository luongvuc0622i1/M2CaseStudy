package controller.comparator.comparatorBook;

import model.book.Book;

import java.util.Comparator;

public class BookIdComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getBookId().compareTo(o2.getBookId());
    }
}
