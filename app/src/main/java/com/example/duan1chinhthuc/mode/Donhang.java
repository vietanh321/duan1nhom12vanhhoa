package com.example.duan1chinhthuc.mode;

public class Donhang {
    int id;
    int id_chitietsp;
    String trangthaidonhang;
    int size;
    int soluong_sp;
    int tongtien;
    String ngay_model;
    int id_user;
    String sdt;
    String diachi;
    String hoten;

    public Donhang() {
    }


    public Donhang(int id, int id_chitietsp, String trangthaidonhang, int size, int soluong_sp, int tongtien, String ngay_model, int id_user) {
        this.id = id;
        this.id_chitietsp = id_chitietsp;
        this.trangthaidonhang = trangthaidonhang;
        this.size = size;
        this.soluong_sp = soluong_sp;
        this.tongtien = tongtien;
        this.ngay_model = ngay_model;
        this.id_user = id_user;
    }

    public Donhang(int id, int id_chitietsp, String trangthaidonhang, int size, int soluong_sp, int tongtien, String ngay_model, int id_user, String sdt, String diachi) {
        this.id = id;
        this.id_chitietsp = id_chitietsp;
        this.trangthaidonhang = trangthaidonhang;
        this.size = size;
        this.soluong_sp = soluong_sp;
        this.tongtien = tongtien;
        this.ngay_model = ngay_model;
        this.id_user = id_user;
        this.sdt = sdt;
        this.diachi = diachi;
    }


    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
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

    public int getSoluong_sp() {
        return soluong_sp;
    }

    public void setSoluong_sp(int soluong_sp) {
        this.soluong_sp = soluong_sp;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public String getNgay_model() {
        return ngay_model;
    }

    public void setNgay_model(String ngay_model) {
        this.ngay_model = ngay_model;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
}
