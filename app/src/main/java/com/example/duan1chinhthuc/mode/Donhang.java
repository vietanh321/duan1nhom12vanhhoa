package com.example.duan1chinhthuc.mode;

public class Donhang {
    int id;
    int id_chitietsp;
    String tenkhachhang;
    int sodienthoai;
    String email;
    String diachi;
    String trangthaidonhang;
    int size;

    public Donhang() {
    }

    public Donhang( int id_chitietsp,int id, String tenkhachhang, int sodienthoai, String email, String diachi, String trangthaidonhang, int size) {
        this.id_chitietsp = id_chitietsp;
        this.id = id;

        this.tenkhachhang = tenkhachhang;
        this.sodienthoai = sodienthoai;
        this.email = email;
        this.diachi = diachi;
        this.trangthaidonhang = trangthaidonhang;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_chitietsp() {
        return id_chitietsp;
    }

    public void setId_chitietsp(int id_chitietsp) {
        this.id_chitietsp = id_chitietsp;
    }

    public String getTenkhachhang() {
        return tenkhachhang;
    }

    public void setTenkhachhang(String tenkhachhang) {
        this.tenkhachhang = tenkhachhang;
    }

    public int getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(int sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getTrangthaidonhang() {
        return trangthaidonhang;
    }

    public void setTrangthaidonhang(String trangthaidonhang) {
        this.trangthaidonhang = trangthaidonhang;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
