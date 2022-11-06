package services;

import database.DataBase;
import model.Inventory;
import model.Material;
import model.Storage;
import utils.InputValue;

import java.time.LocalDate;
import java.util.Iterator;

public class MaterialSercive implements IService{
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
                break;
            }
            switch (choose){
                case 1:
                    showInputMaterial();
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
        Iterator<Material> it = DataBase.materiaExistlList.iterator();
        while (it.hasNext()){
            Material m = it.next();
            System.out.println(m.getStorage() +" " + m.getDateAdd());
        }
    }

    private void showAddList() {
        Iterator<Material> it = DataBase.materialList.iterator();
        while (it.hasNext()){
            Material m = it.next();
            System.out.println(m.getStorage() +" " + m.getInventory() +" " + m.getDateAdd());
        }
    }

    private void showInputMaterial() {
        System.out.println("Tên vật liệu");
        String nameMaterial = InputValue.getString();
        System.out.println("Nhập Model");
        String nameModel = InputValue.getString();
        System.out.println("Số Lượng");
        int number = InputValue.getInputInt();
        System.out.println("Tên Vendor cấp");
        String nameVendor = InputValue.getString();
        System.out.println("ID nhân viên nhập");
        String idNhanVien = InputValue.getString();
        String nameNhanVien = InputValue.getEmployee(idNhanVien);
        System.out.println("Ngày Nhập");
        LocalDate dateAdd = InputValue.getInputLocalDate();
        Storage storage = new Storage(nameMaterial,nameModel,number,nameVendor);
        Inventory inventory = new Inventory(idNhanVien,nameNhanVien);
        Material material = new Material(inventory,storage,dateAdd);
        DataBase.materialList.add(material);
        DataBase.materiaExistlList.add(material);
    }

    private void showOutMaterial() {
        ///
    }
}
