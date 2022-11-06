package services;

import constants.Type;
import database.DataBase;
import model.Account;
import model.Employee;
import utils.InputValue;

import java.util.Iterator;
import java.util.Scanner;

public class AdminService implements IService{


    public void showFunction(){
        while (true){
            System.out.println("1. Nhân Viên");
            System.out.println("2. Tài khoản");
            System.out.println("0. Quay lại");
            int choose = InputValue.getInt(1, 2);
            if (choose == 0){
                break;
            }
            switch (choose){
                case 1:
                    showEmployee();
                    break;
                case 2:
                    showAccount();
                    break;
            }
        }
    }

    public void showAccount(){
        while (true){
            System.out.println("1. Thêm Tài Khoản");
            System.out.println("2. Xóa Tài Khoản");
            System.out.println("3. Thay đổi mặt khẩu");
            System.out.println("0. quay lại");
            int choose = InputValue.getInt(1, 3);
            if (choose == 0 ){
                break;
            }
            switch (choose){
                case 1:
                    addAccount();
                    break;
                case 2:
                    deteleAccount();
                    break;
                case 3:
                    changePassword();
                    break;
            }
        }
    }

    private void changePassword() {
        System.out.println("Nhập tài khoản cần thay đổi");
        String userName = InputValue.getString();
        boolean ketQuaCheckAcc = InputValue.checkAccount(userName);
        if (ketQuaCheckAcc == true){
            System.out.println("Nhập mật khẩu mới");
            String newPassword = InputValue.getString();
            Iterator<Account> it = DataBase.accountsList.iterator();
            while (it.hasNext()){
                Account account = it.next();
                if (account.equals(userName)){
                    account.setPassword(newPassword);
                    System.out.println("Đã thay đổi thành công");
                }
            }
        }
        if (ketQuaCheckAcc == false){
            System.out.println("Tài khoản không tồn tại");
        }
    }

    private void deteleAccount() {
        System.out.println("Nhập tài khoản cần xóa ");
        String userName = InputValue.getString();
        boolean ketQuaCheckAcc = InputValue.checkAccount(userName);
        if (ketQuaCheckAcc == true) {
            Iterator<Account> it = DataBase.accountsList.iterator();
            while (it.hasNext()) {
                Account account = it.next();
                if (account.equals(userName)) {
                    it.remove();
                    System.out.println("Đã xóa tài khoản thành công");
                }
            }
        }
        if (ketQuaCheckAcc == false) {
            System.out.println("Tài khoản không tồn tại");
        }
    }


    public void addAccount(){
        System.out.println("Nhập ID nhân viên");
        String userName = InputValue.getString();
        System.out.println("Nhập Mật Khẩu");
        String password = InputValue.getString();
        System.out.println("Nhập loại nhân viên");
        Type type = checkType();
        Account account = new Account(userName,password,type);
        DataBase.accountsList.add(account);
    }

    private Type checkType(){
        Type type = null;
        System.out.println("1. Nhân Viên Lễ Tân " +
                "2. Nhân viên WIP " +
                "3. Nhân Viên sửa chữa Font " +
                "4. Nhân viên sửa chữa phần mềm " +
                "5. Nhân viên sửa chữa PBA " +
                "6. Nhân viên Kho " +
                "7. Quản lý ");
        int choose = InputValue.getInt(1, 7);
        switch (choose){
            case 1:
                type = Type.NHANVIENLETAN;
                break;
            case 2:
                type = Type.NHANVIENWIP;
                break;
            case 3:
                type = Type.NHANVIENSUAFONT;
                break;
            case 4:
                type = Type.NHANVIENSUAPHANMEM;
                break;
            case 5:
                type = Type.NHANVIENSUAPCB;
                break;
            case 6:
                type = Type.NHANVIENKHO;
                break;
            case 7:
                type = Type.QUANLY;
                break;
        }
        return type;
    }


