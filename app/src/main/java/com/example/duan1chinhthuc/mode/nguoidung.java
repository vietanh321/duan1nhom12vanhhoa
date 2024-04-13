package com.example.duan1chinhthuc.mode;

public class nguoidung {
    private int id_user;
    private String matt;
    private String hoten;
    private String matkhau;
    private String loaitaikhoan;
    private int sdt;
    private String diachi;

    public nguoidung(int id_user, String matt, String hoten, String matkhau, String loaitaikhoan) {
        this.id_user = id_user;
        this.matt = matt;
        this.hoten = hoten;
        this.matkhau = matkhau;
        this.loaitaikhoan = loaitaikhoan;
    }

    public nguoidung(int id_user, String matt, String hoten, String matkhau, String loaitaikhoan, int sdt, String diachi) {
        this.id_user = id_user;
        this.matt = matt;
        this.hoten = hoten;
        this.matkhau = matkhau;
        this.loaitaikhoan = loaitaikhoan;
        this.sdt = sdt;
        this.diachi = diachi;
    }

    public nguoidung(String hoten, int sdt, String diachi) {
        this.hoten = hoten;
        this.sdt = sdt;
        this.diachi = diachi;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getMatt() {
        return matt;
    }

    public void setMatt(String matt) {
        this.matt = matt;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getLoaitaikhoan() {
        return loaitaikhoan;
    }

    public void setLoaitaikhoan(String loaitaikhoan) {
        this.loaitaikhoan = loaitaikhoan;
    }


}
