package com.example.duan1chinhthuc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.duan1chinhthuc.Fragment_admin.QL_donhang;
import com.example.duan1chinhthuc.Fragment_admin.QL_tk_user;
import com.example.duan1chinhthuc.Fragment_admin.add_delete_update;
import com.example.duan1chinhthuc.Fragment_admin.delete_sp;
import com.example.duan1chinhthuc.Fragment_admin.fragment_doanhthu;
import com.example.duan1chinhthuc.Fragment_admin.update_sp;
import com.example.duan1chinhthuc.Frament.Fragment_canhan;
import com.example.duan1chinhthuc.Frament.Fragment_home;
import com.example.duan1chinhthuc.Frament.Frament_yeuthich;
import com.example.duan1chinhthuc.Frament.Fragment_thongbao;


import com.example.duan1chinhthuc.Frament.danh_muc_sp;
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
            menu.findItem(R.id.m_xóaanpham).setVisible(false);
            menu.findItem(R.id.m_update).setVisible(false);
            menu.findItem(R.id.m_QL_TK_user).setVisible(false);
            menu.findItem(R.id.m_QL_DH).setVisible(false);

        }

        if (!loaiTK.equals("thuthu")){
            Menu menu = navigationView.getMenu();
            menu.findItem(R.id.m_Favorite).setVisible(false);
            menu.findItem(R.id.m_Orders).setVisible(false);
            menu.findItem(R.id.m_Notification).setVisible(false);

        }
        if (loaiTK.equals("admin")){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Thông báo");
            builder.setMessage("Bạn đang là admin. Bạn có muốn chuyển qua trang quản lý của admin không?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

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

        ImageView giohang = findViewById(R.id.giohang_main);
        giohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (loaiTK.equals("admin")){
                        AlertDialog.Builder builder1;
                        builder1 = new AlertDialog.Builder(context);
                        builder1.setTitle("Thông báo");
                        builder1.setMessage("Bạn đang là admin không thể dùng chức năng");
                        builder1.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();

                            }
                        });
                        builder1.setPositiveButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();

                            }
                        });
                        builder1.show();
                    }else {
                        Intent intent = new Intent(MainActivity.this, order.class);
                        startActivity(intent);
                        finish();
                       }
                }catch (Exception e){}


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

                Fragment fragment = new danh_muc_sp();
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

                Fragment fragment = new Fragment_canhan();
                fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
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
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Thông báo");
                    builder.setMessage("Bạn có Muốn Đăng Xuất Không ?");
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(MainActivity.this, dangnhap.class);
                            startActivity(intent);
                            finish();
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    builder.show();

            } if (id == R.id.m_themsanpham) {
                Fragment fragment = new add_delete_update();
                fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
            }else if (id == R.id.m_xóaanpham) {
                Fragment fragment = new delete_sp();
                fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
            }else if (id == R.id.m_update) {
                Fragment fragment = new update_sp();
                fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
            }else if (id == R.id.m_QL_DH) {
                Fragment fragment = new QL_donhang();
                fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
            }else if (id == R.id.m_QL_TK_user) {
                Fragment fragment = new QL_tk_user();
                fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
            }else if (id == R.id.m_thongke) {
                Fragment fragment = new fragment_doanhthu();
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

