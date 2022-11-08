package services;

import constants.Status;
import constants.Type;
import database.DataBase;
import model.*;
import utils.InputValue;

import java.time.LocalDate;
import java.util.Iterator;

public class ReceptionistService {


    public void showFunction() {
        while (true){
            System.out.println("1. Khách Hàng");
            System.out.println("2. Sản Phẩm");
            System.out.println("3. Hóa Đơn");;
            System.out.println("4. Transfer Product");
            System.out.println("0. quay lại");
            int choose = InputValue.getInt(1, 4);
            if (choose == 0 ){
                DataBase.employee = null;
                break;
            }
            switch (choose){
                case 1:
                    showChooseCustomer();
                    break;
                case 2:
                    showChooseProduct();
                    break;
                case 3:
                    showChooseInvoice();
                    break;
                case 4:
                    showTransferProduct();
            }
        }
    }

    private void showChooseCustomer(){
        while (true){
            System.out.println("1. Nhập thông tin khách hàng");
            System.out.println("2. Sửa Thông tin khách hàng");
            System.out.println("3. Xóa thông tin khách");
            System.out.println("0. quay lại");
            int choose = InputValue.getInt(1, 3);
            if (choose == 0 ){
                break;
            }
            switch (choose){
                case 1:
                    showAddCustomer();
                    break;
                case 2:
                    showChangeCustomer();
                    break;
                case 3:
                    deteletCustomer();
                    break;
            }
        }
    }
    private void showChooseProduct(){
        while (true){
            System.out.println("1. Nhập thông tin sản phẩm");
            System.out.println("2. Sửa thông tin sản phẩm");
            System.out.println("3. Xóa thông tin sản phẩm");
            System.out.println("0. quay lại");
            int choose = InputValue.getInt(1, 3);
            if (choose == 0 ){
                break;
            }
            switch (choose){
                case 1:
                    showAddProduct();
                    break;
                case 2:
                    showChangeProduct();
                    break;
                case 3:
                    deteletProduct();
                    break;
            }
        }
    }
    private void showChooseInvoice(){
        while (true){
            System.out.println("1. Tạo hóa đơn");
            System.out.println("2. In Hóa Đơn");;
            System.out.println("3. Xóa hóa đơn");
            System.out.println("0. quay lại");
            int choose = InputValue.getInt(1, 3);
            if (choose == 0 ){
                break;
            }
            switch (choose){
                case 1:
                    showInvoice();
                    break;
                case 2:
                    showInInvoice();
                    break;
                case 3:
                    deteletInvoice();
                    break;
            }
        }
    }

    private void showInInvoice() {
        System.out.println("Nhập Code hóa đơn cần In");
        String codeInvoice = getCodeInvoicePrint();
        for (Invoice invoice : DataBase.invoiceList){
            if (invoice.getCodeInvoive().equals(codeInvoice)){
                System.out.println(invoice.toString());
            }
        }
    }

    private String getCodeInvoicePrint() {
        String codeInvoice = InputValue.getString();
        for (Invoice invoice : DataBase.invoiceList){
            if (invoice.getCodeInvoive().equals(codeInvoice)){
                return codeInvoice;
            }
        }
        System.out.println("Không tìm thấy hóa đơn.Vui lòng nhập lại");
        return getCodeInvoicePrint();
    }

    private void showTransferProduct() {
        Product product = searchProduct();
        Status status = Status.PENDING;
        Employee employeeRece = DataBase.employee;
        Employee employeeWIP = getEmployeeAfter();
        LocalDate dayInputRece = LocalDate.now();
        History history = new History(product,status,employeeRece,dayInputRece,employeeWIP);
        DataBase.historyList.add(history);
    }


    private Employee getEmployeeAfter() {
        System.out.println("Nhập ID nhân viên After");
        String idNhanVien = InputValue.getString();
        for (Employee employee : DataBase.employeeList){
            if (employee.getIdNhanVien().equals(idNhanVien) && employee.getType() == Type.NHANVIENWIP){
                return employee;
            }
        }
        System.out.println("Không tìm thấy nhân viên nào hoặc nhân viên không phải nhân viên WIP");
        return getEmployeeAfter();
    }


    private Product searchProduct() {
        System.out.println("Nhập ID sản phẩm");
        String idProduct = InputValue.getString();
        for (Product product : DataBase.productList){
            if (product.getIdProduct().equals(idProduct)){
                return product;
            }
            System.out.println("Không tìm thấy sản phẩm nào.Vui lòng nhập lại");
        }
        return searchProduct();
    }


    private void showChangeProduct() {
        while (true){
            System.out.println("1. Thay đổi ID sản phẩm");
            System.out.println("2. Thay đổi tên Model");
            System.out.println("3. Thay đổi tên lỗi");
            System.out.println("0. quay lại");
            int choose = InputValue.getInt(1, 3);
            if (choose == 0 ){
                break;
            }
            switch (choose){
                case 1:
                    changeIDProduct();
                    break;
                case 2:
                    changeNameModel();
                    break;
                case 3:
                    changeNameErrol();
                    break;
            }
        }
    }

