package com.example.duan1chinhthuc.Frament_user;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1chinhthuc.Adapter.adapter_donhang_user;
import com.example.duan1chinhthuc.Adapter.adapter_love;
import com.example.duan1chinhthuc.Adapter.adapter_user;
import com.example.duan1chinhthuc.DAO.Dao_love;
import com.example.duan1chinhthuc.DAO.DonHang_DAO;
import com.example.duan1chinhthuc.DAO.Home_DAO;
import com.example.duan1chinhthuc.R;
import com.example.duan1chinhthuc.mode.Donhang;
import com.example.duan1chinhthuc.mode.love_model;

import java.util.ArrayList;

public class Frament_yeuthich extends Fragment {

    RecyclerView rcv;
    Dao_love dao;
    adapter_love adapter;
    ArrayList<love_model> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_frament_yeuthich, container, false);

        rcv = view.findViewById(R.id.rcv_QL_DH_user_12);

        dao = new Dao_love(getContext());
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("Thongtin_tt", Context.MODE_PRIVATE);
        String id = sharedPreferences.getString("id_usser","");
        list = dao.get_ds_love_sp_user(Integer.parseInt(id));
        Log.d("check", list.size()+"");
        adapter = new adapter_love(list, getContext());
        rcv.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rcv.setLayoutManager(layoutManager);
        adapter.notifyDataSetChanged();





        return view;
    }
}
