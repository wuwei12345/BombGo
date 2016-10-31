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
import adapter.RankingAdapter;
import bean.HomeBean;
import bean.ReadBean;
import bean.UserSubmissionBean;
import bean.videoBean;
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
public class HomePageFragment extends Fragment implements Initerface {
    int valuse = BmobUri.NETWORK_ERROR;
    String uri;
    @Bind(R.id.BmobGO_XRecyclerView)
    XRecyclerView BmobGOXRecyclerView;
    Banner homeTopBanner;
    //上拉加载后半段地址
    String loadUri;
    //首页
    List<HomeBean.DataBean> mHomeBean;
    //用户投稿
    List<UserSubmissionBean.DataBean> mUserSubmission;
    //视频
    List<videoBean.DataBean> mVideoBean;
    private View Header;
    private HomePageAdapter adapter;
    private HomeUserAdapter useradapter;
    private HomeVideoAdapter videoadapter;
    //默认首页
    private String RankingFlag = BmobUri.HOMEPAGE;
    //阅读
    private List<ReadBean.DataBean> mReadBean;
    private RankingAdapter Readadapter;
    private View view;

    private String Teday = BmobUri.DAY;

    //接收标志位，以及接口地址
    public void setdate(int value, String uri) {
        this.valuse = value;
        this.uri = uri;
    }

    //接受排行榜的页面标识
    public void setRanking(int value, String RankingFlag) {
        this.valuse = value;
        this.RankingFlag = RankingFlag;
    }
    //切换排行榜内容
    public void setRankingDay(int day){
    switch (day){
        case 0:
            Teday=BmobUri.DAY;
            RankingData();
            break;
        case 1:
            Teday=BmobUri.WEEK;
            RankingData();
            break;
        case 2:
            Teday=BmobUri.MONTH;
            RankingData();
            break;
    }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home_page, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        initview();
        initviewoper();
        Logger.i("homepagefragment");
    }

