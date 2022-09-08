package views.system;

import java.util.Scanner;

public class RunByMember {
    public static void menuOfMember() {
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
                //
            } while (true);
        } catch (Exception e) {
            System.out.println("[❌] Bạn nhập sai dữ liệu, mời nhập lại !!!");
            System.out.println("--------------------------------------------------------");
            menuOfMember();
        }
    }
}
