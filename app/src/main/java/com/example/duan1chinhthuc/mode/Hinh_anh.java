package com.example.duan1chinhthuc.mode;

public class Hinh_anh {
    private int id_hinh_anh;
    private int ulr_hinhanh;

    public Hinh_anh(int id_hinh_anh, int ulr_hinhanh) {
        this.id_hinh_anh = id_hinh_anh;
        this.ulr_hinhanh = ulr_hinhanh;
    }

    public Hinh_anh() {
    }

    public int getId_hinh_anh() {
        return id_hinh_anh;
    }

    public void setId_hinh_anh(int id_hinh_anh) {
        this.id_hinh_anh = id_hinh_anh;
    }

    public int getUlr_hinhanh() {
        return ulr_hinhanh;
    }

    public void setUlr_hinhanh(int ulr_hinhanh) {
        this.ulr_hinhanh = ulr_hinhanh;
    }
}
