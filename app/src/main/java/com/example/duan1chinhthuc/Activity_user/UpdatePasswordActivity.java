package com.example.duan1chinhthuc.Activity_user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.duan1chinhthuc.R;

public class UpdatePasswordActivity extends AppCompatActivity {

    private EditText editTextOldPassword;
    private EditText editTextNewPassword;
    private UpdatePassword updatePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_password_activity);

        editTextOldPassword = findViewById(R.id.editTextOldPassword);
        editTextNewPassword = findViewById(R.id.editTextNewPassword);
        Button buttonUpdate = findViewById(R.id.buttonUpdate);

        final Context context = this;
        updatePassword = new UpdatePassword(context);

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oldPassword = editTextOldPassword.getText().toString().trim();
                String newPassword = editTextNewPassword.getText().toString().trim();

                // Kiểm tra mật khẩu cũ và mật khẩu mới không được để trống
                if (oldPassword.isEmpty() || newPassword.isEmpty()) {
                    Toast.makeText(context, "Vui lòng nhập đủ mật khẩu cũ và mới", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Thực hiện cập nhật mật khẩu
                boolean success = updatePassword.updatePassword(oldPassword, newPassword);

                if (success) {
                    Toast.makeText(context, "Cập nhật mật khẩu thành công", Toast.LENGTH_SHORT).show();
                    // Chuyển sang MainActivity
                    Intent intent = new Intent(UpdatePasswordActivity.this, dangnhap.class);
                    startActivity(intent);
                    finish(); // Kết thúc Activity hiện tại
                } else {
                    Toast.makeText(context, "Cập nhật mật khẩu thất bại. Vui lòng kiểm tra lại mật khẩu cũ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
