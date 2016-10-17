package adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.bombgo.bombgo.R;
import com.orhanobut.logger.Logger;
import com.squareup.picasso.Picasso;

import java.util.List;

import bean.videoBean;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by wuwei on 2016/10/14.
 */

public class HomeVideoAdapter extends RecyclerView.Adapter<HomeVideoAdapter.MyViewHolder> {
    List<videoBean.DataBean> videoBean;
    Context context;

    public interface onItemClickLitener{
        void onItemClick(View view,int postion);

    }

    private  onItemClickLitener monItemClickLitener;

    public void setOnItemClickLitener(onItemClickLitener monItemClickLitener){
        this.monItemClickLitener=monItemClickLitener;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.homeadapter_item_video, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    public void setVideoBean(List<videoBean.DataBean> videoBean, Context context) {
        this.videoBean = videoBean;
        this.context = context;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.itemVideoPlaycontent.setText(videoBean.get(position).getPlay_count() + " 播放");
        holder.itemVideoTitle.setText(videoBean.get(position).getTitle()+"");
        Picasso.with(context).load(videoBean.get(position).getImage()).into(holder.itemVideoImg);
        holder.itemvideoplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //隐藏图片
                holder.itemVideoImg.setVisibility(View.GONE);
                holder.itemvideoplay.setVisibility(View.GONE);
                //显示播放器
                holder.itemvideoview.setVisibility(View.VISIBLE);
                holder.itemvideoview.setMediaController(new MediaController(context));
                holder.itemvideoview.setVideoURI(Uri.parse(videoBean.get(position).getFile_url()));
                Logger.i(videoBean.get(position).getFile_url());
                holder.itemvideoview.start();
                holder.itemvideoview.requestFocus();
            }
        });
        if (monItemClickLitener!=null){
            holder.itemvideocarview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    monItemClickLitener.onItemClick(holder.itemView,holder.getLayoutPosition());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return videoBean.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.item_video_img)
        ImageView itemVideoImg;
        @Bind(R.id.item_video_title)
        TextView itemVideoTitle;
        @Bind(R.id.item_video_playcontent)
        TextView itemVideoPlaycontent;
        @Bind(R.id.item_video_play)
        ImageView itemvideoplay;
        @Bind(R.id.item_videoview)
        VideoView itemvideoview;
        @Bind(R.id.item_video_carview)
        CardView itemvideocarview;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
