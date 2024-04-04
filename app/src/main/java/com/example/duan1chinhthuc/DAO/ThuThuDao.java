package com.example.duan1chinhthuc.DAO;

import static android.content.Context.MODE_PRIVATE;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.util.Log;

import com.example.duan1chinhthuc.Database.DbHelper;
import com.example.duan1chinhthuc.mode.San_Pham;
import com.example.duan1chinhthuc.mode.nguoidung;

import java.util.ArrayList;

public class  ThuThuDao {
    private final DbHelper dbHelper;
    private final SharedPreferences sharedPreferences;

    public ThuThuDao(Context context) {
        dbHelper = new DbHelper(context);
        sharedPreferences = context.getSharedPreferences("Thongtin", MODE_PRIVATE);
    }


    public ArrayList<nguoidung> getDS_nguoidung(){
        ArrayList<nguoidung> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();//
        try{
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT  *\n" +
                    "FROM  thuthu where loaitaikhoan = 'thuthu' \n",null);
            if (cursor.getCount() > 0){
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    list.add(new nguoidung(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3)));
                    cursor.moveToNext();
                }
            }
        }catch (Exception e){
            Log.i(TAG, "loi", e);
        }
        return list;
    }

    public boolean login(String matt, String matkhau) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from thuthu where matt =? and matkhau =?", new String[]{matt, matkhau});
        if (cursor.getCount() != 0) {
            cursor.moveToFirst();
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("matt", cursor.getString(0));
            editor.putString("loaitaikhoan", cursor.getString(3));
            editor.putString("hoten", cursor.getString(1));
            editor.apply();
            cursor.close();
            db.close();
            return true;
        } else {
            cursor.close();
            db.close();
            return false;
        }
    }

    public boolean signup(String matt, String ten, String matkhau) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("matt", matt);
        values.put("hoten", ten);
        values.put("matkhau", matkhau);
        values.put("loaitaikhoan", "thuthu");

        long result = db.insert("thuthu", null, values);
        db.close();

        if (result != -1) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("matt", matt);
            editor.putString("loaitaikhoan", "thuthu");
            editor.putString("hoten", ten);
            editor.putString("matkhau", matkhau);
            editor.apply();
            return true;
        }
        return false;
    }

    public boolean checkUserExists(String matt) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM thuthu WHERE matt = ?", new String[]{matt});
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        db.close();
        return exists;
    }

    public int capnhatpass(String user, String cu, String moi) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from thuthu where matt = ? and matkhau = ?", new String[]{user, cu});
        if (cursor.getCount() > 0) {
            ContentValues values = new ContentValues();
            values.put("matkhau", moi);
            long kt = db.update("thuthu", values, "matt =?", new String[]{user});
            cursor.close();
            db.close();
            if (kt != -1) return 1;
        }
        cursor.close();
        db.close();
        return 0;
    }

    public boolean delete(String mapm){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from thuthu where matt = ?", new String[]{String.valueOf(mapm)});
        if(cursor.getCount() > 0){
            long kt = db.delete("thuthu", "matt =?", new String[]{String.valueOf(mapm)}) ;
            return true;
        }
        return false;
    }
}
