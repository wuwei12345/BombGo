package adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.bombgo.bombgo.R;
import com.orhanobut.logger.Logger;
import com.squareup.picasso.Picasso;

import java.util.List;

import Utils.CircleTransform;
import bean.HomeBean;
import bean.UserSubmissionBean;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by wuwei on 2016/10/13.
 */

public class HomePageAdapter extends RecyclerView.Adapter<HomePageAdapter.MyViewHolder> {
    List<HomeBean.DataBean> homeBean;
    Context context;
    private View view;
    private MyViewHolder holder;
    private  onItemClickLitener monItemClickLitener;

    public HomePageAdapter() {

    }

    //首页
    public void setHomeBean( List<HomeBean.DataBean> homeBean, Context context) {
        this.homeBean = homeBean;
        this.context = context;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.homeadapter_item, parent, false);
            holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
                //加载文章图片
                Picasso.with(context).load(homeBean.get(position).getThumbnail()).into(holder.homepageImg);
                //判断用户头像是否为空，空则不加载
                if (homeBean.get(position).getRecommenders() != null) {
                    Picasso.with(context).load(homeBean.get(position).
                            getRecommenders().get(0).getAvatar()).transform(new CircleTransform())
                            .into(holder.itemusericon);
                } else {
                    holder.itemusericon.setVisibility(View.GONE);
                }
                if (homeBean.get(position).getSource_name() != null) {
                    holder.tv_bmob_title.setText(homeBean.get(position).getAuthor_name()
                            + "|" + homeBean.get(position).getSource_name());
                } else {
                    holder.tv_bmob_title.setText(homeBean.get(position).getAuthor_name());
                }
                holder.tv_bmob_zuozhe.setText(homeBean.get(position).getTitle());
        if (monItemClickLitener!=null){
            holder.itemhomecardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    monItemClickLitener.onItemClick(holder.itemView,holder.getLayoutPosition());
                }
            });
        }
    }

    public void setOnItemClickLitener(onItemClickLitener monItemClickLitener){
        this.monItemClickLitener=monItemClickLitener;
    }

    @Override
    public int getItemCount() {

        return homeBean.size();
    }

    public interface onItemClickLitener{
        void onItemClick(View view,int postion);

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        //首页
        @Bind(R.id.homepage_img)
        ImageView homepageImg;
        @Bind(R.id.tv_bmob_title)
        TextView tv_bmob_title;
        @Bind(R.id.tv_bmob_zuozhe)
        TextView tv_bmob_zuozhe;
        @Bind(R.id.item_user_icon)
        ImageView itemusericon;
        @Bind(R.id.item_home_cardview)
        CardView itemhomecardview;
        MyViewHolder(View views) {
            super(views);
            ButterKnife.bind(this, views);
        }

    }


}
