package services;

import constants.Status;
import constants.Type;
import database.DataBase;
import model.Employee;
import model.History;
import model.Product;
import utils.InputValue;

import java.time.LocalDate;

public class EmployeeWIPService implements IService{

    public void showFunction() {
        while (true) {
            System.out.println("1. Transfer Product");
            System.out.println("2. Seach History Product");
            System.out.println("0. Quay lại");
            int choose = InputValue.getInt(1, 2);
            if (choose == 0) {
                DataBase.employee = null;
                break;
            }
            switch (choose) {
                case 1:
                    showTransferProduct();
                    break;
                case 2:
                    searchHistoryProduct();
                    break;
            }
        }
    }

    private void searchHistoryProduct() {

        // chua viet
    }

    private void showTransferProduct() {
        System.out.println("Nhập ID sản phẩm");
        String idProduct = InputValue.getString();
        for (History history : DataBase.historyList){
            if (history.equals(idProduct)){
                Employee employeeFuncion = getEmployeeAfter();
                LocalDate dayInput = LocalDate.now();
                history.setDayInputWIP(dayInput);
                history.setEmployeeFuncion(employeeFuncion);
            }
        }
    }


    private Employee getEmployeeAfter() {
        System.out.println("Nhập ID nhân viên After");
        String idNhanVien = InputValue.getString();
        for (Employee employee : DataBase.employeeList){
            if (employee.getIdNhanVien().equals(idNhanVien) && employee.getType() == Type.NHANVIENSUAFONT){
                return employee;
            }
            if (employee.getIdNhanVien().equals(idNhanVien) && employee.getType() == Type.NHANVIENSUAPCB){
                return employee;
            }
            if (employee.getIdNhanVien().equals(idNhanVien) && employee.getType() == Type.NHANVIENSUAPHANMEM){
                return employee;
            }
        }
        System.out.println("Không tìm thấy nhân viên nào hoặc nhân viên không phải nhân viên WIP");
        return getEmployeeAfter();
    }
}
