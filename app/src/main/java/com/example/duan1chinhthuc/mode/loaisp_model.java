package com.example.duan1chinhthuc.mode;

public class loaisp_model {
    private int id_loaisp;
    private String ten_loaisp;

    public loaisp_model() {
    }

    public loaisp_model(int id_loaisp, String ten_loaisp) {
        this.id_loaisp = id_loaisp;
        this.ten_loaisp = ten_loaisp;
    }

    public int getId_loaisp() {
        return id_loaisp;
    }

    public void setId_loaisp(int id_loaisp) {
        this.id_loaisp = id_loaisp;
    }

    public String getTen_loaisp() {
        return ten_loaisp;
    }

    public void setTen_loaisp(String ten_loaisp) {
        this.ten_loaisp = ten_loaisp;
    }
}
