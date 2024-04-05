package com.example.duan1chinhthuc.Frament;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1chinhthuc.Adapter.Home_adapter;
import com.example.duan1chinhthuc.Adapter.adapter_user;
import com.example.duan1chinhthuc.DAO.Home_DAO;
import com.example.duan1chinhthuc.InterfaceRecycle;
import com.example.duan1chinhthuc.R;
//import com.example.duan1chinhthuc.chitiet.chitiet_sp;
import com.example.duan1chinhthuc.mode.SanPhamChiTiet;
import com.example.duan1chinhthuc.mode.San_Pham;
import com.example.duan1chinhthuc.mode.gio_hang;

import java.util.ArrayList;

public class Fragment_home extends Fragment {
    private static boolean visible;
    RecyclerView rcv;
    Home_DAO dao;
    adapter_user adapter;

ArrayList <San_Pham> list;

ArrayList<SanPhamChiTiet> list1;
    public static ArrayList<gio_hang> manggiohang;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view =  inflater.inflate(R.layout.fragment_home2, container, false).getRootView();
        ImageView sale_img = view.findViewById(R.id.fragment_home_img_sale);

        rcv = view.findViewById(R.id.fragment_home_rcv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rcv.setLayoutManager(layoutManager);

        dao = new Home_DAO(getContext());
        list = dao.getDS_sanpham();
        adapter = new adapter_user(list, getContext());
        rcv.setAdapter(adapter);

        ImageView addtocarrt = view.findViewById(R.id.add_to_cart);
//        adapter.setOnclickRecycle(new InterfaceRecycle() {
//            @Override
//            public void setOnclick(int position) {
//                Intent intent = new Intent(getActivity(), chitiet_sp.class);
//                intent.putExtra("thongtinchitiet", list.get(position));
//                startActivity(intent);
//            }
//        });

        sale_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                if (id==R.id.fragment_home_img_sale){

                    Fragment fragment = new Fragment_sale();
                    fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
                }



            }
        });

        SearchView srview = view.findViewById(R.id.searchSach);
        srview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<San_Pham> newlist = new ArrayList<>();
                for (San_Pham s : list){
                    if (s.getTensp().toLowerCase().contains(newText.toLowerCase())){
                        newlist.add(s);
                    }
                }
                gettimkiem(newlist);
                return false;
            }
        });
       return view;
    }

    private void gettimkiem (ArrayList<San_Pham> list){
        //data
        adapter = new adapter_user(list, getContext());
        rcv.setAdapter(adapter);
    }
//    private void showdialog(){
//
//        AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext());
//        LayoutInflater inflater1 = getLayoutInflater();
//        View view1 = inflater1.inflate(R.layout.item_add_sanpham, null);
//        builder1.setView(view1);
//        AlertDialog alertDialog = builder1.create();
//        Button btnadd = view1.findViewById(R.id.item_add);
//        EditText idsp = view1.findViewById(R.id.item_id_sp_home);
//        EditText tensp = view1.findViewById(R.id.item_ten_sp_home);
//        EditText ngay =view1.findViewById(R.id.item_ngay_sp_home);
//        EditText trangthai =view1.findViewById(R.id.item_trangthai_sp_home);
//        EditText tieude =view1.findViewById(R.id.item_tieude_sp_home);
//        EditText item_tenCL_sp_home =view1.findViewById(R.id.item_tenCL_sp_home);
//        EditText item_giatien_sp_home =view1.findViewById(R.id.item_giatien_sp_home);
//        EditText item_Size_sp_home =view1.findViewById(R.id.item_Size_sp_home);
//
//
//        btnadd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                try{
//                    int id = Integer.parseInt(idsp.getText().toString());
//                    String ten = tensp.getText().toString();
//                    String ngayd = ngay.getText().toString();
//                    String TT = trangthai.getText().toString();
//                    String TD = tieude.getText().toString();
//                    String TCL = item_tenCL_sp_home.getText().toString();
//                    int giatien = Integer.parseInt(item_giatien_sp_home.getText().toString());
//                    int Size = Integer.parseInt(item_Size_sp_home.getText().toString());
//
//
//                    boolean kt = dao.themSP(id,ten,ngayd,TT,TD,TCL,giatien,Size);
//                    if(kt){
//                        list.clear();
//                        list.addAll(dao.getDS_sanpham());
//                        adapter.notifyDataSetChanged();
//                        alertDialog.dismiss();
//                        Toast.makeText(getContext(), "Thanh cong", Toast.LENGTH_SHORT).show();
//                    }
//                }catch (NumberFormatException e){
//                    Log.i(TAG, "loi", e);
//                }
//            }
//        });
//
//
//    }
}