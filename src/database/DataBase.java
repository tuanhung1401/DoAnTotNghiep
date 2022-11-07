package database;

import constants.Type;
import model.*;

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
    // danh sách vật liệu nhập kho

    // danh sách vật liệu tồn kho(khi lấy sẽ remove ở danh sách này còn lại sẽ là hàng tồn)

    // danh sách hàng xuất kho(khi lấy vật liệu danh sách lấy sẽ được lưu vào đây và remove ở materialExistList)
    //...............danh sách ở đây chưa tạo
    // danh sách hóa đơn
    public static List<Invoice> invoiceList = new ArrayList<>();
    // danh sách lịch sử lỗi
    public static List<History> historyList = new ArrayList<>();
    // danh sách hóa đơn oder vật liệu
    public static List<InvoiceMaterial> inputInvoiceMaterialList = new ArrayList<>();
    // danh sách hóa đơn xuât vật liệu
    public static List<InvoiceMaterial> historyOutMaterialList = new ArrayList<>();
    public static List<InvoiceMaterial> historyInputInvoiceMaterialList = new ArrayList<>();
    public static List<InvoiceMaterial> importMaterialList = new ArrayList<>();


    static {
        Account admin = new Account();
        admin.setUserName("admin");
        admin.setPassword("admin");
        admin.setType(Type.ADMIN);
        accountsList.add(admin);
    }
    public static Employee employee;
}
