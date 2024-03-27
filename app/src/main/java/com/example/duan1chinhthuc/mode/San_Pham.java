package com.example.duan1chinhthuc.mode;

public class San_Pham {
    private int id_sanpham;
    private String tensp;
    private String tieude;
    private String ngaydangban;
    private String trangthai;
    private int Id_chatlieu;
    private String tenchatlieu;
    private int hinhanh;
    private int urlhinhanh;
    private int Id_spchitiet;
    private int giatien;
    private int size;

    public San_Pham(String tensp, String tieude, String ngaydangban, String trangthai, String id_CL, String id_HA, int giatien, int size) {
    }

    public San_Pham(int id_sanpham, String tensp, String tieude, String ngaydangban, String trangthai, int id_chatlieu, String tenchatlieu, int hinhanh, int urlhinhanh, int id_spchitiet, int giatien, int size) {
        this.id_sanpham = id_sanpham;
        this.tensp = tensp;
        this.tieude = tieude;
        this.ngaydangban = ngaydangban;
        this.trangthai = trangthai;
        Id_chatlieu = id_chatlieu;
        this.tenchatlieu = tenchatlieu;
        this.hinhanh = hinhanh;
        this.urlhinhanh = urlhinhanh;
        Id_spchitiet = id_spchitiet;
        this.giatien = giatien;
        this.size = size;
    }

    public int getId_sanpham() {
        return id_sanpham;
    }

    public void setId_sanpham(int id_sanpham) {
        this.id_sanpham = id_sanpham;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public String getNgaydangban() {
        return ngaydangban;
    }

    public void setNgaydangban(String ngaydangban) {
        this.ngaydangban = ngaydangban;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public int getId_chatlieu() {
        return Id_chatlieu;
    }

    public void setId_chatlieu(int id_chatlieu) {
        Id_chatlieu = id_chatlieu;
    }

    public String getTenchatlieu() {
        return tenchatlieu;
    }

    public void setTenchatlieu(String tenchatlieu) {
        this.tenchatlieu = tenchatlieu;
    }

    public int getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(int hinhanh) {
        this.hinhanh = hinhanh;
    }

    public int getUrlhinhanh() {
        return urlhinhanh;
    }

    public void setUrlhinhanh(int urlhinhanh) {
        this.urlhinhanh = urlhinhanh;
    }

    public int getId_spchitiet() {
        return Id_spchitiet;
    }

    public void setId_spchitiet(int id_spchitiet) {
        Id_spchitiet = id_spchitiet;
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
