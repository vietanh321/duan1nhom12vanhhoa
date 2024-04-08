package com.example.duan1chinhthuc.mode;

public class Donhang {
    int id;
    int id_chitietsp;
    String tenkhachhang;
    int sodienthoai;
    String diachi;
    String trangthaidonhang;
    int size;
    int soluong_sp;
    int tongtien;
    String ngay_model;

    public Donhang() {
    }

    public Donhang( int id_chitietsp,int id, String tenkhachhang, int sodienthoai, String diachi, String trangthaidonhang, int size) {
        this.id_chitietsp = id_chitietsp;
        this.id = id;

        this.tenkhachhang = tenkhachhang;
        this.sodienthoai = sodienthoai;

        this.diachi = diachi;
        this.trangthaidonhang = trangthaidonhang;
        this.size = size;
    }

    public Donhang(int id, int id_chitietsp, String tenkhachhang, int sodienthoai, String diachi, String trangthaidonhang, int size, int soluong_sp,int tongtien,String ngay) {
        this.id = id;
        this.id_chitietsp = id_chitietsp;
        this.tenkhachhang = tenkhachhang;
        this.sodienthoai = sodienthoai;
        this.diachi = diachi;
        this.trangthaidonhang = trangthaidonhang;
        this.size = size;
        this.soluong_sp = soluong_sp;
        this.tongtien = tongtien;
        this.ngay_model = ngay;
    }

    public String getNgay_model() {
        return ngay_model;
    }

    public void setNgay_model(String ngay_model) {
        this.ngay_model = ngay_model;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public int getSoluong_sp() {
        return soluong_sp;
    }

    public void setSoluong_sp(int soluong_sp) {
        this.soluong_sp = soluong_sp;
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
