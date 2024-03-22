package com.example.duan1chinhthuc.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DB_name="BG";
    public DbHelper(@Nullable Context context){super(context,DB_name,null,24);}
    @Override
    public void onCreate(SQLiteDatabase db) {
        String db_taikhoan="create table taikhoan(Id_taikhoan text primary key," + " matkhau text," + "hoten text,"+ "email text," + "sdt integer," + "diachi text," + "loaitk text)";
        db.execSQL(db_taikhoan);
        String db_giohang="create table giohang(Id_giohang text primary key," + " Id_taikhoan text references Id_giohang(Id_taikhoan))";
        db.execSQL(db_giohang);
        String db_sanpham="create table sanpham(Id_sanpham text primary key," + " Tensp text," + "tieude text,"+ "trangthai text," + "ngaydangban text)";
        db.execSQL(db_sanpham);
        String db_spchitiet="create table spchitiet(Id_spchitiet text primary key," + "Id_sanpham text references Id_spchitiet(Id_sanpham) ," + "Id_chatlieu text references Id_spchitiet(Id_chatlieu), " + "Id_hinhanh text references Id_spchitiet(Id_hinhanh), " + "gia text," + "size text)";
        db.execSQL(db_spchitiet);
        String db_chatlieu="create table chatlieu(Id_chatlieu text primary key," + "tenchatlieu text)";
        db.execSQL(db_chatlieu);
        String db_hinhanh="create table hinhanh(hinhanh text primary key," + "urlhinhanh text)";
        db.execSQL(db_hinhanh);
        String db_danhgia="create table danhgia(Id_danhgia text primary key," + "Id_taikhoan text references Id_danhgia(Id_taikhoan) ," + "note text)";
        db.execSQL(db_danhgia);
        db.execSQL("INSERT INTO taikhoan VALUES('tk1','mk1','vietanh','phucanh@gmail.com',0395972312,'haiduong','admin'),('tk2','mk2','hoa','hoa@gmail.com',0395972222,'hanoi','nguoidung')");
        db.execSQL("INSERT INTO giohang VALUES('giohang2','TK2')");
        db.execSQL("INSERT INTO sanpham VALUES('sp1','Giày Nike Sọc','cực cool','Còn Hàng','ng13thg5'),('sp2','Giày Nike Đen','cực SÌ Tin','Còn Hàng','ng11thg5'),('sp3','Giày Nike Trắng','cực ngầu','Còn Hàng','ng11thg5')");
        db.execSQL("INSERT INTO spchitiet VALUES('sp01','sp1','cl1','ảnh 01','Giá:1,000.000 đ','Size 41'),('sp02','sp1','cl1','ảnh 02','Giá:1,000.000 đ','Size 42'),('sp03','sp2','cl2','ảnh 03','Giá:100.000 đ','Size 41'),('sp04','sp3','cl3','ảnh 04','Giá:500.000 đ','Size 41')");
        db.execSQL("INSERT INTO chatlieu VALUES('cl1','Cao su nhân tạo'),('cl2','nhựa mềm'),('cl3','Cao su tự nhiên')");
        db.execSQL("INSERT INTO hinhanh VALUES('ảnh 01','url1'),('ảnh 02','url1'),('ảnh 03','url2'),('ảnh 04','url3')");
        db.execSQL("INSERT INTO danhgia VALUES('dgia1','tk2','Sản phẩm đẹp')");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       if (newVersion != oldVersion){
           db.execSQL("drop table if exists taikhoan");
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
