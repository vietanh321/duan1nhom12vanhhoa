package com.example.duan1chinhthuc.Fragment_admin;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.duan1chinhthuc.Adapter_admin.Home_adapter;
import com.example.duan1chinhthuc.DAO.Home_DAO;
import com.example.duan1chinhthuc.R;
import com.example.duan1chinhthuc.mode.SanPhamChiTiet;
import com.example.duan1chinhthuc.mode.San_Pham;

import java.util.ArrayList;


public class delete_sp extends Fragment {

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
        View view = inflater.inflate(R.layout.fragment_delete_sp, container, false);
        rcv = view.findViewById(R.id.delete_sp_recycelview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rcv.setLayoutManager(layoutManager);

        dao = new Home_DAO(getContext());
        list = dao.getDS_sanpham();
        adapter = new Home_adapter(list, getContext());
        rcv.setAdapter(adapter);

        EditText id_xoa = view.findViewById(R.id.id_delete);

        Button xoa = view.findViewById(R.id.delete_sp);
        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(id_xoa.getText().toString());
                boolean kt = dao.delete_sp(id);
                if(kt){

                    list.clear();
                    list.remove(dao.getDS_sanpham());
                    adapter.notifyDataSetChanged();
                }

            }
        });
        return view;
    }
//    private void showdialog(){
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(context);
//        builder.setTitle("Xóa sản phẩm");
//        builder.setMessage("Nhập ID sản phẩm cần xóa:");
//
//        final EditText input = new EditText(context);
//        builder.setView(input);
//
//        builder.setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int id) {
//                String productId = input.getText().toString();
//                SQLiteDatabase db = getWritableDatabase();
//                db.delete("spchitiet", "ID = ?", new String[]{productId});
//                // Xử lý xóa sản phẩm với ID là productId
//            }
//        });
//
//        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int id) {
//                dialog.cancel();
//            }
//        });
//
//        AlertDialog dialog = builder.create();
//        dialog.show();
//    }
}