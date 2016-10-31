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

import bean.ReadBean;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by wuwei on 2016/10/19.
 */

public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.ViewHolder>{
    List<ReadBean.DataBean> readbean;
    Context context;
    private RankingAdapter.onItemClickLitener monItemClickLitener;

    public RankingAdapter(List<ReadBean.DataBean> readbean, Context context) {
        this.readbean = readbean;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.homeadapter_item, parent, false);
        ViewHolder holder = new RankingAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Picasso.with(context).load(readbean.get(position).getImage()).into(holder.homepageImg);
        holder.tv_bmob_zuozhe.setText(readbean.get(position).getTitle());
        holder.tv_bmob_title.setText(readbean.get(position).getAuthor_name()+"|"+readbean.get(position).getSection_name());
        if (monItemClickLitener!=null){
            holder.itemhomecardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    monItemClickLitener.onItemClick(holder.itemView,holder.getLayoutPosition());
                }
            });
        }
    }

    public void setOnItemClickLitener(RankingAdapter.onItemClickLitener monItemClickLitener){
        this.monItemClickLitener=monItemClickLitener;
    }

    @Override
    public int getItemCount() {
        return readbean.size();
    }

    public interface onItemClickLitener{
        void onItemClick(View view,int postion);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
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
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
