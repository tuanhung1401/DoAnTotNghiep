package view;

import java.util.Scanner;

public class NhanVienKhoView {

    public void displayLoginKho(Scanner sc){
        // hiển thị mã chủ acc và họ tên chủ accc
        System.out.println("mã Nhân Viên" + "Họ và tên Nhân Viên");
        // chức năng của nhân viên kho
        while (true){
            System.out.println("1. Thông Tin của tôi");
            System.out.println("2. Chức năng ứng dụng");
            System.out.println("0. Log Out");
            int choose = checkInputNumber(sc);
            if (choose == 0){
                break;
            }
            switch (choose){
                case 1:
                    break;
                case 2:
                    break;
            }
        }
    }
    public int checkInputNumber(Scanner sc){
        int choose;
        try {
            choose = Integer.parseInt(sc.nextLine());
            if (choose > 2){
                System.out.println("Nhập Không đúng. Vui lòng nhập 0~2");
                return checkInputNumber(sc);
            }
        }catch (Exception ex){
            System.out.println("Nhập Không đúng. Vui lòng nhập 0~2");
            return checkInputNumber(sc);
        }
        return choose;
    }
}
