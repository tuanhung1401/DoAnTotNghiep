package model;

import java.time.LocalDate;

public class Material {

    private String idMaterial;
    private String nameMaterial;
    private int amount;
    private LocalDate dayInvoice;
    private Employee employee;

    public Material(String idMaterial, String nameMaterial, int amount, LocalDate dayInvoice, Employee employee) {
        this.idMaterial = idMaterial;
        this.nameMaterial = nameMaterial;
        this.amount = amount;
        this.dayInvoice = dayInvoice;
        this.employee = employee;
    }

    public String getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(String idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getNameMaterial() {
        return nameMaterial;
    }

    public void setNameMaterial(String nameMaterial) {
        this.nameMaterial = nameMaterial;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getDayInvoice() {
        return dayInvoice;
    }

    public void setDayInvoice(LocalDate dayInvoice) {
        this.dayInvoice = dayInvoice;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        System.out.printf("ID Vật Liệu: %-10s  -  Tên Vật Liệu: %-20s  -  Sô Lượng: %-10s  -  Ngày: %15s",idMaterial,nameMaterial,amount,dayInvoice,employee+"\n");
        return "";
    }
}
