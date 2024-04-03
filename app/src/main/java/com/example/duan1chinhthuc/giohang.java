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
import com.example.duan1chinhthuc.DAO.Home_DAO;
import com.example.duan1chinhthuc.mode.gio_hang;

import java.util.ArrayList;

public class giohang extends AppCompatActivity {

    RecyclerView rcv;
    Home_DAO dao;
    private ProductAdapter_cart adapter;
    private ArrayList<gio_hang> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giohang);

        rcv = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rcv.setLayoutManager(layoutManager);

        dao = new Home_DAO(this);
        list = dao.getDS_sanpham_giohang();
        adapter = new ProductAdapter_cart(list, this);
        rcv.setAdapter(adapter);

//// Lấy Bundle từ Intent
//        Bundle bundle = getIntent().getExtras();
//        if (bundle != null) {
//
//
//            String productName = bundle.getString("tensp");
//            int productPrice = bundle.getInt("gia");
//
//            // Thêm sản phẩm vào giỏ hàng
//            // Giả sử bạn có một phương thức addProduct trong CartManager
//            gio_hang product = new gio_hang( productName, productPrice);
//            CartManager.getInstance().addProduct(product);
//        }

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