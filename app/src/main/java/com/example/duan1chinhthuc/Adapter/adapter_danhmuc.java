package com.example.duan1chinhthuc.Adapter;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class adapter_danhmuc extends RecyclerView.Adapter<adapter_danhmuc.viewholder>{
    Spinner spn_soluong;
    private final Context context;
    ArrayList<San_Pham> list = new ArrayList<>();

    adapter_danhmuc adapter;
    Home_DAO dao;
    DonHang_DAO dao1;

    ArrayList<Donhang> list12;
    private static int nextId = 1;
    public adapter_danhmuc(ArrayList<San_Pham> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @NonNull
    @Override
    public adapter_danhmuc.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view =inflater.inflate(R.layout.item_sp_danhmuc,parent,false);

        return new adapter_danhmuc.viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter_danhmuc.viewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.tenSP.setText(list.get(position).getTensp());
        holder.giatien.setText(Integer.toString(list.get(position).getGiatien()));
        holder.ten_loaisp.setText(list.get(position).getTen_loaisp());
        SharedPreferences sharedPreferences = context.getSharedPreferences("Thongtin", Context.MODE_PRIVATE);
        String loaiTK = sharedPreferences.getString("loaitaikhoan", "");

        try {
            if (loaiTK.equals("admin")){

            }else {
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
                                EditText email = view1.findViewById(R.id.textinputemail);//soos luong sp
                                EditText trangthai = view1.findViewById(R.id.trangthai);





                                EditText editText = (EditText) view1.findViewById(R.id.trangthai);
                                editText.setVisibility(View.GONE);

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

                                            if(email.getText().toString().equals("")){
                                                Toast.makeText(context, "Nhập số lượng mua", Toast.LENGTH_SHORT).show();
                                                return;
                                            }

                                            DonHang_DAO donHang_dao = new DonHang_DAO(context);

                                            int id_sp12 = Integer.parseInt(id_SP.getText().toString());
                                            int size12 = Integer.parseInt(spn_soluong.getSelectedItem().toString());
                                            String trangthai12 = trangthai.getText().toString();
                                            int email12 = Integer.parseInt(email.getText().toString());
                                            int tongtien = email12 * list.get(position).getGiatien();
                                            Date date = Calendar.getInstance().getTime();
                                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                                            String ngay = simpleDateFormat.format(date);

                                            SharedPreferences sharedPreferences = context.getSharedPreferences("Thongtin_tt", Context.MODE_PRIVATE);
                                            int id_user1 = Integer.parseInt(sharedPreferences.getString("id_usser",""));
                                            boolean kt = donHang_dao.them_donhang(id_sp12,trangthai12,size12,email12,tongtien,ngay,id_user1);

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
                                        alertDialog.dismiss();
                                    }

                                });
                                alertDialog.show();
                            }
                        });



                        alertDialog.show();
                    }

                });
            }
        }catch (Exception e){}

        adapter = new adapter_danhmuc(list, context);
        dao = new Home_DAO(context);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView idSP,tenSP,tieude,ngayban,trangthai,id_CL,ten_CL,id_sp_CT,giatien,size,id_loaisp,ten_loaisp,user_loai_sp1;
        public viewholder(@NonNull View itemView) {
            super(itemView);

            tenSP = itemView.findViewById(R.id.ten_sp_danhmuc);

            giatien = itemView.findViewById(R.id.gia_sp_danhmuc);

            ten_loaisp = itemView.findViewById(R.id.loai_sp_danhmuc);

        }
    }

    private void Spiner() {
        Integer[] soluong = new Integer[]{38,39,40,41,42};
        ArrayAdapter<Integer> sl= new ArrayAdapter<>(context, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, soluong);
        spn_soluong.setAdapter(sl);
    }
}
