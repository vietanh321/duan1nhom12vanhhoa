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

public class Home_DAO {

    Context context;
    private final DbHelper dbHelper;

    public Home_DAO(Context context) {
        dbHelper  = new DbHelper(context);
    }

    public ArrayList<San_Pham> getDS_sanpham(){
        ArrayList<San_Pham> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();//
        try{
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT sp.Id_sanpham ,sp.Tensp,sp.tieude,sp.ngaydangban,sp.trangthai,cl.Id_chatlieu,cl.tenchatlieu,ha.hinhanh,ha.urlhinhanh,ct.Id_spchitiet,ct.gia,ct.size \n" + "FROM sanpham sp, spchitiet ct,hinhanh ha, chatlieu cl \n"+
                    "WHERE sp.Id_sanpham = ct.Id_sanpham and ct.Id_hinhanh = ha.hinhanh ",null);
            if (cursor.getCount() > 0){
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    list.add(new San_Pham(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getInt(5),cursor.getString(6),cursor.getInt(7),cursor.getInt(8),cursor.getInt(9),cursor.getInt(10),cursor.getInt(11)));
                    cursor.moveToNext();
                }
            }
        }catch (Exception e){
            Log.i(TAG, "loi", e);
        }
        return list;
    }
    public boolean themSP(int id_sanpham ,String tensp, String tieude,String ngaydangban,String trangthai,String tenchatlieu,int giatien,int size){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Id_sanpham",id_sanpham);
        values.put("Tensp", tensp);
        values.put("tieude", tieude);
        values.put("ngaydangban", ngaydangban);
        values.put("trangthai", trangthai);
        values.put("tenchatlieu", tenchatlieu);
        values.put("gia", giatien);
        values.put("size", size);
        long kt = db.insert("\"SELECT sp.Id_sanpham ,sp.Tensp,sp.tieude,sp.ngaydangban,sp.trangthai,cl.Id_chatlieu,cl.tenchatlieu,ha.hinhanh,ha.urlhinhanh,ct.Id_spchitiet,ct.gia,ct.size \\n\" + \"FROM sanpham sp, spchitiet ct,hinhanh ha, chatlieu cl \\n\"+\n" +
                "                    \"WHERE sp.Id_sanpham = ct.Id_sanpham and ct.Id_hinhanh = ha.hinhanh \"" , null, values);
        return (kt>0);
    }

    public  boolean capnhatphieumuon(San_Pham pm){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from sanpham where Id_sanpham = ?", new String[]{String.valueOf(pm.getId_sanpham())});
        if(cursor.getCount() > 0) {
            ContentValues values = new ContentValues();
            values.put("Id_sanpham",pm.getId_sanpham());
            values.put("Tensp", pm.getTensp());//gia tri(lay matv)
            values.put("tieude", pm.getTieude());
            values.put("trangthai", pm.getTrangthai());
            values.put("ngaydangban", pm.getNgaydangban());
            long row = db.update("sanpham",  values,  "Id_sanpham = ?", new String[]{String.valueOf(pm.getId_sanpham())});
            return (row>0);
        }
        return false;
    }
    public boolean delete(int mapm){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from phieumuon where mapm = ?", new String[]{String.valueOf(mapm)});
        if(cursor.getCount() > 0){
            long kt = db.delete("phieumuon", "mapm =?", new String[]{String.valueOf(mapm)}) ;
            return true;
        }
        return false;
    }

}
