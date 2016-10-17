package bean;

import java.util.List;

/**
 * Created by wuwei on 2016/10/11.
 */

public class bmobGoBean {

    /**
     * data : [{"name":"首页","url":"http://dailyapi.ibaozou.com/api/v31/documents/latest"},{"name":"用户投稿","url":"http://dailyapi.ibaozou.com/api/v31/documents/contributes/latest"},{"name":"视频","url":"http://dailyapi.ibaozou.com/api/v31/documents/videos/latest"}]
     * version : 5
     */

    private int version;
    /**
     * name : 首页
     * url : http://dailyapi.ibaozou.com/api/v31/documents/latest
     */

    private List<DataBean> data;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String name;
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
