package services;

import constants.Status;
import constants.Type;
import database.DataBase;
import model.Employee;
import model.History;
import model.InvoiceMaterial;
import utils.InputValue;

import java.time.LocalDate;
import java.util.Iterator;

public class EmployeeSoftwareService implements IService{

    public void showFunction() {
        while (true) {
            System.out.println("1. Output Product");
            System.out.println("2. Seach History Product");
            System.out.println("3. Oder Material");
            System.out.println("0. Quay lại");
            int choose = InputValue.getInt(1, 3);
            if (choose == 0) {
                DataBase.employee = null;
                break;
            }
            switch (choose) {
                case 1:
                    showOutputProduct();
                    break;
                case 2:
                    searchHistoryProduct();
                    break;
                case 3:
                    showOderMaterial();
                    break;
            }
        }
    }

    private void showOderMaterial() {
        while (true) {
            System.out.println("1. Tạo hóa đơn Oder Material");
            System.out.println("2. Sửa thông tin Hóa đơn Material");
            System.out.println("3. Xóa hóa đơn Oder Material");
            System.out.println("4. In Hóa đơn Material");
            System.out.println("5. Search history Hóa Đơn Oder Material");
            System.out.println("0. Quay lại");
            int choose = InputValue.getInt(1, 5);
            if (choose == 0) {
                break;
            }
            switch (choose) {
                case 1:
                    createInvoiceMaterial();
                    break;
                case 2:
                    showChangeInvoiceMaterial();
                    break;
                case 3:
                    deteletInvoiceMaterial();
                    break;
                case 4:
                    printIvoiceMaterial();
                    break;
                case 5:
                    searchAllHistoryListInvoice();
                    break;
            }
        }
    }

    private void showChangeInvoiceMaterial() {
        while (true) {
            System.out.println("1. Change tên vật liệu");
            System.out.println("2. Change số lượng");
            System.out.println("0. Quay lại");
            int choose = InputValue.getInt(1, 2);
            if (choose == 0) {
                break;
            }
            switch (choose) {
                case 1:
                    changeNameMaterial();
                    break;
                case 2:
                    changeAmountMaterial();
                    break;
            }
        }
    }

    private void changeAmountMaterial() {
        System.out.println("Nhập code hóa đơn");
        String codeInvoice = InputValue.getString();
        int amount = -1;
        Iterator<InvoiceMaterial> it1 = DataBase.inputInvoiceMaterialList.iterator();
        while (it1.hasNext()){
            InvoiceMaterial material1 = it1.next();
            if (material1.getCodeMaterial().equals(codeInvoice)){
                System.out.println("Nhập tên vật liệu mới");
                int amountMaterialNew = InputValue.getInputInt();
                material1.setAmount(amountMaterialNew);
                amount = amountMaterialNew;
                System.out.println("Đã thay đổi thaành công thành công");
            }
        }
        Iterator<InvoiceMaterial> it2 = DataBase.historyInputInvoiceMaterialList.iterator();
        while (it2.hasNext()){
            InvoiceMaterial material2 = it2.next();
            if (material2.getCodeMaterial().equals(codeInvoice)){
                material2.setAmount(amount);
                return;
            }
        }
        System.out.println("Không tìm thấy hóa đơn nào");
    }

    private void changeNameMaterial() {
        System.out.println("Nhập code hóa đơn");
        String codeInvoice = InputValue.getString();
        String name = null;
        Iterator<InvoiceMaterial> it1 = DataBase.inputInvoiceMaterialList.iterator();
        while (it1.hasNext()){
            InvoiceMaterial material1 = it1.next();
            if (material1.getCodeMaterial().equals(codeInvoice)){
                System.out.println("Nhập tên vật liệu mới");
                 String nameMaterialNew = InputValue.getString();
                material1.setNameMaterial(nameMaterialNew);
                name = nameMaterialNew;
                System.out.println("Đã thay đổi thaành công thành công");
            }
        }
        Iterator<InvoiceMaterial> it2 = DataBase.historyInputInvoiceMaterialList.iterator();
        while (it2.hasNext()){
            InvoiceMaterial material2 = it2.next();
            if (material2.getCodeMaterial().equals(codeInvoice)){
                material2.setNameMaterial(name);
                return;
            }
        }
        System.out.println("Không tìm thấy hóa đơn nào");
    }

    // method có Tosing cần viết lại hàm Tosing
    private void searchAllHistoryListInvoice() {
        Iterator<InvoiceMaterial> it = DataBase.historyInputInvoiceMaterialList.iterator();
        while (it.hasNext()){
            InvoiceMaterial material = it.next();
            System.out.println(material.toString());
        }

    }

