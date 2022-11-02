package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AdminModel {
    // list chứa danh sách nhân viên
    public static List<NhanVien> listNhanVien = new ArrayList<>();
    // list chứa danh sách tài khoản
    public static List<Account> listTaiKhoan = new ArrayList<>();
    // method thêm nhân viên
    public void themNhanVien(Scanner sc){
        System.out.println("Nhập mã nhân viên");
        String idNhanVien = sc.nextLine();
        System.out.println("Nhập Họ Và Tên nhân viên");
        String fullName = sc.nextLine();
        System.out.println("Nhập ngày tháng năm sinh");
        LocalDate ngaySinh = checkInputLocalDate(sc);
        System.out.println("Nhập địa chỉ nhân viên");
        String address = sc.nextLine();
        System.out.println("Nhập số điện thoại ");
        String phoneNUmber = sc.nextLine();
        System.out.println("Nhập giới tính");
        System.out.println("1. FEMALE");
        System.out.println("2. MALE");
        Gender gender =  checkGender(sc);
        System.out.println("Nhập Loại nhân viên ");
        System.out.println("1. Nhân viên lễ tân " + "2. Nhân viên WIP " + "3. Nhân viên sửa phần mềm " +
                "4. Nhân viên sửa bản mạch " + "5. Nhân viên sửa font " + "6. Nhân viên kho");
        Type type = checkType(sc);
        boolean ketQua = checkIdNhanVien(idNhanVien);
        if (ketQua == false){
            NhanVien nhanVien = new NhanVien(idNhanVien,fullName,ngaySinh,address,phoneNUmber,type,gender);
            listNhanVien.add(nhanVien);
        } else {
            System.out.println("Mã nhân viên đã tồn tại");
        }

    }



    // method xóa nhân viên
    public void xoaNhanVien(Scanner sc){
        System.out.println("Nhập Mã nhân viên cần xóa!");
        String idNhanVien = sc.nextLine();
        if (listNhanVien.isEmpty()){
            System.out.println("Chưa có nhân viên nào!");
            return;
        }
        Iterator<NhanVien> iterator = listNhanVien.iterator();
        while (iterator.hasNext()){
            NhanVien nv = iterator.next();
            boolean ketQua = checkIdNhanVien(idNhanVien);
            if (ketQua == true){
                iterator.remove();
                System.out.println("Đã xóa thành công");
                return;
            }
            if (ketQua == false){
                System.out.println("Không tìm thấy người đọc nào có Mã: " + idNhanVien);
                return;
            }
        }
    }
    // method thêm tài khoản
    public void addAccount(Scanner sc){
        System.out.println("Nhập ID nhân viên");
        String idNhanVien = sc.nextLine();
        System.out.println("Nhập Password");
        String password = sc.nextLine();
        boolean ketQua = checkIdNhanVien(idNhanVien);
        if (ketQua == true){
            Account account = new Account(idNhanVien,password);
            listTaiKhoan.add(account);
        }
        if (ketQua == false){
            System.out.println("Không có nhân viên nào có Mã " + idNhanVien);
        }
    }
    // method xóa tài khoản
    public void deteletAccount(Scanner sc){
        System.out.println("Nhập ID nhân viên");
        String idNhanVien = sc.nextLine();
        if (listTaiKhoan.isEmpty()){
            System.out.println("Không có tài khoản nào");
            return;
        }
        Iterator<Account> it = listTaiKhoan.iterator();
        while (it.hasNext()){
            boolean ketQua = checkIdNhanVien(idNhanVien);
            if (ketQua == true){
                it.remove();
                System.out.println("Đã xóa tài khoản!");
                break;
            }
            if (ketQua == false){
                System.out.println("Không tìm thấy tài khoản nào");
            }
        }
        boolean ketQua = checkIdNhanVien(idNhanVien);

    }

    // in ra danh sách thông tin tất cả các nhân viên
    public void danhSachThongTinNhanVien(){
        Iterator<NhanVien> it = listNhanVien.iterator();
        while (it.hasNext()){
            NhanVien nv = it.next();
            System.out.println(nv.toString());
        }

    }

    public void searchNhanVien(Scanner sc){
        System.out.println("Nhập ID nhân viên");
        String idNhanVien = sc.nextLine();
        Iterator<NhanVien> it = listNhanVien.iterator();
        while (it.hasNext()){
            NhanVien nv = it.next();
            if (nv.getIdNhanVien().equals(idNhanVien)){
                System.out.println(nv.toString());
            }
            if (!nv.getIdNhanVien().equals(idNhanVien)){
                System.out.println("Không tìm thấy nhân viên có ID: " + idNhanVien);
            }
        }
    }

    // in ra danh sách sản phẩm điện thoại đã vào cửa hàng
    public void danhSachAllProduct(){

    }
    // in ra danh sách sản phẩm điện thoại đã trả khách
    public void danhSachProductOK(){

    }
    // in ra danh sách sản phẩm điện thoại còn pending trong cửa hàng
    public void danhSachProductPending(){

    }

    // kiểm tra ID đã tồn tại chưa
    public boolean checkIdNhanVien(String idNhanVien){
        for (NhanVien nv : listNhanVien){
            if (nv.getIdNhanVien().equals(idNhanVien)){
                return true;
            }
        }
        return false;

    }

    // check dữ liệu người dùng nhập ngày tháng năm sinh đúng không
    public LocalDate checkInputLocalDate(Scanner sc){
        LocalDate ngaySinh;
        try {
            String dayPay = sc.nextLine();
             ngaySinh = LocalDate.parse(dayPay, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (Exception ex){
            System.out.println("Đinh dạng ngày không đúng. Vui lòng nhập đúng định dạng (dd/MM/yyyy)");
            return checkInputLocalDate(sc);
        }
        return ngaySinh;
    }
    // check dữ liệu người nhập tuổi đúng không?
    public int checkInputNumberAge(Scanner sc){
        try {
            int age = Integer.parseInt(sc.nextLine());
            return age;
        }catch (Exception ex){
            System.out.println("Nhập Không đúng. Vui lòng nhập lại");
            return checkInputNumberAge(sc);
        }
    }
    // check dữ liệu nhập lựa chọn đúng không?
    public int checkInputNumberGender(Scanner sc){
        int choose;
        try {
            choose = Integer.parseInt(sc.nextLine());
        }catch (Exception ex){
            System.out.println("Nhập Không đúng. Vui lòng nhập 1 hoặc 2");
            return checkInputNumberGender(sc);
        }
        return choose;
    }

    public int checkInputNumberType(Scanner sc){
        int choose;
        try {
            choose = Integer.parseInt(sc.nextLine());
        }catch (Exception ex){
            System.out.println("Nhập Không đúng. Vui lòng nhập 1~6");
            return checkInputNumberType(sc);
        }
        return choose;
    }


    private Type checkType(Scanner sc) {
        int choose = checkInputNumberType(sc);
        Type type = null;
        if (choose == 0 && choose > 6){
            System.out.println("Chọn sai. Vui lòng chọn 1~6");
            return checkType(sc);
        }
        switch (choose){
            case 1:
                type = Type.NHANVIENLETAN;
                break;
            case 2:
                type = Type.NHANVIENWIP;
                break;
            case 3:
                type = Type.NHANVIENPHANMEM;
                break;
            case 4:
                type = Type.NHANVIENPHANCUNG;
                break;
            case 5:
                type = Type.NHANVIENFONT;
                break;
            case 6:
                type = Type.NHANVIENKHO;
                break;
        }
     return type;
    }

    // check lựa chọn giới tính
    public Gender checkGender(Scanner sc){
        int choose = checkInputNumberGender(sc);
        Gender gender = null;
        if (choose == 0 && choose > 2 ){
            System.out.println("Chọn sai. Vui lòng chọn 1. FEMALE hoặc 2. MALE");
            return checkGender(sc);
        }
        switch (choose){
            case 1:
                gender = Gender.FEMALE;
                break;
            case 2:
                gender = Gender.MALE;
                break;
        }
        return gender;
    }


}
