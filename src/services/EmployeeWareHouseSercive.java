package services;

import database.DataBase;
import model.Employee;
import model.History;
import model.InvoiceMaterial;
import utils.InputValue;

import java.time.LocalDate;
import java.util.Iterator;

public class EmployeeWareHouseSercive implements IService{
    public void showFunction() {
        while (true){
            System.out.println("1. Nhập Vật Liệu");
            System.out.println("2. Xuất Vật Liệu");
            System.out.println("3. Danh sách hàng Tồn Kho");
            System.out.println("4. Danh nhập vật liệu");
            System.out.println("5. Danh sách xuất Vật Liệu");
            System.out.println("0. Quay lại");
            int choose = InputValue.getInt(1, 5);
            if (choose == 0){
                DataBase.employee = null;
                break;
            }
            switch (choose){
                case 1:
                    showAdd();
                    break;
                case 2:
                    showOutMaterial();
                    break;
                case 3:
                    showExistList();
                    break;
                case 4:
                    showAddList();
                    break;
                case 5:
                    showOutList();
                    break;
            }
        }
    }



    private void showOutList() {
        ///
    }

    private void showExistList() {

    }

    private void showAddList() {

    }

    public void showAdd() {
        System.out.println("Nhập code hóa đơn");
        String codeInvoice = InputValue.checkGetCodeInvoiceMaterial();
        System.out.println("Nhập tên vật liệu");
        String nameMaterial = InputValue.getString();
        System.out.println("Nhập số lượng");
        int amount = InputValue.getInputInt();
        Employee employee = DataBase.employee;
        LocalDate dayImport = LocalDate.now();
        InvoiceMaterial invoiceMaterial = new InvoiceMaterial(codeInvoice,nameMaterial,amount,dayImport,employee);
        DataBase.importMaterialList.add(invoiceMaterial);


    }
    // chưa trừ ở list nhập vật liệu
    private void showOutMaterial() {
        System.out.println("Nhập Mã Hóa đơn Oder xuất Vật liệu");
        String codeInvoice = InputValue.getString();
        Iterator<InvoiceMaterial> it1 = DataBase.inputInvoiceMaterialList.iterator();
        while (it1.hasNext()){
            InvoiceMaterial invoiceMaterial1 = it1.next();
            if (invoiceMaterial1.getCodeMaterial().equals(codeInvoice)){
                DataBase.historyOutMaterialList.add(invoiceMaterial1);
                it1.remove();
            }
        }
        System.out.println("Không tìm thấy hóa đơn Oder vật liệu nào!");
    }
}