    @Override
    public void initview() {
        Logger.i(RankingFlag);
        switch (RankingFlag) {
            //首页
            case BmobUri.HOMEPAGE:
                if (valuse != BmobUri.NETWORK_ERROR) {
                    HomeData(valuse, uri, BmobUri.TYPE_DOWN);
                } else {
                    Toast.makeText(getActivity(), "错误，页面未能正常加载", Toast.LENGTH_SHORT).show();
                }
                break;
            //排行榜
            case BmobUri.RANKING:
                RankingData();
                break;
        }

    }
    public void rankingclick(){
        //排行榜点击事件
        Readadapter.setOnItemClickLitener(new RankingAdapter.onItemClickLitener() {
            @Override
            public void onItemClick(View view, int postion) {
                Intent intent=new Intent(getActivity(),ArticleActivity.class);
                intent.putExtra("documentid",mReadBean.get(postion-1).getDocument_id()+"");
                intent.putExtra("flag",0+"");
                startActivity(intent);
            }
        });
    }
    private void RankingData() {
        BmobGOXRecyclerView.setLoadingMoreEnabled(false);
        initdata();
        switch (valuse) {
            //阅读
            case 0:
                RetrofitUtils
                        .getInstance()
                        .getRetrofit(BmobUri.BMOBGO_URI)
                        .create(RetrofitUtils.BmobGo.class)
                        .ReadDataBean(BmobUri.READ_URI + Teday)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<ReadBean>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                Toast.makeText(getActivity(), "错误" + e.toString(), Toast.LENGTH_SHORT).show();
                                Logger.i(e.toString());
                            }

                            @Override
                            public void onNext(ReadBean readBean) {
                                mReadBean = readBean.getData();
                                Readadapter = new RankingAdapter(mReadBean, getActivity());
                                BmobGOXRecyclerView.setAdapter(Readadapter);
                                BmobGOXRecyclerView.refreshComplete();
                                rankingclick();
                            }
                        });
                break;
            //赞
            case 1:
                RetrofitUtils
                        .getInstance()
                        .getRetrofit(BmobUri.BMOBGO_URI)
                        .create(RetrofitUtils.BmobGo.class)
                        .GOODDataBean(BmobUri.GOOD_URI + Teday)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<ReadBean>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                Logger.i(e.toString());
                            }

                            @Override
                            public void onNext(ReadBean readBean) {
                                mReadBean = readBean.getData();
                                Readadapter = new RankingAdapter(mReadBean, getActivity());
                                BmobGOXRecyclerView.setAdapter(Readadapter);
                                BmobGOXRecyclerView.refreshComplete();
                                rankingclick();
                            }
                        });
                break;
            //评论
            case 2:
                RetrofitUtils
                        .getInstance()
                        .getRetrofit(BmobUri.BMOBGO_URI)
                        .create(RetrofitUtils.BmobGo.class)
                        .GOODDataBean(BmobUri.COMMENT_URI + Teday)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<ReadBean>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                Logger.i(e.toString());
                            }

                            @Override
                            public void onNext(ReadBean readBean) {
                                mReadBean = readBean.getData();
                                Readadapter = new RankingAdapter(mReadBean, getActivity());
                                BmobGOXRecyclerView.setAdapter(Readadapter);
                                BmobGOXRecyclerView.refreshComplete();
                                rankingclick();
                            }
                        });
                break;
        }
    }

    @Override
    public void initdata() {
        if (RankingFlag.equals(BmobUri.HOMEPAGE) && valuse == 0 && Header == null) {
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

    }

    @Override
    public void initviewoper() {
        //刷新以及加载
        BmobGOXRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                switch (RankingFlag) {
                    //首页
                    case BmobUri.HOMEPAGE:
                        HomeData(valuse, uri, BmobUri.TYPE_DOWN);
                        break;
//                    //排行榜
//                    case BmobUri.RANKING:
//                        RankingData();
//                        break;
                }

            }

            @Override
            public void onLoadMore() {
                HomeData(valuse, uri + loadUri, BmobUri.TYPE_LOAD);
            }
        });
    }

    /**
     * 首页的所有操作
     *
     * @param valuse
     * @param uris
     * @param TYPEFLAG
     */
    private void HomeData(final int valuse, String uris, final int TYPEFLAG) {
        initdata();
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
                        .subscribe(new Observer<HomeBean>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                Logger.i(e.toString());
                            }

                            @Override
                            public void onNext( HomeBean homeBean) {
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
                               homeclick(3);
                                if (TYPEFLAG == BmobUri.TYPE_DOWN) {
                                    mHomeBean = homeBean.getData();
                                    adapter = new HomePageAdapter();
                                    adapter.setHomeBean(mHomeBean, getActivity());
                                    BmobGOXRecyclerView.setAdapter(adapter);
                                    //停止刷新
                                    BmobGOXRecyclerView.refreshComplete();
                                } else if (TYPEFLAG == BmobUri.TYPE_LOAD) {
                                    mHomeBean.addAll(homeBean.getData());
                                    // adapter=new HomePageAdapter();
                                    adapter.setHomeBean(mHomeBean, getActivity());
                                    adapter.notifyDataSetChanged();
                                    //停止刷新
                                    BmobGOXRecyclerView.loadMoreComplete();
                                }
                                //item点击事件
                               homeclick(0);
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
                        .subscribe(new Observer<UserSubmissionBean>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                Logger.i(e.toString());

                            }

                            @Override
                            public void onNext( UserSubmissionBean userSubmissionBean) {
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
                               homeclick(1);
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
                        .subscribe(new Observer<videoBean>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                Logger.i(e.toString());
                            }

                            @Override
                            public void onNext( videoBean videobean) {
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
                                homeclick(2);
                            }
                        });
                break;
        }

    }
    public void homeclick(int posint){
        switch (posint){
            case 0:
                adapter.setOnItemClickLitener(new HomePageAdapter.onItemClickLitener() {
                    @Override
                    public void onItemClick(View view, int postion) {
                        intentArticle(mHomeBean.get(postion - 2).getDocument_id(), BmobUri.WEB_URI);
                    }
                });
                break;
            case 1:
                useradapter.setOnItemClickLitener(new HomeUserAdapter.onItemClickLitener() {
                    @Override
                    public void onItemClick(View view, int postion) {
                        intentArticle(mUserSubmission.get(postion).getDocument_id(), BmobUri.WEB_URI);
                    }
                });
                break;
            case 2:
                videoadapter.setOnItemClickLitener(new HomeVideoAdapter.onItemClickLitener() {
                    @Override
                    public void onItemClick(View view, int postion) {
                        intentArticle(mVideoBean.get(postion).getDocument_id(), 0);
                    }
                });
                break;
            case 3:
                //轮播图点击事件
                homeTopBanner.setOnBannerClickListener(new OnBannerClickListener() {
                    @Override
                    public void OnBannerClick(int position) {
                        intentArticle(mHomeBean.get(position).getDocument_id(), BmobUri.WEB_SHAREURI);
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
