package com.example.duan1chinhthuc.Activity_ADMIN;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.duan1chinhthuc.Activity_user.MainActivity;
import com.example.duan1chinhthuc.Activity_user.dangnhap;
import com.example.duan1chinhthuc.Activity_user.order;
import com.example.duan1chinhthuc.Fragment_admin.QL_donhang;
import com.example.duan1chinhthuc.Fragment_admin.QL_tk_user;
import com.example.duan1chinhthuc.Fragment_admin.add_delete_update;
import com.example.duan1chinhthuc.Fragment_admin.delete_sp;
import com.example.duan1chinhthuc.Fragment_admin.fragment_doanhthu;
import com.example.duan1chinhthuc.Fragment_admin.update_sp;
import com.example.duan1chinhthuc.Frament_user.Fragment_canhan;
import com.example.duan1chinhthuc.Frament_user.Fragment_home;
import com.example.duan1chinhthuc.Frament_user.Fragment_thongbao;
import com.example.duan1chinhthuc.Frament_user.Frament_yeuthich;
import com.example.duan1chinhthuc.Frament_user.danh_muc_sp;
import com.example.duan1chinhthuc.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity_admin extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawerLayout;
    public static final int Frament_QL_PM = 1;
    private int mCurrentFrament = Frament_QL_PM;

    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);

        drawerLayout = findViewById(R.id.admin_draw_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        Toolbar toolbar2 = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        setSupportActionBar(toolbar2);

        NavigationView navigationView = findViewById(R.id.nvView);
        navigationView.setNavigationItemSelectedListener(this);



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.admin_menu_nav_2, menu);
        getMenuInflater().inflate(R.menu.admin_menu_nav_1, menu);

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.admin_menu_nav_1) {
            drawerLayout.openDrawer(GravityCompat.START);
        }

        //// menu_2
        FragmentManager fragmentManager = getSupportFragmentManager();
        try {
            if (id == R.id.nav_home) {

            }else if (id == R.id.nav_thongbao) {

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
            }else if (id == R.id.m_Dangxuat) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn có Muốn Đăng Xuất Không ?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity_admin.this, dangnhap.class);
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
}