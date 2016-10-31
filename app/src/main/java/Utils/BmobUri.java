package Utils;

/**
 * Created by wuwei on 2016/10/11.
 */

public class BmobUri {
    /**
     * 页面标识
     * RANKING:排行榜
     * HOMEPAGEL:首页
     */
    public static final String RANKING="RANKING";
    public static final String HOMEPAGE="HOMEPAGE";
    /**
     * 排行榜
     * READ_URI:阅读
     * GOOD_URI：赞
     * COMMENT_URI：评论
     */
    public static final String READ_URI="http://dailyapi.ibaozou.com/api/v31/rank/vote/";
    public static final String GOOD_URI="http://dailyapi.ibaozou.com/api/v31/rank/vote/";
    public static final String COMMENT_URI="http://dailyapi.ibaozou.com/api/v31/rank/comment/";
    /**
     * 今天，7天，30天
     */
    public static final String DAY="day";
    public static final String WEEK="week";
    public static final String MONTH="month";
    /**
     * 刷新状态
     * TYPE_DOWN：下拉
     * TYPE_LOAD：上拉
     */
    public static final int TYPE_DOWN = 0;
    public static final int TYPE_LOAD = 1;
    //接口地址
    public static String BMOBGO_URI = "http://dailyapi.ibaozou.com/";
    //文章内容地址
    public static String BMOBGO_ARTICLE = "http://dailyapi.ibaozou.com/api/v31/documents/";
    /**
     * 频道
     */
    public static String CHANNEL_URI="http://dailyapi.ibaozou.com/api/v31/channels/";
    /**
     * 频道2
     */
    public static String CHANNEL_URI_TWO="http://dailyapi.ibaozou.com/api/v31/channels/";
    /**
     * 加载网址
     * WEB_URI：加载第二个网址
     * WEB_SHAREURI：加载第一个网址
     */
    public static int WEB_URI = 1;
    public static int WEB_SHAREURI = 0;
    /**
     * 错误代码
     */
    public static int NETWORK_ERROR=404;
    /**
     * page
     */
    public static String PAGE="1";
    private static BmobUri bmobUri;

    public static BmobUri getBmobUri() {
        if (bmobUri == null) {
            bmobUri = new BmobUri();
        }
        return bmobUri;
    }
    /*
    初始界面：http://dailyapi.ibaozou.com/api/v31/tags/index

首页：http://dailyapi.ibaozou.com/api/v31/documents/latest

用户投稿：http://dailyapi.ibaozou.com/api/v31/documents/contributes/latest

视频：http://dailyapi.ibaozou.com/api/v31/documents/videos/latest

排行榜（今天）
		阅读：http://dailyapi.ibaozou.com/api/v31/rank/vote/day
		赞： http://dailyapi.ibaozou.com/api/v31/rank/vote/day
		评论：http://dailyapi.ibaozou.com/api/v31/rank/comment/day
	    （7天）
		阅读：http://dailyapi.ibaozou.com/api/v31/rank/read/week
		赞：http://dailyapi.ibaozou.com/api/v31/rank/vote/week
		评论：http://dailyapi.ibaozou.com/api/v31/rank/comment/week
	    （30天）
		阅读：http://dailyapi.ibaozou.com/api/v31/rank/read/month
		赞：http://dailyapi.ibaozou.com/api/v31/rank/vote/month
		评论：http://dailyapi.ibaozou.com/api/v31/rank/comment/month
频道：http://dailyapi.ibaozou.com/api/v31/channels/index?page=1&per_page=10& （page后面跟页码累加）

频道二：http://dailyapi.ibaozou.com/api/v31/channels/3  （最后的数字对应上一个接口对应频道id）
频道二加载： http://dailyapi.ibaozou.com/api/v31/channels/4?timestamp=1473080400&（timestamp对应频道二的timestamp）

文章内容：http://dailyapi.ibaozou.com/api/v31/documents/32542 （最后数字对应上一个接口频道的document_id）

评论最新：http://dailyapi.ibaozou.com/api/v31/documents/32542/comments/latest（中间数字对应上一个频道document_id）
评论热门：http://dailyapi.ibaozou.com/api/v31/documents/32542/comments/hot

搜索： http://dailyapi.ibaozou.com/api/v31/documents/search
注意！搜索是post请求，要携带page：页码，keyword：搜索内容，如："page":"2","keyword":"张全蛋"



     */
}
