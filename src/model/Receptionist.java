package model;

import constants.Type;

public class Receptionist extends Employee{
    public Receptionist(String idNhanVien, String fullName) {
        super(idNhanVien, fullName, Type.NHANVIENLETAN);
    }
}
