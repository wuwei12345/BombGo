package Utils;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by wuwei on 2016/10/14.
 */

public class PicassoImageLoader implements ImageLoader {
    @Override
    public void displayImage(Context context, Object paths, ImageView imageView) {
        Picasso.with(context).load(String.valueOf(paths)).into(imageView);
    }
}
