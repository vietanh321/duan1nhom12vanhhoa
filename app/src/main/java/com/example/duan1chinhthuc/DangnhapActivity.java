package com.example.duan1chinhthuc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DangnhapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);
        EditText edttaikhoan=findViewById(R.id.edttaikhoan);
        EditText edtmatkhau=findViewById(R.id.edtmatkhau);
        TextView txtquen=findViewById(R.id.txtquen);
        Button btndangnhap=findViewById(R.id.btndangnhap);
        Button btngg=findViewById(R.id.btngg);
        TextView txttaoacc=findViewById(R.id.txttaoacc);
        txtquen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(DangnhapActivity.this, QuenmatkhauActivity.class);
                startActivity(intent);
            }
        });
        txttaoacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangnhapActivity.this, DangKyActivity.class);
                startActivity(intent);
            }
        });
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =getIntent();
                Bundle bundle = intent.getExtras();
                if(bundle!=null){
                    String TaiKhoan= bundle.getString("TaiKhoan");
                    String MatKhau= bundle.getString("MatKhau");
                    boolean u=TaiKhoan.equals(edttaikhoan.getText().toString());
                    boolean p=MatKhau.equals(edtmatkhau.getText().toString());
                    if(u&&p){
                        Intent intent1=new Intent(DangnhapActivity.this, MainActivity.class);//Thay trang tiep theo
                        startActivity(intent1);
                        Toast.makeText(DangnhapActivity.this,"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(DangnhapActivity.this,"Đăng nhập thất bại ",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(DangnhapActivity.this, "Bạn chưa đăng ký", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}