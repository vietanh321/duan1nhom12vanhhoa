package com.example.duan1chinhthuc.DAO;

import static android.content.Context.MODE_PRIVATE;
import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.duan1chinhthuc.Database.DbHelper;
import com.example.duan1chinhthuc.mode.Donhang;
import com.example.duan1chinhthuc.mode.San_Pham;
import com.example.duan1chinhthuc.mode.gettkmk;

import java.util.ArrayList;

public class DAO_gettkmk {
    Context context;
    private final DbHelper dbHelper;

    public DAO_gettkmk(Context context) {
        dbHelper = new DbHelper(context);
    }

    public ArrayList<gettkmk> hienthijtkmk(){
        ArrayList<gettkmk> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();//
        try{
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT * \n" +
                    "FROM  gettk \n",null);
            if (cursor.getCount() > 0){
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    list.add(new gettkmk(cursor.getString(0),cursor.getString(1)));
                    cursor.moveToNext();
                }
            }
        }catch (Exception e){
            Log.i(TAG, "loi", e);
        }
        return list;
    }

    public boolean themtkmk(String tk , String mk) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("tk", tk);
        values.put("mk", mk);

        long kt = db.insert("gettk" , null, values);
        return (kt>0);

    }
    public boolean delete_tkmk(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("gettk", null, null);
        db.close();

        return false;
    }


}
