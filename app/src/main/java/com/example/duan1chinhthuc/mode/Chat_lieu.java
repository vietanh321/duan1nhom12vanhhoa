package com.example.duan1chinhthuc.mode;

public class Chat_lieu {
   private int id_chatlieu;
   private String tenchatlieu;

    public Chat_lieu() {
    }

    public Chat_lieu(int id_chatlieu, String tenchatlieu) {
        this.id_chatlieu = id_chatlieu;
        this.tenchatlieu = tenchatlieu;
    }

    public int getId_chatlieu() {
        return id_chatlieu;
    }

    public void setId_chatlieu(int id_chatlieu) {
        this.id_chatlieu = id_chatlieu;
    }

    public String getTenchatlieu() {
        return tenchatlieu;
    }

    public void setTenchatlieu(String tenchatlieu) {
        this.tenchatlieu = tenchatlieu;
    }
}
