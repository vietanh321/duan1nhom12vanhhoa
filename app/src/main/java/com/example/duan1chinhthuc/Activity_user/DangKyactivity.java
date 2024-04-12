package com.example.duan1chinhthuc.Activity_user;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.duan1chinhthuc.DAO.ThuThuDao;
import com.example.duan1chinhthuc.R;

public class DangKyactivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_kyactivity);

        EditText txtma = findViewById(R.id.txtma);
        EditText txtten = findViewById(R.id.txtten);
        EditText txtpass = findViewById(R.id.txtpass);
        EditText dc = findViewById(R.id.diachi);
        EditText sdt = findViewById(R.id.sodienthoai);
        Button btndk = findViewById(R.id.btndk);
        TextView b = findViewById(R.id.back);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangKyactivity.this, dangnhap.class);
                startActivity(intent);
                finish();
            }
        });
        ThuThuDao dao = new ThuThuDao(this);

        btndk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = txtma.getText().toString();
                String pass = txtpass.getText().toString();
                String ten = txtten.getText().toString();
                String dc1 = dc.getText().toString();
                String sdt1 = sdt.getText().toString();
                String regex = "^(09|03|07|08|05)[0-9]{9}$";
                if(sdt1.matches(regex)){
                    Toast.makeText(DangKyactivity.this, "Số điện thoại phải là 9 số", Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(ten) || TextUtils.isEmpty(dc1)) {
                    Toast.makeText(DangKyactivity.this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    // Kiểm tra tài khoản đã tồn tại hay chưa
                    if (dao.checkUserExists(user)) {
                        Toast.makeText(DangKyactivity.this, "Tài khoản đã tồn tại", Toast.LENGTH_SHORT).show();
                    } else {
                        // Tiến hành đăng ký
                        if (dao.signup(user, ten, pass,dc1, Integer.parseInt(sdt1))) {
                            Toast.makeText(DangKyactivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                            // Chuyển hướng đến hoạt động đăng nhập sau khi đăng ký thành công
                            Intent intent = new Intent(DangKyactivity.this, dangnhap.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(DangKyactivity.this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }
}
