package model;

import java.time.LocalDate;

public class Product {
    private String idSanPham;
    private String tenModel;
    private int soLuong;
    private String tenLoi;
    private int quanlity;
    private LocalDate timeTra;
    private LocalDate timeNhan;
    private Status status;

    public Product() {
    }

    public String getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(String idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getTenModel() {
        return tenModel;
    }

    public void setTenModel(String tenModel) {
        this.tenModel = tenModel;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTenLoi() {
        return tenLoi;
    }

    public void setTenLoi(String tenLoi) {
        this.tenLoi = tenLoi;
    }

    public int getQuanlity() {
        return quanlity;
    }

    public void setQuanlity(int quanlity) {
        this.quanlity = quanlity;
    }

    public LocalDate getTimeTra() {
        return timeTra;
    }

    public void setTimeTra(LocalDate timeTra) {
        this.timeTra = timeTra;
    }

    public LocalDate getTimeNhan() {
        return timeNhan;
    }

    public void setTimeNhan(LocalDate timeNhan) {
        this.timeNhan = timeNhan;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
