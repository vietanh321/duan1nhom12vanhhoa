package com.example.duan1chinhthuc.mode;

public class gio_hang {
    private int id_giohang;
    private int id_idtaikhoan;
    private int id_sanpham;
    private String ten_sanpham;
    private int soluong_sp;
    private int giatien;
    private int size;

    public gio_hang() {
    }

    public gio_hang(int id_giohang, int id_idtaikhoan, int id_sanpham, String ten_sanpham, int soluong_sp, int giatien, int size) {
        this.id_giohang = id_giohang;
        this.id_idtaikhoan = id_idtaikhoan;
        this.id_sanpham = id_sanpham;
        this.ten_sanpham = ten_sanpham;
        this.soluong_sp = soluong_sp;
        this.giatien = giatien;
        this.size = size;
    }

    public int getId_giohang() {
        return id_giohang;
    }

    public void setId_giohang(int id_giohang) {
        this.id_giohang = id_giohang;
    }

    public int getId_idtaikhoan() {
        return id_idtaikhoan;
    }

    public void setId_idtaikhoan(int id_idtaikhoan) {
        this.id_idtaikhoan = id_idtaikhoan;
    }

    public int getId_sanpham() {
        return id_sanpham;
    }

    public void setId_sanpham(int id_sanpham) {
        this.id_sanpham = id_sanpham;
    }

    public String getTen_sanpham() {
        return ten_sanpham;
    }

    public void setTen_sanpham(String ten_sanpham) {
        this.ten_sanpham = ten_sanpham;
    }

    public int getSoluong_sp() {
        return soluong_sp;
    }

    public void setSoluong_sp(int soluong_sp) {
        this.soluong_sp = soluong_sp;
    }

    public int getGiatien() {
        return giatien;
    }

    public void setGiatien(int giatien) {
        this.giatien = giatien;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
