package com.example.duan1chinhthuc.Frament;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.duan1chinhthuc.DangKyactivity;
import com.example.duan1chinhthuc.Database.DbHelper;
import com.example.duan1chinhthuc.R;
import com.example.duan1chinhthuc.dangnhap;

public class Fragment_canhan extends Fragment {

    private TextView txtTaiKhoan, txtHoTen;
    private Button btnDoiMatKhau, btnDangXuat;
    private DbHelper dbHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_canhan, container, false);

        dbHelper = new DbHelper(getActivity());
        txtTaiKhoan = view.findViewById(R.id.txtTaiKhoan);
        txtHoTen = view.findViewById(R.id.txtHoTen);
        btnDoiMatKhau = view.findViewById(R.id.btnDoiMatKhau);
        btnDangXuat = view.findViewById(R.id.btnDangXuat);

        // Lấy thông tin tài khoản từ cơ sở dữ liệu và hiển thị
        getAccountInfo();

        // Xử lý sự kiện nút Đổi mật khẩu
        btnDoiMatKhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Gọi phương thức đổi mật khẩu
                changePassword();
            }
        });

        // Xử lý sự kiện nút Đăng xuất
        btnDangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Thực hiện đăng xuất
                logout();
            }
        });

        return view;
    }

    private void getAccountInfo() {
        // Mở cơ sở dữ liệu để truy vấn
        dbHelper = new DbHelper(getActivity());
        Cursor cursor = dbHelper.getReadableDatabase().rawQuery("SELECT * FROM thuthu", null);

        // Kiểm tra xem dữ liệu có sẵn hay không
        if (cursor != null && cursor.moveToFirst()) {
            // Lấy thông tin tài khoản từ cơ sở dữ liệu và hiển thị lên giao diện
            String taiKhoan = cursor.getString(cursor.getColumnIndex("matt"));
            String hoTen = cursor.getString(cursor.getColumnIndex("hoten"));
            txtTaiKhoan.setText("Tài khoản: " + taiKhoan);
            txtHoTen.setText("Họ tên: " + hoTen);
        } else {
            // Hiển thị thông báo nếu không tìm thấy thông tin tài khoản
            Toast.makeText(getActivity(), "Không tìm thấy thông tin tài khoản", Toast.LENGTH_SHORT).show();
        }
    }

    private void changePassword() {
        // Tạo Intent để mở Activity Đổi mật khẩu
        Intent intent = new Intent(getActivity(), DangKyactivity.class);
        startActivity(intent);
    }

    private void logout() {
        // Thực hiện đăng xuất bằng cách đóng Activity hiện tại và chuyển về màn hình đăng nhập
        getActivity().finish();
        Intent intent = new Intent(getActivity(), dangnhap.class);
        startActivity(intent);
    }
}
