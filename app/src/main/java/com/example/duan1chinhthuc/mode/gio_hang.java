package com.example.duan1chinhthuc.mode;

import java.io.Serializable;

public class gio_hang implements Serializable {
    private int id_giohang;
    private int id_sp;
    private int gia_sp;
    private int soluong_sp;
    private String tensp;
    private int id_user;


    public gio_hang() {
    }

    public gio_hang(int id_giohang, int id_sp, int gia_sp, int soluong_sp, String tensp, int id_user) {
        this.id_giohang = id_giohang;
        this.id_sp = id_sp;
        this.gia_sp = gia_sp;
        this.soluong_sp = soluong_sp;
        this.tensp = tensp;
        this.id_user = id_user;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_giohang() {
        return id_giohang;
    }

    public void setId_giohang(int id_giohang) {
        this.id_giohang = id_giohang;
    }

    public int getId_sp() {
        return id_sp;
    }

    public void setId_sp(int id_sp) {
        this.id_sp = id_sp;
    }

    public int getGia_sp() {
        return gia_sp;
    }

    public void setGia_sp(int gia_sp) {
        this.gia_sp = gia_sp;
    }

    public int getSoluong_sp() {
        return soluong_sp;
    }

    public void setSoluong_sp(int soluong_sp) {
        this.soluong_sp = soluong_sp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }
}
