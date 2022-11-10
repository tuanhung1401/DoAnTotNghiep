package utils;

import constants.Type;
import database.DataBase;
import model.Account;
import model.Employee;
import model.Invoice;
import model.InvoiceMaterial;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Scanner;

public class InputValue {
    private static Scanner sc = new Scanner(System.in);

    // check input bằng String
    public static String getString() {
        return sc.nextLine();
    }
    // check input bằng int với lựa chọn
    public static int getInt(int min,int max) {
        int value;
        try {
            value = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException ex) {
            System.out.println(String.format("vui lòng nhập số trong khoảng %o đến %o", min, max));
            return getInt(min, max);
        }
        return value;
    }
    // check tài khoản acc username
    public static boolean checkAccount(String userName){
        for (Account acc : DataBase.accountsList){
            if (acc.getUserName().equals(userName)){
                return true;
            }
        }
        return false;
    }
    // check danh sách nhân viên có tồn tại không
    public static boolean checkEmployee(String idNhanVien) {
        for (Employee employee : DataBase.employeeList){
            if (employee.getIdNhanVien().equals(idNhanVien)){
                return true;
            }
        }
        return false;
    }
    // check id nhân viên mới xem đã tồn tại chưa
    public static boolean checkEmployeeNew(String newIDNhanVien) {
        for (Employee employee : DataBase.employeeList){
            if (employee.getIdNhanVien().equals(newIDNhanVien)){
                return true;
            }
        }
        return false;
    }
    // check input là int
    public static int getInputInt() {
        int number;
        try {
            number = Integer.parseInt(sc.nextLine());
        } catch (Exception ex) {
            System.out.println("Nhập không đúng. Vui Lòng nhập lại");
            return getInputInt();
        }
        return number;
    }
    // check lỗi input đầu vài localdate
    public static LocalDate getInputLocalDate() {
        try {
            String ngayNhan = getString();
            LocalDate date = LocalDate.parse(ngayNhan, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return date;
        } catch (Exception ex) {
            System.out.println("Đinh dạng ngày không đúng. Vui lòng nhập đúng định dạng (dd/MM/yyyy)");
            return getInputLocalDate();
        }
    }
    // lấy tên nhân viên ra theo ID nhân viên
    public static String getEmployee(String idNhanVien) {
        Iterator<Employee> it = DataBase.employeeList.iterator();
        while (it.hasNext()){
            Employee employee = it.next();
            if (employee.getIdNhanVien().equals(idNhanVien) && employee.getType() == Type.NHANVIENKHO){
                String nameNhanVien = employee.getFullName();
                return nameNhanVien;
            }
        }
        return null;
    }

    public static double getInputDouble() {
        double price;
        try {
            price = Double.parseDouble(sc.nextLine());
        } catch (Exception ex) {
            System.out.println("Nhập không đúng. Vui Lòng nhập lại");
            return getInputDouble();
        }
        return price;
    }

    public static Employee getOneEmployee(String account) {
        for (Employee employee : DataBase.employeeList){
            if (employee.getIdNhanVien().equals(account)){
                return employee;
            }
        }
        return null;
    }

    public static String getIDEmployee() {
        System.out.println("Nhập ID Nhân viên");
        String idNhanVien = getString();
        for (Employee employee : DataBase.employeeList){
            if (employee.getIdNhanVien().equals(idNhanVien)){
                String codeEmployee = employee.getIdNhanVien();
                return codeEmployee;
            }
        }
        return getIDEmployee();
    }

    public static String checkGetEmployee() {
        System.out.println("Nhập ID nhân viên");
        String idNhanVien = getString();
        for (Employee employee : DataBase.employeeList){
            if (employee.getIdNhanVien().equals(idNhanVien)){
                System.out.println("ID nhân viên đã tồn tại");
                return checkGetEmployee();
            }
        }
        return idNhanVien;
    }

    public static String checkGetCodeInvoiceMaterial() {
        String codeInvoice = getString();
        for (InvoiceMaterial material : DataBase.historyInputInvoiceMaterialList){
            if (material.getCodeMaterial().equals(codeInvoice)){
                System.out.println("Code đã tồn tại");
                return checkGetCodeInvoiceMaterial();
            }
        }
        return codeInvoice;
    }
}
