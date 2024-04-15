package com.example.duan1chinhthuc.DAO;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.duan1chinhthuc.Activity_user.dangnhap;
import com.example.duan1chinhthuc.Database.DbHelper;
import com.example.duan1chinhthuc.Frament_user.Fragment_canhan;
import com.example.duan1chinhthuc.R;

public class UpdateInformationFragment extends AppCompatActivity {
    private TextView txtHoTen;
    private TextView textViewCurrentUsernameValue;
    private TextView textViewCurrentPhoneNumberValue;
    private TextView textViewCurrentAddressValue;
    private EditText editTextNewUsername;
    private EditText editTextNewPhoneNumber;
    private EditText editTextNewAddress;
    private Button buttonSave;
    private DbHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_update_information);

        txtHoTen = findViewById(R.id.txtHoTen);
        textViewCurrentUsernameValue = findViewById(R.id.textViewCurrentUsernameValue);
        textViewCurrentPhoneNumberValue = findViewById(R.id.textViewCurrentPhoneNumberValue);
        textViewCurrentAddressValue = findViewById(R.id.textViewCurrentAddressValue);
        editTextNewUsername = findViewById(R.id.editTextNewUsername);
        editTextNewPhoneNumber = findViewById(R.id.editTextNewPhoneNumber);
        editTextNewAddress = findViewById(R.id.editTextNewAddress);
        buttonSave = findViewById(R.id.buttonSave);
        databaseHelper = new DbHelper(this);

        loadDataFromDatabase();

        buttonSave.setOnClickListener(v -> {
            saveDataToDatabase();
            moveToFragment(new Fragment_canhan());
        });
    }

    private void loadDataFromDatabase() {
        SharedPreferences sharedPreferences = getSharedPreferences("Thongtin_tt", Context.MODE_PRIVATE);
        String currentUsername = sharedPreferences.getString("hoten", "");
        String currentPhoneNumber = sharedPreferences.getString("sodienthoai", "");
        String currentAddress = sharedPreferences.getString("diachi", "");

        textViewCurrentUsernameValue.setText(currentUsername);
        textViewCurrentPhoneNumberValue.setText(currentPhoneNumber);
        textViewCurrentAddressValue.setText(currentAddress);
    }

    private void saveDataToDatabase() {
        String newUsername = editTextNewUsername.getText().toString();
        String newPhoneNumber = editTextNewPhoneNumber.getText().toString();
        String newAddress = editTextNewAddress.getText().toString();

        // Kiểm tra nếu các trường hoten, sodienthoai và diachi không được điền
        if (newUsername.isEmpty() || newPhoneNumber.isEmpty() || newAddress.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            return; // Kết thúc phương thức nếu thông tin không đầy đủ
        }

        // Lưu thông tin mới vào cơ sở dữ liệu
        boolean success = databaseHelper.updateUserInfo(newUsername, newPhoneNumber, newAddress);

        if (success) {
            Toast.makeText(this, "Thông tin đã được cập nhật", Toast.LENGTH_SHORT).show();
            // Chuyển sang trang đăng nhập
            Intent intent = new Intent(UpdateInformationFragment.this, dangnhap.class);
            startActivity(intent);
            finish(); // Đóng hoạt động hiện tại để ngăn ngừa quay lại bằng nút "Back"
        } else {
            Toast.makeText(this, "Cập nhật thông tin thất bại", Toast.LENGTH_SHORT).show();
        }
    }


    private void moveToFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
