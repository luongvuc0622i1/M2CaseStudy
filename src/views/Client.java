package views;

import controller.BookManager;
import controller.MemberManager;
import controller.OrderManager;
import model.book.Book;
import model.member.Member;
import model.order.Order;

import java.util.List;

public class Client {

    public static void main(String[] args) {
        Login login = new Login();
        login.loginSystem();
    }
}
