package model;

import java.time.LocalDate;

public class Material {
    private Inventory inventory;
    private Storage storage;
    private LocalDate dateAdd;
    private LocalDate dateExport;


    public Material(Inventory inventory, Storage storage, LocalDate dateAdd) {
        this.inventory = inventory;
        this.storage = storage;
        this.dateAdd = dateAdd;
    }



    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public LocalDate getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(LocalDate dateAdd) {
        this.dateAdd = dateAdd;
    }

    public LocalDate getDateExport() {
        return dateExport;
    }

    public void setDateExport(LocalDate dateExport) {
        this.dateExport = dateExport;
    }
}
