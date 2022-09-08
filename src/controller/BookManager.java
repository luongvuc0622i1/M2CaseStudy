package controller;

import model.book.Book;
import storage.IGenericReadWriteData;

import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private static IGenericReadWriteData readWriteData = storage.book_ReadWriteData.ReadWriteFile.getInstance();
    public static List<Book> bookList = new ArrayList<>();

    public BookManager() {
    }

    public void addNewBook(Book book) {
        bookList = readWriteData.readData();
        bookList.add(book);
        readWriteData.writeData(bookList);
    }

    public void copyBookList(String pathIn, String pathOut) {
        bookList = readWriteData.readData(pathIn);
        readWriteData.writeData(bookList, pathOut);
    }

    public void editBookById(int index, Book book) {
        bookList = readWriteData.readData();
        bookList.set(index, book);
        readWriteData.writeData(bookList);
    }

    public void removeBookById(int index) {
        bookList = readWriteData.readData();
        bookList.remove(index);
        readWriteData.writeData(bookList);
    }
}
