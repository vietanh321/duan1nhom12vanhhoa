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
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1chinhthuc.Adapter_admin.Home_adapter;
import com.example.duan1chinhthuc.Adapter_admin.adapter_QL_donhang;
import com.example.duan1chinhthuc.DAO.Dao_love;
import com.example.duan1chinhthuc.DAO.DonHang_DAO;
import com.example.duan1chinhthuc.DAO.Home_DAO;
import com.example.duan1chinhthuc.InterfaceRecycle;
import com.example.duan1chinhthuc.R;
import com.example.duan1chinhthuc.mode.Donhang;
import com.example.duan1chinhthuc.mode.San_Pham;
import com.example.duan1chinhthuc.mode.love_model;
import com.example.duan1chinhthuc.mode.nguoidung;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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
    Dao_love dao_love;
    ArrayList<love_model> list_love;
    adapter_love adapter_love;

    ArrayList<Donhang> list12;
    private static int nextId = 1;


    private Context mContext;
    private SharedPreferences mSharedPreferences;

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
        SharedPreferences sharedPreferences = context.getSharedPreferences("Thongtin_tt", Context.MODE_PRIVATE);
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
                        TextView idCL = view1.findViewById(R.id.item_idCL_sp_home_12);
                        idCL.setText(String.valueOf(list.get(position).getId_chatlieu()));

                        TextView editText = (TextView) view1.findViewById(R.id.item_idCL_sp_home_12);
                        editText.setVisibility(View.GONE);

                        Spiner();


                        Button addtocart = view1.findViewById(R.id.btn_add_cart);
                        ImageView addtolove = view1.findViewById(R.id.add_to_love_ct);

                        addtolove.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                        try {
                            Dao_love love = new Dao_love(context);

                            int id_sp1 = Integer.parseInt(idSP.getText().toString());
                            String tensp1 = ten.getText().toString();
                            SharedPreferences sharedPreferences = context.getSharedPreferences("Thongtin_tt", Context.MODE_PRIVATE);
                            int id_user1 = Integer.parseInt(sharedPreferences.getString("id_usser",""));
                            int giatien1 = Integer.parseInt(giatien.getText().toString());
                            String tieude1 = tieude.getText().toString();


                            boolean kt = love.addSanPhamtoLove(id_sp1,tensp1,giatien1,tieude1,id_user1);
                            if(kt){
                                Toast.makeText(context, "thành công !", Toast.LENGTH_SHORT).show();
                                list_love.clear();
                                list_love.addAll(dao_love.get_ds_love_sp());
                                alertDialog.dismiss();
                                adapter_love.notifyDataSetChanged();
                            }


                        }catch (Exception e){}
                            }
                        });

                        addtocart.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                androidx.appcompat.app.AlertDialog.Builder builder1 = new androidx.appcompat.app.AlertDialog.Builder(context);
                                LayoutInflater inflater1 = LayoutInflater.from(context);
                                View view1 = inflater1.inflate(R.layout.activity_thong_tin_khactivity, null);
                                builder1.setView(view1);
                                AlertDialog alertDialog = builder1.create();

                                EditText id_SP = view1.findViewById(R.id.id_sanpham);
                                EditText email = view1.findViewById(R.id.textinputemail);//soos luong sp
                                EditText trangthai = view1.findViewById(R.id.trangthai);





                                EditText editText = (EditText) view1.findViewById(R.id.trangthai);
                                editText.setVisibility(View.GONE);



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
                                        try{

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
                                            String sdt = sharedPreferences.getString("sodienthoai","");
                                          String sc = sharedPreferences.getString("diachi","");
                                            boolean kt = donHang_dao.them_donhang(id_sp12,trangthai12,size12,email12,tongtien,ngay,id_user1,sdt,sc);

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


        adapter = new Home_adapter(list, context);
        dao = new Home_DAO(context);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView idSP,tenSP,tieude,ngayban,trangthai,id_CL,ten_CL,id_sp_CT,giatien,size,idhinhanh;

        public viewholder(@NonNull View itemView) {
            super(itemView);

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
        Integer[] soluong = new Integer[]{38,39,40,41,42};
        ArrayAdapter<Integer> sl= new ArrayAdapter<>(context, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, soluong);
        spn_soluong.setAdapter(sl);
    }

}
