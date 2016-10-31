package fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bombgo.bombgo.ChannelActivity;
import com.bombgo.bombgo.R;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.orhanobut.logger.Logger;

import java.util.List;

import Utils.BmobUri;
import Utils.RetrofitUtils;
import Utils.SpaceItemDecoration;
import adapter.channelAdapter;
import bean.channelBean;
import butterknife.Bind;
import butterknife.ButterKnife;
import initerface.Initerface;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 * 频道
 */
public class channelFragment extends Fragment implements Initerface {


    @Bind(R.id.channer_xrecyclerview)
    XRecyclerView channerXrecyclerview;
    @Bind(R.id.channel_pb)
    ProgressBar channelPb;
    channelAdapter channelAdapter;
    int page = 1;
    //刷新状态
    int Resfh_Type = BmobUri.TYPE_DOWN;
    private List<channelBean.DataBean> mchannelbean;

    public channelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_channel, container, false);
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void initview() {
//设置列表样式
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        channerXrecyclerview.setLayoutManager(manager);
        //设置item间距
        channerXrecyclerview.addItemDecoration(new SpaceItemDecoration(5));
        //设置刷新样式以及主题
        channerXrecyclerview.setRefreshProgressStyle(ProgressStyle.BallPulse);
        channerXrecyclerview.setLoadingMoreProgressStyle(ProgressStyle.SquareSpin);
    }

    @Override
    public void initdata() {
        //加载数据
        RetrofitUtils
                .getInstance()
                .getRetrofit(BmobUri.CHANNEL_URI)
                .create(RetrofitUtils.BmobGo.class)
                .channelDataBean(page + "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<channelBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.i(e.toString());
                    }

                    @Override
                    public void onNext(channelBean channelBeans) {
                        //如果为空则证明服务端没有更多数据
                        if (channelBeans.getData() != null) {
                            switch (Resfh_Type) {
                                case BmobUri.TYPE_DOWN:
                                    mchannelbean = channelBeans.getData();
                                    channelAdapter = new channelAdapter(getActivity(), mchannelbean);
                                    channerXrecyclerview.setAdapter(channelAdapter);
                                    //显示列表，隐藏pb
                                    channerXrecyclerview.setVisibility(View.VISIBLE);
                                    channelPb.setVisibility(View.GONE);
                                    //结束下拉刷新
                                    channerXrecyclerview.refreshComplete();
                                    break;
                                case BmobUri.TYPE_LOAD:
                                    mchannelbean.addAll(channelBeans.getData());
                                    channelAdapter.setdata(mchannelbean);
                                    channelAdapter.notifyDataSetChanged();
                                    //结束上拉加载
                                    channerXrecyclerview.loadMoreComplete();
                                    break;
                            }
                        } else {
                            Toast.makeText(getActivity(), "没有更多", Toast.LENGTH_SHORT).show();
                        }
                        //adapter点击事件
                        channelAdapter.setOnItemClickLitener(new channelAdapter.onItemClickLitener() {
                            @Override
                            public void onItemClick(View view, int postion) {
                                Intent intent=new Intent(getActivity(), ChannelActivity.class);
                                intent.putExtra("id",mchannelbean.get(postion-1).getId()+"");
                                intent.putExtra("title",mchannelbean.get(postion-1).getName());
                                startActivity(intent);
                            }
                        });
                    }
                });
    }

    @Override
    public void initviewoper() {
        channerXrecyclerview.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 1;
                initdata();
            }

            @Override
            public void onLoadMore() {
                //更改刷新状态为上拉加载
                Resfh_Type = BmobUri.TYPE_LOAD;
                page++;
                initdata();
            }
        });

    }
}
