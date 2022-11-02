package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NhanVienLeTanModel {
    public static List<Customer> listKhachHang = new ArrayList<>();
    public static List<Product> listProduct = new ArrayList<>();


    public void nhapThongTin(Scanner sc){
        System.out.println("Nhập ID khách hàng");
        String idCustomer = sc.nextLine();
        System.out.println("Nhập họ và tên khách hàng");
        String nameCustomer = sc.nextLine();
        // làm điều kiện để nhập số điệ thoại đúng()
        System.out.println("Nhập số điện thoại khách hàng");
        String phoneNumber = sc.nextLine();
        System.out.println("Nhập ID sản phẩm");
        String idProduct = sc.nextLine();
        System.out.println("Nhập tên Model");
        String nameProduct = sc.nextLine();
        System.out.println("Nhập tên lỗi");
        String nameErrol = sc.nextLine();
        System.out.println("Nhập số lượng");
        int quanlity = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập ngày nhận");
        LocalDate ngayNhan = checkInputLocalDate(sc);
        System.out.println("Trạng thái sản phẩm");
        System.out.println("1. OK hoặc 2. NG");
        StatusCustomer statusCustomer = checkStatusCustomer(sc);
        Customer customer = new Customer(idCustomer, nameCustomer, phoneNumber,quanlity,statusCustomer);
        Product product = new Product();
        product.setIdSanPham(idProduct);
        product.setTenModel(nameProduct);
        product.setTenLoi(nameErrol);
        product.setQuanlity(quanlity);
        listKhachHang.add(customer);
        listProduct.add(product);
    }

    public LocalDate checkInputLocalDate(Scanner sc){
        try {
            String ngayNhan = sc.nextLine();
            LocalDate nn = LocalDate.parse(ngayNhan, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return nn;
        } catch (Exception ex){
            System.out.println("Đinh dạng ngày không đúng. Vui lòng nhập đúng định dạng (dd/MM/yyyy)");
            return checkInputLocalDate(sc);
        }
    }

    public int checkInputNumberStatusCustomer(Scanner sc){
        int choose;
        try {
            choose = Integer.parseInt(sc.nextLine());
        }catch (Exception ex){
            System.out.println("Nhập Không đúng. Vui lòng nhập 1 hoặc 2");
            return checkInputNumberStatusCustomer(sc);
        }
        return choose;
    }

    public StatusCustomer checkStatusCustomer(Scanner sc){
        int choose = checkInputNumberStatusCustomer(sc);
        StatusCustomer status = null;
        if (choose == 0 && choose > 2 ){
            System.out.println("Chọn sai. Vui lòng chọn 1. OK hoặc 2. NG");
            return checkStatusCustomer(sc);
        }
        switch (choose){
            case 1:
                status = StatusCustomer.OK;
                break;
            case 2:
                status = StatusCustomer.NG;
                break;
        }
        return status;
    }
}
