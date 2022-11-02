package view;

import model.AdminModel;

import java.util.Scanner;

public class AdminView {
    AdminModel adminModel = new AdminModel();

    public void loginAdmin(Scanner sc){
        while (true){
            System.out.println("1. Thêm Nhân Viên");
            System.out.println("2. Xóa nhân viên");
            System.out.println("3. Thêm tài khoản");
            System.out.println("4. Xóa tài khoản");
            System.out.println("5. Tra thông tin cửa hàng");
            System.out.println("6. Tra cứu thông tin nhân viên");
            System.out.println("0. Log Out");
            int choose = checkInputNumber(sc);
            if (choose == 0){
                break;
            }
            switch (choose){
                case 1:
                    adminModel.themNhanVien(sc);
                    break;
                case 2:
                    adminModel.xoaNhanVien(sc);
                    break;
                case 3:
                    adminModel.addAccount(sc);
                    break;
                case 4:
                    adminModel.deteletAccount(sc);
                    break;
                case 5:
                    traCuuThongTinCuaHang(sc);
                    break;
                case 6:
                    traCuuThongTinNhanVien(sc);
                    break;
            }
        }

    }

    public void traCuuThongTinCuaHang(Scanner sc){
        while (true) {
            System.out.println("1. Danh sách thông tin tất cả sản phẩm");
            System.out.println("2. Danh sách sản phẩm đã trả khách hàng");
            System.out.println("3. Danh sách sản phẩm còn Pending");
            System.out.println("0. Quay Lại");
            int choose = checkInputThongTinCuaHang(sc);
            if (choose == 0) {
                break;
            }
            switch (choose){
                case 1:
                    adminModel.danhSachAllProduct();
                    break;
                case 2:
                    adminModel.danhSachProductOK();
                    break;
                case 3:
                    adminModel.danhSachProductPending();
                    break;
            }
        }
    }


    // display tra cứu thông tin nhân viên
    public void traCuuThongTinNhanVien(Scanner sc){
        while (true) {
            System.out.println("1. Danh sách thông tin tất cả nhân viên");
            System.out.println("2. Tìm kiếm nhân viên theo ID");
            System.out.println("0. Quay Lại");
            int choose = checkInputThongTinNhanVien(sc);
            if (choose == 0) {
                break;
            }
            switch (choose){
                case 1:
                    adminModel.danhSachAllProduct();
                    break;
                case 2:
                    adminModel.searchNhanVien(sc);
                    break;
            }
        }
    }
    public int checkInputNumber(Scanner sc){
        int choose;
        try {
            choose = Integer.parseInt(sc.nextLine());
            if (choose > 6){
                System.out.println("Nhập Không đúng. Vui lòng nhập 0~6");
                return checkInputNumber(sc);
            }
        }catch (Exception ex){
            System.out.println("Nhập Không đúng. Vui lòng nhập 0~6");
            return checkInputNumber(sc);
        }
        return choose;
    }

    public int checkInputThongTinCuaHang(Scanner sc){
        int choose;
        try {
            choose = Integer.parseInt(sc.nextLine());
            if (choose > 3){
                System.out.println("Nhập Không đúng. Vui lòng nhập 0~3");
                return checkInputThongTinCuaHang(sc);
            }
        }catch (Exception ex){
            System.out.println("Nhập Không đúng. Vui lòng nhập 0~3");
            return checkInputThongTinCuaHang(sc);
        }
        return choose;
    }
    public int checkInputThongTinNhanVien(Scanner sc){
        int choose;
        try {
            choose = Integer.parseInt(sc.nextLine());
            if (choose > 2){
                System.out.println("Nhập Không đúng. Vui lòng nhập 0~2");
                return checkInputThongTinNhanVien(sc);
            }
        }catch (Exception ex){
            System.out.println("Nhập Không đúng. Vui lòng nhập 0~2");
            return checkInputThongTinNhanVien(sc);
        }
        return choose;
    }
}
