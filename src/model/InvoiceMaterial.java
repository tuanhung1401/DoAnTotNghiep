package model;

import java.time.LocalDate;

public class InvoiceMaterial {

    private String codeMaterial;
    private String nameMaterial;
    private int amount;
    private LocalDate dayInvoice;
    private Employee employee;

    public InvoiceMaterial(String codeMaterial, String nameMaterial, int amount, LocalDate dayInvoice, Employee employee) {
        this.codeMaterial = codeMaterial;
        this.nameMaterial = nameMaterial;
        this.amount = amount;
        this.dayInvoice = dayInvoice;
        this.employee = employee;
    }

    public String getCodeMaterial() {
        return codeMaterial;
    }

    public void setCodeMaterial(String codeMaterial) {
        this.codeMaterial = codeMaterial;
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
}
