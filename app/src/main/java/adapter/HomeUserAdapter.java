package adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bombgo.bombgo.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import bean.UserSubmissionBean;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by wuwei on 2016/10/14.
 */

public class HomeUserAdapter extends RecyclerView.Adapter<HomeUserAdapter.MyViewHolder> {
    List<UserSubmissionBean.DataBean> userBean;
    Context context;


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.homeadapter_item_user, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.tvBmobTitle.setText(userBean.get(position).getTitle());
        holder.tvBmobZuozhe.setText(userBean.get(position).getRecommenders().get(0).getName());
        Picasso.with(context).load(userBean.get(position)
                        .getRecommenders().get(0).getAvatar())
                        .into(holder.homepageUserImg);
        if (monItemClickLitener!=null){
            holder.itemusercardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    monItemClickLitener.onItemClick(holder.itemView,holder.getLayoutPosition());
                }
            });
        }
    }

    //用户投稿
    public void setUserBean(List<UserSubmissionBean.DataBean> userBean, Context context) {
        this.userBean = userBean;
        this.context = context;
        notifyDataSetChanged();
    }

    public interface onItemClickLitener{
        void onItemClick(View view,int postion);

    }

    private  onItemClickLitener monItemClickLitener;

    public void setOnItemClickLitener(onItemClickLitener monItemClickLitener){
        this.monItemClickLitener=monItemClickLitener;
    }

    @Override
    public int getItemCount() {
        return userBean.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.homepage_user_img)
        ImageView homepageUserImg;
        @Bind(R.id.tv_bmob_user_zuozhe)
        TextView tvBmobZuozhe;
        @Bind(R.id.tv_bmob_user_title)
        TextView tvBmobTitle;
        @Bind(R.id.item_user_cardview)
        CardView itemusercardview;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
