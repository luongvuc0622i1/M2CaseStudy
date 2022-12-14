package views.system;

import controller.AdminManager;
import controller.BookManager;
import controller.MemberManager;
import controller.OrderManager;
import model.book.Book;
import model.book.FictionBook;
import model.book.NovelBook;
import model.book.ProgrammingBook;
import model.member.ExternalMember;
import model.member.InternalMember;
import model.member.Member;
import model.order.Order;
import views.Validate;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static controller.BookManager.bookList;
import static controller.MemberManager.memberList;
import static views.Client.loginSystem;

public class RunByAdmin {
    public static final int MAX_BORROW = 5;
    private static Validate validate = Validate.getInstance();

    private static BookManager bookManager = new BookManager();
    private static AdminManager adminManager = new AdminManager();
    private static MemberManager memberManager = new MemberManager();
    private static OrderManager orderManager = new OrderManager();
    public static void menuOfAdmin() {
        try {
            do {
                System.out.println("╔=============================================╗");
                System.out.println("║               CodeGym Library               ║");
                System.out.println("╠=============================================╣");
                System.out.println("║<> [1]. Thêm đầu sách vào thư viện           ║");
                System.out.println("║<> [2]. Sửa đầu sách trong thư viện          ║");
                System.out.println("║<> [3]. In ra danh sách các đầu sách         ║");
                System.out.println("║<> [4]. Thêm người dùng mới                  ║");
                System.out.println("║<> [5]. Sửa thông tin người dùng             ║");
                System.out.println("║<> [6]. In ra danh sách người dùng           ║");
                System.out.println("║<> [7]. Thêm phiếu mượn mới                  ║");
                System.out.println("║<> [8]. Trả sách (xoá phiếu mượn)            ║");
                System.out.println("║<> [9]. In ra danh sách phiếu mượn hiện hành ║");
                System.out.println("║<>[10]. Kiểm tra các phiếu mượn hết hạn      ║");
                System.out.println("║<> [0]. Đăng xuất                            ║");
                System.out.println("╚=============================================╝");
                Scanner scanner = new Scanner(System.in);
                System.out.print("[\uD83D\uDC4B] Mời bạn nhập lựa chọn: ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        Book book = creatNewBook();
                        bookManager.addNewBook(book);
                        break;
                    case 2:
                        menuEditBook();
                        break;
                    case 3:
                        menuShowBook();
                        break;
                    case 4:
                        menuAddMember();
                        break;
                    case 5:
                        menuEditMember();
                        break;
                    case 6:
                        menuShowMember();
                        break;
                    case 7:
                        Order order = creatNewOrder();
                        orderManager.addNewOrder(order);
                        break;
                    case 8:
                        removeOrder();
                        break;
                    case 9:
                        menuShowOrder();
                        break;
                    case 10:
                        showCheckTimeOrder();
                        break;
                    case 0:
                        System.out.println("[\uD83D\uDD10] Đã thoát khỏi hệ thống ADMIN !!!");
                        System.out.println("_______________________________________________");
                        loginSystem();
                        break;
                    default:
                        System.out.println("[❌] Không có lựa chọn trên");
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("[❌] Bạn nhập sai dữ liệu, mời nhập lại !!!");
            System.out.println("_______________________________________________");
            menuOfAdmin();
        }
    }

    public static Book creatNewBook() {
        Book book = null;
        try {
            book = inputInformationBook();
        } catch (Exception e) {
            System.out.println("[❌] Bạn nhập sai dữ liệu, mời nhập lại !!!");
            System.out.println("_______________________________________________");
            creatNewBook();
        } finally {
            return book;
        }
    }

    private static Book inputInformationBook() {
        Book book = null;
        System.out.println("Nhập thông tin 1 cuốn sách mới");
        System.out.println("_______________________________________________");
        String bookId;
        do {
            Scanner input1 = new Scanner(System.in);
            System.out.print("Nhập vào mã đầu sách: ");
            bookId = input1.nextLine();
        } while (!validate.validateBookID(bookId));
        Scanner input2 = new Scanner(System.in);
        System.out.print("Nhập vào tên đầu sách: ");
        String bookName = input2.nextLine();
        Scanner input3 = new Scanner(System.in);
        System.out.print("Nhập vào tên tác giả: ");
        String author = input3.nextLine();
        Scanner input4 = new Scanner(System.in);
        System.out.print("Nhập vào năm xuất bản: ");
        int publishYear = Integer.parseInt(input4.nextLine());
        Scanner input5 = new Scanner(System.in);
        System.out.print("Nhập vào số lượng đầu sách: ");
        int amount = Integer.parseInt(input5.nextLine());
        Scanner input6 = new Scanner(System.in);
        System.out.print("Nhập vào giá sách: ");
        int price = Integer.parseInt(input6.nextLine());
        Scanner input7 = new Scanner(System.in);
        System.out.print("Nhập loại sách ( 1-ProgrammingBook | 2-FictionBook | 3-NovelBook ): ");
        int choice = Integer.parseInt(input7.nextLine());
        if (choice == 1) {
            Scanner scanner1 =  new Scanner(System.in);
            System.out.print("Nhập vào ngôn ngữ sách: ");
            String language = scanner1.nextLine();
            Scanner scanner2 =  new Scanner(System.in);
            System.out.print("Nhập vào framework: ");
            String framework = scanner2.nextLine();
            book = new ProgrammingBook(bookId, bookName, author, publishYear, amount, price, language, framework);
        } else if (choice == 2) {
            Scanner scanner =  new Scanner(System.in);
            System.out.print("Nhập vào thể loại sách: ");
            String category = scanner.nextLine();
            book = new FictionBook(bookId, bookName, author, publishYear, amount, price, category);
        } else if (choice == 3) {
            Scanner scanner =  new Scanner(System.in);
            System.out.print("Nhập vào nơi xuất bản: ");
            String original = scanner.nextLine();
            book = new NovelBook(bookId, bookName, author, publishYear, amount, price, original);
        }
        return book;
    }

    private static void menuEditBook() {
        System.out.println("╔=============================================╗");
        System.out.println("║                Menu Edit Book               ║");
        System.out.println("╠=============================================╣");
        System.out.println("║<> [1]. Sửa đầu sách đã có                   ║");
        System.out.println("║<> [2]. Xoá đầu sách đã có                   ║");
        System.out.println("║<> [0]. Thoát menu sửa sách                  ║");
        System.out.println("╚=============================================╝");
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("[\uD83D\uDC4B] Mời bạn nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    editBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 0:
                    menuOfAdmin();
                    break;
                default:
                    System.out.println("[❌] Không có lựa chọn trên");
            }
        } catch (Exception e) {
            System.out.println("[❌] Bạn nhập sai dữ liệu, mời nhập lại !!!");
            System.out.println("_______________________________________________");
        }
        menuEditBook();
    }

    private static void editBook() {
        String bookId;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập vào mã đầu sách: ");
            bookId = scanner.nextLine();
        } while (!validate.validateBookID(bookId));
        Book book = creatNewBook();
        bookManager.editBookByBookId(bookId, book);
    }

