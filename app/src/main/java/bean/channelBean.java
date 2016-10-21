package bean;

import java.util.List;

/**
 * Created by wuwei on 2016/10/21.
 */

public class channelBean {

    /**
     * data : [{"id":3,"name":"全网最好笑","summary":"搜罗网络上最好笑的内容，带给你最好笑的日报","thumbnail":"http://ww3.sinaimg.cn/mw690/da4a9471tw1eqz3q6av98j203c03ct8q.jpg","image":"http://ww2.sinaimg.cn/large/0062aae5jw1ewkb9nkir3j30f00a0q3e.jpg"},{"id":4,"name":"贵圈真乱","summary":"给我一个槽点 我能撬开整个娱乐圈","thumbnail":"http://ww1.sinaimg.cn/thumbnail/7c1bc3cfjw1evobqxr369j20dw0dw0u7.jpg","image":"http://ww3.sinaimg.cn/large/0060u6Bxjw1ewkbig4xauj30f00a0wf5.jpg"},{"id":5,"name":"游戏拯救智障","summary":"我以前和你一样也是个冒险家，直到我玩了这些游戏变成死宅","thumbnail":"http://7o51ui.com1.z0.glb.clouddn.com/ribaopic/2015/09/1441091374003-y3lwrhytw03eo14n5d08q-62e6c0ee3417785e286c980036949ae5!preview","image":"http://ww3.sinaimg.cn/large/0060idtijw1ewkbexye5kj30f00a0q47.jpg"},{"id":6,"name":"电影收割机","summary":"用我一生，换你十年不看烂片","thumbnail":"http://ww1.sinaimg.cn/bmiddle/731ce372jw1evnuwui1kgj203c03cjra.jpg","image":"http://ww4.sinaimg.cn/large/0062RSUgjw1ewkh4h5u3xj30f00a0glx.jpg"},{"id":7,"name":"学霸追剧攻略","summary":"只看外剧，抵制资本主义的黄色糖衣炮弹","thumbnail":"http://ww4.sinaimg.cn/mw1024/88d822f7jw1evkrbjo4i1j203c03cq2y.jpg","image":"http://ww3.sinaimg.cn/large/005VULD0jw1ewkbgg85t8j30f00a00ts.jpg"},{"id":8,"name":"日本一宅友","summary":"我宅故我在，我在故我宅","thumbnail":"http://7o51ui.com1.z0.glb.clouddn.com/ribaopic/2015/08/1440497605836-9380vlf9nry28v8nd084f2-8daa49083d2b67fad5b519fdf10558cc!preview","image":"http://7o51ui.com1.z0.glb.clouddn.com/ribaopic/2016/01/1453082242451-2cwqldrnc1z7st9le0nyhf-1bbeca8347319a45f754a06ec84b0c0d"},{"id":9,"name":"啊Mui的漫画","summary":"我很酷","thumbnail":"http://ww3.sinaimg.cn/mw1024/da4a9471jw1ekeb7ned57j203c03cmx3.jpg","image":"http://ww3.sinaimg.cn/large/005RXPhKjw1f1kygeh2zuj30f00a0dg5.jpg"},{"id":10,"name":"深夜美食研究所","summary":"我们不仅是美食搬运工，更是美（hei）味（an）食（iao）物（li）的生产者。","thumbnail":"http://7o51ui.com1.z0.glb.clouddn.com/ribaopic/2015/11/1446808909694-qr0qls4929gc99uomgpv6-573948c77c354bbc769086999f42074e","image":"http://7o51ui.com1.z0.glb.clouddn.com/ribaopic/2015/11/1446808909702-herqvwc130ldf8sble75r-573948c77c354bbc769086999f42074e"},{"id":11,"name":"扯片部落","summary":"好故事就该拉出来扯一扯......如有不适，概不负责","thumbnail":"http://ww2.sinaimg.cn/mw1024/730c1913jw1evn50x4eyqj20bj0bjmz2.jpg","image":"http://ww1.sinaimg.cn/mw1024/730c1913jw1f110m8egplj20xc0m8t9m.jpg"},{"id":12,"name":"别人家的妹子","summary":"得不到的永远在骚动","thumbnail":"http://ww3.sinaimg.cn/mw690/da4a9471tw1eqz3q3sys7j203c03caa1.jpg","image":"http://ww2.sinaimg.cn/large/0060u6Dpjw1ewkbjx6qcxj30f00a075t.jpg"}]
     * total_pages : 2
     * per_page : 10
     * page : 1
     * total_count : 13
     */

    private int total_pages;
    private int per_page;
    private int page;
    private int total_count;
    /**
     * id : 3
     * name : 全网最好笑
     * summary : 搜罗网络上最好笑的内容，带给你最好笑的日报
     * thumbnail : http://ww3.sinaimg.cn/mw690/da4a9471tw1eqz3q6av98j203c03ct8q.jpg
     * image : http://ww2.sinaimg.cn/large/0062aae5jw1ewkb9nkir3j30f00a0q3e.jpg
     */

    private List<DataBean> data;

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private int id;
        private String name;
        private String summary;
        private String thumbnail;
        private String image;

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

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
