package com.example.duan1chinhthuc.Frament;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.duan1chinhthuc.Adapter.adapter_danhmuc;
import com.example.duan1chinhthuc.Adapter.adapter_user;
import com.example.duan1chinhthuc.DAO.Home_DAO;
import com.example.duan1chinhthuc.R;
import com.example.duan1chinhthuc.mode.San_Pham;

import java.util.ArrayList;

public class danh_muc_sp extends Fragment {
    RecyclerView rcv;
    Home_DAO dao;
    adapter_danhmuc adapter;

    ArrayList<San_Pham> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_danh_muc_sp, container, false);
        rcv = view.findViewById(R.id.fragment_danhmucsp_rcv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rcv.setLayoutManager(layoutManager);

        dao = new Home_DAO(getContext());
        list = dao.getDanhmuc_sanpham_1();
        adapter = new adapter_danhmuc(list, getContext());
        rcv.setAdapter(adapter);
        ImageView img1 = view.findViewById(R.id.danhmuc1);
        ImageView img2 = view.findViewById(R.id.danhmuc2);
        ImageView img3 = view.findViewById(R.id.danhmuc3);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rcv = view.findViewById(R.id.fragment_danhmucsp_rcv);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                rcv.setLayoutManager(layoutManager);

                dao = new Home_DAO(getContext());
                list = dao.getDanhmuc_sanpham_1();
                adapter = new adapter_danhmuc(list, getContext());
                rcv.setAdapter(adapter);
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rcv = view.findViewById(R.id.fragment_danhmucsp_rcv);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                rcv.setLayoutManager(layoutManager);

                dao = new Home_DAO(getContext());
                list = dao.getDanhmuc_sanpham_2();
                adapter = new adapter_danhmuc(list, getContext());
                rcv.setAdapter(adapter);
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rcv = view.findViewById(R.id.fragment_danhmucsp_rcv);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                rcv.setLayoutManager(layoutManager);

                dao = new Home_DAO(getContext());
                list = dao.getDanhmuc_sanpham_3();
                adapter = new adapter_danhmuc(list, getContext());
                rcv.setAdapter(adapter);
            }
        });

        return view;
    }
}