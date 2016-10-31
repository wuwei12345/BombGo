package fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bombgo.bombgo.R;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.orhanobut.logger.Logger;

import java.util.List;

import Utils.BmobUri;
import Utils.RetrofitUtils;
import Utils.SpaceItemDecoration;
import adapter.SrearchaAdapter;
import bean.SrearchBean;
import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class SrearchFramgent extends Fragment {


    @Bind(R.id.Srecar_recyclerview)
    XRecyclerView SrecarRecyclerview;
    String value;
    int i=2;
    List<SrearchBean.DataBean> msrear;
    private SrearchaAdapter srearchaAdapter;

    public SrearchFramgent() {
        // Required empty public constructor
    }

    public void setdata(SrearchBean srearchBean,String value) {
        this.value=value;
        msrear=srearchBean.getData();
        Logger.i(msrear.size()+"");
        srearchaAdapter=new SrearchaAdapter(msrear,getActivity());
        SrecarRecyclerview.setAdapter(srearchaAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_srearch_framgent, container, false);
        ButterKnife.bind(this, view);
        //设置列表样式
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        SrecarRecyclerview.setLayoutManager(manager);
        //设置item间距
        SrecarRecyclerview.addItemDecoration(new SpaceItemDecoration(5));
        //设置刷新样式以及主题
        SrecarRecyclerview.setPullRefreshEnabled(false);
        SrecarRecyclerview.setLoadingMoreProgressStyle(ProgressStyle.SquareSpin);
        SrecarRecyclerview.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

            }

            @Override
            public void onLoadMore() {
                RetrofitUtils
                        .getInstance()
                        .getRetrofit(BmobUri.BMOBGO_URI)
                        .create(RetrofitUtils.BmobGo.class)
                        .SrearchDataBean(""+i++,value)
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
                                Logger.i(""+srearchBean.getData().size());
                                if (srearchBean.getData()!=null) {
                                    msrear.addAll(srearchBean.getData());
                                    srearchaAdapter.setdate(msrear);
                                    srearchaAdapter.notifyDataSetChanged();
                                    SrecarRecyclerview.loadMoreComplete();
                                }else{
                                    Toast.makeText(getActivity(),"没有更多",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
