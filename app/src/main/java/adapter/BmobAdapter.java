package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.orhanobut.logger.Logger;

import java.util.List;

import bean.bmobGoBean;
import fragment.HomePageFragment;

/**
 * Created by wuwei on 2016/10/11.
 */

public class BmobAdapter extends FragmentPagerAdapter {
    private List<HomePageFragment> list;//fragemtn列表
    private List<bmobGoBean.DataBean> list_Title;//列表名
    public BmobAdapter(FragmentManager fm, List<HomePageFragment> list, List<bmobGoBean.DataBean> list_Title) {
        super(fm);
        this.list=list;
        this.list_Title=list_Title;
    }

    @Override
    public Fragment getItem(int position) {
        return list!=null?list.get(position):null;
    }

    @Override
    public int getCount() {
        return list_Title!=null?list_Title.size():0;
    }


    //此方法用来显示tab上的名字
    @Override
    public CharSequence getPageTitle(int position) {
        return list_Title.get(position%list_Title.size()).getName();
    }
}
