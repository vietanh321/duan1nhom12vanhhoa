package com.example.duan1chinhthuc.Activity_user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.duan1chinhthuc.Adapter.adapter_donhang_user;
import com.example.duan1chinhthuc.Adapter_admin.adapter_QL_donhang;
import com.example.duan1chinhthuc.DAO.DonHang_DAO;
import com.example.duan1chinhthuc.R;
import com.example.duan1chinhthuc.mode.Donhang;

import java.util.ArrayList;

public class order extends AppCompatActivity {
    RecyclerView rcv;
    DonHang_DAO dao;
    adapter_donhang_user adapter;
    ArrayList<Donhang> list;

    Context context;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        rcv = findViewById(R.id.rcv_QL_DH_user);

        dao = new DonHang_DAO(this);
        SharedPreferences sharedPreferences = getSharedPreferences("Thongtin_tt", Context.MODE_PRIVATE);
        String id = sharedPreferences.getString("id_usser","");
        list = dao.getDS_donhang_user(Integer.parseInt(id));
        Log.d("check", list.size()+"");
        adapter = new adapter_donhang_user(list, this);
        rcv.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rcv.setLayoutManager(layoutManager);
        adapter.notifyDataSetChanged();



        ImageView back = findViewById(R.id.back_oder);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(order.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }
}