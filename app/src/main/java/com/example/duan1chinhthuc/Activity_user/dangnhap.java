package com.example.duan1chinhthuc;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.duan1chinhthuc.DAO.DAO_gettkmk;
import com.example.duan1chinhthuc.DAO.ThuThuDao;
import com.example.duan1chinhthuc.Frament.Fragment_canhan;

public class dangnhap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);

        EditText txtuser = findViewById(R.id.txtuser);
        EditText txtpass = findViewById(R.id.txtpass);
        Button btndn = findViewById(R.id.btnlogin);
        Button btndk = findViewById(R.id.btnsignin);

        ThuThuDao dao = new ThuThuDao(this);
        DAO_gettkmk dao1 = new DAO_gettkmk(this);

        btndk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(dangnhap.this, DangKyactivity.class));
            }
        });

        btndn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongViewCast")
            @Override
            public void onClick(View v) {
                String user = txtuser.getText().toString();
                String pass = txtpass.getText().toString();

                if (dao.login(user, pass)) {
                    Toast.makeText(dangnhap.this, "Login thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(dangnhap.this, MainActivity.class));
                } else {
                    Toast.makeText(dangnhap.this, "Nhập sai", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
