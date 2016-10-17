package fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bombgo.bombgo.ArticleActivity;
import com.bombgo.bombgo.R;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.orhanobut.logger.Logger;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerClickListener;

import java.util.ArrayList;
import java.util.List;

import Utils.BmobUri;
import Utils.PicassoImageLoader;
import Utils.RetrofitUtils;
import Utils.SpaceItemDecoration;
import adapter.HomePageAdapter;
import adapter.HomeUserAdapter;
import adapter.HomeVideoAdapter;
import bean.HomeBean;
import bean.UserSubmissionBean;
import bean.videoBean;
import butterknife.Bind;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragment extends Fragment {
    int valuse = 404;
    String uri;
    @Bind(R.id.BmobGO_XRecyclerView)
    XRecyclerView BmobGOXRecyclerView;
    Banner homeTopBanner;
    private View Header;
    //上拉加载后半段地址
    String loadUri;
    //首页
    List<HomeBean.DataBean> mHomeBean;
    //用户投稿
    List<UserSubmissionBean.DataBean> mUserSubmission;
    //视频
    List<videoBean.DataBean> mVideoBean;
    private HomePageAdapter adapter;
    private HomeUserAdapter useradapter;
    private HomeVideoAdapter videoadapter;

    //接收标志位，以及接口地址
    public void setdate(int value, String uri) {
        this.valuse = value;
        this.uri = uri;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        ButterKnife.bind(this, view);
        initview();
        if (valuse != 404)
            HomeData(valuse, uri, BmobUri.TYPE_DOWN);
        return view;
    }

    private void initview() {
        if (valuse == 0) {
            //添加头视图
            Header = LayoutInflater.from(getActivity()).inflate(R.layout.home_banner,
                    (ViewGroup) getActivity().findViewById(android.R.id.content), false);
            homeTopBanner = (Banner) Header.findViewById(R.id.home_top_banner);
            homeTopBanner.setImageLoader(new PicassoImageLoader());
            homeTopBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
            BmobGOXRecyclerView.addHeaderView(Header);
        }
        //设置列表样式
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        BmobGOXRecyclerView.setLayoutManager(manager);
        //设置item间距
        BmobGOXRecyclerView.addItemDecoration(new SpaceItemDecoration(5));
        //设置刷新样式以及主题
        BmobGOXRecyclerView.setRefreshProgressStyle(ProgressStyle.BallPulse);
        BmobGOXRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.SquareSpin);
        BmobGOXRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                HomeData(valuse, uri, BmobUri.TYPE_DOWN);
            }

            @Override
            public void onLoadMore() {
                HomeData(valuse, uri + loadUri, BmobUri.TYPE_LOAD);
            }
        });
    }


    private void HomeData(final int valuse, String uris, final int TYPEFLAG) {
        //判断接口地址是否以 ／ 结尾
        if (!uris.endsWith("/")) {
            uris += "/";
        }
        Logger.i(uris);
        switch (valuse) {
            //首页
            case 0:
                RetrofitUtils
                        .getInstance()
                        .getRetrofit(BmobUri.BMOBGO_URI)
                        .create(RetrofitUtils.BmobGo.class)
                        .homeDataBean(uris)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<HomeBean>() {
                            @Override
                            public void call(final HomeBean homeBean) {
                                //设置后半段地址，加载时用
                                loadUri = "?timestamp=" + homeBean.getTimestamp() + "&/";
                                //获得轮播图的图片和标题
                                if (homeBean.getTop_stories() != null) {
                                    List<String> imglist = new ArrayList<String>();
                                    List<String> titlelist = new ArrayList<String>();
                                    for (int i = 0; i < homeBean.getTop_stories().size(); i++) {
                                        imglist.add(homeBean.getTop_stories().get(i).getImage());
                                        titlelist.add(homeBean.getTop_stories().get(i).getTitle());
                                    }
                                    homeTopBanner.setImages(imglist).setBannerTitles(titlelist).start();
                                }
                                //轮播图点击事件
                                homeTopBanner.setOnBannerClickListener(new OnBannerClickListener() {
                                    @Override
                                    public void OnBannerClick(int position) {
                                        intentArticle(homeBean.getTop_stories().get(position).getDocument_id(), 0);
                                    }
                                });
                                if (TYPEFLAG == BmobUri.TYPE_DOWN) {
                                    mHomeBean = homeBean.getData();
                                    adapter = new HomePageAdapter();
                                    adapter.setHomeBean(mHomeBean, getActivity());
                                    BmobGOXRecyclerView.setAdapter(adapter);
                                    //停止刷新
                                    BmobGOXRecyclerView.refreshComplete();
                                } else if (TYPEFLAG == BmobUri.TYPE_LOAD) {
                                    mHomeBean.addAll(homeBean.getData());
//                                    adapter=new HomePageAdapter();
                                    adapter.setHomeBean(mHomeBean, getActivity());
                                    adapter.notifyDataSetChanged();
                                    //停止刷新
                                    BmobGOXRecyclerView.loadMoreComplete();
                                }
                                //item点击事件
                                adapter.setOnItemClickLitener(new HomePageAdapter.onItemClickLitener() {
                                    @Override
                                    public void onItemClick(View view, int postion) {
                                        intentArticle(homeBean.getData().get(postion).getDocument_id(), 1);
                                    }
                                });
                            }
                        });
                break;
            //用户投稿
            case 1:
                RetrofitUtils
                        .getInstance()
                        .getRetrofit(BmobUri.BMOBGO_URI)
                        .create(RetrofitUtils.BmobGo.class)
                        .userSubmissonBeans(uris)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<UserSubmissionBean>() {
                            @Override
                            public void call(final UserSubmissionBean userSubmissionBean) {
                                //设置后半段地址，加载时用
                                loadUri = "?timestamp=" + userSubmissionBean.getTimestamp() + "&/";
                                if (TYPEFLAG == BmobUri.TYPE_DOWN) {
                                    mUserSubmission = userSubmissionBean.getData();
                                    useradapter = new HomeUserAdapter();
                                    useradapter.setUserBean(mUserSubmission, getActivity());
                                    BmobGOXRecyclerView.setAdapter(useradapter);
                                    //停止刷新
                                    BmobGOXRecyclerView.refreshComplete();
                                } else if (TYPEFLAG == BmobUri.TYPE_LOAD) {
                                    mUserSubmission.addAll(userSubmissionBean.getData());
                                    useradapter.setUserBean(mUserSubmission, getActivity());
                                    useradapter.notifyDataSetChanged();
                                    //停止刷新
                                    BmobGOXRecyclerView.loadMoreComplete();
                                }
                                //item点击事件
                                useradapter.setOnItemClickLitener(new HomeUserAdapter.onItemClickLitener() {
                                    @Override
                                    public void onItemClick(View view, int postion) {
                                        intentArticle(userSubmissionBean.getData().get(postion).getDocument_id(), 1);
                                    }
                                });
                            }
                        });
                break;
            //视频
            case 2:
                RetrofitUtils
                        .getInstance()
                        .getRetrofit(BmobUri.BMOBGO_URI)
                        .create(RetrofitUtils.BmobGo.class)
                        .videoDataBean(uris)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<videoBean>() {
                            @Override
                            public void call(final videoBean videobean) {
                                //设置后半段地址，加载时用
                                loadUri = "?timestamp=" + videobean.getTimestamp() + "&/";
                                if (TYPEFLAG == BmobUri.TYPE_DOWN) {
                                    mVideoBean = videobean.getData();
                                    videoadapter = new HomeVideoAdapter();
                                    videoadapter.setVideoBean(mVideoBean, getActivity());
                                    BmobGOXRecyclerView.setAdapter(videoadapter);
                                    //停止刷新
                                    BmobGOXRecyclerView.refreshComplete();
                                } else if (TYPEFLAG == BmobUri.TYPE_LOAD) {
                                    mVideoBean.addAll(videobean.getData());
                                    videoadapter.setVideoBean(mVideoBean, getActivity());
                                    videoadapter.notifyDataSetChanged();
                                    //停止刷新
                                    BmobGOXRecyclerView.loadMoreComplete();
                                }
                                //item点击事件
                                videoadapter.setOnItemClickLitener(new HomeVideoAdapter.onItemClickLitener() {
                                    @Override
                                    public void onItemClick(View view, int postion) {
                                        intentArticle(videobean.getData().get(postion).getDocument_id(), 1);
                                    }
                                });
                            }
                        });
                break;
        }

    }

    //跳转到文章详情页面
    private void intentArticle(int document_id, int flag) {
        getActivity().startActivity(new Intent(getActivity(), ArticleActivity.class)
                .putExtra("documentid", document_id + "").putExtra("flag", flag + ""));
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
