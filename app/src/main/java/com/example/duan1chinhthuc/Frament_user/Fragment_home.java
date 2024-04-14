package com.example.duan1chinhthuc.Frament_user;


import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.duan1chinhthuc.Adapter.SlideAdapter;
import com.example.duan1chinhthuc.Adapter.adapter_user;
import com.example.duan1chinhthuc.DAO.Home_DAO;
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
    ViewPager viewPager;
    SlideAdapter slideAdapter;
    int[] images = {R.drawable.banner_1, R.drawable.banner_2, R.drawable.banner_sale_fragmenthome, R.drawable.banner_3, R.drawable.banner_4};
    private static final long SLIDE_DELAY = 3000;
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        public void run() {
            int nextSlide = viewPager.getCurrentItem() + 1;
            if (nextSlide >= images.length) {
                nextSlide = 0;
            }
            viewPager.setCurrentItem(nextSlide, true);
            // Lặp lại việc gửi tin nhắn sau mỗi khoảng thời gian
            handler.postDelayed(this, SLIDE_DELAY);
        }
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view =  inflater.inflate(R.layout.fragment_home2, container, false).getRootView();
//        ImageView sale_img = view.findViewById(R.id.fragment_home_img_sale);

        rcv = view.findViewById(R.id.fragment_home_rcv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rcv.setLayoutManager(layoutManager);

        dao = new Home_DAO(getContext());
        list = dao.getDS_sanpham();
        adapter = new adapter_user(list, getContext());
        rcv.setAdapter(adapter);

        TextView bsl = view.findViewById(R.id.bestseller);
        bsl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                Fragment fragment = new best_seller();
                fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
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



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CardView cardView = view.findViewById(R.id.cardView_nguoidung);


        cardView.setCardBackgroundColor(Color.WHITE);
        cardView.setRadius(20);

        cardView.setCardElevation(8);
        viewPager = view.findViewById(R.id.viewPager_nguoidung);
        slideAdapter = new SlideAdapter(getActivity(), images);
        viewPager.setAdapter(slideAdapter);

        handler.postDelayed(runnable, SLIDE_DELAY);


    }
    private void gettimkiem (ArrayList<San_Pham> list){
        //data
        adapter = new adapter_user(list, getContext());
        rcv.setAdapter(adapter);
    }
    public void onDestroy() {
        super.onDestroy();
        // Dừng việc gửi tin nhắn khi activity bị hủy
        handler.removeCallbacks(runnable);
    }
}