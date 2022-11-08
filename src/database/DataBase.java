package database;

import constants.Type;
import model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    // danh sách nhân viên
    public static List<Employee> employeeList = new ArrayList<>();
    // danh sách khách hàng
    public static List<Customer> customerList = new ArrayList<>();
    // danh sách sản phẩm
    public static List<Product> productList = new ArrayList<>();
    // danh sách tài khoản
    public static List<Account> accountsList = new ArrayList<>();
    // danh sách hóa đơn
    public static List<Invoice> invoiceList = new ArrayList<>();
    // danh sách lịch sử lỗi
    public static List<History> historyList = new ArrayList<>();
    // danh sách hóa đơn oder vật liệu của Fuction
    public static List<InvoiceMaterial> inputInvoiceMaterialList = new ArrayList<>();
    // history xuất vật liệu của nhân viên kho cho function
    public static List<InvoiceMaterial> historyOutMaterialList = new ArrayList<>();
    // danh sách history Oder vật liệu của Funcion
    public static List<InvoiceMaterial> historyInputInvoiceMaterialList = new ArrayList<>();
    // List danh sách vật liệu nhập vào kho và lịch sử nhập kho
    public static List<Material> historyImportMaterialList = new ArrayList<>();
    // danh sách hàng tồn trong kho
    public static List<Material> inventoryMaterialList = new ArrayList<>();


    static {
        Account admin = new Account();
        admin.setUserName("admin");
        admin.setPassword("admin");
        admin.setType(Type.ADMIN);
        accountsList.add(admin);

    }
    public static Employee employee;
}
