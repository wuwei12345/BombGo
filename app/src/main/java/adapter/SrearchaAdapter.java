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
import bean.SrearchBean;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by wuwei on 2016/10/28.
 */

public class SrearchaAdapter extends RecyclerView.Adapter<SrearchaAdapter.ViewHolder>{
        List<SrearchBean.DataBean> readbean;
        Context context;


        public SrearchaAdapter(List<SrearchBean.DataBean> readbean, Context context) {
            this.readbean = readbean;
            this.context = context;
        }
        public void setdate(List<SrearchBean.DataBean> readbean){
            this.readbean = readbean;
            notifyDataSetChanged();
        }


        @Override
        public SrearchaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.homeadapter_item, parent, false);
            SrearchaAdapter.ViewHolder holder = new SrearchaAdapter.ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(SrearchaAdapter.ViewHolder holder, int position) {
            Picasso.with(context).load(readbean.get(position).getImage()).into(holder.homepageImg);
            holder.tv_bmob_zuozhe.setText(readbean.get(position).getTitle());
            holder.tv_bmob_title.setText(readbean.get(position).getAuthor_name()+"|"+readbean.get(position).getSection_name());
        }

        @Override
        public int getItemCount() {
            return readbean.size();
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
