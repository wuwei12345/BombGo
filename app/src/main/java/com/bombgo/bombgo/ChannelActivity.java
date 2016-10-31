package com.bombgo.bombgo;

import android.os.Bundle;
import android.renderscript.Script;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.orhanobut.logger.Logger;

import java.util.List;

import Utils.BmobUri;
import Utils.RetrofitUtils;
import Utils.SpaceItemDecoration;
import adapter.channeltwoAdapter;
import bean.channeltwoBean;
import butterknife.Bind;
import butterknife.ButterKnife;
import initerface.Initerface;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ChannelActivity extends AppCompatActivity implements Initerface {

    @Bind(R.id.act_channel_toolbar)
    Toolbar actChannelToolbar;
    @Bind(R.id.act_channel_recyclerview)
    XRecyclerView actChannelRecyclerview;
    private String id;
    private String title;
    private String load="";
    private channeltwoBean mchanneltwobean;
    private int TYPEFLAG=BmobUri.TYPE_DOWN;
    private channeltwoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel);
        ButterKnife.bind(this);
        initview();
        initdata();
        initviewoper();
    }

    @Override
    public void initview() {
        //接受传过来的id,title
        id = getIntent().getStringExtra("id");
        title=getIntent().getStringExtra("title");
        actChannelToolbar.setTitle(title);
        //设置返回按钮
        setSupportActionBar(actChannelToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actChannelToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        //设置列表样式
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        actChannelRecyclerview.setLayoutManager(manager);
        //设置item间距
        actChannelRecyclerview.addItemDecoration(new SpaceItemDecoration(5));
        //设置刷新样式以及主题
        actChannelRecyclerview.setRefreshProgressStyle(ProgressStyle.BallPulse);
        actChannelRecyclerview.setLoadingMoreProgressStyle(ProgressStyle.SquareSpin);
    }

    @Override
    public void initdata() {
        Logger.e(BmobUri.CHANNEL_URI_TWO+id+load);
        //加载数据
        RetrofitUtils
                .getInstance()
                .getRetrofit(BmobUri.BMOBGO_URI)
                .create(RetrofitUtils.BmobGo.class)
                .channeltwoDataBean(BmobUri.CHANNEL_URI_TWO+id+load)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<channeltwoBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.e(e.toString());
                    }

                    @Override
                    public void onNext(channeltwoBean channeltwoBean) {
                        if (TYPEFLAG==BmobUri.TYPE_DOWN) {
                            mchanneltwobean=channeltwoBean;
                            adapter = new channeltwoAdapter(mchanneltwobean.getData(), ChannelActivity.this);
                            actChannelRecyclerview.setAdapter(adapter);
                            actChannelRecyclerview.refreshComplete();
                        }else{
                            mchanneltwobean.setTimestamp(channeltwoBean.getTimestamp());
                            mchanneltwobean.getData().addAll(channeltwoBean.getData());
                            adapter.setdata(mchanneltwobean);
                            adapter.notifyDataSetChanged();
                            actChannelRecyclerview.loadMoreComplete();
                        }
                    }
                });
    }

    @Override
    public void initviewoper() {
    //刷新以及加载
      actChannelRecyclerview.setLoadingListener(new XRecyclerView.LoadingListener() {
          @Override
          public void onRefresh() {
              TYPEFLAG=BmobUri.TYPE_DOWN;
              load="";
              initdata();
          }

          @Override
          public void onLoadMore() {
              TYPEFLAG=BmobUri.TYPE_LOAD;
              load="?timestamp="+mchanneltwobean.getTimestamp()+"&";
              initdata();
          }
      });
    }
}
