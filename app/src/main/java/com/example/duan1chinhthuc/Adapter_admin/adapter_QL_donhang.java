package com.example.duan1chinhthuc.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1chinhthuc.DAO.DonHang_DAO;
import com.example.duan1chinhthuc.DAO.Home_DAO;
import com.example.duan1chinhthuc.R;
import com.example.duan1chinhthuc.mode.Donhang;

import java.util.ArrayList;

public class adapter_QL_donhang extends RecyclerView.Adapter<adapter_QL_donhang.viewholder>{
    private final ArrayList<Donhang> list;
    private final Context context;
    Spinner spn_soluong;
    adapter_QL_donhang adapter;
    DonHang_DAO dao;
    TextView textView;

    public adapter_QL_donhang(ArrayList<Donhang> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public adapter_QL_donhang.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view =inflater.inflate(R.layout.item_donhang,parent,false);

        return new adapter_QL_donhang.viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter_QL_donhang.viewholder holder, @SuppressLint("RecyclerView") int position) {

        holder.id_DH.setText(Integer.toString(list.get(position).getId()));
        holder.id_SP.setText(Integer.toString(list.get(position).getId_chitietsp()));
        holder.tenKH.setText(list.get(position).getTenkhachhang());
        holder.SDT.setText(Integer.toString(list.get(position).getSodienthoai()));
        holder.email.setText(Integer.toString(list.get(position).getSoluong_sp()));
        holder.diachi.setText(list.get(position).getDiachi());
        holder.size.setText(Integer.toString(list.get(position).getSize()));
        holder.trangthai.setText(list.get(position).getTrangthaidonhang());
//        email12 = email12 *  list.get(position).getGiatien();
        holder.tongtien1.setText(Integer.toString(list.get(position).getTongtien()));

        if (list.get(position).getTrangthaidonhang().equals("chờ xác nhận")){
            holder.trangthai.setTextColor(Color.parseColor("#0A47FD"));
        }
        else if (list.get(position).getTrangthaidonhang().equals("đang giao hàng")){
            holder.trangthai.setTextColor(Color.parseColor("#ff0000"));
        }else if (list.get(position).getTrangthaidonhang().equals("đã giao")){}

holder.xoa.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(dao.delete(list.get(holder.getAdapterPosition()).getId())){
            list.clear();
            list.addAll(dao.getDS_donhang());
            notifyDataSetChanged();
            Toast.makeText(context, "Đã xóa", Toast.LENGTH_SHORT).show();
        }
    }
});
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                androidx.appcompat.app.AlertDialog.Builder builder1 = new androidx.appcompat.app.AlertDialog.Builder(context);
                LayoutInflater inflater1 = LayoutInflater.from(context);
                View view1 = inflater1.inflate(R.layout.item_update_donhang, null);
                builder1.setView(view1);
                androidx.appcompat.app.AlertDialog alertDialog = builder1.create();
                EditText id_SP = view1.findViewById(R.id.id_sanpham);
                EditText id_donhang = view1.findViewById(R.id.idDonhang);
                EditText tenkhachhang = view1.findViewById(R.id.textinputname);
                EditText sodienthoai = view1.findViewById(R.id.textinputsdt);
                EditText email = view1.findViewById(R.id.textinputemail);
                EditText diachi = view1.findViewById(R.id.textinputaddress);
//                EditText trangthai = view1.findViewById(R.id.trangthai);
                EditText size = view1.findViewById(R.id.size);
                spn_soluong=view1.findViewById(R.id.trangthai);
                EditText ngay = view1.findViewById(R.id.ngay);


                id_SP.setText(String.valueOf(list.get(position).getId_chitietsp()));
                id_donhang.setText(String.valueOf(list.get(position).getId()));
                tenkhachhang.setText(list.get(position).getTenkhachhang());
                sodienthoai.setText(String.valueOf(list.get(position).getSodienthoai()));
                email.setText(String.valueOf(list.get(position).getSoluong_sp()));
                diachi.setText(list.get(position).getDiachi());
                Spiner(); //chọn trạng thái
                size.setText(String.valueOf(list.get(position).getSize()));
                ngay.setText(list.get(position).getNgay_model());

                Button btnxacnhan = view1.findViewById(R.id.btnxacnhan);
                btnxacnhan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int id_SP1 = Integer.parseInt(id_SP.getText().toString());
                        int id_donhang1 = Integer.parseInt(id_donhang.getText().toString());
                        String tenkhachhang1 = tenkhachhang.getText().toString();
                        int sodienthoai1 = Integer.parseInt(sodienthoai.getText().toString());
                        int email1 = Integer.parseInt(email.getText().toString());
                        String diachi1 = diachi.getText().toString();
                        String trangthai1 = spn_soluong.getSelectedItem().toString();
                        int size1 = Integer.parseInt(size.getText().toString());
                        int tongtien = email1 * list.get(position).getTongtien();

                        String ngay1 = ngay.getText().toString();

//                        if (email.getText().toString().equals("")){}
                        Donhang ls = new Donhang(id_SP1, id_donhang1,tenkhachhang1,sodienthoai1,diachi1,trangthai1,size1,email1,tongtien,ngay1);
                        boolean kt = dao.capnhatdonhang_admin(ls);
                        if(kt){
                            list.clear();
                            list.addAll(dao.getDS_donhang());
                            adapter.notifyDataSetChanged();
                            alertDialog.dismiss();
                            Toast.makeText(context, "Succesfully", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(context, "Fail", Toast.LENGTH_SHORT).show();
                        }

                    }
                });




                alertDialog.show();
            }
        });

        adapter = new adapter_QL_donhang(list, context);
        dao = new DonHang_DAO(context);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView id_DH,id_SP,tenKH,SDT,email,diachi,size,trangthai,tongtien1;
        ImageView xoa;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            xoa = itemView.findViewById(R.id.delete_donhang);
            id_DH = itemView.findViewById(R.id.idDonhang22);
            id_SP = itemView.findViewById(R.id.id_sanpham22);
            tenKH = itemView.findViewById(R.id.textinputname22);
            SDT = itemView.findViewById(R.id.textinputsdt22);
            email = itemView.findViewById(R.id.textinputemail22);
            diachi = itemView.findViewById(R.id.textinputaddress22);
            size = itemView.findViewById(R.id.size22);
            tongtien1 = itemView.findViewById(R.id.tongtien);
            trangthai = itemView.findViewById(R.id.trangthai22);
        }
    }

    private void Spiner() {
        String[] soluong = new String[]{"chờ xác nhận","đang giao hàng","đã giao"};
        ArrayAdapter<String> sl= new ArrayAdapter<>(context, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, soluong);
        spn_soluong.setAdapter(sl);
    }
}