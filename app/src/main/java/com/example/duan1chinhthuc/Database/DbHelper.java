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
    public DbHelper(@Nullable Context context) {
        super(context, DB_name, null, 73);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String chitietdonhang = "CREATE TABLE CHITIETDONHANG(id integer, masp integer , giasp integer, soluong integer,matt text references thuthu(matt))";
        db.execSQL(chitietdonhang);
        String donhang = "CREATE TABLE DONHANG(id integer primary key, tenkhachhang text,sodienthoai integer, " +
                "email text,diachi text,Id_spchitiet references spchitiet(Id_spchitiet),trangthai text,size integer)";
        db.execSQL(donhang);


        String db_thuthu="create table thuthu(matt text primary key," + "hoten text," + "matkhau text," + "loaitaikhoan text)";
        db.execSQL(db_thuthu);



        String db_giohang="create table giohang(id_giohang text primary key ," + " Id_spchitiet text references spchitiet(Id_spchitiet),"+ "matt text references thuthu(matt),"+"soluongsp integer,Tensp text references spchitiet(Tensp),gia integer references spchitiet(gia))";
        db.execSQL(db_giohang);


        String db_spchitiet="create table spchitiet(Id_spchitiet integer primary key ,"
                + "Id_chatlieu integer references chatlieu(Id_chatlieu)," +
                " " + "Id_hinhanh integer references hinhanh(Id_hinhanh)," +
                " " + "gia integer," + "size integer,"+"tensp text,"+"tieude text,"+"trangthai text,"+"ngaydangban text,"+"idloaisp integer references loaisp(idloaisp))";
        db.execSQL(db_spchitiet);

        String db_loaisp="create table loaisp(idloaisp integer primary key," + "tenloai text)";
        db.execSQL(db_loaisp);


        String db_chatlieu="create table chatlieu(Id_chatlieu integer primary key," + "tenchatlieu text)";
        db.execSQL(db_chatlieu);
        String db_hinhanh="create table hinhanh(hinhanh integer primary key," + "urlhinhanh integer)";
        db.execSQL(db_hinhanh);
        String db_danhgia="create table danhgia(Id_danhgia text primary key," + "Id_taikhoan text references thuthu(matt) ," + "note text)";
        db.execSQL(db_danhgia);
        db.execSQL("INSERT INTO thuthu VALUES ('hoaddph46289','duy hoa','hoaddph46289','admin'),('hoaddph46289tt','thi thinh','hoaddph46289tt','thuthu'),('tv1','thi thinh','1','thuthu')");
        db.execSQL("INSERT INTO danhgia VALUES('dgia1','tk2','Sản phẩm đẹp')");

        db.execSQL("insert into hinhanh values(1,1)");
        db.execSQL("insert into chatlieu values(1,'cotton')");
        db.execSQL("insert into spchitiet values(1,1,1,400,29,'Nike Air Force 1 canvat','Top bán chạy','con hang','14/12/2024',1)");
        db.execSQL("insert into spchitiet values(4,1,1,400,29,'NIKE AF1 LV BÒ XANH','Top bán chạy','con hang','14/12/2024',1)");
        db.execSQL("insert into spchitiet values(5,1,1,400,29,'Giày Nike_Air Force 1','Top bán chạy','con hang','14/12/2024',1)");
        db.execSQL("insert into spchitiet values(6,1,1,400,29,'Convers Chuck taylor 1970s','Top bán chạy','con hang','14/12/2024',1)");
        db.execSQL("insert into spchitiet values(7,1,1,400,29,'Das Samba Classic','Top bán chạy','con hang','14/12/2024',1)");
        db.execSQL("insert into spchitiet values(8,1,1,400,29,'Asics Court MZ Cream Black Gum','Top bán chạy','con hang','14/12/2024',1)");
        db.execSQL("insert into spchitiet values(2,1,1,400,29,'Lười da bò','Top bán chạy','con hang','14/12/2024',2)");
        db.execSQL("insert into spchitiet values(3,1,1,400,29,'Penny Loafer Black','Top bán chạy','con hang','14/12/2024',2)");
        db.execSQL("insert into spchitiet values(9,1,1,400,29,'Penny Loafer Black','Top bán chạy','con hang','14/12/2024',2)");
        db.execSQL("insert into spchitiet values(10,1,1,400,29,'Giày Vans Old Skool','Top bán chạy','con hang','14/12/2024',2)");
        db.execSQL("insert into spchitiet values(11,1,1,400,29,'Penny Loafer Da TIBAS','Top bán chạy','con hang','14/12/2024',2)");
        db.execSQL("insert into spchitiet values(12,1,1,400,29,'GUDETU','Top bán chạy','con hang','14/12/2024',2)");
        db.execSQL("insert into spchitiet values(13,1,1,400,29,'Chelsea Boots Classic','Top bán chạy','con hang','14/12/2024',3)");
        db.execSQL("insert into spchitiet values(14,1,1,400,29,'Martin','Top bán chạy','con hang','14/12/2024',3)");
        db.execSQL("insert into spchitiet values(15,1,1,400,29,'Harness Boots','Top bán chạy','con hang','14/12/2024',3)");
        db.execSQL("insert into spchitiet values(16,1,1,400,29,'Boot ulzzang','Top bán chạy','con hang','14/12/2024',3)");
        db.execSQL("insert into spchitiet values(17,1,1,400,29,'Boots Zip Black','Top bán chạy','con hang','14/12/2024',3)");
        db.execSQL("insert into spchitiet values(18,1,1,400,29,'Chunky Combat Boots','Top bán chạy','con hang','14/12/2024',3)");
        db.execSQL("insert into spchitiet values(19,1,1,400,29,'Zip Boots','Top bán chạy','con hang','14/12/2024',3)");

        db.execSQL("insert into loaisp values(1,'Giày Thể Thao'),(2,'giày Lười'),(3,'Boot')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       if (newVersion != oldVersion){
           db.execSQL("drop table if exists thuthu");
           db.execSQL("drop table if exists giohang");
           db.execSQL("drop table if exists spchitiet");
           db.execSQL("drop table if exists chatlieu");
           db.execSQL("drop table if exists hinhanh");
           db.execSQL("drop table if exists danhgia");
           db.execSQL("drop table if exists CHITIETDONHANG");
           db.execSQL("drop table if exists DONHANG");
           db.execSQL("drop table if exists loaisp");
           onCreate(db);
       }
    }
public Cursor rawQuery(String sqltop,Object o){
        return null;
}

}
