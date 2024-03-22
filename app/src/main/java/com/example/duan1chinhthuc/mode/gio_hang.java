package com.example.duan1chinhthuc.mode;

public class gio_hang {
    private int id_giohang;
    private int id_idtaikhoan;

    public gio_hang() {
    }

    public gio_hang(int id_giohang, int id_idtaikhoan) {
        this.id_giohang = id_giohang;
        this.id_idtaikhoan = id_idtaikhoan;
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
}
