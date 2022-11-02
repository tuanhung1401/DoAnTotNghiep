package model;

public class Customer {
    private String idCumtomer;
    private String nameCumtommer;
    private String phoneNumber;
    private int quantity;

    private StatusCustomer statusCustomer;

    public Customer() {
    }

    public Customer(String idCumtomer, String nameCumtommer, String phoneNumber, int quantity, StatusCustomer statusCustomer) {
        this.idCumtomer = idCumtomer;
        this.nameCumtommer = nameCumtommer;
        this.phoneNumber = phoneNumber;
        this.quantity = quantity;
        this.statusCustomer = statusCustomer;
    }

    public String getIdCumtomer() {
        return idCumtomer;
    }

    public void setIdCumtomer(String idCumtomer) {
        this.idCumtomer = idCumtomer;
    }

    public String getNameCumtommer() {
        return nameCumtommer;
    }

    public void setNameCumtommer(String nameCumtommer) {
        this.nameCumtommer = nameCumtommer;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public StatusCustomer getStatusCustomer() {
        return statusCustomer;
    }

    public void setStatusCustomer(StatusCustomer statusCustomer) {
        this.statusCustomer = statusCustomer;
    }
}