    // method có Tosing cần viết lại hàm Tosing
    private void printIvoiceMaterial() {
        System.out.println("Nhập Code hóa đơn");
        String codeInvoice = InputValue.getString();
        Iterator<InvoiceMaterial> it = DataBase.inputInvoiceMaterialList.iterator();
        while (it.hasNext()){
            InvoiceMaterial material = it.next();
            if (material.getCodeMaterial().equals(codeInvoice)){
                System.out.println(material.toString());
            }
        }
    }

    private void deteletInvoiceMaterial() {
        System.out.println("Nhập code hóa đơn");
        String codeInvoice = InputValue.getString();
        Iterator<InvoiceMaterial> it1 = DataBase.inputInvoiceMaterialList.iterator();
        while (it1.hasNext()){
            InvoiceMaterial material1 = it1.next();
            if (material1.getCodeMaterial().equals(codeInvoice)){
                it1.remove();
                System.out.println("Đã xóa thành công");
            }
        }
        Iterator<InvoiceMaterial> it2 = DataBase.historyInputInvoiceMaterialList.iterator();
        while (it2.hasNext()){
            InvoiceMaterial material2 = it2.next();
            if (material2.getCodeMaterial().equals(codeInvoice)){
                it2.remove();
                return;
            }
        }
        System.out.println("Không tìm thấy hóa đơn nào");
    }

    private void createInvoiceMaterial() {
        System.out.println("Nhập code hóa đơn");
        String codeInvoice = InputValue.checkGetCodeInvoiceMaterial();
        System.out.println("Nhập ID Vật liệu");
        String idMaterial = InputValue.getIDMaterial();
        System.out.println("Nhập tên vật liệu");
        String nameMaterial = InputValue.getString();
        System.out.println("Nhập số lượng");
        int amount = InputValue.getInputInt();
        LocalDate dayOder = LocalDate.now();
        Employee employee = DataBase.employee;
        InvoiceMaterial  invoiceMaterial = new InvoiceMaterial(codeInvoice,idMaterial,nameMaterial,amount,dayOder,employee);
        DataBase.inputInvoiceMaterialList.add(invoiceMaterial);
        DataBase.historyInputInvoiceMaterialList.add(invoiceMaterial);
    }

    private void searchHistoryProduct() {
        while (true) {
            System.out.println("1. Search history Product");
            System.out.println("2. Search all history Product");
            System.out.println("0. Quay lại");
            int choose = InputValue.getInt(1, 2);
            if (choose == 0) {
                break;
            }
            switch (choose) {
                case 1:
                    searchOneHistoryProduct();
                    break;
                case 2:
                    searchAllHistoryProduct();
                    break;
            }
        }
    }
    // method có Tosing cần viết lại hàm Tosing
    private void searchAllHistoryProduct() {
        Iterator<History> it = DataBase.historyList.iterator();
        while (it.hasNext()){
            History history = it.next();
            System.out.println(history.toString());
        }
    }

    // method có Tosing cần viết lại hàm Tosing
    private void searchOneHistoryProduct() {
        System.out.println("Nhập ID sản phẩm");
        String idProduct = InputValue.getString();
        Iterator<History> it = DataBase.historyList.iterator();
        while (it.hasNext()){
            History history = it.next();
            if (history.getProduct().getIdProduct().equals(idProduct)){
                System.out.println(history.toString());
            }
        }
    }

    // output sản phẩm
    private void showOutputProduct() {
        System.out.println("Nhập ID sản phẩm");
        String idProduct = InputValue.getString();
        for (History history : DataBase.historyList){
            if (history.equals(idProduct)){
                System.out.println("Nhập vị trí lỗi");
                String location = InputValue.getString();
                Status status = checkStatus();
                LocalDate dayInput = LocalDate.now();
                history.setLocation(location);
                history.setStatusFuncion(status);
                history.setDayInputFuncion(dayInput);
            }
        }
    }

    private Status checkStatus(){
        Status status = null;
        System.out.println("Chọn trạng thái sản phẩm");
        System.out.println("1. OK " +
                "2. Hỏng");

        int choose = InputValue.getInt(1, 2);
        if (choose == 0 && choose > 2){
            return checkStatus();
        }
        switch (choose){
            case 1:
                status = Status.OK;
                break;
            case 2:
                status = Status.NG;
                break;
        }
        return status;
    }
}
