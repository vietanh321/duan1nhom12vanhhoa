package com.example.duan1chinhthuc.mode;

public class SanPhamChiTiet {

    private String tensp;
    private int id_hinh_anh;
    private int url_hinhanh;
    private int gia_sp;


    public SanPhamChiTiet() {
    }

    public SanPhamChiTiet(String tensp, int id_hinh_anh, int url_hinhanh, int gia_sp) {
        this.tensp = tensp;
        this.id_hinh_anh = id_hinh_anh;
        this.url_hinhanh = url_hinhanh;
        this.gia_sp = gia_sp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getId_hinh_anh() {
        return id_hinh_anh;
    }

    public void setId_hinh_anh(int id_hinh_anh) {
        this.id_hinh_anh = id_hinh_anh;
    }

    public int getUrl_hinhanh() {
        return url_hinhanh;
    }

    public void setUrl_hinhanh(int url_hinhanh) {
        this.url_hinhanh = url_hinhanh;
    }

    public int getGia_sp() {
        return gia_sp;
    }

    public void setGia_sp(int gia_sp) {
        this.gia_sp = gia_sp;
    }
}
