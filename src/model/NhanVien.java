package model;

import java.time.LocalDate;
import java.util.List;

public class NhanVien {
    private String idNhanVien;
    private String hoVaTenNhanVien;
    private LocalDate ngaySinh;
    private String diaChi;
    private String soDienThoai;
    private Type type;
    private Gender gender;

    public NhanVien() {
    }

    public NhanVien(String idNhanVien, String hoVaTenNhanVien, LocalDate ngaySinh, String diaChi, String soDienThoai, Type type, Gender gender) {
        this.idNhanVien = idNhanVien;
        this.hoVaTenNhanVien = hoVaTenNhanVien;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.type = type;
        this.gender = gender;
    }

    public String getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(String idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getHoVaTenNhanVien() {
        return hoVaTenNhanVien;
    }

    public void setHoVaTenNhanVien(String hoVaTenNhanVien) {
        this.hoVaTenNhanVien = hoVaTenNhanVien;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

}
