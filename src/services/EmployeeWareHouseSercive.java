package services;

import database.DataBase;
import model.Employee;
import model.History;
import model.InvoiceMaterial;
import model.Material;
import utils.InputValue;

import java.time.LocalDate;
import java.util.Iterator;

public class EmployeeWareHouseSercive implements IService{
    public void showFunction() {
        while (true){
            System.out.println("1. Nhập Vật Liệu");
            System.out.println("2. Xuất Vật Liệu");
            System.out.println("3. History");
            System.out.println("0. Quay lại");
            int choose = InputValue.getInt(1, 3);
            if (choose == 0){
                DataBase.employee = null;
                break;
            }
            switch (choose){
                case 1:
                    showAddMaterial();
                    break;
                case 2:
                    showOutMaterial();
                    break;
                case 3:
                    showHistory();
                    break;
            }
        }
    }

    private void showHistory() {
        while (true){
            System.out.println("1. History All Nhập vật liệu");
            System.out.println("2. History All Xuất vật liệu");
            System.out.println("3. List Tồn Kho");
            System.out.println("0. Quay lại");
            int choose = InputValue.getInt(1, 3);
            if (choose == 0){
                break;
            }
            switch (choose){
                case 1:
                    showHistoryAddMaterial();
                    break;
                case 2:
                    showHistoryOutMaterial();
                    break;
                case 3:
                    showInventoryMaterial();
                    break;
            }
        }
    }


    private void showHistoryAddMaterial() {
        Iterator<Material> it = DataBase.historyImportMaterialList.iterator();
        while (it.hasNext()){
            Material material = it.next();
            System.out.println(material.toString());
        }
    }

    private void showHistoryOutMaterial() {
        Iterator<Material> it = DataBase.inventoryMaterialList.iterator();
        while (it.hasNext()){
            Material material = it.next();
            System.out.println(material.toString());
        }
    }

    private void showInventoryMaterial() {
        Iterator<Material> it = DataBase.inventoryMaterialList.iterator();
        while (it.hasNext()){
            Material material = it.next();
            System.out.println(material.toString());
        }
    }

    private void showAddMaterial(){
        while (true){
            System.out.println("1. Thêm Vật liệu mới");
            System.out.println("2. Thêm số lượng vật liệu");
            System.out.println("0. Quay lại");
            int choose = InputValue.getInt(1, 2);
            if (choose == 0){
                break;
            }
            switch (choose){
                case 1:
                    showAddMaterialNew();
                    break;
                case 2:
                    showAddMaterialOld();
                    break;
            }
        }
    }


    private void showAddMaterialNew() {
        System.out.println("Nhập ID Vật liệu");
        String idMaterial = InputValue.getIDMaterial();
        System.out.println("Nhập tên vật liệu");
        String nameMaterial = InputValue.getString();
        System.out.println("Nhập số lượng");
        int amount = InputValue.getInputInt();
        Employee employee = DataBase.employee;
        LocalDate dayImport = LocalDate.now();
        Material material = new Material(idMaterial,nameMaterial,amount,dayImport,employee);
        DataBase.historyImportMaterialList.add(material);
        DataBase.inventoryMaterialList.add(material);


    }

    private void showAddMaterialOld(){
        System.out.println("Nhập ID Vật liệu");
        String idMaterial = getIDMaterial();
        System.out.println("Nhập số lượng thêm");
        int amount = InputValue.getInputInt();
        Iterator<Material> it1 = DataBase.historyImportMaterialList.iterator();
        while (it1.hasNext()){
            Material material1 = it1.next();
            if (material1.getIdMaterial().equals(idMaterial)){
                material1.setAmount((material1.getAmount()+amount));
                System.out.println("Cập nhật thành  công");
            }
        }
        Iterator<Material> it2 = DataBase.inventoryMaterialList.iterator();
        while (it2.hasNext()){
            Material material2 = it2.next();
            if (material2.getIdMaterial().equals(idMaterial)){
                material2.setAmount((material2.getAmount()+amount));
                return;
            }
        }
        System.out.println("Không tìm thấy Mã vật liệu nào");
    }

    private String getIDMaterial(){
        String idMaterial = InputValue.getString();
        for (Material material : DataBase.historyImportMaterialList){
            if (material.getIdMaterial().equals(idMaterial)){
                return idMaterial;
            }
        }
        System.out.println("Không tìm thấy thấy ID vật liệu nào");
        return getIDMaterial();
    }
    private void showOutMaterial() {
        System.out.println("Nhập Mã Hóa đơn Oder xuất Vật liệu");
        String codeInvoice = InputValue.getString();
        String idMaterial = null;
        int quanliti = 0;
        Iterator<InvoiceMaterial> it1 = DataBase.inputInvoiceMaterialList.iterator();
        while (it1.hasNext()){
            InvoiceMaterial invoiceMaterial1 = it1.next();
            if (invoiceMaterial1.getCodeMaterial().equals(codeInvoice)){
                quanliti = invoiceMaterial1.getAmount();
                idMaterial = invoiceMaterial1.getIdMaterial();
                DataBase.historyOutMaterialList.add(invoiceMaterial1);
                it1.remove();
            }
        }
        Iterator<Material> it2 = DataBase.inventoryMaterialList.iterator();
        while (it2.hasNext()){
            Material invoiceMaterial2 = it2.next();
            if (invoiceMaterial2.getIdMaterial().equals(idMaterial)){
               invoiceMaterial2.setAmount((invoiceMaterial2.getAmount()-quanliti));
                return;
            }
        }
        System.out.println("Không tìm thấy hóa đơn Oder vật liệu nào!");
    }
}
