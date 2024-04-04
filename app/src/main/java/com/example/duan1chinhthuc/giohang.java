package com.example.duan1chinhthuc;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1chinhthuc.Adapter.ProductAdapter_cart;
import com.example.duan1chinhthuc.Adapter.adapter_QL_donhang;
import com.example.duan1chinhthuc.DAO.DonHang_DAO;
import com.example.duan1chinhthuc.DAO.Home_DAO;
import com.example.duan1chinhthuc.mode.Donhang;
import com.example.duan1chinhthuc.mode.gio_hang;

import java.util.ArrayList;

public class giohang extends AppCompatActivity {

    RecyclerView rcv;
    DonHang_DAO dao;
    private adapter_QL_donhang adapter;
    private ArrayList<Donhang> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giohang);

            rcv = findViewById(R.id.recyclerView);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            rcv.setLayoutManager(layoutManager);

            dao = new DonHang_DAO(this);
            list = dao.getDS_donhang();
            adapter = new adapter_QL_donhang(list, this);
            rcv.setAdapter(adapter);



      ImageView back = findViewById(R.id.back_cart);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(giohang.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }



}