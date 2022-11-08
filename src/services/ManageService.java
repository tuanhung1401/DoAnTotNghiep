package services;

import constants.Type;
import database.DataBase;
import model.Account;
import model.Employee;
import utils.InputValue;

import java.util.Iterator;

public class ManageService implements IService{

    public void showFunction() {
        while (true){
            System.out.println("1. Thay đổi công việc nhân viên");
            System.out.println("2. Thêm tài khoản");
            System.out.println("3. Đổi mật khẩu tài khoản");
            System.out.println("0. Quay lại");
            int choose = InputValue.getInt(1, 3);
            if (choose == 0){
                DataBase.employee = null;
                break;
            }
            switch (choose){
                case 1:
                    changeWordEmployee();
                    break;
                case 2:
                    showAdd();
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
    public void showAdd(){
        String userName = InputValue.getIDEmployee();
        System.out.println("Nhập Mật Khẩu");
        String password = InputValue.getString();
        System.out.println("Nhập loại nhân viên");
        Type type = checkType();
        Account account = new Account(userName,password,type);
        DataBase.accountsList.add(account);
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

    private Type checkType(){
        Type type = null;
        System.out.println("1. Nhân Viên Lễ Tân " +
                "2. Nhân viên WIP " +
                "3. Nhân Viên sửa chữa Font " +
                "4. Nhân viên sửa chữa phần mềm " +
                "5. Nhân viên sửa chữa PBA " +
                "6. Nhân viên Kho ");
        int choose = InputValue.getInt(1, 6);
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
        }
        return type;
    }
}
