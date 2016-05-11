package com.zhi.widget.list.uti;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.zhi.widget.list.ViewType;
import com.zhi.widget.list.uti.SimpleImageViewHolder.ImageGifItem;

public class SimpleImageGifModel extends SimpleImageUrlModel implements ImageGifItem {

    @Nullable
    public final String gif;

    public SimpleImageGifModel(@DrawableRes int resId, @NonNull String url,
            @Nullable String gif, @ViewType int viewType) {
        super(resId, url, viewType);
        this.gif = gif;
    }

    @Nullable
    @Override
    public String getImageGif() {
        return gif;
    }

    @Override
    public String toString() {
        return "SimpleImageGifModel{" +
                "gif='" + gif + '\'' +
                "} " + super.toString();
    }
}
