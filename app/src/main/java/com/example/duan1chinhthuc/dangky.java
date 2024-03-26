package com.example.duan1chinhthuc;

import android.content.Context;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.duan1chinhthuc.R;
import com.example.duan1chinhthuc.DAO.ThuThuDao;

public class dangky extends AppCompatActivity {
Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dangky);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            EditText txtma = findViewById(R.id.ma_tk);
            EditText txtten = findViewById(R.id.ten_tk);
            EditText txtpass = findViewById(R.id.matkhau_tk);
            Button btndk = findViewById(R.id.dangky);
            ThuThuDao dao = new ThuThuDao(context);
            btndk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(txtma.equals("")){
                        Toast.makeText(context, "không để trống Thông tin", Toast.LENGTH_SHORT).show();
                    }if(txtpass.equals("")){
                        Toast.makeText(context, "không để trống Thông tin", Toast.LENGTH_SHORT).show();
                    }if (txtten.equals("")){
                        Toast.makeText(context, "không để trống Thông tin", Toast.LENGTH_SHORT).show();
                    }else {
                        String user = txtma.getText().toString();
                        String pass = txtpass.getText().toString();
                        String ten = txtten.getText().toString();
                        if(dao.signup(user,ten, pass)){
                            Toast.makeText(context, "Thành công", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(context, "Tài khoản trùng", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
            });
            return insets;
        });
    }
}