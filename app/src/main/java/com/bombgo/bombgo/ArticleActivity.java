package com.bombgo.bombgo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import Utils.BmobUri;
import Utils.RetrofitUtils;
import bean.ArticleBean;
import butterknife.Bind;
import butterknife.ButterKnife;
import initerface.Initerface;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ArticleActivity extends AppCompatActivity implements Initerface{

    @Bind(R.id.act_article_toolbar)
    Toolbar actArticleToolbar;
    @Bind(R.id.act_article_webview)
    WebView actArticleWebview;
    private String DOCUMENTID;
    private String FLAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        ButterKnife.bind(this);
        initview();
        initdata();
        initviewoper();
    }

    @Override
    public void initview() {
        //设置返回按钮
        actArticleToolbar.setTitle("");
        setSupportActionBar(actArticleToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actArticleToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        //获取上一个界面传来的
        DOCUMENTID=getIntent().getStringExtra("documentid");
        FLAG=getIntent().getStringExtra("flag");
    }

    @Override
    public void initdata() {
        RetrofitUtils
                .getInstance()
                .getRetrofit(BmobUri.BMOBGO_ARTICLE)
                .create(RetrofitUtils.BmobGo.class)
                .ArticleDataBean(BmobUri.BMOBGO_ARTICLE+DOCUMENTID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ArticleBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(ArticleActivity.this,"网络错误",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(ArticleBean articleBean) {
                        if (FLAG.equals("0")){
                            //WebView加载web资源
                            actArticleWebview.loadUrl(articleBean.getShare_url());
                        }else{
                            //WebView加载web资源
                            actArticleWebview.loadUrl(articleBean.getUrl());
                        }
                        //启用支持javascript
                        actArticleWebview.getSettings().setJavaScriptEnabled(true);
                        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
                        actArticleWebview.setWebViewClient(new WebViewClient(){
                            @Override
                            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                                view.loadUrl(url);
                                return true;
                            }
                        });
                    }
                });

    }

    @Override
    public void initviewoper() {

    }
}
