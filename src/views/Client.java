package views;

import controller.BookManager;
import controller.MemberManager;
import controller.OrderManager;
import model.book.Book;
import model.member.Member;
import model.order.Order;
import views.system.RunByAdmin;
import views.system.RunByMember;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static controller.AdminManager.isAdmin;
import static controller.MemberManager.isMember;

public class Client {

    public static void main(String[] args) {
        loginSystem();
    }

    public static void loginSystem() {
        try {
            menuLogin();
        } catch (Exception e) {
            System.out.println("[❌] Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            System.out.println("---------------------------------------------------");
            loginSystem();
        }
    }

    private static void menuLogin() throws NumberFormatException {
        int choice = 0;
        do {
            System.out.println("╔=============================================╗");
            System.out.println("║               CodeGym Library               ║");
            System.out.println("╠=============================================╣");
            System.out.println("║>[1]. Đăng nhập                              ║");
            System.out.println("║>[2]. Đăng ký tài khoản                      ║");
            System.out.println("║>[0]. Thoát                                  ║");
            System.out.println("╚=============================================╝");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập lựa chọn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    registerAccountUser();
                    break;
                case 0:
                    System.out.println("____________Thoát khỏi chương trình____________");
                    System.out.println("Cảm ơn quý vị đã sử dụng dịch vụ của chúng tôi!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("[❌] Lựa chọn không tồn tại, mời bạn nhập lại !!!");
                    break;
            }
        } while (choice != 0);
    }

    private static void login() throws InputMismatchException {
        System.out.println("__________________[ĐĂNG NHẬP]__________________");
        Scanner input1 = new Scanner(System.in);
        System.out.print("  ▹ Nhập số điện thoại: ");
        String phone = input1.nextLine();
        Scanner input2 = new Scanner(System.in);
        System.out.print("  ▹ Nhập mật khẩu: ");
        String password = input2.next();
        System.out.println("_______________________________________________");
        checkAccount(phone, password);
    }

    private static void checkAccount(String phone, String password) {
        try {
            if (isAdmin(phone, password)) {
                System.out.println("[\uD83D\uDD13] Đặng nhập hệ thống bởi ADMIN thành công !!!");
                System.out.println("_______________________________________________");
                RunByAdmin.menuOfAdmin();
            } else if (isMember(phone, password)) {
                System.out.println("[\uD83D\uDD13] Đặng nhập hệ thống bởi MEMBER thành công !!!");
                System.out.println("_______________________________________________");
                RunByMember.menuOfMember(phone, password);
            } else {
                throw new IndexOutOfBoundsException();
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("[❌] Đăng nhập thất bại. Vui lòng đăng nhập lại !!!");
            System.out.println("_______________________________________________");
            login();
        }
    }

    private static void registerAccountUser() throws InputMismatchException {
        System.out.println("___________________[ĐĂNG KÝ]___________________");
        Member member = (new RunByAdmin()).creatNewMenber();
        new MemberManager().addNewMember(member);
//        String phone = (new RunByAdmin()).creatNewMenber().getPhone();
//        String password = (new RunByAdmin()).creatNewMenber().getPassword();
//        checkAccountUser(phone, password, member);
        System.out.println("_______________________________________________");
    }

    private static void checkAccountUser(String phone, String password, Member member) {
        if (isMember(phone, password)) {
            System.out.println("[❌] Tài khoản đã tồn tại. Vui lòng đăng ký lại !!!");
            System.out.println("---------------------------------------");
        } else {
            new MemberManager().addNewMember(member);
            System.out.println("Đăng ký thành công. Mời đăng nhập vào hệ thống !!!");
            System.out.println("----------------------------------------");
            System.out.println();
        }
        login();
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
