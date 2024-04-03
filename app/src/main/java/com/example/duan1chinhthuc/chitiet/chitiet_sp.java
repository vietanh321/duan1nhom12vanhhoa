package com.example.duan1chinhthuc.chitiet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.duan1chinhthuc.Frament.Fragment_home;
import com.example.duan1chinhthuc.R;
import com.example.duan1chinhthuc.giohang;
import com.example.duan1chinhthuc.mode.San_Pham;
import com.example.duan1chinhthuc.mode.gio_hang;

import java.util.ArrayList;

public class chitiet_sp extends AppCompatActivity {
    San_Pham product = new San_Pham();

    TextView txt_nameproduct,txt_loaiproduct,txt_price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitiet_sp);

        TextView ten = findViewById(R.id.item_ten_sp_home_12);
        TextView tieude = findViewById(R.id.item_tieude_sp_home_12);
        TextView trangthai = findViewById(R.id.item_trangthai_sp_home_12);
        TextView tenchatlieu = findViewById(R.id.item_tenCL_sp_home_12);
        TextView giatien = findViewById(R.id.item_giatien_sp_home_12);
        TextView size = findViewById(R.id.item_Size_sp_home_12);
        product = (San_Pham) getIntent().getSerializableExtra("thongtinchitiet");
        ten.setText(String.valueOf(product.getTensp()));
        tieude.setText(String.valueOf(product.getTieude()));
        trangthai.setText(String.valueOf(product.getTrangthai()));
        tenchatlieu.setText(String.valueOf(product.getTenchatlieu()));
        giatien.setText(String.valueOf(product.getGiatien()));
        size.setText(String.valueOf(product.getSize()));

        Button addToCartButton = findViewById(R.id.btn_add_cart12);
        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                product = (San_Pham) getIntent().getSerializableExtra("thongtinchitiet");
                // Tạo một Bundle để chứa thông tin sản phẩm
                Bundle bundle = new Bundle();
                bundle.putString("tensp",ten.toString());
                bundle.putInt("gia", Integer.parseInt(giatien.getText().toString()));

                // Gửi Bundle qua Intent đến Activity giỏ hàng
                Intent intent = new Intent(chitiet_sp.this, giohang.class);
                intent.putExtras(bundle);
                startActivity(intent);

//                // Lấy thông tin sản phẩm từ Intent hoặc từ các trường trong Activity
//                int productId = getIntent().getIntExtra("ten");
//                String productName = getIntent().getStringExtra("PRODUCT_NAME");
//                String productPrice = getIntent().getStringExtra("PRODUCT_PRICE");
//
//                // Tạo một đối tượng sản phẩm mới
//                gio_hang product = new gio_hang(productId, productName, productPrice);
//
//                // Gọi phương thức để thêm sản phẩm vào giỏ hàng
//                addToCart(product);
            }
        });


        getData();

    }
    private void getData(){
        product = (San_Pham) getIntent().getSerializableExtra("thongtinchitiet");
      int  id = product.getId_sanpham();
       String name = product.getTensp();
     int   giasp = product.getGiatien();

    }
}