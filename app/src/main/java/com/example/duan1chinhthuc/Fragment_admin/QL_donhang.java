package com.example.duan1chinhthuc.Fragment_admin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.duan1chinhthuc.Adapter_admin.adapter_QL_donhang;
import com.example.duan1chinhthuc.DAO.DonHang_DAO;
import com.example.duan1chinhthuc.R;
import com.example.duan1chinhthuc.mode.Donhang;

import java.util.ArrayList;


public class QL_donhang extends Fragment {
    RecyclerView rcv;
    DonHang_DAO dao;
    adapter_QL_donhang adapter;
    ArrayList<Donhang> list;

    Context context;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_q_l_donhang, container, false);
        rcv = view.findViewById(R.id.rcv_QL_DH);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rcv.setLayoutManager(layoutManager);

        dao = new DonHang_DAO(getContext());
        list = dao.getDS_donhang();
        adapter = new adapter_QL_donhang(list, getContext());
        rcv.setAdapter(adapter);

        ImageView img1 = view.findViewById(R.id.danhmuc1);
        ImageView img2 = view.findViewById(R.id.danhmuc2);
        ImageView img3 = view.findViewById(R.id.danhmuc3);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rcv = view.findViewById(R.id.rcv_QL_DH);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                rcv.setLayoutManager(layoutManager);

                dao = new DonHang_DAO(getContext());
                list = dao.getDS_donhang1();
                adapter = new adapter_QL_donhang(list, getContext());
                rcv.setAdapter(adapter);
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rcv = view.findViewById(R.id.rcv_QL_DH);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                rcv.setLayoutManager(layoutManager);

                dao = new DonHang_DAO(getContext());
                list = dao.getDS_donhang2();
                adapter = new adapter_QL_donhang(list, getContext());
                rcv.setAdapter(adapter);
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rcv = view.findViewById(R.id.rcv_QL_DH);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                rcv.setLayoutManager(layoutManager);

                dao = new DonHang_DAO(getContext());
                list = dao.getDS_donhang3();
                adapter = new adapter_QL_donhang(list, getContext());
                rcv.setAdapter(adapter);
            }
        });

        return view;
    }
}