package database;

import constants.Type;
import model.Account;
import model.Customer;
import model.Employee;
import model.Material;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    // danh sách nhân viên
    public static List<Employee> employeeList = new ArrayList<>();
    // danh sách khách hàng
    public static List<Customer> customerList = new ArrayList<>();
    // danh sách tài khoản
    public static List<Account> accountsList = new ArrayList<>();
    // danh sách vật liệu nhập kho
    public static List<Material> materialList = new ArrayList<>();
    // danh sách vật liệu tồn kho(khi lấy sẽ remove ở danh sách này còn lại sẽ là hàng tồn)
    public static List<Material> materiaExistlList = new ArrayList<>();
    // danh sách hàng xuất kho(khi lấy vật liệu danh sách lấy sẽ được lưu vào đây và remove ở materialExistList)
    //...............danh sách ở đây chưa tạo
    static {
        Account admin = new Account();
        admin.setUserName("admin");
        admin.setPassword("admin");
        admin.setType(Type.ADMIN);
        accountsList.add(admin);
    }
}
