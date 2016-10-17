package com.bombgo.myapplication.ui;

import android.os.Bundle;

import com.bombgo.myapplication.R;
import com.bombgo.myapplication.base.BaseActivity;

public class Main2Activity extends BaseActivity implements Main2Contract.View {
    private Main2Contract.Presenter mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new Main2Presenter();
        mPresenter.attachView(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main2;
    }

    @Override
    public void initViews() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
