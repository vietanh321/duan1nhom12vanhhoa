package com.example.duan1chinhthuc.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1chinhthuc.DAO.Home_DAO;
import com.example.duan1chinhthuc.Frament.Fragment_home;
import com.example.duan1chinhthuc.MainActivity;
import com.example.duan1chinhthuc.R;
import com.example.duan1chinhthuc.mode.San_Pham;
import com.example.duan1chinhthuc.mode.gio_hang;
import com.example.duan1chinhthuc.mode.giohangchitiet;

import java.util.ArrayList;

public class adapter_user extends RecyclerView.Adapter<adapter_user.viewholder> {
    private final ArrayList<San_Pham> list;
    private final Context context;

    Home_adapter adapter;
    Home_DAO dao;

    public adapter_user(ArrayList<San_Pham> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public adapter_user.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view =inflater.inflate(R.layout.item_sanpham_use,parent,false);

        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter_user.viewholder holder, @SuppressLint("RecyclerView") int position) {

        holder.tenSP.setText(list.get(position).getTensp());
        holder.giatien.setText(Integer.toString(list.get(position).getGiatien()));


holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {


        androidx.appcompat.app.AlertDialog.Builder builder1 = new androidx.appcompat.app.AlertDialog.Builder(context);
        LayoutInflater inflater1 = LayoutInflater.from(context);
        View view1 = inflater1.inflate(R.layout.chitiet_sp_user, null);
        builder1.setView(view1);
        androidx.appcompat.app.AlertDialog alertDialog = builder1.create();
        TextView ten = view1.findViewById(R.id.item_ten_sp_home_12);
        TextView tieude = view1.findViewById(R.id.item_tieude_sp_home_12);
        TextView trangthai = view1.findViewById(R.id.item_trangthai_sp_home_12);
        TextView tenchatlieu = view1.findViewById(R.id.item_tenCL_sp_home_12);
        TextView giatien = view1.findViewById(R.id.item_giatien_sp_home_12);
        TextView size = view1.findViewById(R.id.item_Size_sp_home_12);
        ten.setText(String.valueOf(list.get(position).getTensp()));
        tieude.setText(String.valueOf(list.get(position).getTieude()));
        trangthai.setText(String.valueOf(list.get(position).getTrangthai()));
        tenchatlieu.setText(String.valueOf(list.get(position).getTenchatlieu()));
        giatien.setText(String.valueOf(list.get(position).getGiatien()));
        size.setText(String.valueOf(list.get(position).getSize()));










        alertDialog.show();
    }
});







        adapter = new Home_adapter(list, context);
        dao = new Home_DAO(context);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView idSP,tenSP,tieude,ngayban,trangthai,id_CL,ten_CL,id_sp_CT,giatien,size,idhinhanh;
        ImageView hinhanhsp,hinhanh,love,addcart;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            love = itemView.findViewById(R.id.add_to_love);
            addcart =  itemView.findViewById(R.id.add_to_cart);
            tenSP = itemView.findViewById(R.id.user_ten_sp);
//            idhinhanh = itemView.findViewById(R.id.user_idhinhanh_hinhanh);
            giatien = itemView.findViewById(R.id.user_giatien_sp);
            idSP = itemView.findViewById(R.id.item_id_sp_home);

            tieude = itemView.findViewById(R.id.item_tieude_sp_home);
            trangthai = itemView.findViewById(R.id.item_trangthai_sp_home);
            ten_CL = itemView.findViewById(R.id.item_tenCL_sp_home);
            size = itemView.findViewById(R.id.item_Size_sp_home);

        }
    }
}
