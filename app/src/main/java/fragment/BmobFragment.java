package fragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.bombgo.bombgo.MainActivity;
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
import initerface.Initerface;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class BmobFragment extends Fragment implements Initerface{

    @Bind(R.id.act_bombgo_tablayout)
    TabLayout actBombgoTablayout;
    @Bind(R.id.act_bmob_Mvp)
    ViewPager actBmobMvp;
    private BmobAdapter adapter;
    private List<HomePageFragment> fragmentlist=new ArrayList<>();
    OnArticleSelectedListener onArticleSelectedListener;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bmob, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public void setdata(int value,OnArticleSelectedListener callBack){
                callBack.onArticleSelected(value);
    }
    //接口
    public interface OnArticleSelectedListener{
        public void onArticleSelected(int values);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initview();
        initdata();
        initviewoper();
    }
    //初始化数据
    @Override
    public void initview() {
        actBmobMvp.setOffscreenPageLimit(3);
        //网络访问，json解析，ui设置
        RetrofitUtils.BmobGo bmobGo = RetrofitUtils.getInstance().getRetrofit(BmobUri.BMOBGO_URI)
                .create(RetrofitUtils.BmobGo.class);
        bmobGo.repoDataBean().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<bmobGoBean>() {
                    @Override
                    public void call(bmobGoBean bmobGoBeans) {
                        for (int i = 0; i < bmobGoBeans.getData().size(); i++) {
                            actBombgoTablayout.addTab(actBombgoTablayout.newTab().setText(bmobGoBeans.getData().get(i).getName()));
                            fragmentlist.add(new HomePageFragment());
                            fragmentlist.get(i).setdate(i,bmobGoBeans.getData().get(i).getUrl());
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
        try {
            onArticleSelectedListener = (OnArticleSelectedListener) activity;
        }catch (Exception e){

        }
    }

    @Override
    public void initdata() {

    }

    @Override
    public void initviewoper() {

    }


}
