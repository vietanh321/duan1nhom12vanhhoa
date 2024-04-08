package com.example.duan1chinhthuc.Frament_user;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class View_page extends FragmentStatePagerAdapter {


    public View_page(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 : return  new Fragment_home();
            case 1 : return new Frament_yeuthich();
            case 2 : return new Fragment_thongbao();
            case 3 : return new Fragment_canhan();


        }
        return null;
    }


    @Override
    public int getCount() {
        return 0;
    }
}
