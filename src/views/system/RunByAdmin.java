package views.system;

import controller.BookManager;
import controller.OrderManager;
import controller.comparator.comparatorBook.BookNameComparator;
import model.book.Book;
import model.book.FictionBook;
import model.book.NovelBook;
import model.book.ProgrammingBook;
import storage.IGenericReadWriteData;
import storage.admin_ReadWriteData.ReadWriteFile;
import views.Login;
import views.Validate;

import java.util.List;
import java.util.Scanner;

public class RunByAdmin {
    private static IGenericReadWriteData readWriteData = ReadWriteFile.getInstance();
    private static Validate validate = Validate.getInstance();

    private static BookManager bookManager = new BookManager();
    private static OrderManager orderManager = new OrderManager();
    private static List<Book> bookList = BookManager.bookList;
//    private static List<Member> memberList = MemberManager.memberList;
//    private static List<Order> orderList = OrderManager.orderList;
//    IGenericReadWriteData readWriteData = ReadWriteFile.getInstance();
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
                System.out.println("║<> [8]. Sửa phiếu mượn                       ║");
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
//                        menuAddMember();
                        break;
                    case 5:
//                        menuEditMember();
                        break;
                    case 6:
//                        menuShowMember();
                        break;
                    case 7:
//                        Order order = creatNewOrder();
//                        orderManager.addNewOrder(order);
                        break;
                    case 8:
//                        menuEditOrder();
                        break;
                    case 9:
//                        menuShowOrder();
                        break;
                    case 10:
//                        menuShowCheckOrder();
                        break;
                    case 0:
                        System.out.println("[\uD83D\uDD10] Đã thoát khỏi hệ thống ADMIN !!!");
                        System.out.println("_______________________________________________");
                        new Login().loginSystem();
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

    private static Book creatNewBook() {
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
            menuEditBook();
        }
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

    private static void menuShowBook() {
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
            menuShowBook();
        }
    }
}
