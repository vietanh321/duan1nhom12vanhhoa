package com.example.duan1chinhthuc.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1chinhthuc.Frament.Fragment_yeuthich;
import com.example.duan1chinhthuc.R;
import com.example.duan1chinhthuc.mode.San_Pham;

import java.util.ArrayList;

public class adapter_user extends RecyclerView.Adapter<adapter_user.viewholder> {
    private final ArrayList<San_Pham> list;
    private final Context context;

    public adapter_user(ArrayList<San_Pham> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public adapter_user.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_sanpham_use, parent, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter_user.viewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.tenSP.setText(list.get(position).getTensp());
        holder.giatien.setText(String.valueOf(list.get(position).getGiatien()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
                LayoutInflater inflater1 = LayoutInflater.from(context);
                View view1 = inflater1.inflate(R.layout.chitiet_sp_user, null);
                builder1.setView(view1);
                AlertDialog alertDialog = builder1.create();
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

        holder.love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy sản phẩm tương ứng với vị trí được click
                San_Pham sanPham = list.get(position);

                // Tạo một Bundle để chứa thông tin của sản phẩm
                Bundle bundle = new Bundle();
                bundle.putSerializable("sanPham", sanPham);

                // Tạo Fragment_yeuthich mới và thiết lập Bundle
                Fragment_yeuthich fragment = new Fragment_yeuthich();
                fragment.setArguments(bundle);

                // Thay thế Fragment hiện tại bằng Fragment_yeuthich
                ((FragmentActivity) context).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView tenSP, giatien;
        ImageView love, addcart;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            tenSP = itemView.findViewById(R.id.user_ten_sp);
            giatien = itemView.findViewById(R.id.user_giatien_sp);
            love = itemView.findViewById(R.id.add_to_love);
            addcart = itemView.findViewById(R.id.add_to_cart);
        }
    }
}
