package controller;

import controller.comparator.comparatorBook.BookIdComparator;
import controller.comparator.comparatorBook.BookNameComparator;
import controller.comparator.comparatorBook.BookPriceComparator;
import model.book.Book;
import storage.IGenericReadWriteData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    public void editBookByBookId(String bookId, Book book) {
        bookList = readWriteData.readData();
        int index = -1;
        for (int i = 0; i < bookList.size(); i++) {
            if (bookId.equals(bookList.get(i).getBookId())) {
                index = i;
            }
        }
        bookList.set(index, book);
        readWriteData.writeData(bookList);
    }

    public void removeBookByBookId(String bookId) {
        bookList = readWriteData.readData();
        int index = -1;
        for (int i = 0; i < bookList.size(); i++) {
            if (bookId.equals(bookList.get(i).getBookId())) {
                index = i;
            }
        }
        System.out.println(index);
        bookList.remove(index);
        readWriteData.writeData(bookList);
    }

    public void sortByName() {
        bookList = readWriteData.readData();
        System.out.println("Sắp xếp theo thuộc tính name:");
        Collections.sort(bookList, new BookNameComparator());
        readWriteData.writeData(bookList);
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    public void sortById() {
        bookList = readWriteData.readData();
        System.out.println("Sắp xếp theo thuộc tính id:");
        Collections.sort(bookList, new BookIdComparator());
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    public void sortByPrice() {
        bookList = readWriteData.readData();
        System.out.println("Sắp xếp theo thuộc tính giá:");
        Collections.sort(bookList, new BookPriceComparator());
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    public void display() {
        bookList = readWriteData.readData();
        if(bookList.isEmpty()){
            System.out.println("Thư viện đang trống sách!");
        } else {
            for (Book book : bookList) {
                System.out.println(book);
            }
        }
    }
}
