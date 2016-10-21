package Utils;

import java.nio.channels.Channel;

import bean.ArticleBean;
import bean.HomeBean;
import bean.ReadBean;
import bean.UserSubmissionBean;
import bean.bmobGoBean;
import bean.channelBean;
import bean.videoBean;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by Administrator on 2016/8/18.
 */
public class RetrofitUtils {
    private static RetrofitUtils RX = new RetrofitUtils();

    private RetrofitUtils() {
    }

    //静态工厂方法
    public static RetrofitUtils getInstance() {
        return RX;
    }

    public Retrofit getRetrofit(String uri) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(uri).
                addCallAdapterFactory(RxJavaCallAdapterFactory.create()).
                addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit;
    }


    public interface BmobGo {
        /**
         * 首页标题
         */
        @GET("api/v31/tags/index")
        public Observable<bmobGoBean> repoDataBean();

        /**
         * 首页内容
         * @return
         */
        @GET
        public Observable<HomeBean> homeDataBean(@Url()String url);
        /**
         * 用户投稿
         */
        @GET
        public Observable<UserSubmissionBean> userSubmissonBeans(@Url()String url);
        /**
         * 视频
         */
        @GET
        public Observable<videoBean> videoDataBean(@Url()String url);
        /**
         * 文章内容
         */
        @GET
        public Observable<ArticleBean> ArticleDataBean(@Url()String url);
        /**
         * 阅读
         */
        @GET
        public Observable<ReadBean> ReadDataBean(@Url()String url);
        /**
         * 赞
         */
        @GET
        public Observable<ReadBean> GOODDataBean(@Url()String url);
        /**
         * 评论
         */
        @GET
        public Observable<ReadBean> CommentDataBean(@Url()String url);
        /**
        * 频道
        */
        @GET("index?&per_page=10&")
        public Observable<channelBean> channelDataBean(@Query("page") String page);
    }
}
