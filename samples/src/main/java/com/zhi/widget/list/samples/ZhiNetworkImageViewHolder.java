package com.zhi.widget.list.samples;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.zhi.volley.image.NetworkImageView;
import com.zhi.widget.list.uti.SimpleImageViewHolder;

public class ZhiNetworkImageViewHolder extends SimpleImageViewHolder {

    public ZhiNetworkImageViewHolder(@NonNull View view) {
        super(view);
    }

    @Override
    protected int getImageViewResId() {
        return R.id.image;
    }

    @NonNull
    @Override
    protected ImageLoader getImageLoader() {
        return new ImageLoader() {
            @Override
            public void load(@NonNull ImageItem item, @NonNull ImageView imageView) {
                final NetworkImageView networkImageView = (NetworkImageView) imageView;
                networkImageView.setDefaultImageResId(item.getImageRes());

                if (item instanceof ImageGifItem) {
                    final String gif = ((ImageGifItem) item).getImageGif();
                    if (!TextUtils.isEmpty(gif)) {
                        networkImageView.setGifUrl(gif);
                        return;
                    }
                }
                if (item instanceof ImageItemUrl) {
                    final String url = ((ImageItemUrl) item).getImageUrl();
                    if (!TextUtils.isEmpty(url)) {
                        networkImageView.setImageUrl(url);
                        return;
                    }
                }

            }
        };
    }
}
