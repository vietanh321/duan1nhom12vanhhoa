package com.example.duan1chinhthuc.Frament;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1chinhthuc.Adapter.Home_adapter;
import com.example.duan1chinhthuc.DAO.Home_DAO;
import com.example.duan1chinhthuc.R;
import com.example.duan1chinhthuc.mode.SanPhamChiTiet;
import com.example.duan1chinhthuc.mode.San_Pham;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Fragment_home extends Fragment {
    RecyclerView rcv;
    Home_DAO dao;
    Home_adapter adapter;
ArrayList <San_Pham> list;
ArrayList<SanPhamChiTiet> list1;
Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view =  inflater.inflate(R.layout.fragment_home2, container, false).getRootView();
        ImageView sale_img = view.findViewById(R.id.fragment_home_img_sale);

        rcv = view.findViewById(R.id.fragment_home_rcv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rcv.setLayoutManager(layoutManager);
//        FloatingActionButton floatingActionButton = view.findViewById(R.id.FL_add_btn);
        dao = new Home_DAO(getContext());
        list = dao.getDS_sanpham();
        adapter = new Home_adapter(list, getContext());
        rcv.setAdapter(adapter);

        Button btnadd = view.findViewById(R.id.them_sp_home);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showdialog();
            }
        });


        sale_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                if (id==R.id.fragment_home_img_sale){

                    Fragment fragment = new Fragment_sale();
                    fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
                }



            }
        });


       return view;
    }
    private void showdialog(){

        AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext());
        LayoutInflater inflater1 = getLayoutInflater();
        View view1 = inflater1.inflate(R.layout.item_add_sanpham, null);
        builder1.setView(view1);
        AlertDialog alertDialog = builder1.create();
        Button btnadd = view1.findViewById(R.id.item_add);
        EditText idsp = view1.findViewById(R.id.item_id_sp_home);
        EditText tensp = view1.findViewById(R.id.item_ten_sp_home);
        EditText ngay =view1.findViewById(R.id.item_ngay_sp_home);
        EditText trangthai =view1.findViewById(R.id.item_trangthai_sp_home);
        EditText tieude =view1.findViewById(R.id.item_tieude_sp_home);
        EditText item_tenCL_sp_home =view1.findViewById(R.id.item_tenCL_sp_home);
        EditText item_giatien_sp_home =view1.findViewById(R.id.item_giatien_sp_home);
        EditText item_Size_sp_home =view1.findViewById(R.id.item_Size_sp_home);


        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    int id = Integer.parseInt(idsp.getText().toString());
                    String ten = tensp.getText().toString();
                    String ngayd = ngay.getText().toString();
                    String TT = trangthai.getText().toString();
                    String TD = tieude.getText().toString();
                    String TCL = item_tenCL_sp_home.getText().toString();
                    int giatien = Integer.parseInt(item_giatien_sp_home.getText().toString());
                    int Size = Integer.parseInt(item_Size_sp_home.getText().toString());


                    boolean kt = dao.themSP(id,ten,ngayd,TT,TD,TCL,giatien,Size);
                    if(kt){
                        list.clear();
                        list.addAll(dao.getDS_sanpham());
                        adapter.notifyDataSetChanged();
                        alertDialog.dismiss();
                        Toast.makeText(getContext(), "Thanh cong", Toast.LENGTH_SHORT).show();
                    }
                }catch (NumberFormatException e){
                    Log.i(TAG, "loi", e);
                }
            }
        });


    }
}