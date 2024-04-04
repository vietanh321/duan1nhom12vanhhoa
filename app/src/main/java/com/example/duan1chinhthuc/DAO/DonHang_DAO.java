package com.example.duan1chinhthuc.DAO;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.duan1chinhthuc.Database.DbHelper;
import com.example.duan1chinhthuc.mode.Donhang;
import com.example.duan1chinhthuc.mode.San_Pham;
import com.example.duan1chinhthuc.mode.gio_hang;

import java.util.ArrayList;

public class DonHang_DAO {

    Context context;
    private final DbHelper dbHelper;

    public DonHang_DAO(Context context) {
        dbHelper  = new DbHelper(context);
    }





    public ArrayList<Donhang> getDS_donhang(){
        ArrayList<Donhang> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();//
        try{
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT  ct.Id_spchitiet,dh.id,dh.tenkhachhang ,dh.sodienthoai ,dh.email ,dh.diachi,dh.trangthai , dh.size \n" +
                    "FROM  spchitiet ct, DONHANG dh \n"+
                    "WHERE ct.Id_spchitiet = dh.Id_spchitiet  ",null);
            if (cursor.getCount() > 0){
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    list.add(new Donhang(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getInt(3),cursor.getString(4), cursor.getString(5),cursor.getString(6), cursor.getInt(7)));
                    cursor.moveToNext();
                }
            }
        }catch (Exception e){
            Log.i(TAG, "loi", e);
        }
        return list;
    }

    public ArrayList<Donhang> getDS_donhang_user(){
        ArrayList<Donhang> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();//
        try{
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT  ct.Id_spchitiet,dh.id,dh.tenkhachhang ,dh.sodienthoai ,dh.email ,dh.diachi,dh.trangthai , dh.size \n" +
                    "FROM  spchitiet ct, DONHANG dh \n"+
                    "WHERE ct.Id_spchitiet = dh.Id_spchitiet  ",null);
            if (cursor.getCount() > 0){
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    list.add(new Donhang(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getInt(3),cursor.getString(4), cursor.getString(5),cursor.getString(6), cursor.getInt(7)));
                    cursor.moveToNext();
                }
            }
        }catch (Exception e){
            Log.i(TAG, "loi", e);
        }
        return list;
    }


    public boolean them_donhang(int idDonhang12, int idSp12, String tenkhachhang12, int sodienthoai12, String email12, String diachi12, String trangthai12, int size12) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Id_spchitiet", idSp12);
        values.put("id",idDonhang12);
        values.put("tenkhachhang", tenkhachhang12);
        values.put("sodienthoai", sodienthoai12);
        values.put("email", email12);
        values.put("diachi", diachi12);
        values.put("trangthai",trangthai12);
        values.put("size", size12);
        long kt = db.insert("DONHANG" , null, values);
        return (kt>0);

    }


    public  boolean capnhatdonhang_admin(Donhang ls){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from DONHANG where id = ?", new String[]{String.valueOf(ls.getId())});
        if(cursor.getCount() > 0) {
            ContentValues values = new ContentValues();
            values.put("trangthai", ls.getTrangthaidonhang());
            long kt = db.update("DONHANG", values, "id =?", new String[]{String.valueOf(ls.getId())});
            return (kt> 0);
        }
        return false;
    }

    public boolean delete(int mapm){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from DONHANG where id = ?", new String[]{String.valueOf(mapm)});
        if(cursor.getCount() > 0){
            long kt = db.delete("DONHANG", "id =?", new String[]{String.valueOf(mapm)}) ;
            return true;
        }
        return false;
    }
}
