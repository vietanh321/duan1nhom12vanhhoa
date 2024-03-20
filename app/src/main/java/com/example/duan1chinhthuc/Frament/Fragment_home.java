package com.example.duan1chinhthuc.Frament;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.duan1chinhthuc.R;

public class Fragment_home extends Fragment {
Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view =  inflater.inflate(R.layout.fragment_home2, container, false).getRootView();
        ImageView sale_img = view.findViewById(R.id.fragment_home_img_sale);

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


       return view;
    }
    private void showdialog(){

//        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//        LayoutInflater inflater = getLayoutInflater();
//        View view = inflater.inflate(R.layout.dialog_sale,null);
//        builder.setView(view);
//        AlertDialog alertDialog = builder.create();
//        alertDialog.show();
    }
}