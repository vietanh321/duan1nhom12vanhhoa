package com.example.duan1chinhthuc.Frament;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.duan1chinhthuc.R;
public class Fragment_thongbao extends Fragment {

    public Fragment_thongbao() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_thongbao, container, false);
    }
}