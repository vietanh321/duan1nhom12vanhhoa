package com.example.duan1chinhthuc.Fragment_admin;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.duan1chinhthuc.Adapter.Home_adapter;
import com.example.duan1chinhthuc.DAO.Home_DAO;
import com.example.duan1chinhthuc.R;
import com.example.duan1chinhthuc.mode.SanPhamChiTiet;
import com.example.duan1chinhthuc.mode.San_Pham;

import java.util.ArrayList;

public class add_delete_update extends Fragment {
    RecyclerView rcv;
    Home_DAO dao;
    Home_adapter adapter;
    ArrayList<San_Pham> list;
    ArrayList<SanPhamChiTiet> list1;
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_delete_update, container, false);

        rcv = view.findViewById(R.id.add_sp_recycelview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rcv.setLayoutManager(layoutManager);

        dao = new Home_DAO(getContext());
        list = dao.getDS_sanpham();
        adapter = new Home_adapter(list, getContext());
        rcv.setAdapter(adapter);

        EditText id_SP = view.findViewById(R.id.edt_id_SP_ADD);
        EditText ten_SP = view.findViewById(R.id.edt_ten_SP_ADD);
        EditText tieude_SP = view.findViewById(R.id.edt_tieude_SP_ADD);
        EditText ngayban_SP = view.findViewById(R.id.edt_ngayban_SP_ADD);

        EditText trangthai_SP = view.findViewById(R.id.edt_Trangthai_SP_ADD);

        EditText tenchatlieu_SP = view.findViewById(R.id.edt_Tenchatlieu_SP_ADD);
        EditText hinhanh = view.findViewById(R.id.edt_hinhanh_SP_ADD);
        EditText giatien_SP = view.findViewById(R.id.edt_giatien_SP_ADD);

        EditText size_SP = view.findViewById(R.id.edt_Size_SP_ADD);
Button button = view.findViewById(R.id.add_SP_123);
        Button update = view.findViewById(R.id.update_SP_123);

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                int id = Integer.parseInt(id_SP.getText().toString());
//                String ten = ten_SP.getText().toString();
//                String tieude = tieude_SP.getText().toString();
//                String ngayban = ngayban_SP.getText().toString();
//                String trangthai = trangthai_SP.getText().toString();
//                int idchatlieu = Integer.parseInt(tenchatlieu_SP.getText().toString());
//                int giatien1 = Integer.parseInt(giatien_SP.getText().toString());
//                int hinanh1 = Integer.parseInt(hinhanh.getText().toString());
//                int size = Integer.parseInt(size_SP.getText().toString());
//                capnhapsanpham1(id,ten, tieude, ngayban, trangthai,idchatlieu,giatien1,hinanh1,size);
//
//            }
//        });

        button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        try {
            int id = Integer.parseInt(id_SP.getText().toString());
            String ten = ten_SP.getText().toString();
            String tieude = tieude_SP.getText().toString();
            String ngayban = ngayban_SP.getText().toString();
            String trangthai = trangthai_SP.getText().toString();
            int idchatlieu = Integer.parseInt(tenchatlieu_SP.getText().toString());
            int giatien1 = Integer.parseInt(giatien_SP.getText().toString());
            int hinanh1 = Integer.parseInt(hinhanh.getText().toString());
            int size = Integer.parseInt(size_SP.getText().toString());

            Boolean kt = dao.themSP(id,ten,tieude,ngayban,trangthai,idchatlieu,hinanh1,giatien1,size);

            if(kt){
                list.clear();
                list.addAll(dao.getDS_sanpham());
                adapter.notifyDataSetChanged();

            }
        }catch (Exception e){
            Log.i(TAG, "Fail", e);
        }
    }
});


        return view;
    }


//    private void capnhapsanpham1(int id, String tensp , String tieude, String ngaydangban, String trangthai, int Id_chatlieu, int hinhanh, int giatien, int size){
//        SharedPreferences sharedPreferences = getContext().getSharedPreferences("Thongtin", Context.MODE_PRIVATE);
//        String id_CL = sharedPreferences.getString("matt", "");
//        String id_HA = sharedPreferences.getString("matt", "");
//        //
//
//
//        San_Pham pm = new San_Pham( tensp, tieude, ngaydangban, trangthai, id_CL, id_HA,giatien,size);
//        boolean kt = dao.capnhatsanpham(pm);
//        if(kt){
//            list.clear();
//            list.addAll(dao.getDS_sanpham());
//            adapter.notifyDataSetChanged();
//            Toast.makeText(getContext(), "ok", Toast.LENGTH_SHORT).show();
//        }else{
//            Toast.makeText(getContext(), "fail", Toast.LENGTH_SHORT).show();
//        }
//
//    }


    }
