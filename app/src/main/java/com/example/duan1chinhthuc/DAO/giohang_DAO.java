package com.example.duan1chinhthuc.DAO;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.duan1chinhthuc.Database.DbHelper;
import com.example.duan1chinhthuc.mode.San_Pham;

import java.util.ArrayList;

public class giohang_DAO {
    Context context;
    private final DbHelper dbHelper;

    public giohang_DAO(Context context) {
        dbHelper  = new DbHelper(context);
    }



    public class ProductDAO {
        private ArrayList<San_Pham> productList;


        public ArrayList<San_Pham> getAllProducts() {
            return productList;
        }
    }

    public ArrayList<San_Pham> getDS_sanpham(){
        ArrayList<San_Pham> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();//
        try{
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT ct.Id_spchitiet ,ct.Tensp,ct.tieude,ct.ngaydangban,ct.trangthai,cl.Id_chatlieu,cl.tenchatlieu,ha.hinhanh,ha.urlhinhanh,ct.Id_spchitiet,ct.gia,ct.size \n" +
                    "FROM  spchitiet ct,hinhanh ha, chatlieu cl \n"+
                    "WHERE  ct.Id_chatlieu = cl.Id_chatlieu and ct.Id_hinhanh = ha.hinhanh ",null);
            if (cursor.getCount() > 0){
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    list.add(new San_Pham(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4), cursor.getInt(5),cursor.getString(6), cursor.getInt(7),cursor.getInt(8),cursor.getInt(9),cursor.getInt(10),cursor.getInt(11)));
                    cursor.moveToNext();
                }
            }
        }catch (Exception e){
            Log.i(TAG, "loi", e);
        }
        return list;
    }
    //    public ArrayList<SanPhamChiTiet> getDS_sanpham_shrot(){
//        ArrayList<SanPhamChiTiet> list = new ArrayList<>();
//        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();//
//        try{
//            Cursor cursor = sqLiteDatabase.rawQuery("SELECT ct.Tensp,ha.hinhanh,ha.urlhinhanh,ct.gia \n" +
//                    "FROM  spchitiet ct,hinhanh ha, chatlieu cl \n"+
//                    "WHERE  ct.Id_chatlieu = cl.Id_chatlieu and ct.Id_hinhanh = ha.hinhanh ",null);
//            if (cursor.getCount() > 0){
//                cursor.moveToFirst();
//                while (!cursor.isAfterLast()){
//                    list.add(new San_Pham(cursor.getString(0),cursor.getInt(1),cursor.getInt(2),cursor.getInt(3)));
//                    cursor.moveToNext();
//                }
//            }
//        }catch (Exception e){
//            Log.i(TAG, "loi", e);
//        }
//        return list;
//    }
    public boolean themSP(int id_sanpham , String tensp, String tieude, String ngaydangban, String trangthai, int idchatlieu, int hinhanh, int giatien, int size){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Id_spchitiet",id_sanpham);
        values.put("Tensp", tensp);
        values.put("tieude", tieude);
        values.put("ngaydangban", ngaydangban);
        values.put("trangthai", trangthai);
        values.put("Id_chatlieu", idchatlieu);
        values.put("Id_hinhanh",hinhanh);
        values.put("gia", giatien);
        values.put("size", size);
        long kt = db.insert("spchitiet" , null, values);
        return (kt>0);
    }

    public  boolean capnhatsanpham(San_Pham pm){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from spchitiet where Id_spchitiet = ?", new String[]{String.valueOf(pm.getId_sanpham())});
        if(cursor.getCount() > 0) {
            ContentValues values = new ContentValues();
            values.put("Id_spchitiet",pm.getId_sanpham());
            values.put("Tensp", pm.getTensp());//gia tri(lay matv)
            values.put("tieude", pm.getTieude());
            values.put("trangthai", pm.getTrangthai());
            values.put("ngaydangban", pm.getNgaydangban());
            values.put("Id_chatlieu", pm.getId_chatlieu());
            values.put("Id_hinhanh",pm.getHinhanh());
            values.put("gia", pm.getGiatien());
            values.put("size", pm.getSize());
            long row = db.update("spchitiet",  values,  "Id_spchitiet = ?", new String[]{String.valueOf(pm.getId_sanpham())});
            return (row>0);
        }
        return false;
    }
    public boolean delete_sp(int mapm){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from spchitiet where Id_spchitiet = ?", new String[]{String.valueOf(mapm)});
        if(cursor.getCount() > 0){
            long kt = db.delete("spchitiet", "Id_spchitiet =?", new String[]{String.valueOf(mapm)}) ;
            return true;
        }
        return false;
    }
}
