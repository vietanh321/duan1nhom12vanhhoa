package com.example.duan1chinhthuc.Frament;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.duan1chinhthuc.R;
import com.example.duan1chinhthuc.mode.San_Pham;

public class Fragment_yeuthich extends Fragment {

    private static final String ARG_SAN_PHAM = "sanPham";

    private San_Pham sanPham;

    public Fragment_yeuthich() {
        // Required empty public constructor
    }

    public static Fragment_yeuthich newInstance(San_Pham sanPham) {
        Fragment_yeuthich fragment = new Fragment_yeuthich();
        Bundle args = new Bundle();
        args.putSerializable(ARG_SAN_PHAM, sanPham);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            sanPham = (San_Pham) getArguments().getSerializable(ARG_SAN_PHAM);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_frament_yeuthich, container, false);

        // Hiển thị thông tin của sản phẩm yêu thích
        if (sanPham != null) {
            TextView tenSP = rootView.findViewById(R.id.item_ten_sp_home_12);
            TextView tieude = rootView.findViewById(R.id.item_tieude_sp_home_12);
            TextView trangthai = rootView.findViewById(R.id.item_trangthai_sp_home_12);
            TextView tenchatlieu = rootView.findViewById(R.id.item_tenCL_sp_home_12);
            TextView giatien = rootView.findViewById(R.id.item_giatien_sp_home_12);
            TextView size = rootView.findViewById(R.id.item_Size_sp_home_12);

            tenSP.setText(sanPham.getTensp());
            tieude.setText(sanPham.getTieude());
            trangthai.setText(sanPham.getTrangthai());
            tenchatlieu.setText(sanPham.getTenchatlieu());
            giatien.setText(String.valueOf(sanPham.getGiatien()));
            size.setText(String.valueOf(sanPham.getSize()));
        }

        // Xử lý khi người dùng click vào trái tim
        ImageView heartIcon = rootView.findViewById(R.id.myImageView);
        heartIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xử lý khi trái tim được click
                // Ví dụ: Thêm sản phẩm vào danh sách yêu thích
                Toast.makeText(getContext(), "Sản phẩm đã được thêm vào danh sách yêu thích", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }
}
