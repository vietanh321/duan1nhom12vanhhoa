//package com.example.duan1chinhthuc.chitiet;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.Toolbar;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.Spinner;
//import android.widget.TextView;
//
//import com.example.duan1chinhthuc.R;
//import com.example.duan1chinhthuc.mode.San_Pham;
//
//public class chitiet_sp extends AppCompatActivity {
//    Toolbar toolbar;
//    TextView txt_nameproduct,txt_loaiproduct,txt_price;
//    Spinner spn_soluong;
//    Button btn_giohang;
//    ImageView img_product;
//    String name, loai, image;
//    int giasp;
//    int id;
//    San_Pham product = new San_Pham(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getInt(5), cursor.getString(6), cursor.getInt(7), cursor.getInt(8), cursor.getInt(9), cursor.getInt(10), cursor.getInt(11), cursor.getInt(12), cursor.getString(13));
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_chitiet_sp);
//
//        TextView id = findViewById(R.id.item_id_sp_home_12);
//        TextView ten = findViewById(R.id.item_ten_sp_home_12);
//        TextView tieude = findViewById(R.id.item_tieude_sp_home_12);
//        TextView trangthai = findViewById(R.id.item_trangthai_sp_home_12);
//        TextView tenchatlieu = findViewById(R.id.item_tenCL_sp_home_12);
//        TextView giatien = findViewById(R.id.item_giatien_sp_home_12);
//        TextView size = findViewById(R.id.item_Size_sp_home_12);
//        product = (San_Pham) getIntent().getSerializableExtra("thongtinchitiet");
//        id.setText(String.valueOf(product.getId_sanpham()));
//        ten.setText(String.valueOf(product.getTensp()));
//        tieude.setText(String.valueOf(product.getTieude()));
//        trangthai.setText(String.valueOf(product.getTrangthai()));
//        tenchatlieu.setText(String.valueOf(product.getTenchatlieu()));
//        giatien.setText(String.valueOf(product.getGiatien()));
//        size.setText(String.valueOf(product.getSize()));
//
//        Button addToCartButton = findViewById(R.id.btn_add_cart12);
//        addToCartButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//
//
////                product = (San_Pham) getIntent().getSerializableExtra("thongtinchitiet");
////                // Tạo một Bundle để chứa thông tin sản phẩm
////                Bundle bundle = new Bundle();
////                bundle.putInt("Id_spchitiet", Integer.parseInt(id.getText().toString()));
////                bundle.putString("tensp",ten.getText().toString());
////                bundle.putInt("gia", Integer.parseInt(giatien.getText().toString()));
////
////                // Gửi Bundle qua Intent đến Activity giỏ hàng
////                Intent intent = new Intent(chitiet_sp.this, giohang.class);
////                intent.putExtras(bundle);
////                startActivity(intent);
//
////                // Lấy thông tin sản phẩm từ Intent hoặc từ các trường trong Activity
////                int productId = getIntent().getIntExtra("ten");
////                String productName = getIntent().getStringExtra("PRODUCT_NAME");
////                String productPrice = getIntent().getStringExtra("PRODUCT_PRICE");
////
////                // Tạo một đối tượng sản phẩm mới
////                gio_hang_activity product = new gio_hang_activity(productId, productName, productPrice);
////
////                // Gọi phương thức để thêm sản phẩm vào giỏ hàng
////                addToCart(product);
//            }
//        });
//
//
//        getData();
//
//    }
//    private void getData(){
//        product = (San_Pham) getIntent().getSerializableExtra("thongtinchitiet");
//      int  id = product.getId_sanpham();
//       String name = product.getTensp();
//     int   giasp = product.getGiatien();
//
//    }
//    private void Spiner() {
//        Integer[] soluong = new Integer[]{1,2,3};
//        ArrayAdapter<Integer> sl= new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, soluong);
//        spn_soluong.setAdapter(sl);
//    }
//    private void ActionBar() {
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//
//    }
//}