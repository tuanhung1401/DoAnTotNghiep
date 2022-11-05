package database;

import constants.Type;
import model.Account;
import model.Customer;
import model.Employee;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

    public static List<Employee> employeeList = new ArrayList<>();
    public static List<Customer> customerList = new ArrayList<>();
    public static List<Account> accountsList = new ArrayList<>();

    static {
        Account admin = new Account();
        admin.setUserName("admin");
        admin.setPassword("admin");
        admin.setType(Type.ADMIN);
        accountsList.add(admin);
    }
}
