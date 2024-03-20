package com.example.duan1chinhthuc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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

import com.example.duan1chinhthuc.Frament.Fragment_canhan;
import com.example.duan1chinhthuc.Frament.Fragment_home;
import com.example.duan1chinhthuc.Frament.Fragment_thongbao;
import com.example.duan1chinhthuc.Frament.Frament_yeuthich;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawerLayout;
    public static final int Frament_QL_PM = 1 ;
    private int mCurrentFrament = Frament_QL_PM;

    private Context context;
    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.draw_layout);
        Toolbar toolbar = findViewById(R.id.main_menu_2);
        setSupportActionBar(toolbar);

        ImageView giohang = findViewById(R.id.giohang_main);
        giohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, giohang.class);
                startActivity(intent);
                finish();
            }
        });



        //
//        NavigationView navigationView = findViewById(R.id.nvView);
//        navigationView.setNavigationItemSelectedListener(this);

        //start app
//        repleFrament(new Fragment_home());
//        navigationView.getMenu().findItem(R.id.profile).setChecked(true);
//


//
//        SharedPreferences sharedPreferences = getSharedPreferences("Thongtin", MODE_PRIVATE);
//        String loaiTK = sharedPreferences.getString("loaitaikhoan", "");
//        if (!loaiTK.equals("admin")){
//            Menu menu = navigationView.getMenu();
//            menu.findItem(R.id.taotaikhoan).setVisible(false);
//        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_nav_2,menu);
//        getMenuInflater().inflate(R.menu.menu_nav_1,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        //,menu_1
//        int id1 = item.getItemId();
//
//        if (id1==R.id.menu_nav_1){
//            drawerLayout.openDrawer(GravityCompat.START);
//
//        }

        //// menu_2
        FragmentManager fragmentManager = getSupportFragmentManager();
        try {
            if (id==R.id.nav_home){

                Fragment fragment = new Fragment_home();
                fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
            }else if (id==R.id.nav_yeuthich){

                Fragment fragment = new Frament_yeuthich();
                fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
            }
            else if (id==R.id.nav_thongbao){

                Fragment fragment = new Fragment_thongbao();
                fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
            }
            else if (id==R.id.nav_canhan){

                Fragment fragment = new Fragment_canhan();
                fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
            }
            drawerLayout.closeDrawer(GravityCompat.END);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }


        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

//        int id1 = item.getItemId();
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        try {
//            if (id1==R.id.profile){
//
//                Fragment fragment = new Fragment_profile();
//                fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
//            }
//            drawerLayout.closeDrawer(GravityCompat.END);
//            return true;
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        return false;
    }

    private void repleFrament(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout,fragment);
        transaction.commit();
    }
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.END)){
            drawerLayout.closeDrawer(GravityCompat.END);
        }else {
            super.onBackPressed();
        }

    }

//private void showdialog(){
//    AlertDialog.Builder builder= new AlertDialog.Builder(context);
//    LayoutInflater inflater = getLayoutInflater();
//    View view = inflater.inflate(R.layout.dialog_menu_1, null);
//    builder.setView(view);
//
//}
}




//package com.example.nhom12__x;
//
//import static com.example.nhom12__x.R.id.nav_home;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.Toolbar;
//import androidx.core.view.GravityCompat;
//import androidx.drawerlayout.widget.DrawerLayout;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentPagerAdapter;
//import androidx.fragment.app.FragmentStatePagerAdapter;
//import androidx.viewpager.widget.ViewPager;
//
//import android.annotation.SuppressLint;
//import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//
//import com.example.nhom12__x.Frament.Fragment_home;
//import com.example.nhom12__x.Frament.View_page;
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//import com.google.android.material.navigation.NavigationView;
//
//public class MainActivity extends AppCompatActivity {
//private ViewPager viewPage;
//
//    DrawerLayout drawerLayout;
//private BottomNavigationView bottomNavigationView;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//
//
//        drawerLayout = findViewById(R.id.draw_layout);
//        Toolbar toolbar = findViewById(R.id.main_menu_2);
//        setSupportActionBar(toolbar);
////        viewPage = findViewById(R.id.viewPager);
////        bottomNavigationView = findViewById(R.id.main_menu_2);
//
//        View_page adapter = new View_page(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
//        viewPage.setAdapter(adapter);
//
//        viewPage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//
//                switch (position){
//
//                    case 0:
//                        bottomNavigationView.getMenu().findItem(R.id.nav_home).setChecked(true);
//                        break;
//                    case 1:
//                        bottomNavigationView.getMenu().findItem(R.id.nav_yeuthich).setChecked(true);
//                        break;
//                    case 2:
//                        bottomNavigationView.getMenu().findItem(R.id.nav_thongbao).setChecked(true);
//                        break;
//                    case 3:
//                        bottomNavigationView.getMenu().findItem(R.id.nav_canhan).setChecked(true);
//                        break;
//
//                }
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//
//        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
//            @Override
//            public void onNavigationItemReselected(@NonNull MenuItem item) {
//                int id = item.getItemId();
//                FragmentManager fragmentManager = getSupportFragmentManager();
//                if (id== nav_home){
//
//                    Fragment fragment = new Fragment_home();
//                    fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
//                }
//                drawerLayout.closeDrawer(GravityCompat.END);
//
////                switch (item.getItemId()){
////                    case 0:
////                        viewPage.setCurrentItem(0);
////                        break;
////                    case 1:
////                        viewPage.setCurrentItem(1);
////                        break;
////                    case 2:
////                        viewPage.setCurrentItem(2);
////                        break;
////                    case 3:
////                        viewPage.setCurrentItem(3);
////                        break;
////
////                }
//            }
//        });
//
//
//
//    }
//
//}