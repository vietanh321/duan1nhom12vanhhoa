package com.example.duan1chinhthuc.Frament;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.duan1chinhthuc.R;


public class Fragment_sale extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_sale, container, false).getRootView();

        TextView back = view.findViewById(R.id.back_sale);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                if (id==R.id.back_sale){

                    Fragment fragment = new Fragment_home();
                    fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
                }

            }
        });
     return view;
    }
}