package model;

import services.Login;

import java.time.LocalDate;

public class Invoice {
    private String codeInvoive;
    private Customer customer;
    private Product product;
    private int number;
    private double price;
    private LocalDate dateAdd;
    private LocalDate datePay;
    private Receptionist receptionist;

    public Invoice(String codeInvoive, Customer customer, Product product, int number, double price, LocalDate dateAdd, LocalDate datePay, Receptionist receptionist) {
        this.codeInvoive = codeInvoive;
        this.customer = customer;
        this.product = product;
        this.number = number;
        this.price = price;
        this.dateAdd = dateAdd;
        this.datePay = datePay;
        this.receptionist = receptionist;
    }


    public String getCodeInvoive() {
        return codeInvoive;
    }

    public void setCodeInvoive(String codeInvoive) {
        this.codeInvoive = codeInvoive;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(LocalDate dateAdd) {
        this.dateAdd = dateAdd;
    }

    public LocalDate getDatePay() {
        return datePay;
    }

    public void setDatePay(LocalDate datePay) {
        this.datePay = datePay;
    }

    public Receptionist getReceptionist() {
        return receptionist;
    }

    public void setReceptionist(Receptionist receptionist) {
        this.receptionist = receptionist;
    }
}
