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

import com.example.duan1chinhthuc.Adapter.adapter_QL_donhang;
import com.example.duan1chinhthuc.Adapter.adapter_QL_nguoidung;
import com.example.duan1chinhthuc.DAO.DonHang_DAO;
import com.example.duan1chinhthuc.DAO.ThuThuDao;
import com.example.duan1chinhthuc.R;
import com.example.duan1chinhthuc.mode.Donhang;
import com.example.duan1chinhthuc.mode.nguoidung;

import java.util.ArrayList;

public class QL_tk_user extends Fragment {
    RecyclerView rcv;
    ThuThuDao dao;
    adapter_QL_nguoidung adapter;
    ArrayList<nguoidung> list;

    Context context;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_q_l_tk_user, container, false);
        rcv = view.findViewById(R.id.rcv_QL_tk_user);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rcv.setLayoutManager(layoutManager);

        dao = new ThuThuDao(getContext());
        list = dao.getDS_nguoidung();
        adapter = new adapter_QL_nguoidung(list, getContext());
        rcv.setAdapter(adapter);
        return view;
    }
}