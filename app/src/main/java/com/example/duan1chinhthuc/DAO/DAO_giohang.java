package com.example.duan1chinhthuc.DAO;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.duan1chinhthuc.Database.DbHelper;
import com.example.duan1chinhthuc.mode.Donhang;
import com.example.duan1chinhthuc.mode.gio_hang;

import java.util.ArrayList;

public class DAO_giohang {

    private SQLiteDatabase db;
    private Context context;
    DbHelper myDbHelper;

    public DAO_giohang( Context context) {
        this.context = context;
        myDbHelper = new DbHelper(context);
        db = myDbHelper.getWritableDatabase();
    }
    public ArrayList<gio_hang> getlistCart() {
        ArrayList<gio_hang> list = new ArrayList<>();
        try{
            Cursor cursor = db.rawQuery("SELECT * \n" + "FROM giohang  \n",null);
            if (cursor.getCount() > 0){
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    list.add(new gio_hang(
                            cursor.getInt(0)
                            , cursor.getInt(1)
                            , cursor.getInt(2)
                            , cursor.getInt(3)
                           ,cursor.getString(4)
                            , cursor.getInt(5)));
                    cursor.moveToNext();
                }
            }
        }catch (Exception e){
            Log.i(TAG, "loi", e);
        }
        return list;
    }
    public boolean them_sanpham_giohang(int id_sp, int gia_sp , String ten_sp, int soluong_sp, int id_user) {
        SQLiteDatabase db = myDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id_sp", id_sp);
        values.put("gia_sp", gia_sp);
        values.put("ten_sp", ten_sp);
        values.put("soluong_sp", soluong_sp);
        values.put("id_user", id_user);
        long kt = db.insert("giohang" , null, values);
        return (kt>0);

    }

    public boolean delete_sp(int mapm){
        SQLiteDatabase db = myDbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from giohang where id_giohang = ?", new String[]{String.valueOf(mapm)});
        if(cursor.getCount() > 0){
            long kt = db.delete("giohang", "id_giohang =?", new String[]{String.valueOf(mapm)}) ;
            return true;
        }
        return false;
    }
    public ArrayList<gio_hang> getDS_giohang_user(int id){
        ArrayList<gio_hang> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = myDbHelper.getReadableDatabase();//
        try{
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT  * \n" +
                    "FROM   giohang \n"+
                    "WHERE id_user = ? ",new String[]{String.valueOf(id)});
            if (cursor.getCount() > 0){
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    list.add(new gio_hang(
                            cursor.getInt(0)
                            , cursor.getInt(1)
                            , cursor.getInt(2)
                            , cursor.getInt(3)
                            ,cursor.getString(4)
                            , cursor.getInt(5)));
                    cursor.moveToNext();
                }
            }
        }catch (Exception e){
            Log.i(TAG, "loi", e);
        }
        return list;
    }
}
