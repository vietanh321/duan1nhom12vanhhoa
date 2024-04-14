package com.example.duan1chinhthuc.mode;

public class love_model {
    private int id_love;
    private int id_sp;
    private String ten_sp;
    private int gia_sp;
    private int id_user;
private String tieude;



    public love_model(int id_love, int id_sp, String ten_sp, int id_user) {
        this.id_love = id_love;
        this.id_sp = id_sp;
        this.ten_sp = ten_sp;
        this.id_user = id_user;
    }


    public love_model(int id_love, int id_sp, String ten_sp, int gia_sp, int id_user) {
        this.id_love = id_love;
        this.id_sp = id_sp;
        this.ten_sp = ten_sp;
        this.gia_sp = gia_sp;
        this.id_user = id_user;
    }

    public love_model(int id_love, int id_sp, String ten_sp, int gia_sp, int id_user, String tieude) {
        this.id_love = id_love;
        this.id_sp = id_sp;
        this.ten_sp = ten_sp;
        this.gia_sp = gia_sp;
        this.id_user = id_user;
        this.tieude = tieude;
    }

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public int getGia_sp() {
        return gia_sp;
    }

    public void setGia_sp(int gia_sp) {
        this.gia_sp = gia_sp;
    }

    public love_model() {

    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_love() {
        return id_love;
    }

    public void setId_love(int id_love) {
        this.id_love = id_love;
    }

    public int getId_sp() {
        return id_sp;
    }

    public void setId_sp(int id_sp) {
        this.id_sp = id_sp;
    }

    public String getTen_sp() {
        return ten_sp;
    }

    public void setTen_sp(String ten_sp) {
        this.ten_sp = ten_sp;
    }
}
