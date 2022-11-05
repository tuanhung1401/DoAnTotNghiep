package utils;

import database.DataBase;
import model.Account;
import model.Employee;

import java.util.Scanner;

public class InputValue {
    private static Scanner sc = new Scanner(System.in);

    // check input bằng String
    public static String getString() {
        return sc.nextLine();
    }
    // check input bằng int
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

    public static boolean checkAccount(String userName){
        for (Account acc : DataBase.accountsList){
            if (acc.getUserName().equals(userName)){
                return true;
            }
        }
        return false;
    }

    public static boolean checkEmployee(String idNhanVien) {
        for (Employee employee : DataBase.employeeList){
            if (employee.getIdNhanVien().equals(idNhanVien)){
                return true;
            }
        }
        return false;
    }

    public static boolean checkEmployeeNew(String newIDNhanVien) {
        for (Employee employee : DataBase.employeeList){
            if (employee.getIdNhanVien().equals(newIDNhanVien)){
                return true;
            }
        }
        return false;
    }
}
