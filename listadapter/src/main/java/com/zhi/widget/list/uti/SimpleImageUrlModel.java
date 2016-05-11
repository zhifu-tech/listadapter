package com.zhi.widget.list.uti;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.zhi.widget.list.ViewType;
import com.zhi.widget.list.uti.SimpleImageViewHolder.ImageItemUrl;

public class SimpleImageUrlModel extends SimpleImageModel implements ImageItemUrl {

    @Nullable
    public final String url;

    public SimpleImageUrlModel(@DrawableRes int resId, @NonNull String url, @ViewType int viewType) {
        super(resId, viewType);
        this.url = url;
    }

    @Override
    public String getImageUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "SimpleImageUrlModel{" +
                "url='" + url + '\'' +
                "} " + super.toString();
    }
}
