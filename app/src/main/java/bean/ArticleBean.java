package bean;

import java.util.List;

/**
 * Created by wuwei on 2016/10/17.
 */

public class ArticleBean {

    /**
     * document_id : 37621
     * display_type : 2
     * image :
     * title : 他拍了一辈子商业电影，大概就是为了让你看到这部文艺片
     * vote_count : 14
     * comment_count : 11
     * contribute : 0
     * timestamp : 1476680420
     * url : http://mp.weixin.qq.com/s?__biz=MzA5MjMzNTQyNw==&mid=2656027182&idx=1&sn=a2b7c4fc239209f2980abfa3b2a7ddf1&chksm=8bd5de02bca2571479b68b4b83e51c2a384504c5fce7c93fe8a4f0a3a95f01bdace4342855b3&scene=0#wechat_redirect
     * source_name : 微在
     * hit_count : 3459
     * hit_count_string : 3千
     * share_url : http://baozouribao.com/documents/37621
     * publish_time : 1476680400000
     * published_at : 2016-10-17 13:00
     * recommenders : [{"id":683367,"name":"失足大爷翠花","avatar":"http://ww2.sinaimg.cn/large/005PbyN3jw1f0navbez6xj305l05k0sz.jpg"}]
     * author_id : 683367
     * author_name : 失足大爷翠花
     * author_avatar : http://ww2.sinaimg.cn/large/005PbyN3jw1f0navbez6xj305l05k0sz.jpg
     * thumbnail : http://ww3.sinaimg.cn/large/006eTtQVjw1f8v6hoer67j306o06ogls.jpg
     * hack_js : {"ducoment_loaded":"","set_night_mode":"\n          var style = document.createElement('style');\n          style.type = 'text/css';\n          style.id = 'baozouribao';\n          style.innerText = '*{background-color:#343434!important;color:#B8B8B8!important;}';\n          if (document.head){\n            document.head.appendChild(style);\n          } else {\n            document.documentElement.appendChild(style);\n          }\n        ","set_day_mode":"\n          var style = document.getElementById('baozouribao');\n          style && style.parentNode && style.parentNode.removeChild(style);\n        "}
     * channels : []
     */

    private int document_id;
    private int display_type;
    private String image;
    private String title;
    private int vote_count;
    private int comment_count;
    private int contribute;
    private int timestamp;
    private String url;
    private String source_name;
    private int hit_count;
    private String hit_count_string;
    private String share_url;
    private long publish_time;
    private String published_at;
    private int author_id;
    private String author_name;
    private String author_avatar;
    private String thumbnail;
    /**
     * ducoment_loaded :
     * set_night_mode :
     var style = document.createElement('style');
     style.type = 'text/css';
     style.id = 'baozouribao';
     style.innerText = '*{background-color:#343434!important;color:#B8B8B8!important;}';
     if (document.head){
     document.head.appendChild(style);
     } else {
     document.documentElement.appendChild(style);
     }

     * set_day_mode :
     var style = document.getElementById('baozouribao');
     style && style.parentNode && style.parentNode.removeChild(style);

     */

    private HackJsBean hack_js;
    /**
     * id : 683367
     * name : 失足大爷翠花
     * avatar : http://ww2.sinaimg.cn/large/005PbyN3jw1f0navbez6xj305l05k0sz.jpg
     */

    private List<RecommendersBean> recommenders;
    private List<?> channels;

    public int getDocument_id() {
        return document_id;
    }

    public void setDocument_id(int document_id) {
        this.document_id = document_id;
    }

    public int getDisplay_type() {
        return display_type;
    }

    public void setDisplay_type(int display_type) {
        this.display_type = display_type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public int getContribute() {
        return contribute;
    }

    public void setContribute(int contribute) {
        this.contribute = contribute;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSource_name() {
        return source_name;
    }

    public void setSource_name(String source_name) {
        this.source_name = source_name;
    }

    public int getHit_count() {
        return hit_count;
    }

    public void setHit_count(int hit_count) {
        this.hit_count = hit_count;
    }

    public String getHit_count_string() {
        return hit_count_string;
    }

    public void setHit_count_string(String hit_count_string) {
        this.hit_count_string = hit_count_string;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public long getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(long publish_time) {
        this.publish_time = publish_time;
    }

    public String getPublished_at() {
        return published_at;
    }

    public void setPublished_at(String published_at) {
        this.published_at = published_at;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_avatar() {
        return author_avatar;
    }

    public void setAuthor_avatar(String author_avatar) {
        this.author_avatar = author_avatar;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public HackJsBean getHack_js() {
        return hack_js;
    }

    public void setHack_js(HackJsBean hack_js) {
        this.hack_js = hack_js;
    }

    public List<RecommendersBean> getRecommenders() {
        return recommenders;
    }

    public void setRecommenders(List<RecommendersBean> recommenders) {
        this.recommenders = recommenders;
    }

    public List<?> getChannels() {
        return channels;
    }

    public void setChannels(List<?> channels) {
        this.channels = channels;
    }

    public static class HackJsBean {
        private String ducoment_loaded;
        private String set_night_mode;
        private String set_day_mode;

        public String getDucoment_loaded() {
            return ducoment_loaded;
        }

        public void setDucoment_loaded(String ducoment_loaded) {
            this.ducoment_loaded = ducoment_loaded;
        }

        public String getSet_night_mode() {
            return set_night_mode;
        }

        public void setSet_night_mode(String set_night_mode) {
            this.set_night_mode = set_night_mode;
        }

        public String getSet_day_mode() {
            return set_day_mode;
        }

        public void setSet_day_mode(String set_day_mode) {
            this.set_day_mode = set_day_mode;
        }
    }

    public static class RecommendersBean {
        private int id;
        private String name;
        private String avatar;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }
    }
}
