package com.example.duan1chinhthuc.mode;

public class San_Pham {
    private int id_sanpham;
    private String tensp;
    private String tieude;
    private String ngaydangban;
    private String trangthai;

    public San_Pham() {
    }

    public San_Pham(int id_sanpham, String tensp, String tieude, String ngaydangban, String trangthai) {
        this.id_sanpham = id_sanpham;
        this.tensp = tensp;
        this.tieude = tieude;
        this.ngaydangban = ngaydangban;
        this.trangthai = trangthai;
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
}
