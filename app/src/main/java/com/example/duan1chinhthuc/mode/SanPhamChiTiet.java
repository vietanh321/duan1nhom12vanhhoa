package com.example.duan1chinhthuc.mode;

public class SanPhamChiTiet {
    private int id_SP_chitiet;
    private int id_sanpham;
    private int id_chatlieu;
    private int id_hinh_anh;
    private int gia_sp;
    private int Size;

    public SanPhamChiTiet() {
    }

    public SanPhamChiTiet(int id_SP_chitiet, int id_sanpham, int id_chatlieu, int id_hinh_anh, int gia_sp, int size) {
        this.id_SP_chitiet = id_SP_chitiet;
        this.id_sanpham = id_sanpham;
        this.id_chatlieu = id_chatlieu;
        this.id_hinh_anh = id_hinh_anh;
        this.gia_sp = gia_sp;
        Size = size;
    }

    public int getId_SP_chitiet() {
        return id_SP_chitiet;
    }

    public void setId_SP_chitiet(int id_SP_chitiet) {
        this.id_SP_chitiet = id_SP_chitiet;
    }

    public int getId_sanpham() {
        return id_sanpham;
    }

    public void setId_sanpham(int id_sanpham) {
        this.id_sanpham = id_sanpham;
    }

    public int getId_chatlieu() {
        return id_chatlieu;
    }

    public void setId_chatlieu(int id_chatlieu) {
        this.id_chatlieu = id_chatlieu;
    }

    public int getId_hinh_anh() {
        return id_hinh_anh;
    }

    public void setId_hinh_anh(int id_hinh_anh) {
        this.id_hinh_anh = id_hinh_anh;
    }

    public int getGia_sp() {
        return gia_sp;
    }

    public void setGia_sp(int gia_sp) {
        this.gia_sp = gia_sp;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int size) {
        Size = size;
    }
}
