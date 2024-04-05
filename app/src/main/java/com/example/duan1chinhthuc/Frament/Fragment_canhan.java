package com.example.duan1chinhthuc.Frament;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
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
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.duan1chinhthuc.Adapter.adapter_user;
import com.example.duan1chinhthuc.DAO.DAO_gettkmk;
import com.example.duan1chinhthuc.DAO.Home_DAO;
import com.example.duan1chinhthuc.DangKyactivity;
import com.example.duan1chinhthuc.Database.DbHelper;
import com.example.duan1chinhthuc.MainActivity;
import com.example.duan1chinhthuc.R;
import com.example.duan1chinhthuc.dangnhap;
import com.example.duan1chinhthuc.mode.San_Pham;
import com.example.duan1chinhthuc.mode.gettkmk;

import java.util.ArrayList;

public class Fragment_canhan extends Fragment {

    private TextView txtTaiKhoan, txtHoTen;
    private Button btnDoiMatKhau, btnDangXuat;
    private DbHelper dbHelper;
    ArrayList<gettkmk> list;
    DAO_gettkmk dao;
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
            @SuppressLint("Range") String taiKhoan = cursor.getString(cursor.getColumnIndex("matt"));
            @SuppressLint("Range") String hoTen = cursor.getString(cursor.getColumnIndex("hoten"));
            txtTaiKhoan.setText("  " + taiKhoan);
            txtHoTen.setText("  " + hoTen);
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
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Thông báo");
        builder.setMessage("Bạn có Muốn Đăng Xuất Không ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                getActivity().finish();
                Intent intent = new Intent(getActivity(), dangnhap.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
        // Thực hiện đăng xuất bằng cách đóng Activity hiện tại và chuyển về màn hình đăng nhập

    }
}
