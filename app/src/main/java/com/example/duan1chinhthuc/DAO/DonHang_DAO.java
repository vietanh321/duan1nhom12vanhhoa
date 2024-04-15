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
            Cursor cursor = sqLiteDatabase.query("DONHANG", null, null, null, null, null, null);
            if (cursor.getCount() > 0){
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    list.add(new Donhang(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getInt(3), cursor.getInt(4),cursor.getInt(5),cursor.getString(6),cursor.getInt(7),cursor.getString(8),cursor.getString(9)));
                    cursor.moveToNext();
                }
            }
        }catch (Exception e){
            Log.i(TAG, "loi", e);
        }
        return list;
    }


    public ArrayList<Donhang> getDS_donhang1(){
        ArrayList<Donhang> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();//
        try{
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT  * \n" +
                    "FROM   DONHANG dh \n"+
                    "WHERE  dh.trangthai = 'chờ xác nhận' ",null);
            if (cursor.getCount() > 0){
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    list.add(new Donhang(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getInt(3), cursor.getInt(4),cursor.getInt(5),cursor.getString(6),cursor.getInt(7)));
                    cursor.moveToNext();
                }
            }
        }catch (Exception e){
            Log.i(TAG, "loi", e);
        }
        return list;
    }

    public ArrayList<Donhang> getDS_donhang2(){
        ArrayList<Donhang> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();//
        try{
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT  * \n" +
                    "FROM   DONHANG dh \n"+
                    "WHERE  dh.trangthai = 'đang giao hàng' ",null);
            if (cursor.getCount() > 0){
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    list.add(new Donhang(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getInt(3), cursor.getInt(4),cursor.getInt(5),cursor.getString(6),cursor.getInt(7)));                    cursor.moveToNext();
                }
            }
        }catch (Exception e){
            Log.i(TAG, "loi", e);
        }
        return list;
    }
    public ArrayList<Donhang> getDS_donhang3(){
        ArrayList<Donhang> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();//
        try{
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT  * \n" +
                    "FROM   DONHANG dh \n"+
                    "WHERE  dh.trangthai = 'đã giao' ",null);
            if (cursor.getCount() > 0){
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    list.add(new Donhang(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getInt(3), cursor.getInt(4),cursor.getInt(5),cursor.getString(6),cursor.getInt(7)));                    cursor.moveToNext();
                }
            }
        }catch (Exception e){
            Log.i(TAG, "loi", e);
        }
        return list;
    }




    public boolean them_donhang(int idSp12, String trangthai12, int size12, int email12,int tongtien,String ngay,int id,String sdt,String dc) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Id_spchitiet", idSp12);
        values.put("trangthai",trangthai12);
        values.put("size", size12);
        values.put("soluong_sp", email12);
        values.put("tongtien", tongtien);
        values.put("ngay", ngay);
        values.put("id_user", id);
        values.put("sdt", sdt);
        values.put("diachi", dc);
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

    //------------phần của người dùng-------------//

    public ArrayList<Donhang> getDS_donhang_user(int id){
        ArrayList<Donhang> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();//
        try{
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT  * \n" +
                    "FROM   DONHANG \n"+
                    "WHERE id_user = ? ",new String[]{String.valueOf(id)});
            if (cursor.getCount() > 0){
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    list.add(new Donhang(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getInt(3), cursor.getInt(4),cursor.getInt(5),cursor.getString(6),cursor.getInt(7)));                    cursor.moveToNext();
                }
            }
        }catch (Exception e){
            Log.i(TAG, "loi", e);
        }
        return list;
    }

    public  boolean capnhatdonhang_user(Donhang ls){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from DONHANG where id = ?", new String[]{String.valueOf(ls.getId())});
        if(cursor.getCount() > 0) {
            ContentValues values = new ContentValues();
            values.put("size", ls.getSize());
            values.put("soluong_sp", ls.getSoluong_sp());
            long kt = db.update("DONHANG", values, "id =?", new String[]{String.valueOf(ls.getId())});
            return (kt> 0);
        }
        return false;
    }
}