    private static void removeBook() {
        String bookId;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập vào mã đầu sách: ");
            bookId = scanner.nextLine();
        } while (!validate.validateBookID(bookId));
        bookManager.removeBookByBookId(bookId);
    }

    public static void menuShowBook() {
        System.out.println("╔=============================================╗");
        System.out.println("║                Menu Show Book               ║");
        System.out.println("╠=============================================╣");
        System.out.println("║<> [1]. Hiển thị danh sách sắp xếp theo ID   ║");
        System.out.println("║<> [2]. Hiển thị danh sách sắp xếp theo TÊN  ║");
        System.out.println("║<> [3]. Hiển thị danh sách sắp xếp theo GIÁ  ║");
        System.out.println("║<> [0]. Thoát menu hiển thị                  ║");
        System.out.println("╚=============================================╝");
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("[\uD83D\uDC4B] Mời bạn nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    bookManager.sortById();
                    break;
                case 2:
                    bookManager.sortByName();
                    break;
                case 3:
                    bookManager.sortByPrice();
                    break;
                case 0:
                    menuOfAdmin();
                    break;
                default:
                    System.out.println("[❌] Không có lựa chọn trên");
            }
        } catch (Exception e) {
            System.out.println("[❌] Bạn nhập sai dữ liệu, mời nhập lại !!!");
            System.out.println("_______________________________________________");
        }
        menuShowBook();
    }

    private static void menuAddMember() {
        System.out.println("╔=============================================╗");
        System.out.println("║                Menu Add Member              ║");
        System.out.println("╠=============================================╣");
        System.out.println("║<> [1]. Thêm admin                           ║");
        System.out.println("║<> [2]. Thêm thành viên                      ║");
        System.out.println("║<> [0]. Thoát menu add member                ║");
        System.out.println("╚=============================================╝");
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("[\uD83D\uDC4B] Mời bạn nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    Member admin = creatNewAdmin();
                    adminManager.addNewAdmin(admin);
                    break;
                case 2:
                    Member member = creatNewMember();
                    memberManager.addNewMember(member);
                    break;
                case 0:
                    menuOfAdmin();
                    break;
                default:
                    System.out.println("[❌] Không có lựa chọn trên");
            }
        } catch (Exception e) {
            System.out.println("[❌] Bạn nhập sai dữ liệu, mời nhập lại !!!");
            System.out.println("_______________________________________________");
        }
        menuAddMember();
    }

    private static Member creatNewAdmin() {
        Member admin = null;
        try {
            admin = inputInformationAdmin();
        } catch (Exception e) {
            System.out.println("[❌] Bạn nhập sai dữ liệu, mời nhập lại !!!");
            System.out.println("_______________________________________________");
            creatNewAdmin();
        } finally {
            return admin;
        }
    }

    private static Member inputInformationAdmin() {
        Member admin = null;
        System.out.println("Nhập thông tin 1 admin mới");
        System.out.println("_______________________________________________");
        String adminId;
        do {
            Scanner input1 = new Scanner(System.in);
            System.out.print("Nhập vào mã admin: ");
            adminId = input1.nextLine();
        } while (!validate.validateAdminID(adminId));
        Scanner input2 = new Scanner(System.in);
        System.out.print("Nhập vào số căn cước: ");
        String passport = input2.nextLine();
        Scanner input3 = new Scanner(System.in);
        System.out.print("Nhập vào tên admin: ");
        String adminName = input3.nextLine();
        Scanner input4 = new Scanner(System.in);
        System.out.print("Nhập vào giới tính ( 0-Nam | 1-Nữ ): ");
        int sex = Integer.parseInt(input4.nextLine());
        Scanner input5 = new Scanner(System.in);
        System.out.print("Nhập vào địa chỉ admin: ");
        String address = input5.nextLine();
        Scanner input6 = new Scanner(System.in);
        System.out.print("Nhập vào số điện thoại admin: ");
        String phone = input6.nextLine();
        Scanner input7 = new Scanner(System.in);
        System.out.print("Nhập vào mật khẩu: ");
        String password = input7.nextLine();
        admin = new InternalMember(adminId, passport, adminName, sex, address, phone, password, 0);
        return admin;
    }

    public static Member creatNewMember() {
        Member member = null;
        try {
            member = inputInformationMember();
        } catch (Exception e) {
            System.out.println("[❌] Bạn nhập sai dữ liệu, mời nhập lại !!!");
            System.out.println("_______________________________________________");
            creatNewMember();
        } finally {
            return member;
        }
    }

    public Member creatNewMenber() {
        Member member = null;
        try {
            member = inputInformationMember();
        } catch (Exception e) {
            System.out.println("[❌] Bạn nhập sai dữ liệu, mời nhập lại !!!");
            System.out.println("_______________________________________________");
            creatNewMenber();
        } finally {
            return member;
        }
    }

    private static Member inputInformationMember() {
        Member member = null;
        System.out.println("Nhập thông tin 1 thành viên mới");
        System.out.println("_______________________________________________");
        String memberId;
        do {
            Scanner input1 = new Scanner(System.in);
            System.out.print("Nhập vào mã thành viên: ");
            memberId = input1.nextLine();
        } while (!validate.validateMemberID(memberId));
        Scanner input2 = new Scanner(System.in);
        System.out.print("Nhập vào số căn cước: ");
        String passport = input2.nextLine();
        Scanner input3 = new Scanner(System.in);
        System.out.print("Nhập vào tên thành viên: ");
        String memberName = input3.nextLine();
        Scanner input4 = new Scanner(System.in);
        System.out.print("Nhập vào giới tính ( 0-Nam | 1-Nữ ): ");
        int sex = Integer.parseInt(input4.nextLine());
        Scanner input5 = new Scanner(System.in);
        System.out.print("Nhập vào địa chỉ thành viên: ");
        String address = input5.nextLine();
        Scanner input6 = new Scanner(System.in);
        System.out.print("Nhập vào số điện thoại thành viên: ");
        String phone = input6.nextLine();
        Scanner input7 = new Scanner(System.in);
        System.out.print("Nhập vào mật khẩu: ");
        String password = input7.nextLine();
        Scanner input8 = new Scanner(System.in);
        System.out.print("Bạn có phải là học viên CodeGym không ( 0-Người ngoài | 1-Học viên ): ");
        int group = Integer.parseInt(input8.nextLine());
        if (group == 0) {
            member = new ExternalMember(memberId, passport, memberName, sex, address, phone, password, MAX_BORROW);
        } else if (group == 1) {
            member = new InternalMember(memberId, passport, memberName, sex, address, phone, password, group);
        }
        return member;
    }

    private static void menuEditMember() {
        System.out.println("╔=============================================╗");
        System.out.println("║                Menu Edit Member             ║");
        System.out.println("╠=============================================╣");
        System.out.println("║<> [1]. Sửa thành viên đã có                 ║");
        System.out.println("║<> [2]. Xoá thành viên đã có                 ║");
        System.out.println("║<> [0]. Thoát menu sửa sách                  ║");
        System.out.println("╚=============================================╝");
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("[\uD83D\uDC4B] Mời bạn nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    editMember();
                    break;
                case 2:
                    removeMember();
                    break;
                case 0:
                    menuOfAdmin();
                    break;
                default:
                    System.out.println("[❌] Không có lựa chọn trên");
            }
        } catch (Exception e) {
            System.out.println("[❌] Bạn nhập sai dữ liệu, mời nhập lại !!!");
            System.out.println("_______________________________________________");
        }
        menuEditMember();
    }

    private static void editMember() {
        String memberId;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập vào mã thành viên: ");
            memberId = scanner.nextLine();
        } while (!validate.validateMemberID(memberId));
        Member member = creatNewMember();
        memberManager.editMemberByMemberId(memberId, member);
    }

    private static void removeMember() {
        String memberId;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập vào mã thành viên: ");
            memberId = scanner.nextLine();
        } while (!validate.validateMemberID(memberId));
        memberManager.removeMemberByMemberId(memberId);
    }

    private static void menuShowMember() {
        System.out.println("╔=============================================╗");
        System.out.println("║                Menu Show Member             ║");
        System.out.println("╠=============================================╣");
        System.out.println("║<> [1]. Hiển thị danh sách admin             ║");
        System.out.println("║<> [2]. Hiển thị thành viên sắp xếp theo ID  ║");
        System.out.println("║<> [3]. Hiển thị thành viên sắp xếp theo TÊN ║");
        System.out.println("║<> [0]. Thoát menu hiển thị                  ║");
        System.out.println("╚=============================================╝");
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("[\uD83D\uDC4B] Mời bạn nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    adminManager.display();
                    break;
                case 2:
                    memberManager.sortById();
                    break;
                case 3:
                    memberManager.sortByName();
                    break;
                case 0:
                    menuOfAdmin();
                    break;
                default:
                    System.out.println("[❌] Không có lựa chọn trên");
            }
        } catch (Exception e) {
            System.out.println("[❌] Bạn nhập sai dữ liệu, mời nhập lại !!!");
            System.out.println("_______________________________________________");
        }
        menuShowMember();
    }

    private static Order creatNewOrder() {
        Order order = null;
        try {
            do {
                order = inputInformationOrder();
            } while (order == null);
        } catch (Exception e) {
            System.out.println("[❌] Bạn nhập sai dữ liệu, mời nhập lại !!!");
            System.out.println("_______________________________________________");
            creatNewBook();
        } finally {
            return order;
        }
    }

    private static Order inputInformationOrder() {
        Order order = null;
        System.out.println("Nhập thông tin 1 phiếu mượn sách mới");
        System.out.println("_______________________________________________");
        String orderId;
        do {
            Scanner input1 = new Scanner(System.in);
            System.out.print("Nhập vào mã phiếu mượn: ");
            orderId = input1.nextLine();
        } while (!validate.validateOrderID(orderId));
        String memberId;
        do {
            Scanner input2 = new Scanner(System.in);
            System.out.print("Nhập vào mã thành viên cần mượn: ");
            memberId = input2.nextLine();
        } while (!validate.validateMemberID(memberId));
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

    public static Date inputStartTime() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ngày, tháng, năm mượn sách:");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        Date startTime = calendar.getTime();
        return startTime;
    }

    public static Date inputEndTime() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ngày, tháng, năm trả sách:");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        Date endTime = calendar.getTime();
        return endTime;
    }

    public static Date inputCheckTime() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ngày, tháng, năm mốc kiểm tra:");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        Date checkTime = calendar.getTime();
        return checkTime;
    }

    private static void removeOrder() {
        try {
            Order order = null;
            System.out.println("Nhập thông tin 1 phiếu muốn trả");
            System.out.println("_______________________________________________");
            String orderId;
            do {
                Scanner input1 = new Scanner(System.in);
                System.out.print("Nhập vào mã phiếu mượn: ");
                orderId = input1.nextLine();
            } while (!validate.validateOrderID(orderId));
            orderManager.removeOrderByOrderId(orderId);
        } catch (Exception e) {
            System.out.println("[❌] Bạn nhập sai dữ liệu, mời nhập lại !!!");
            System.out.println("_______________________________________________");
            removeOrder();
        }
    }

    private static void menuShowOrder() {
        System.out.println("╔=============================================╗");
        System.out.println("║               Menu Show Order               ║");
        System.out.println("╠=============================================╣");
        System.out.println("║<> [1]. Hiển thị danh sách sắp xếp theo ID   ║");
        System.out.println("║<> [2]. Hiển thị danh sách sắp xếp theo BOOK ║");
        System.out.println("║<> [3]. Hiển thị danh sách sắp xếp theo MEMBE║");
        System.out.println("║<> [0]. Thoát menu hiển thị                  ║");
        System.out.println("╚=============================================╝");
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("[\uD83D\uDC4B] Mời bạn nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    orderManager.sortById();
                    break;
                case 2:
                    orderManager.sortByBook();
                    break;
                case 3:
                    orderManager.sortByMember();
                    break;
                case 0:
                    menuOfAdmin();
                    break;
                default:
                    System.out.println("[❌] Không có lựa chọn trên");
            }
        } catch (Exception e) {
            System.out.println("[❌] Bạn nhập sai dữ liệu, mời nhập lại !!!");
            System.out.println("_______________________________________________");
        }
        menuShowOrder();
    }

    private static void showCheckTimeOrder() {
        try {
            Date checkTime = inputCheckTime();
            System.out.println("Danh sách các phiếu mượn đã hết hạn:");
            List<Order> orderCheckList = orderManager.displayCheckTime(checkTime);
            for (Order order : orderCheckList) {
                System.out.println(order);
            }
        } catch (Exception e) {
            System.out.println("[❌] Bạn nhập sai dữ liệu, mời nhập lại !!!");
            System.out.println("_______________________________________________");
            showCheckTimeOrder();
        }
    }
}
