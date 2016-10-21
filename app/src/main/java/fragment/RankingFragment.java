package fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bombgo.bombgo.R;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import Utils.BmobUri;
import adapter.BmobAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;
import initerface.Initerface;

/**
 * A simple {@link Fragment} subclass.
 */
public class RankingFragment extends Fragment implements Initerface{

    @Bind(R.id.act_ranking_tablayout)
    TabLayout actBombgoTablayout;
    @Bind(R.id.act_ranking_Mvp)
    ViewPager actBmobMvp;
    String[] RankingTitle = {"阅读", "赞", "评论"};
    private BmobAdapter adapter;
    private List<HomePageFragment> fragmentlist = new ArrayList<>();
    private View view;

    public RankingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_ranking, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initview();
        initdata();
        initviewoper();
    }

    private void RankingLoading() {
        for (int i = 0; i < 3; i++) {
            actBombgoTablayout.addTab(actBombgoTablayout.newTab().setText(RankingTitle[i]));
            fragmentlist.add(new HomePageFragment());
            fragmentlist.get(i).setRanking(i,BmobUri.RANKING);
        }
        //设置adapter以及标题
        adapter = new BmobAdapter(getActivity().getSupportFragmentManager(), fragmentlist, RankingTitle);
        actBmobMvp.setAdapter(adapter);
        actBombgoTablayout.setupWithViewPager(actBmobMvp);
    }

    @Override
    public void initview() {
        actBmobMvp.setOffscreenPageLimit(3);
        RankingLoading();
    }

    @Override
    public void initdata() {

    }

    @Override
    public void initviewoper() {

    }

}
