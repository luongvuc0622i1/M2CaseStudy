package views.system;

import controller.AdminManager;
import controller.BookManager;
import controller.MemberManager;
import controller.OrderManager;
import model.book.Book;
import model.member.Member;
import model.order.Order;
import storage.IGenericReadWriteData;
import storage.admin_ReadWriteData.ReadWriteFile;
import views.Validate;

import java.util.Date;
import java.util.Scanner;

import static controller.BookManager.bookList;
import static controller.MemberManager.memberList;
import static views.Client.loginSystem;
import static views.system.RunByAdmin.*;

public class RunByMember {
    private static Validate validate = Validate.getInstance();
    private static MemberManager memberManager = new MemberManager();
    private static OrderManager orderManager = new OrderManager();
    public static void menuOfMember(String phone, String password) {
        try {
            do {
                System.out.println("╔=============================================╗");
                System.out.println("║               CodeGym Library               ║");
                System.out.println("╠=============================================╣");
                System.out.println("║<> [1]. Sửa thông tin cá nhân                ║");
                System.out.println("║<> [2]. In ra các đầu sách đang mượn         ║");
                System.out.println("║<> [3]. In ra các đầu sách có thể mượn       ║");
                System.out.println("║<> [4]. Tạo mới phiếu mượn                   ║");
                System.out.println("║<> [0]. Đăng xuất                            ║");
                System.out.println("╚=============================================╝");
                Scanner scanner = new Scanner(System.in);
                System.out.print("[\uD83D\uDC4B] Mời bạn nhập lựa chọn: ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        editMember(phone, password);
                        break;
                    case 2:
                        showBorrowingBook(phone, password);
                        break;
                    case 3:
                        menuShowBook();
                        break;
                    case 4:
                        Order order = creatNewOrder(phone, password);
                        orderManager.addNewOrder(order);
                        break;
                    case 0:
                        System.out.println("[\uD83D\uDD10] Đã thoát khỏi hệ thống MEMBER !!!");
                        System.out.println("_______________________________________________");
                        loginSystem();
                        break;
                    default:
                        System.out.println("[❌] Không có lựa chọn trên");
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("[❌] Bạn nhập sai dữ liệu, mời nhập lại !!!");
            System.out.println("--------------------------------------------------------");
            menuOfMember(phone, password);
        }
    }

    private static void editMember(String phone, String password) {
        String memberId = memberManager.exportMemberId(phone, password);
        Member member = creatNewMember();
        memberManager.editMemberByMemberId(memberId, member);
    }

    private static void showBorrowingBook(String phone, String password) {
        String memberId = memberManager.exportMemberId(phone, password);
        System.out.println("Danh sách các cuốn sách đang mượn:");
        orderManager.showBorrowingBook(memberId);
    }

    private static Order creatNewOrder(String phone, String password) {
        Order order = null;
        try {
            do {
                order = inputInformationOrder(phone, password);
            } while (order == null);
        } catch (Exception e) {
            System.out.println("[❌] Bạn nhập sai dữ liệu, mời nhập lại !!!");
            System.out.println("_______________________________________________");
            creatNewBook();
        } finally {
            return order;
        }
    }

    private static Order inputInformationOrder(String phone, String password) {
        Order order = null;
        System.out.println("Nhập thông tin 1 phiếu mượn sách mới");
        System.out.println("_______________________________________________");
        String orderId;
        do {
            Scanner input1 = new Scanner(System.in);
            System.out.print("Nhập vào mã phiếu mượn: ");
            orderId = input1.nextLine();
        } while (!validate.validateOrderID(orderId));
        String memberId = memberManager.exportMemberId(phone, password);
        String bookId;
        do {
            Scanner input3 = new Scanner(System.in);
            System.out.print("Nhập vào mã đầu sách muốn mượn: ");
            bookId = input3.nextLine();
        } while (!validate.validateBookID(bookId));
        if (BookManager.checkBook(bookId) && MemberManager.checkMember(memberId)) {
            Book checkedBook = null;
            Member checkedMember = null;
            for (Book book : bookList) {
                if (bookId.equals(book.getBookId())) {
                    checkedBook = book;
                }
            }
            for (Member member : memberList) {
                if (memberId.equals(member.getMemberId())) {
                    checkedMember = member;
                }
            }
            Date startTime = inputStartTime();
            Date endTime = inputEndTime();
            order = new Order(orderId, checkedBook, checkedMember, startTime, endTime);
        }
        return order;
    }
}
