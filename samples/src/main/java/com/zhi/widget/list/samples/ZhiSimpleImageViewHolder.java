package com.zhi.widget.list.samples;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.zhi.volley.image.NetworkImageView;
import com.zhi.widget.list.uti.SimpleImageViewHolder;

public class ZhiSimpleImageViewHolder extends SimpleImageViewHolder {

    public ZhiSimpleImageViewHolder(@NonNull View view) {
        super(view, 0, new VolleyImageLoader());
    }

    public static class VolleyImageLoader extends SimpleImageLoader {
        private CharSequence imageUrl;

        @Override
        public ImageLoader load(@Nullable CharSequence imageUrl) {
            this.imageUrl = imageUrl;
            return super.load(imageUrl);
        }

        @Override
        public void into(@NonNull ImageView imageView) {
            final NetworkImageView networkImageView = (NetworkImageView) imageView;
            networkImageView.setDefaultImageResId(defaultResId);
            if (!TextUtils.isEmpty(imageUrl)) {
                ((NetworkImageView) imageView).setImageUrl((String) imageUrl);
            } else {
                super.into(imageView);
            }
        }
    }
}
