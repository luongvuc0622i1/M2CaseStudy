package views;

import controller.BookManager;
import controller.MemberManager;
import controller.OrderManager;
import model.book.Book;
import model.member.Member;
import model.order.Order;

import java.io.IOException;
import java.util.List;

public class Client {

    public static void main(String[] args) {
        Login login = new Login();
        login.loginSystem();
    }

//    public static void clrscr(){
//        //Clears Screen in java
//        try {
//            if (System.getProperty("os.name").contains("Windows"))
//                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
//            else
//                Runtime.getRuntime().exec("clear");
//        } catch (IOException | InterruptedException ex) {}
//    }
}
