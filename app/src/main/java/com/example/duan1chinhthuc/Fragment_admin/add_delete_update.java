package com.example.duan1chinhthuc.Fragment_admin;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.duan1chinhthuc.Activity_ADMIN.MainActivity_admin;
import com.example.duan1chinhthuc.Activity_user.MainActivity;
import com.example.duan1chinhthuc.Adapter_admin.Home_adapter;
import com.example.duan1chinhthuc.DAO.Home_DAO;
import com.example.duan1chinhthuc.R;
import com.example.duan1chinhthuc.mode.SanPhamChiTiet;
import com.example.duan1chinhthuc.mode.San_Pham;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class add_delete_update extends Fragment {
    RecyclerView rcv;
    Home_DAO dao;
    Home_adapter adapter;
    ArrayList<San_Pham> list;
    ArrayList<SanPhamChiTiet> list1;
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_delete_update, container, false);

        rcv = view.findViewById(R.id.add_sp_recycelview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rcv.setLayoutManager(layoutManager);

        dao = new Home_DAO(getContext());
        list = dao.getDS_sanpham();
        adapter = new Home_adapter(list, getContext());
        rcv.setAdapter(adapter);

        EditText ten_SP = view.findViewById(R.id.edt_ten_SP_ADD);
        EditText tieude_SP = view.findViewById(R.id.edt_tieude_SP_ADD);

        EditText trangthai_SP = view.findViewById(R.id.edt_Trangthai_SP_ADD);

        EditText tenchatlieu_SP = view.findViewById(R.id.edt_Tenchatlieu_SP_ADD);
        EditText hinhanh = view.findViewById(R.id.edt_hinhanh_SP_ADD);
        EditText giatien_SP = view.findViewById(R.id.edt_giatien_SP_ADD);
        EditText id_loai = view.findViewById(R.id.edt_id_loai_SP_ADD);

        EditText size_SP = view.findViewById(R.id.edt_Size_SP_ADD);
Button button = view.findViewById(R.id.add_SP_123);
        Button update = view.findViewById(R.id.update_SP_123);



        button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Thông báo");
        builder.setMessage("Xác nhận thêm sản phẩm !");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    String ten = ten_SP.getText().toString();
                    String tieude = tieude_SP.getText().toString();
                    Date date = Calendar.getInstance().getTime();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    String ngayban = simpleDateFormat.format(date);
                    String trangthai = trangthai_SP.getText().toString();
                    int idchatlieu = Integer.parseInt(tenchatlieu_SP.getText().toString());
                    int giatien1 = Integer.parseInt(giatien_SP.getText().toString());
                    int hinanh1 = Integer.parseInt(hinhanh.getText().toString());
                    int size = Integer.parseInt(size_SP.getText().toString());
                    int id_loai1 = Integer.parseInt(id_loai.getText().toString());

                    Boolean kt = dao.themSP(ten,tieude,ngayban,trangthai,idchatlieu,hinanh1,giatien1,size,id_loai1);

                    if(kt){
                        Toast.makeText(getContext(), "Thêm Thành công !", Toast.LENGTH_SHORT).show();
                        list.clear();
                        list.addAll(dao.getDS_sanpham());
                        adapter.notifyDataSetChanged();
                    }else {
                        Toast.makeText(getContext(), "Thất bại", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Log.i(TAG, "Fail", e);
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


        return view;
    }


//    private void capnhapsanpham1(int id, String tensp , String tieude, String ngaydangban, String trangthai, int Id_chatlieu, int hinhanh, int giatien, int size){
//        SharedPreferences sharedPreferences = getContext().getSharedPreferences("Thongtin", Context.MODE_PRIVATE);
//        String id_CL = sharedPreferences.getString("matt", "");
//        String id_HA = sharedPreferences.getString("matt", "");
//        //
//
//
//        San_Pham pm = new San_Pham( tensp, tieude, ngaydangban, trangthai, id_CL, id_HA,giatien,size);
//        boolean kt = dao.capnhatsanpham(pm);
//        if(kt){
//            list.clear();
//            list.addAll(dao.getDS_sanpham());
//            adapter.notifyDataSetChanged();
//            Toast.makeText(getContext(), "ok", Toast.LENGTH_SHORT).show();
//        }else{
//            Toast.makeText(getContext(), "fail", Toast.LENGTH_SHORT).show();
//        }
//
//    }


    }
