package com.example.duan1chinhthuc.Frament_user;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.duan1chinhthuc.Activity_user.UpdatePasswordActivity;
import com.example.duan1chinhthuc.DAO.UpdateInformationFragment;
import com.example.duan1chinhthuc.Database.DbHelper;
import com.example.duan1chinhthuc.R;
import com.example.duan1chinhthuc.Activity_user.dangnhap;

public class Fragment_canhan extends Fragment {

    private TextView txtTaiKhoan;
    private TextView txtHoTen;
    private Button btnDoiMatKhau, btnDangXuat;
    private DbHelper dbHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_canhan, container, false);

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("Thongtin_tt", Context.MODE_PRIVATE);
        String hoten = sharedPreferences.getString("hoten", "");

        dbHelper = new DbHelper(getActivity());

        txtHoTen = view.findViewById(R.id.txtHoTen);
        btnDoiMatKhau = view.findViewById(R.id.btnDoiMatKhau);
        btnDangXuat = view.findViewById(R.id.btnDangXuat);
        txtHoTen.setText(hoten);

        ImageView updateInfoBtn = view.findViewById(R.id.update_information);

        updateInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToUpdateInformationFragment();
            }
        });

        btnDoiMatKhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToChangePasswordActivity();
            }
        });

        btnDangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLogoutConfirmationDialog();
            }
        });

        return view;
    }

    private void moveToUpdateInformationFragment() {
        Intent intent = new Intent(getActivity(), UpdateInformationFragment.class);
        startActivity(intent);
    }

    private void moveToChangePasswordActivity() {
        Intent intent = new Intent(getActivity(), UpdatePasswordActivity.class);
        startActivity(intent);
    }

    private void showLogoutConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Thông báo");
        builder.setMessage("Bạn có muốn đăng xuất không?");
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                logout();
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    private void logout() {
        getActivity().finish();
        Intent intent = new Intent(getActivity(), dangnhap.class);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("Thongtin_tt", Context.MODE_PRIVATE);
        String hoten = sharedPreferences.getString("hoten", "");
        txtHoTen.setText(hoten);
    }
}
