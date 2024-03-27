////package com.example.duan1chinhthuc;
////
////import android.annotation.SuppressLint;
////import android.content.Context;
////import android.content.Intent;
////import android.os.Bundle;
////import android.view.Menu;
////import android.view.MenuItem;
////import android.view.View;
////import android.widget.ImageView;
////
////import androidx.annotation.NonNull;
////import androidx.appcompat.app.AppCompatActivity;
////import androidx.appcompat.widget.Toolbar;
////import androidx.core.view.GravityCompat;
////import androidx.drawerlayout.widget.DrawerLayout;
////import androidx.fragment.app.Fragment;
////import androidx.fragment.app.FragmentManager;
////import androidx.fragment.app.FragmentTransaction;
////
////import com.example.duan1chinhthuc.Frament.Fragment_canhan;
////import com.example.duan1chinhthuc.Frament.Fragment_home;
////import com.example.duan1chinhthuc.Frament.Fragment_thongbao;
////import com.example.duan1chinhthuc.Frament.Frament_yeuthich;
////import com.google.android.material.navigation.NavigationView;
////
////public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
////    private DrawerLayout drawerLayout;
////    public static final int Frament_QL_PM = 0 ;
////    private int mCurrentFrament = Frament_QL_PM;
////
////    private Context context;
////    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_main);
////
////        drawerLayout = findViewById(R.id.draw_layout);
////        Toolbar toolbar = findViewById(R.id.toolbar);
////        setSupportActionBar(toolbar);
////        NavigationView navigationView = findViewById(R.id.nvView);
////        navigationView.setNavigationItemSelectedListener(this);
////
////        //start app
////        repleFrament(new Fragment_home());
////        navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);
////
//////        ImageView giohang = findViewById(R.id.giohang_main);
//////        giohang.setOnClickListener(new View.OnClickListener() {
//////            @Override
//////            public void onClick(View v) {
//////                Intent intent = new Intent(MainActivity.this, giohang.class);
//////                startActivity(intent);
//////                finish();
//////            }
//////        });
////
////    }
////
////    @Override
////    public boolean onCreateOptionsMenu(Menu menu) {
//
////    }
////
////
////    @Override
////    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
////        int id = item.getItemId();
////
////        if (id==R.id.menu_main){
////            drawerLayout.openDrawer(GravityCompat.START);
////
////        }
////
////        //// menu_2
////        FragmentManager fragmentManager = getSupportFragmentManager();
////        try {
////            if (id==R.id.nav_home){
////                if (mCurrentFrament!= Frament_QL_PM){repleFrament(new Fragment_home()); mCurrentFrament = Frament_QL_PM;}
////                Fragment fragment = new Fragment_home();
////                fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
////            }else if (id==R.id.nav_yeuthich){
////
////                Fragment fragment = new Frament_yeuthich();
////                fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
////            }
////            else if (id==R.id.nav_thongbao){
////
////                Fragment fragment = new Fragment_thongbao();
////                fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
////            }
////            else if (id==R.id.nav_canhan){
////
////                Fragment fragment = new Fragment_canhan();
////                fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
////            }
////            drawerLayout.closeDrawer(GravityCompat.END);
////            return true;
////        }catch (Exception e){
////            e.printStackTrace();
////        }
////
////
////        return true;
////    }
////
////    @Override
////    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
////
////
////
////        return false;
////    }
////
////    private void repleFrament(Fragment fragment){
////        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
////        transaction.replace(R.id.frame_layout,fragment);
////        transaction.commit();
////    }
////    @Override
////    public void onBackPressed() {
////        if(drawerLayout.isDrawerOpen(GravityCompat.END)){
////            drawerLayout.closeDrawer(GravityCompat.END);
////        }else {
////            super.onBackPressed();
////        }
////
////    }
////
////
////}
////
////
////
////
//package com.example.duan1chinhthuc;
//
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.Toolbar;
//import androidx.core.view.GravityCompat;
//import androidx.drawerlayout.widget.DrawerLayout;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentTransaction;
//
//
//import com.example.duan1chinhthuc.Frament.Fragment_canhan;
//import com.example.duan1chinhthuc.Frament.Fragment_home;
//import com.example.duan1chinhthuc.Frament.Fragment_thongbao;
//import com.example.duan1chinhthuc.Frament.Frament_yeuthich;
//import com.google.android.material.navigation.NavigationView;
//
//public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
//    private DrawerLayout drawerLayout;
//    public static final int Frament_QL_PM = 1 ;
//    public static final int Frament_QL_LoaiSach = 2 ;
//    public static final int Frament_QL_Sach = 3 ;
//    public static final int Frament_QL_TV = 4 ;
//    public static final int Frament_TOP10 = 5 ;
//    public static final int Frament_DoanhThu = 6 ;
//    public static final int Frament_DoiMatKhau = 7 ;
//    public static final int Frament_DangXuat = 8 ;
//
//    private int mCurrentFrament = Frament_QL_PM;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        drawerLayout = findViewById(R.id.draw_layout);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        Toolbar toolbar2 = findViewById(R.id.toolbar2);
//        setSupportActionBar(toolbar);
//        setSupportActionBar(toolbar2);
//
//        NavigationView navigationView = findViewById(R.id.nvView);
//        navigationView.setNavigationItemSelectedListener(this);
//
//        //start app
//        repleFrament(new Fragment_home());
//        navigationView.getMenu().findItem(R.id.QL_PM).setChecked(true);
//
//
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main,menu);
//        getMenuInflater().inflate(R.menu.menu_nav_2,menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        int id = item.getItemId();
//        if (id==R.id.menu_main){
//            drawerLayout.openDrawer(GravityCompat.START);
//        }
//
//            FragmentManager fragmentManager = getSupportFragmentManager();
//            try {
//                if (id == R.id.nav_home) {
//                    if (mCurrentFrament != Frament_QL_PM) {
//                        repleFrament(new Fragment_home());
//                        mCurrentFrament = Frament_QL_PM;
//                    }
//                    Fragment fragment = new Fragment_home();
//                    fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
//                } else if (id == R.id.nav_yeuthich) {
//
//                    Fragment fragment = new Frament_yeuthich();
//                    fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
//                } else if (id == R.id.nav_thongbao) {
//
//                    Fragment fragment = new Fragment_thongbao();
//                    fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
//                } else if (id == R.id.nav_canhan) {
//
//                    Fragment fragment = new Fragment_canhan();
//                    fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
//                }
//                drawerLayout.closeDrawer(GravityCompat.END);
//                return true;
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        return true;
//    }
//
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        int id = item.getItemId();
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        try {
//            if (id==R.id.QL_PM){
//
//                Fragment fragment = new Fragment_home();
//                fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
//            }
//            drawerLayout.closeDrawer(GravityCompat.END);
//            return true;
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//
//        return false;
//    }
//
//    private void repleFrament(Fragment fragment){
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.frame_layout,fragment);
//        transaction.commit();
//    }
//    @Override
//    public void onBackPressed() {
//        if(drawerLayout.isDrawerOpen(GravityCompat.END)){
//            drawerLayout.closeDrawer(GravityCompat.END);
//        }else {
//            super.onBackPressed();
//        }
//
//    }
//
//}

