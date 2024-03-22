package com.example.duan1chinhthuc.mode;

public class giohangchitiet {
    private int id_giohangchitiet;
    private int id_giohang;
    private int id_SP_chitiet;
    private int soluongsp;
    private int gia_sp;

    public giohangchitiet() {
    }

    public giohangchitiet(int id_giohangchitiet, int id_giohang, int id_SP_chitiet, int soluongsp, int gia_sp) {
        this.id_giohangchitiet = id_giohangchitiet;
        this.id_giohang = id_giohang;
        this.id_SP_chitiet = id_SP_chitiet;
        this.soluongsp = soluongsp;
        this.gia_sp = gia_sp;
    }

    public int getId_giohangchitiet() {
        return id_giohangchitiet;
    }

    public void setId_giohangchitiet(int id_giohangchitiet) {
        this.id_giohangchitiet = id_giohangchitiet;
    }

    public int getId_giohang() {
        return id_giohang;
    }

    public void setId_giohang(int id_giohang) {
        this.id_giohang = id_giohang;
    }

    public int getId_SP_chitiet() {
        return id_SP_chitiet;
    }

    public void setId_SP_chitiet(int id_SP_chitiet) {
        this.id_SP_chitiet = id_SP_chitiet;
    }

    public int getSoluongsp() {
        return soluongsp;
    }

    public void setSoluongsp(int soluongsp) {
        this.soluongsp = soluongsp;
    }

    public int getGia_sp() {
        return gia_sp;
    }

    public void setGia_sp(int gia_sp) {
        this.gia_sp = gia_sp;
    }
}
