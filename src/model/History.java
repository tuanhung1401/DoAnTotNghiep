package model;

import constants.Status;

import java.time.LocalDate;

public class History {
    private Product product;
    private Status statusRece;
    private Employee employeeRece;
    private LocalDate dayInputRece;
    private Employee employeeWip;
    private LocalDate dayInputWIP;
    private Employee employeeFuncion;
    private String location;
    private Status statusFuncion;
    private LocalDate dayInputFuncion;

    public History(Product product, Status statusRece, Employee employeeRece, LocalDate dayInputRece, Employee employeeWip) {
        this.product = product;
        this.statusRece = statusRece;
        this.employeeRece = employeeRece;
        this.dayInputRece = dayInputRece;
        this.employeeWip = employeeWip;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Status getStatusRece() {
        return statusRece;
    }

    public void setStatusRece(Status statusRece) {
        this.statusRece = statusRece;
    }

    public Employee getEmployeeRece() {
        return employeeRece;
    }

    public void setEmployeeRece(Employee employeeRece) {
        this.employeeRece = employeeRece;
    }

    public LocalDate getDayInputRece() {
        return dayInputRece;
    }

    public void setDayInputRece(LocalDate dayInputRece) {
        this.dayInputRece = dayInputRece;
    }

    public Employee getEmployeeWip() {
        return employeeWip;
    }

    public void setEmployeeWip(Employee employeeWip) {
        this.employeeWip = employeeWip;
    }

    public LocalDate getDayInputWIP() {
        return dayInputWIP;
    }

    public void setDayInputWIP(LocalDate dayInputWIP) {
        this.dayInputWIP = dayInputWIP;
    }

    public Employee getEmployeeFuncion() {
        return employeeFuncion;
    }

    public void setEmployeeFuncion(Employee employeeFuncion) {
        this.employeeFuncion = employeeFuncion;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Status getStatusFuncion() {
        return statusFuncion;
    }

    public void setStatusFuncion(Status statusFuncion) {
        this.statusFuncion = statusFuncion;
    }

    public LocalDate getDayInputFuncion() {
        return dayInputFuncion;
    }

    public void setDayInputFuncion(LocalDate dayInputFuncion) {
        this.dayInputFuncion = dayInputFuncion;
    }
}
