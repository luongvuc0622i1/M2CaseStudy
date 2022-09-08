package views.system;

import controller.BookManager;
import controller.MemberManager;
import controller.OrderManager;
import model.book.Book;
import model.member.Member;
import model.order.Order;
import storage.IGenericReadWriteData;
import storage.admin_ReadWriteData.ReadWriteFile;
import views.Login;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class RunByAdmin {
//    private static List<Book> bookList = BookManager.bookList;
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
//                    case 1:
//                        addBook();
//                        break;
//                    case 2:
//                        menuEditBook();
//                        break;
//                    case 3:
//                        try {
//                            System.out.print("Nhập username người dùng: ");
//                            String nameOfUser = scanner.nextLine();
//                            nameOfUser1.delete(0,1);
//                            nameOfUser1.append(nameOfUser);
//                            List<Product> temp = readWriteData.readData(nameOfUser1.toString() + ".data") ;
//                            for (Product x : temp) {
//                                productManager.addProduct(x, nameOfUser1.toString() + ".data");
//                            }
//                            productManager.showProductInCart();
//                            System.out.print("[\uD83D\uDD0E] Nhập mã ID sản phẩm muốn sửa: ");
//                            String id = scanner.nextLine();
//                            if (productManager.checkIdOfCart(id) != -1) {
//                                int idex = productManager.checkIdOfCart(id);
//                                editProductInCartUser(idex);
//                                System.out.println("[\uD83D\uDC4C] Đã cập nhật thông tin sản phẩm");
//                            } else if (productManager.checkIdOfCart(id) == -1) {
//                                System.out.println("[❌] Không có mã ID trên");
//                                System.out.println("---------------------------------------------------");
//                            }
//                        } catch (InputMismatchException e) {
//                            System.out.println("[❌] Sai kiểu dữ liệu");
//                            System.out.println("---------------------------------------------------");
//                        }
//                        break;
//                    case 4:
//                        System.out.print("Nhập username người dùng: ");
//                        String nameOfUser = scanner1.nextLine();
//                        nameOfUser1.delete(0,1);
//                        nameOfUser1.append(nameOfUser);
//                        List<Product> temp = readWriteData.readData(nameOfUser1.toString() + ".data") ;
//                        for (Product x : temp) {
//                            productManager.addProduct(x, nameOfUser1.toString() + ".data");
//                        }
//                        productManager.showProductInCart();
//                        deleteProductInCart();
//                        break;
//                    case 5:
//                        System.out.println("Nhập username của khách hàng");
//                        String name = scanner1.nextLine();
//                        if (name.equals(RunShopByUser.usernameInShop.toString())) {
//                            productManager.showProductInCart();
//                        }
//                        break;
//                    case 6:
//                        managerUser();
//                        break;
                    case 0:
                        System.out.println("[\uD83D\uDD10] Đã thoát khỏi hệ thống ADMIN !!!");
                        System.out.println("_______________________________________________");
                        new Login().loginSystem();
                        break;
                    default:
                        System.out.println("[❌] Không có lựa chọn trên");
                        break;
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("[❌] Bạn nhập sai dữ liệu, mời nhập lại !!!");
            System.out.println("_______________________________________________");
            menuOfAdmin();
        }
    }
}
