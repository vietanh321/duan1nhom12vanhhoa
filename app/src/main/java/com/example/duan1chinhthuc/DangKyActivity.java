package com.example.duan1chinhthuc;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DangKyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitydangky);
        EditText edttaikhoan=findViewById(R.id.edttaikhoan);
        EditText edtmatkhau=findViewById(R.id.edtmatkhau);
        EditText edtnhaplaimatkhau=findViewById(R.id.edtnhaplaimatkhau);
        Button btndangky=findViewById(R.id.btndangky);
        btndangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taikhoan=edttaikhoan.getText().toString();
                String matkhau=edtmatkhau.getText().toString();
                String nhaplaimatkhau=edtnhaplaimatkhau.getText().toString();
                if(TextUtils.isEmpty(taikhoan)|TextUtils.isEmpty(matkhau)|TextUtils.isEmpty(nhaplaimatkhau)) {
                    Toast.makeText(DangKyActivity.this, "Bạn Chưa điền hết thông tin", Toast.LENGTH_SHORT).show();
                }else{
                    if(matkhau.equals(nhaplaimatkhau)){
                        Intent intent=new Intent(DangKyActivity.this, DangnhapActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("TaiKhoan",taikhoan);
                        bundle.putString("MatKhau",matkhau);
                        intent.putExtras(bundle);
                        Toast.makeText(DangKyActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }
                }
                }

        });
    }
}