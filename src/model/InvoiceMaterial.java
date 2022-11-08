package model;

import java.time.LocalDate;

public class InvoiceMaterial extends Material{
    private String codeMaterial;

    public InvoiceMaterial(String codeMaterial, String idMaterial, String nameMaterial, int amount, LocalDate dayInvoice, Employee employee) {
        super(idMaterial, nameMaterial, amount, dayInvoice, employee);
        this.codeMaterial = codeMaterial;
    }

    public String getCodeMaterial() {
        return codeMaterial;
    }

    public void setCodeMaterial(String codeMaterial) {
        this.codeMaterial = codeMaterial;
    }

    @Override
    public String toString() {
        super.toString();
        System.out.printf("  -  Code Hóa đơn: %-15s",codeMaterial);
        return "";
    }
}
