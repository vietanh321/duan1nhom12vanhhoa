package com.example.duan1chinhthuc.mode;

import java.io.Serializable;

public class gio_hang implements Serializable {
    private int id;
    private String tensp;
    private int giasp;
    private int hinhanhsp;
    private int soluongsp;

    public gio_hang(int id, String tensp, int giasp) {
        this.id = id;
        this.tensp = tensp;
        this.giasp = giasp;
    }

    public gio_hang() {
    }

    public gio_hang(int id, String tensp, int giasp, int hinhanhsp, int soluongsp) {
        this.id = id;
        this.tensp = tensp;
        this.giasp = giasp;
        this.hinhanhsp = hinhanhsp;
        this.soluongsp = soluongsp;
    }

    public gio_hang(String tensp, int giasp) {
        this.tensp = tensp;
        this.giasp = giasp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getGiasp() {
        return giasp;
    }

    public void setGiasp(int giasp) {
        this.giasp = giasp;
    }

    public int getHinhanhsp() {
        return hinhanhsp;
    }

    public void setHinhanhsp(int hinhanhsp) {
        this.hinhanhsp = hinhanhsp;
    }

    public int getSoluongsp() {
        return soluongsp;
    }

    public void setSoluongsp(int soluongsp) {
        this.soluongsp = soluongsp;
    }
}
