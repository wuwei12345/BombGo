package com.bombgo.bombgo;

import android.graphics.Color;
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
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import Utils.BmobUri;
import Utils.RetrofitUtils;
import bean.SrearchBean;
import butterknife.Bind;
import butterknife.ButterKnife;
import fragment.BmobFragment;
import fragment.RankingFragment;
import fragment.SrearchFramgent;
import fragment.channelFragment;
import initerface.Initerface;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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
    @Bind(R.id.act_channel_edit)
    EditText actChannelEdit;
    @Bind(R.id.act_spinner)
    Spinner actSpinner;

    private List<Fragment> fragmentlist = new ArrayList();
    private actViewAdapter adapter;
    private FragmentTransaction ft;
    //    private List<Fragment> bmobfragment = new ArrayList<>();

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
            actViewpage.setCurrentItem(0);
            toolbar.setTitle("暴走日报");
            actChannelEdit.setVisibility(View.GONE);
            actSpinner.setVisibility(View.GONE);
        } else if (id == R.id.nav_gallery) {
            actViewpage.setCurrentItem(1);
            toolbar.setTitle("暴走日报");
            actChannelEdit.setVisibility(View.GONE);
            actSpinner.setVisibility(View.VISIBLE);
        } else if (id == R.id.nav_slideshow) {
            actViewpage.setCurrentItem(2);
            toolbar.setTitle("暴走日报");
            actChannelEdit.setVisibility(View.GONE);
            actSpinner.setVisibility(View.GONE);
        } else if (id == R.id.nav_manage) {
            actViewpage.setCurrentItem(3);
            toolbar.setTitle("");
            actChannelEdit.setVisibility(View.VISIBLE);
            actSpinner.setVisibility(View.GONE);
        } else if (id == R.id.nav_share) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //初始化操作
    @Override
    public void initview() {
        actViewpage.setOffscreenPageLimit(3);
        toolbar.setTitle("暴走日报");
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        navView.setNavigationItemSelectedListener(this);
        final BmobFragment bm1 = new BmobFragment();
        final RankingFragment bm2 = new RankingFragment();
        final channelFragment bm3 = new channelFragment();
        final SrearchFramgent bm4 = new SrearchFramgent();
        fragmentlist.add(bm1);
        fragmentlist.add(bm2);
        fragmentlist.add(bm3);
        fragmentlist.add(bm4);

        adapter = new actViewAdapter(getSupportFragmentManager(), fragmentlist);
        actViewpage.setAdapter(adapter);
//      软键盘回车点击事件
        actChannelEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_UNSPECIFIED) {
                    Toast.makeText(MainActivity.this, "开始搜索", Toast.LENGTH_SHORT).show();
                    RetrofitUtils
                            .getInstance()
                            .getRetrofit(BmobUri.BMOBGO_URI)
                            .create(RetrofitUtils.BmobGo.class)
                            .SrearchDataBean(BmobUri.PAGE, actChannelEdit.getText().toString().trim())
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Observer<SrearchBean>() {
                                @Override
                                public void onCompleted() {

                                }

                                @Override
                                public void onError(Throwable e) {
                                    Logger.i(e.toString());
                                }

                                @Override
                                public void onNext(SrearchBean srearchBean) {
                                    Logger.i("" + srearchBean.getData().size());
                                    Bundle bundle = new Bundle();
//                                    bundle.putSerializable("srearch",srearchBean);
                                    bm4.setdata(srearchBean, actChannelEdit.getText().toString().trim());
                                }
                            });
                }
                return false;
            }
        });
        //spinner
        List<String> spinstr = new ArrayList<>();
        spinstr.add("今天");
        spinstr.add("7天");
        spinstr.add("30天");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, spinstr);
        arrayAdapter.setDropDownViewResource(R.layout.dropdown_stytle);
        actSpinner.setAdapter(arrayAdapter);
        //spinner监听事件
        actSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                bm2.setdata(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
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

    class actViewAdapter extends FragmentPagerAdapter {
        List<Fragment> listfragment;

        public actViewAdapter(FragmentManager fm, List<Fragment> listfragment) {
            super(fm);
            this.listfragment = listfragment;
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
