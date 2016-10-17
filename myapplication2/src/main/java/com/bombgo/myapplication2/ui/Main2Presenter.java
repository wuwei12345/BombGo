package com.bombgo.myapplication2.ui;

/**
 * Created by zhonghang on 2016/10/9.
 */

public class Main2Presenter implements Main2Contract.Presenter {
    private Main2Contract.View mView;
    private Main2Contract.Modle mModle;

    public Main2Presenter() {
    }

    @Override
    public void detachView() {
        //此处用于销毁网络连接，或者查询数据库的操作，耗时操作导致view不能被正常回收导致内存泄漏
    }

    @Override
    public void attachView(Main2Contract.View view) {
        mView = view;
        this.mModle = new Main2Modle();
    }
}
