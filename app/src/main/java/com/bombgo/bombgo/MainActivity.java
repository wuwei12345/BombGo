package com.bombgo.bombgo;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import adapter.BmobAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;
import fragment.BmobFragment;
import fragment.RankingFragment;
import initerface.Initerface;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, Initerface {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.nav_view)
    NavigationView navView;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @Bind(R.id.act_fragmentlayout)
    FrameLayout actFragmentlayout;
    @Bind(R.id.act_viewpage)
    ViewPager actViewpage;

    private List<Fragment> fragmentlist = new ArrayList();
    private actViewAdapter adapter;
    private FragmentTransaction ft;
//    private List<Fragment> bmobfragment = new ArrayList<>();
    private Fragment mfragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initview();
        initdata();
        initviewoper();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            actViewpage.setCurrentItem(0);
        } else if (id == R.id.nav_gallery) {
            actViewpage.setCurrentItem(1);
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //初始化操作
    @Override
    public void initview() {
//        actBombgoTablayout.setTabMode(TabLayout.MODE_FIXED);
//        actBmobMvp.setOffscreenPageLimit(3);
        actViewpage.setOffscreenPageLimit(1);
        toolbar.setTitle("暴走日报");
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        navView.setNavigationItemSelectedListener(this);
        BmobFragment bm1=new BmobFragment();
        RankingFragment bm2=new RankingFragment();
//        BmobFragment bm3=new BmobFragment();
//        BmobFragment bm4=new BmobFragment();
        fragmentlist.add(bm1);
        fragmentlist.add(bm2);
//        fragmentlist.add(bm3);
//        fragmentlist.add(bm4);

        adapter=new actViewAdapter(getSupportFragmentManager(),fragmentlist);
        actViewpage.setAdapter(adapter);
//        actViewpage.

    }

    //加载数据
    @Override
    public void initdata() {
        actViewpage.setCurrentItem(0);
    }

//    private void LoadData(FragmentTransaction ft, int positon) {
//        ft = getSupportFragmentManager().beginTransaction();
//        hindFragment(ft, positon);
//        if (fragmentlist.get(positon) != null) {
//            if (!fragmentlist.get(positon).isAdded()) {
////                bmobfragment.get(positon).setdata(positon);
//                ft.add(R.id.act_fragmentlayout, fragmentlist.get(positon));
//                ft.show(fragmentlist.get(positon));
////                ft.replace(R.id.act_fragmentlayout,bmobfragment.get(positon));
//            } else {
//                Logger.i("显示fragment");
//                ft.show(fragmentlist.get(positon));
//            }
//        }
//        ft.commit();
//    }

//    private void hindFragment(FragmentTransaction ft, int postion) {
//        for (int i = 0; i < bmobfragment.size(); i++) {
//            ft.hide(bmobfragment.get(i));
////                ft.remove(bmobfragment.get(i));
//        }
//    }

    @Override
    public void initviewoper() {

    }

    class actViewAdapter extends FragmentPagerAdapter{
        List<Fragment> listfragment;
        public actViewAdapter(FragmentManager fm,List<Fragment> listfragment) {
            super(fm);
            this.listfragment=listfragment;
        }
        @Override
        public Fragment getItem(int position) {
            return listfragment.get(position);
        }

        @Override
        public int getCount() {
            return listfragment.size();
        }
    }

}
