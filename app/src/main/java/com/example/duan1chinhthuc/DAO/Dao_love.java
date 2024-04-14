package com.example.duan1chinhthuc.DAO;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.duan1chinhthuc.Database.DbHelper;
import com.example.duan1chinhthuc.mode.Donhang;
import com.example.duan1chinhthuc.mode.love_model;

import java.util.ArrayList;

public class Dao_love {
    private SQLiteDatabase db;
    private Context context;
    DbHelper myDbHelper;

    public Dao_love( Context context) {
        this.context = context;
        myDbHelper = new DbHelper(context);
        db = myDbHelper.getWritableDatabase();
    }

    public ArrayList<love_model> get_ds_love_sp() {
        ArrayList<love_model> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = myDbHelper.getReadableDatabase();//
        try{
            Cursor cursor = sqLiteDatabase.query("love", null, null, null, null, null, null);
            if (cursor.getCount() > 0){
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    list.add(new love_model(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getInt(3),cursor.getInt(4),cursor.getString(5)));
                    cursor.moveToNext();
                }
            }
        }catch (Exception e){
            Log.i(TAG, "loi", e);
        }
        return list;
    }
    public boolean addSanPhamtoLove(int id , String ten ,int gia,String tieude,int id_user) {
        SQLiteDatabase db = myDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id_sp", id);
        values.put("ten_sp",ten);
        values.put("gia",gia);
        values.put("tieude",tieude);
        values.put("id_user",id_user);
        long kt = db.insert("love" , null, values);
        return (kt>0);
    }
    public int deleteRowLove(love_model cart){
        String[] dk = new String[]{String.valueOf(cart.getId_love())};
        return db.delete("love","id_love=?",dk);

    }

//người dùng

    public ArrayList<love_model> get_ds_love_sp_user(int id) {
        ArrayList<love_model> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = myDbHelper.getReadableDatabase();//
        try{
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT  * \n" +
                    "FROM   love \n"+
                    "WHERE id_user = ? ",new String[]{String.valueOf(id)});
            if (cursor.getCount() > 0){
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    list.add(new love_model(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getInt(3),cursor.getInt(4),cursor.getString(5)));
                    cursor.moveToNext();
                }
            }
        }catch (Exception e){
            Log.i(TAG, "loi", e);
        }
        return list;
    }
    public boolean delete(int mapm){
        SQLiteDatabase db = myDbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from love where id_love = ?", new String[]{String.valueOf(mapm)});
        if(cursor.getCount() > 0){
            long kt = db.delete("love", "id_love =?", new String[]{String.valueOf(mapm)}) ;
            return true;
        }
        return false;
    }
}
