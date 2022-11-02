package model;

public class Common {
    private Customer customer;
    private NhanVien nhanVien;
    private Product product;

    public Common() {
    }

    public Common(Customer customer, NhanVien nhanVien, Product product) {
        this.customer = customer;
        this.nhanVien = nhanVien;
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
