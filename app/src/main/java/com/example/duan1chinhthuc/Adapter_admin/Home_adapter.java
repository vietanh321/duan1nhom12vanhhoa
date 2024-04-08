package com.example.duan1chinhthuc.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1chinhthuc.DAO.Home_DAO;
import com.example.duan1chinhthuc.R;
import com.example.duan1chinhthuc.mode.San_Pham;

import java.util.ArrayList;
import java.util.List;

public class Home_adapter extends RecyclerView.Adapter<Home_adapter.viewholder> {
    private final ArrayList<San_Pham> list;
    private final Context context;

    Home_adapter adapter;
    Home_DAO dao;

    public Home_adapter(ArrayList<San_Pham> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public Home_adapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view =inflater.inflate(R.layout.item_sanpham,parent,false);

        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Home_adapter.viewholder holder, int position) {
        holder.idSP.setText(Integer.toString(list.get(position).getId_sanpham()));
        holder.tenSP.setText(list.get(position).getTensp());
        holder.tieude.setText(list.get(position).getTieude());
        holder.ngayban.setText(list.get(position).getNgaydangban());
        holder.trangthai.setText(list.get(position).getTrangthai());
        holder.id_CL.setText(Integer.toString(list.get(position).getId_chatlieu()));
        holder.ten_CL.setText(list.get(position).getTenchatlieu());
        holder.id_sp_CT.setText(Integer.toString(list.get(position).getId_spchitiet()));
        holder.giatien.setText(Integer.toString(list.get(position).getGiatien()));
        holder.size.setText(Integer.toString(list.get(position).getSize()));
        holder.id_loaisp.setText(Integer.toString(list.get(position).getId_loaisp()));
        holder.ten_loaisp.setText(list.get(position).getTen_loaisp());







        adapter = new Home_adapter(list, context);
        dao = new Home_DAO(context);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView idSP,tenSP,tieude,ngayban,trangthai,id_CL,ten_CL,id_sp_CT,giatien,size,id_loaisp,ten_loaisp;
        ImageView hinhanhsp;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            idSP = itemView.findViewById(R.id.item_id_sp_home);
            tenSP = itemView.findViewById(R.id.item_ten_sp_home);
            tieude = itemView.findViewById(R.id.item_tieude_sp_home);
            ngayban = itemView.findViewById(R.id.item_ngay_sp_home);
            trangthai = itemView.findViewById(R.id.item_trangthai_sp_home);
            id_CL = itemView.findViewById(R.id.item_id_CL_sp_home);
            ten_CL = itemView.findViewById(R.id.item_tenCL_sp_home);
            id_sp_CT = itemView.findViewById(R.id.item_id_sp_CT_home);
            giatien = itemView.findViewById(R.id.item_giatien_sp_home);
            size = itemView.findViewById(R.id.item_Size_sp_home);
            id_loaisp = itemView.findViewById(R.id.item_id_loai_sp_home);
            ten_loaisp = itemView.findViewById(R.id.item_ten_loaisp_home);
        }
    }
}