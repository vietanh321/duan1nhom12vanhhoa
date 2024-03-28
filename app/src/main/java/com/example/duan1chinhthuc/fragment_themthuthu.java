package com.example.duan1chinhthuc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.duan1chinhthuc.DAO.ThuThuDao;
import com.example.duan1chinhthuc.DAO.ThuThuDao;

public class fragment_themthuthu extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_themthuthu, container, false);
        EditText txtma = view.findViewById(R.id.ma_tk);
        EditText txtten = view.findViewById(R.id.ten_tk);
        EditText txtpass = view.findViewById(R.id.matkhau_tk);
        Button btndk = view.findViewById(R.id.dangky);
        ThuThuDao dao = new ThuThuDao(getContext());
        btndk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtma.equals("")){
                    Toast.makeText(getContext(), "không để trống Thông tin", Toast.LENGTH_SHORT).show();
                }if(txtpass.equals("")){
                    Toast.makeText(getContext(), "không để trống Thông tin", Toast.LENGTH_SHORT).show();
                }if (txtten.equals("")){
                    Toast.makeText(getContext(), "không để trống Thông tin", Toast.LENGTH_SHORT).show();
                }else {
                    String user = txtma.getText().toString();
                    String pass = txtpass.getText().toString();
                    String ten = txtten.getText().toString();
                    if(dao.signup(user,ten, pass)){
                        Toast.makeText(getContext(), "Thành công", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getContext(), "Tài khoản trùng", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        return view;
    }
}
