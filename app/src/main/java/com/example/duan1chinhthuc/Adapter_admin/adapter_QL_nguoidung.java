package com.example.duan1chinhthuc.Adapter_admin;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1chinhthuc.Activity_ADMIN.MainActivity_admin;
import com.example.duan1chinhthuc.Activity_user.MainActivity;
import com.example.duan1chinhthuc.DAO.ThuThuDao;
import com.example.duan1chinhthuc.R;
import com.example.duan1chinhthuc.mode.nguoidung;

import java.util.ArrayList;

public class adapter_QL_nguoidung extends RecyclerView.Adapter<adapter_QL_nguoidung.viewholder>{

    private final ArrayList<nguoidung> list;
    private final Context context;

    adapter_QL_nguoidung adapter;
    ThuThuDao dao;
    TextView textView;

    public adapter_QL_nguoidung(ArrayList<nguoidung> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public adapter_QL_nguoidung.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view =inflater.inflate(R.layout.item_ql_nguoidung,parent,false);

        return new adapter_QL_nguoidung.viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter_QL_nguoidung.viewholder holder, int position) {
        holder.matt.setText(list.get(position).getMatt());
        holder.matkhau.setText(list.get(position).getMatkhau());
        holder.tennguoidung.setText(list.get(position).getHoten());
        holder.loaitk.setText(list.get(position).getLoaitaikhoan());
        holder.sdt.setText(Integer.toString(list.get(position).getSdt()));
        holder.diachi.setText(list.get(position).getDiachi());
        holder.id_user.setText(Integer.toString(list.get(position).getId_user()));
holder.deletenn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
        builder.setTitle("Thông báo");
        builder.setMessage("bạn chắc chắn xóa tài khoản người dùng này ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(dao.delete(list.get(holder.getAdapterPosition()).getMatt())){
                    list.clear();
                    list.addAll(dao.getDS_nguoidung());
                    notifyDataSetChanged();
                    Toast.makeText(context, "Đã xóa", Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();

    }
});

        adapter = new adapter_QL_nguoidung(list, context);
        dao = new ThuThuDao(context);
    }

    @Override
    public int getItemCount() {
       return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView matt,matkhau,tennguoidung,loaitk,diachi,sdt,id_user;
        ImageView deletenn;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            deletenn = itemView.findViewById(R.id.delete_tk_nguoidung);
            matt = itemView.findViewById(R.id.taikhoan_123);
            matkhau = itemView.findViewById(R.id.matkhau_123);
            tennguoidung = itemView.findViewById(R.id.hoten_123);
            loaitk = itemView.findViewById(R.id.loaitk_123);
            diachi = itemView.findViewById(R.id.diachi_123);
            sdt = itemView.findViewById(R.id.sdt_123);
            id_user = itemView.findViewById(R.id.id_nguoidung);
        }
    }
}
