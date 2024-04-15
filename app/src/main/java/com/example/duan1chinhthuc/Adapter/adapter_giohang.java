package com.example.duan1chinhthuc.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1chinhthuc.Adapter_admin.Home_adapter;
import com.example.duan1chinhthuc.DAO.DAO_giohang;
import com.example.duan1chinhthuc.DAO.DonHang_DAO;
import com.example.duan1chinhthuc.DAO.Home_DAO;
import com.example.duan1chinhthuc.R;
import com.example.duan1chinhthuc.mode.Donhang;
import com.example.duan1chinhthuc.mode.gio_hang;

import java.util.ArrayList;

public class adapter_giohang extends RecyclerView.Adapter<adapter_giohang.viewholder>{

    private final ArrayList<gio_hang> list;
    private final Context context;
    adapter_giohang adapter;
    DAO_giohang dao;
    TextView textView;

    public adapter_giohang(ArrayList<gio_hang> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @NonNull
    @Override
    public adapter_giohang.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view =inflater.inflate(R.layout.item_sp_giohang,parent,false);

        return new adapter_giohang.viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter_giohang.viewholder holder, int position) {
        holder.ten.setText(String.valueOf(list.get(position).getId_sp()));
        holder.gia.setText(String.valueOf(list.get(position).getSoluong_sp()));

        adapter = new adapter_giohang(list, context);
        dao = new DAO_giohang(context);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView ten, gia;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            ten = itemView.findViewById(R.id.ten_sp_giohang);
            gia = itemView.findViewById(R.id.giatien_sp_giohang);

        }
    }
}
