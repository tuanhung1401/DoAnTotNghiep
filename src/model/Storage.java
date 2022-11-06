package model;

public class Storage {
    private String nameMaterial;
    private String nameModel;
    private int number;
    private String nameVendor;


    public Storage() {
    }

    public Storage(String nameMaterial, String nameModel, int number, String nameVendor) {
        this.nameMaterial = nameMaterial;
        this.nameModel = nameModel;
        this.number = number;
        this.nameVendor = nameVendor;
    }


    public String getNameMaterial() {
        return nameMaterial;
    }

    public void setNameMaterial(String nameMaterial) {
        this.nameMaterial = nameMaterial;
    }

    public String getNameModel() {
        return nameModel;
    }

    public void setNameModel(String nameModel) {
        this.nameModel = nameModel;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getNameVendor() {
        return nameVendor;
    }

    public void setNameVendor(String nameVendor) {
        this.nameVendor = nameVendor;
    }
}

