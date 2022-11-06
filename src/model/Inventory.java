package model;

import constants.Type;

public class Inventory extends Employee{

    public Inventory() {
    }

    public Inventory(String idNhanVien, String fullName) {
        super(idNhanVien, fullName, Type.NHANVIENKHO);
    }
}
