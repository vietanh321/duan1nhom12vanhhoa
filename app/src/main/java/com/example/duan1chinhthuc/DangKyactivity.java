package com.example.duan1chinhthuc;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.duan1chinhthuc.DAO.ThuThuDao;

public class DangKyactivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_kyactivity);

        EditText txtma = findViewById(R.id.txtma);
        EditText txtten = findViewById(R.id.txtten);
        EditText txtpass = findViewById(R.id.txtpass);
        Button btndk = findViewById(R.id.btndk);
        ThuThuDao dao = new ThuThuDao(this);

        btndk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = txtma.getText().toString();
                String pass = txtpass.getText().toString();
                String ten = txtten.getText().toString();

                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(ten)) {
                    Toast.makeText(DangKyactivity.this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    // Kiểm tra tài khoản đã tồn tại hay chưa
                    if (dao.checkUserExists(user)) {
                        Toast.makeText(DangKyactivity.this, "Tài khoản đã tồn tại", Toast.LENGTH_SHORT).show();
                    } else {
                        // Tiến hành đăng ký
                        if (dao.signup(user, ten, pass)) {
                            Toast.makeText(DangKyactivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                            // Chuyển hướng đến hoạt động đăng nhập sau khi đăng ký thành công
                            Intent intent = new Intent(DangKyactivity.this, dangnhap.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("TaiKhoan", user);
                            bundle.putString("MatKhau", pass);
                            intent.putExtras(bundle);
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
