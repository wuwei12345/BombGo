package Utils;

/**
 * Created by wuwei on 2016/10/11.
 */

public class BmobUri {
    private static BmobUri bmobUri;

    public static BmobUri getBmobUri() {
        if (bmobUri == null) {
            bmobUri = new BmobUri();
        }
        return bmobUri;
    }
    //接口地址
    public static  String BMOBGO_URI="http://dailyapi.ibaozou.com/";
    //文章内容地址
    public static String BMOBGO_ARTICLE="http://dailyapi.ibaozou.com/api/v31/documents/";
    /**
     *     刷新状态
     *     TYPE_DOWN：下拉
     *     TYPE_LOAD：上拉
     */
    public static int  TYPE_DOWN=0;
    public static int  TYPE_LOAD=1;
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
		阅读：http://dailyapi.ibaozou.com/api/v31/rank/read/week		赞：http://dailyapi.ibaozou.com/api/v31/rank/vote/week
		评论：http://dailyapi.ibaozou.com/api/v31/rank/comment/week
	    （30天）
		阅读：http://dailyapi.ibaozou.com/api/v31/rank/read/month 		赞：http://dailyapi.ibaozou.com/api/v31/rank/vote/month
		评论：http://dailyapi.ibaozou.com/api/v31/rank/comment/month
频道：http://dailyapi.ibaozou.com/api/v31/channels/index?page=1&per_page=10& （page后面跟页码累加）

频道二：http://dailyapi.ibaozou.com/api/v31/channels/3  （最后的数字对应上一个接口对应频道id）

文章内容：http://dailyapi.ibaozou.com/api/v31/documents/32542 （最后数字对应上一个接口频道的document_id）

评论最新：http://dailyapi.ibaozou.com/api/v31/documents/32542/comments/latest（中间数字对应上一个频道document_id）
评论热门：http://dailyapi.ibaozou.com/api/v31/documents/32542/comments/hot

搜索： http://dailyapi.ibaozou.com/api/v31/documents/search
注意！搜索是post请求，要携带page：页码，keyword：搜索内容，如："page":"2","keyword":"张全蛋"



     */
}
