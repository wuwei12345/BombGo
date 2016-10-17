package com.bombgo.myapplication.ui;

import com.bombgo.myapplication.base.IModle;
import com.bombgo.myapplication.base.IPresenter;
import com.bombgo.myapplication.base.IView;

/**
 * Created by zhonghang on 2016/10/9.
 */

public class Main2Contract {
    public interface View extends IView {

    }

    public interface Modle extends IModle {

    }

    public interface Presenter extends IPresenter<View> {

    }
}
