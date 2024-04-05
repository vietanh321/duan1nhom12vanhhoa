package com.example.duan1chinhthuc.Adapter;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.Log;
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
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1chinhthuc.DAO.DonHang_DAO;
import com.example.duan1chinhthuc.DAO.Home_DAO;
import com.example.duan1chinhthuc.InterfaceRecycle;
import com.example.duan1chinhthuc.R;
import com.example.duan1chinhthuc.mode.Donhang;
import com.example.duan1chinhthuc.mode.San_Pham;

import java.util.ArrayList;

public class adapter_user extends RecyclerView.Adapter<adapter_user.viewholder> {
    InterfaceRecycle interfaceRecycle;
    private final Context context;
    ///
    Spinner spn_soluong;
    int giasp;
    int id;
    String name, loai,image;
    // Ensure your ArrayList is initialized before using it.
    ArrayList<San_Pham> list = new ArrayList<>();

    // Now you can safely call methods on 'list'
    adapter_QL_donhang adapter11;

    ////
    Home_adapter adapter;
    Home_DAO dao;
    DonHang_DAO dao1;

    ArrayList<Donhang> list12;
    private static int nextId = 1;

    public adapter_user(ArrayList<San_Pham> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setOnclickRecycle(InterfaceRecycle interfaceRecycle) {
        this.interfaceRecycle = interfaceRecycle;
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
        TextView idSP = view1.findViewById(R.id.ma_sp);
        TextView ten = view1.findViewById(R.id.item_ten_sp_home_12);
        TextView tieude = view1.findViewById(R.id.item_tieude_sp_home_12);
        TextView trangthai = view1.findViewById(R.id.item_trangthai_sp_home_12);
        TextView tenchatlieu = view1.findViewById(R.id.item_tenCL_sp_home_12);
        TextView giatien = view1.findViewById(R.id.item_giatien_sp_home_12);
        spn_soluong=view1.findViewById(R.id.spn_soluong);
        idSP.setText(String.valueOf(list.get(position).getId_sanpham()));
        ten.setText(String.valueOf(list.get(position).getTensp()));
        tieude.setText(String.valueOf(list.get(position).getTieude()));
        trangthai.setText(String.valueOf(list.get(position).getTrangthai()));
        tenchatlieu.setText(String.valueOf(list.get(position).getTenchatlieu()));
        giatien.setText(String.valueOf(list.get(position).getGiatien()));

        Spiner();


        Button addtocart = view1.findViewById(R.id.btn_add_cart);

        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                androidx.appcompat.app.AlertDialog.Builder builder1 = new androidx.appcompat.app.AlertDialog.Builder(context);
                LayoutInflater inflater1 = LayoutInflater.from(context);
                View view1 = inflater1.inflate(R.layout.activity_thong_tin_khactivity, null);
                builder1.setView(view1);

                EditText id_SP = view1.findViewById(R.id.id_sanpham);
                EditText tenkhachhang = view1.findViewById(R.id.textinputname);
                EditText sodienthoai = view1.findViewById(R.id.textinputsdt);
                EditText email = view1.findViewById(R.id.textinputemail);
                EditText diachi = view1.findViewById(R.id.textinputaddress);
                EditText trangthai = view1.findViewById(R.id.trangthai);

                AlertDialog alertDialog = builder1.create();

                id_SP.setText(String.valueOf(list.get(position).getId_spchitiet()));

                Button quayliaj = view1.findViewById(R.id.btnquaylai);
                quayliaj.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                Button btnxacnhan = view1.findViewById(R.id.btnxacnhan);
                btnxacnhan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       try {
                           DonHang_DAO donHang_dao = new DonHang_DAO(context);

                           int id_sp12 = Integer.parseInt(id_SP.getText().toString());
                           int size12 = Integer.parseInt(spn_soluong.getSelectedItem().toString());
                           int sodienthoai12 = Integer.parseInt(sodienthoai.getText().toString());
                           String trangthai12 = trangthai.getText().toString();
                           String tenkhachhang12 = tenkhachhang.getText().toString();
                           String email12 = email.getText().toString();
                           String diachi12 = diachi.getText().toString();


                           boolean kt = donHang_dao.them_donhang(id_sp12,tenkhachhang12,
                                   sodienthoai12,email12,diachi12,trangthai12,size12);

                           if(kt){
                               Toast.makeText(context, "Đặt Hàng thành công !", Toast.LENGTH_SHORT).show();
                               list12.clear();
                               list12.addAll(dao1.getDS_donhang());
                               adapter.notifyDataSetChanged();
                               alertDialog.dismiss();

                           }else {
                               Toast.makeText(context, "Fail-Trùng mã đơn hàng hoặc id sản phẩm không tồn tại", Toast.LENGTH_SHORT).show();
                           notifyDataSetChanged();
                               alertDialog.dismiss();
                           }
                       }catch (Exception e){
                           Log.i(TAG, "Fail", e);

                       }

                    }
                });
                alertDialog.show();
            }
        });



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
        Button addtocart;
        ImageView hinhanhsp,hinhanh,love,addcart;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            addtocart = itemView.findViewById(R.id.btn_add_cart);
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

    private void Spiner() {
        Integer[] soluong = new Integer[]{39,40,42};
        ArrayAdapter<Integer> sl= new ArrayAdapter<>(context, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, soluong);
        spn_soluong.setAdapter(sl);
    }

}
