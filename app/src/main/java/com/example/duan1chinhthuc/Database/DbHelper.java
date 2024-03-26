package com.example.duan1chinhthuc.Database;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;





public class DbHelper extends SQLiteOpenHelper {
    private static final String DB_name="BG";

    @Override
    public void onCreate(SQLiteDatabase db) {
        String db_thuthu="create table thuthu(matt text primary key," + "hoten text," + "matkhau text," + "loaitaikhoan text)";
        db.execSQL(db_thuthu);
        String db_giohang="create table giohang(Id_giohang text primary key," + " Id_taikhoan text references Id_giohang(Id_taikhoan))";
        db.execSQL(db_giohang);
        String db_sanpham="create table sanpham(Id_sanpham integer primary key," + " Tensp text," + "tieude text,"+ "trangthai text," + "ngaydangban text)";
        db.execSQL(db_sanpham);
        String db_spchitiet="create table spchitiet(Id_spchitiet integer primary key," + "Id_sanpham integer references Id_spchitiet(Id_sanpham) ," + "Id_chatlieu integer references Id_spchitiet(Id_chatlieu), " + "Id_hinhanh integer references Id_spchitiet(Id_hinhanh), " + "gia integer," + "size integer)";
        db.execSQL(db_spchitiet);
        String db_chatlieu="create table chatlieu(Id_chatlieu integer primary key," + "tenchatlieu text)";
        db.execSQL(db_chatlieu);
        String db_hinhanh="create table hinhanh(hinhanh integer primary key," + "urlhinhanh integer)";
        db.execSQL(db_hinhanh);
        String db_danhgia="create table danhgia(Id_danhgia text primary key," + "Id_taikhoan text references Id_danhgia(Id_taikhoan) ," + "note text)";
        db.execSQL(db_danhgia);
        db.execSQL("INSERT INTO thuthu VALUES ('hoaddph46289','duy hoa','hoaddph46289','admin'),('hoaddph46289tt','thi thinh','hoaddph46289tt','thuthu')");
        db.execSQL("INSERT INTO giohang VALUES('giohang2','TK2')");
        db.execSQL("INSERT INTO danhgia VALUES('dgia1','tk2','Sản phẩm đẹp')");

        db.execSQL("insert into hinhanh values(1,1)");
        db.execSQL("insert into chatlieu values(1,'cotton')");
        db.execSQL("insert into sanpham values(1,'MLB','NEW','conhang','10/12/2024')");
        db.execSQL("insert into spchitiet values(1,1,1,1,400,29)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       if (newVersion != oldVersion){
           db.execSQL("drop table if exists thuthu");
           db.execSQL("drop table if exists giohang");
           db.execSQL("drop table if exists sanpham");
           db.execSQL("drop table if exists spchitiet");
           db.execSQL("drop table if exists chatlieu");
           db.execSQL("drop table if exists hinhanh");
           db.execSQL("drop table if exists danhgia");
           onCreate(db);
       }
    }
public Cursor rawQuery(String sqltop,Object o){
        return null;
}

}