package com.example.duan1chinhthuc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.duan1chinhthuc.Fragment_admin.add_delete_update;
import com.example.duan1chinhthuc.Fragment_admin.delete_sp;
import com.example.duan1chinhthuc.Frament.Fragment_home;
import com.example.duan1chinhthuc.Frament.Frament_yeuthich;
import com.example.duan1chinhthuc.Frament.Fragment_thongbao;
import com.example.duan1chinhthuc.Frament.Fragment_canhan;


import com.example.duan1chinhthuc.Frament.Fragment_profile;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    public static final int Frament_QL_PM = 1;
    private int mCurrentFrament = Frament_QL_PM;

    private Context context;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.draw_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        Toolbar toolbar2 = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        setSupportActionBar(toolbar2);

        NavigationView navigationView = findViewById(R.id.nvView);
        navigationView.setNavigationItemSelectedListener(this);

        //start app
        repleFrament(new Fragment_home());
        SharedPreferences sharedPreferences = getSharedPreferences("Thongtin", MODE_PRIVATE);
        String loaiTK = sharedPreferences.getString("loaitaikhoan", "");
        if (!loaiTK.equals("admin")){
            Menu menu = navigationView.getMenu();
            menu.findItem(R.id.m_themsanpham).setVisible(false);
        }

        ImageView giohang = findViewById(R.id.giohang_main);
        giohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, giohang.class);
                startActivity(intent);
                finish();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_nav_2, menu);
        getMenuInflater().inflate(R.menu.menu_nav_1, menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_nav_1) {
            drawerLayout.openDrawer(GravityCompat.START);
        }

        //// menu_2
        FragmentManager fragmentManager = getSupportFragmentManager();
        try {
            if (id == R.id.nav_home) {

                Fragment fragment = new Fragment_home();
                fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
            } else if (id == R.id.nav_yeuthich) {

                Fragment fragment = new Frament_yeuthich();
                fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
            } else if (id == R.id.nav_thongbao) {

                Fragment fragment = new Fragment_thongbao();
                fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
            } else if (id == R.id.nav_canhan) {

                Fragment fragment = new Fragment_canhan();
                fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
            }
            drawerLayout.closeDrawer(GravityCompat.END);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }


        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        FragmentManager fragmentManager = getSupportFragmentManager();
        try {
            if (id == R.id.m_profile) {

                Fragment fragment = new Fragment_profile();
                fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
            }else   if (id == R.id.m_mycart) {
                        Intent intent = new Intent(MainActivity.this, giohang.class);
                        startActivity(intent);
                        finish();
            }else  if (id == R.id.m_Favorite) {
                Fragment fragment = new Frament_yeuthich();
                fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
            }else  if (id == R.id.m_Orders) {

                Intent intent = new Intent(MainActivity.this, order.class);
                startActivity(intent);
                finish();
           }else  if (id == R.id.m_Notification) {

                Fragment fragment = new Fragment_thongbao();
                fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
            }else if (id == R.id.m_Dangxuat) {
                Intent intent = new Intent(MainActivity.this, dangnhap.class);
                startActivity(intent);
                finish();
            } if (id == R.id.m_themsanpham) {
                Fragment fragment = new add_delete_update();
                fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
            }else if (id == R.id.m_xóaanpham) {
                Fragment fragment = new delete_sp();
                fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
            }
                drawerLayout.closeDrawer(GravityCompat.END);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    private void repleFrament(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, fragment);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.END)) {
            drawerLayout.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
        }

    }
}