    public void showEmployee(){
        while (true){
            System.out.println("1. Thêm Nhân Viên");
            System.out.println("2. Xóa Nhân Viên");
            System.out.println("3. Thay đổi ID Nhân Viên");
            System.out.println("4. Thay đổi tên nhân viên");
            System.out.println("5. Thay đổi công việc nhân viên");
            System.out.println("0. quay lại");
            int choose = InputValue.getInt(1, 5);
            if (choose == 0){
                break;
            }
            switch (choose){
                case 1:
                    addEmployee();
                    break;
                case 2:
                    deteletEmployee();
                    break;
                case 3:
                    changeIDEmployee();
                    break;
                case 4:
                    changeNameEmployee();
                    break;
                case 5:
                    changeWordEmployee();
                    break;
            }
        }
    }

    private void changeWordEmployee() {
        System.out.println("Nhập ID Nhân Viên cần thay đổi");
        String idNhanVien = InputValue.getString();
        boolean ketQuaCheckID = InputValue.checkEmployee(idNhanVien);
        if (ketQuaCheckID == true){
            Type type = checkType();
            Iterator<Employee> it = DataBase.employeeList.iterator();
            while (it.hasNext()){
                Employee employee = it.next();
                if (employee.getIdNhanVien().equals(idNhanVien)){
                    employee.setType(type);
                    System.out.println("Đã thay đổi thành công");
                }
            }
        }
        if (ketQuaCheckID == false){
            System.out.println("Nhân Viên không tồn tại");
        }
    }

    private void changeNameEmployee() {
        System.out.println("Nhập ID Nhân Viên cần thay đổi");
        String idNhanVien = InputValue.getString();
        boolean ketQuaCheckID = InputValue.checkEmployee(idNhanVien);
        if (ketQuaCheckID == true){
            System.out.println("Nhập tên mới");
            String newNameEmployee = InputValue.getString();
            Iterator<Employee> it = DataBase.employeeList.iterator();
            while (it.hasNext()){
                Employee employee = it.next();
                if (employee.getIdNhanVien().equals(idNhanVien)){
                    employee.setFullName(newNameEmployee);
                    System.out.println("Đã thay đổi thành công");
                }
            }
        }
        if (ketQuaCheckID == false){
            System.out.println("Nhân Viên không tồn tại");
        }
    }

    private void changeIDEmployee() {
        System.out.println("Nhập ID Nhân Viên cần thay đổi");
        String idNhanVien = InputValue.getString();
        boolean ketQuaCheckID = InputValue.checkEmployee(idNhanVien);
        if (ketQuaCheckID == true){
            System.out.println("Nhập ID nhân viên mới");
            String newIDNhanVien = InputValue.getString();
            boolean ketQuaCheckIDMoi = InputValue.checkEmployeeNew(newIDNhanVien);
            if (ketQuaCheckIDMoi == false){
                Iterator<Employee> it = DataBase.employeeList.iterator();
                while (it.hasNext()) {
                    Employee employee = it.next();
                    if (employee.getIdNhanVien().equals(idNhanVien)){
                        employee.setIdNhanVien(newIDNhanVien);
                        System.out.println("Đã thay đổi thành công");
                    }
                }
            }
            if (ketQuaCheckIDMoi == true){
                System.out.println("ID " + newIDNhanVien + " Đã tồn tại");
            }
        }
        if (ketQuaCheckID == false){
            System.out.println("Nhân Viên không tồn tại");
        }
    }

    private void deteletEmployee() {
        System.out.println("Nhập ID Nhân Viên cần xóa ");
        String idNhanVien = InputValue.getString();
        boolean ketQuaCheckID = InputValue.checkEmployee(idNhanVien);
        if (ketQuaCheckID == true) {
            Iterator<Employee> it = DataBase.employeeList.iterator();
            while (it.hasNext()) {
                Employee employee = it.next();
                if (employee.getIdNhanVien().equals(idNhanVien)) {
                    it.remove();
                    System.out.println("Đã xóa thành công");
                }
            }
        }
        if (ketQuaCheckID == false) {
            System.out.println("Nhân Viên không tồn tại");
        }
    }

    private void addEmployee() {
        System.out.println("Nhập ID nhân viên");
        String idNhanVien = InputValue.getString();
        System.out.println("Nhập Họ và Tên Nhân viên");
        String fullNameNhanVien = InputValue.getString();
        System.out.println("Nhập loại nhân viên");
        Type type = checkType();
        Employee employee = new Employee(idNhanVien, fullNameNhanVien ,type);
        DataBase.employeeList.add(employee);
    }

}
