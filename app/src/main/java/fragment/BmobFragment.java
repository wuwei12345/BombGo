package fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bombgo.bombgo.R;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import Utils.BmobUri;
import Utils.RetrofitUtils;
import adapter.BmobAdapter;
import bean.bmobGoBean;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import initerface.Initerface;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class BmobFragment extends Fragment implements Initerface {

    @Bind(R.id.act_bombgo_tablayout)
    TabLayout actBombgoTablayout;
    @Bind(R.id.act_bmob_Mvp)
    ViewPager actBmobMvp;
    @Bind(R.id.act_bmob_error)
    TextView actBmobError;
    private BmobAdapter adapter;
    private List<HomePageFragment> fragmentlist = new ArrayList<>();
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bmob, container, false);
        ButterKnife.bind(this, view);
        actBmobMvp.setOffscreenPageLimit(3);
        initview();
        return view;
//        }

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    //初始化数据
    @Override
    public void initview() {
                HomeLoading();
    }

    private void HomeLoading() {
        //网络访问，json解析，ui设置
        RetrofitUtils.BmobGo bmobGo = RetrofitUtils
                .getInstance().getRetrofit(BmobUri.BMOBGO_URI)
                .create(RetrofitUtils.BmobGo.class);
        bmobGo.repoDataBean().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<bmobGoBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        actBmobMvp.setVisibility(View.GONE);
                        actBombgoTablayout.setVisibility(View.GONE);
                        actBmobError.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onNext(bmobGoBean bmobGoBeans) {
                        for (int i = 0; i < bmobGoBeans.getData().size(); i++) {
                            actBombgoTablayout.addTab(actBombgoTablayout.newTab().setText(bmobGoBeans.getData().get(i).getName()));
                            fragmentlist.add(new HomePageFragment());
                            fragmentlist.get(i).setdate(i, bmobGoBeans.getData().get(i).getUrl());
                        }
                        //设置adapter以及标题
                        adapter = new BmobAdapter(getActivity().getSupportFragmentManager(), fragmentlist, bmobGoBeans.getData());
                        actBmobMvp.setAdapter(adapter);
                        actBombgoTablayout.setupWithViewPager(actBmobMvp);
                    }
                });
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void initdata() {

    }

    @Override
    public void initviewoper() {

    }


    @OnClick(R.id.act_bmob_error)
    public void onClick() {
        actBmobMvp.setVisibility(View.VISIBLE);
        actBombgoTablayout.setVisibility(View.VISIBLE);
        actBmobError.setVisibility(View.GONE);
        initview();
    }
}