    private void changeNameErrol() {
        System.out.println("Nhập Mã Sản Phẩm cần xóa");
        String idProduct = InputValue.getString();
        Iterator<Product> it = DataBase.productList.iterator();
        while (it.hasNext()){
            Product product = it.next();
            if (product.getIdProduct().equals(idProduct)){
                System.out.println("Nhập tên lỗi mới");
                String nameErrolNew = InputValue.getString();
                product.setNameErrol(nameErrolNew);
                System.out.println("Đã thay đổi thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm nào!");
    }

    private void changeNameModel() {
        System.out.println("Nhập Mã Sản Phẩm cần xóa");
        String idProduct = InputValue.getString();
        Iterator<Product> it = DataBase.productList.iterator();
        while (it.hasNext()){
            Product product = it.next();
            if (product.getIdProduct().equals(idProduct)){
                System.out.println("Nhập tên Model mới");
                String nameModelNew = InputValue.getString();
                product.setNameProduct(nameModelNew);
                System.out.println("Đã thay đổi thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm nào!");
    }

    private void changeIDProduct() {
        System.out.println("Nhập Mã Sản Phẩm cần xóa");
        String idProduct = InputValue.getString();
        Iterator<Product> it = DataBase.productList.iterator();
        while (it.hasNext()){
            Product product = it.next();
            if (product.getIdProduct().equals(idProduct)){
                System.out.println("Nhập ID sản phẩm mới");
                String idProductNew = InputValue.getString();
                product.setIdProduct(idProductNew);
                System.out.println("Đã thay đổi thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm nào!");
    }

    private void showChangeCustomer() {
        while (true){
            System.out.println("1. Thay đổi ID khách hàng");
            System.out.println("2. Thay đổi tên khách hàng");
            System.out.println("3. Thay đổi địa chỉ khách hàng");
            System.out.println("4. Thay đổi số điện thoại");
            System.out.println("0. quay lại");
            int choose = InputValue.getInt(1, 4);
            if (choose == 0 ){
                break;
            }
            switch (choose){
                case 1:
                    changeIDCustomer();
                    break;
                case 2:
                    changeNameCustomer();
                    break;
                case 3:
                    changeAddressCustomer();
                    break;
                case 4:
                    changePhoneNumberCustomer();
                    break;
            }
        }
    }

    private void changePhoneNumberCustomer() {
        System.out.println("Nhập Mã Khách hàng cần thay đổi");
        String idCustomer = InputValue.getString();
        Iterator<Customer> it = DataBase.customerList.iterator();
        while (it.hasNext()){
            Customer customer = it.next();
            if (customer.getIdCustomer().equals(idCustomer)){
                System.out.println("Nhập số điện thoại khách hàng mới");
                String phoneNumberCustomerNew = InputValue.getString();
                customer.setPhoneNumber(phoneNumberCustomerNew);
                System.out.println("Đã thay đổi thành công");
                return;
            }
        }
        System.out.println("Không Tìm thấy khách hàng nào!");
    }

    private void changeAddressCustomer() {
        System.out.println("Nhập Mã Khách hàng cần thay đổi");
        String idCustomer = InputValue.getString();
        Iterator<Customer> it = DataBase.customerList.iterator();
        while (it.hasNext()){
            Customer customer = it.next();
            if (customer.getIdCustomer().equals(idCustomer)){
                System.out.println("Nhập địa chỉ khách hàng mới");
                String addressCustomerNew = InputValue.getString();
                customer.setAddress(addressCustomerNew);
                System.out.println("Đã thay đổi thành công");
                return;
            }
        }
        System.out.println("Không Tìm thấy khách hàng nào!");
    }

    private void changeNameCustomer() {
        System.out.println("Nhập Mã Khách hàng cần thay đổi");
        String idCustomer = InputValue.getString();
        Iterator<Customer> it = DataBase.customerList.iterator();
        while (it.hasNext()){
            Customer customer = it.next();
            if (customer.getIdCustomer().equals(idCustomer)){
                System.out.println("Nhập tên khách hàng mới");
                String nameCustomerNew = InputValue.getString();
                customer.setNameCustomer(nameCustomerNew);
                System.out.println("Đã thay đổi thành công");
                return;
            }
        }
        System.out.println("Không Tìm thấy khách hàng nào!");
    }

    private void changeIDCustomer() {
        System.out.println("Nhập Mã Khách hàng cần thay đổi");
        String idCustomer = InputValue.getString();
        Iterator<Customer> it = DataBase.customerList.iterator();
        while (it.hasNext()){
            Customer customer = it.next();
            if (customer.getIdCustomer().equals(idCustomer)){
                System.out.println("Nhập ID khách hàng mới");
                String idCustomerNew = InputValue.getString();
                customer.setIdCustomer(idCustomerNew);
                System.out.println("Đã thay đổi thành công");
                return;
            }
        }
        System.out.println("Không Tìm thấy khách hàng nào!");
    }

    private void showAddProduct() {
        System.out.println("Nhập ID sản phẩm");
        String idProduct = InputValue.getString();
        System.out.println("Nhập Tên Model");
        String nameModel = InputValue.getString();
        System.out.println("Nhập Tên lỗi");
        String nameErrol = InputValue.getString();
        Product product = new Product(idProduct,nameModel,nameErrol);
        DataBase.productList.add(product);
        LocalDate dateNow = LocalDate.now();
    }

    private void showInvoice() {
        String codeInvoice = getCodeInvoice();
        Customer customer = getByCustomer();
        Product product = getByProduct();
        System.out.println("Nhập số lượng");
        int amount = InputValue.getInputInt();
        System.out.println("Nhập số tiền sửa");
        double price = InputValue.getInputDouble();
        LocalDate startDay = LocalDate.now();
        System.out.println("Nhập ngày trả");
        LocalDate endDay = InputValue.getInputLocalDate();
        Employee employee = getByEmployee();
        Invoice invoice = new Invoice(codeInvoice, customer,product,amount,price,startDay,endDay,employee);
        DataBase.invoiceList.add(invoice);
    }

    private Employee getByEmployee() {
        System.out.println("Nhập ID Nhân viên làm hóa đơn");
        String idNhanVien = InputValue.getString();
        for (Employee employee : DataBase.employeeList){
            if (employee.getIdNhanVien().equals(idNhanVien) && employee.getType() == Type.NHANVIENLETAN){
                return employee;
            }
        }
        return getByEmployee();
    }

    private String getCodeInvoice() {
        System.out.println("Nhập Mã Hóa Đơn");
        String codeInvoice = InputValue.getString();
        for (Invoice invoice : DataBase.invoiceList){
            if (invoice.getCodeInvoive().equals(codeInvoice)){
                System.out.println("Mã hóa đơn đã tồn tại. Vui lòng nhập lại");
                return getCodeInvoice();
            }
        }
        return codeInvoice;
    }

    private Product getByProduct() {
        System.out.println("Nhập mã Sản phẩm");
        String idProduct = InputValue.getString();
        for (Product product : DataBase.productList){
            if (product.getIdProduct().equals(idProduct)){
                return product;
            }
        }
        System.out.println("Không tìm thấy mã sản phẩm!. Vui lòng nhập lại");
        return getByProduct();
    }

    private Customer getByCustomer() {
        System.out.println("Nhập Mã khách hàng");
        String idCustomer = InputValue.getString();
        for (Customer customer : DataBase.customerList){
            if (customer.getIdCustomer().equals(idCustomer)){
                return customer;
            }
        }
        System.out.println("Không tìm thấy mã khách hàng!. Vui lòng nhập lại");
        return getByCustomer();
    }

    private void showAddCustomer() {
        System.out.println("Nhập ID Khách hàng");
        String idCustomer = InputValue.getString();
        System.out.println("Nhập Tên Khách hàng");
        String nameCustomer = InputValue.getString();
        System.out.println("Nhập địa chỉ khách hàng");
        String address = InputValue.getString();
        System.out.println("Nhập số điện thoại khách hàng");
        String phoneNumber = InputValue.getString();
        Customer customer = new Customer(idCustomer,nameCustomer,address,phoneNumber);
        DataBase.customerList.add(customer);
    }




    private void deteletProduct() {
        System.out.println("Nhập Mã Sản Phẩm cần xóa");
        String idProduct = InputValue.getString();
        Iterator<Product> it = DataBase.productList.iterator();
        while (it.hasNext()){
            Product product = it.next();
            if (product.getIdProduct().equals(idProduct)){
                it.remove();
                System.out.println("Đã xóa thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm nào!");
    }

    private void deteletCustomer() {
        System.out.println("Nhập Mã Khách hàng cần Xóa");
        String idCustomer = InputValue.getString();
        Iterator<Customer> it = DataBase.customerList.iterator();
        while (it.hasNext()){
            Customer customer = it.next();
            if (customer.getIdCustomer().equals(idCustomer)){
                it.remove();
                System.out.println("Đã xóa thành công");
                return;
            }
        }
        System.out.println("Không Tìm thấy khách hàng nào!");
    }

    private void deteletInvoice() {
        System.out.println("Nhập Mã Hóa Đơn");
        String codeInvoice = InputValue.getString();
        Iterator<Invoice> it = DataBase.invoiceList.iterator();
        while (it.hasNext()){
            Invoice invoice = it.next();
            if (invoice.getCodeInvoive().equals(codeInvoice)){
                it.remove();
                System.out.println("Đã xóa thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy hóa đơn nào!");
    }
}
