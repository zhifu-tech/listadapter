package com.zhi.widget.list.uti;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

import com.zhi.widget.list.ViewType;
import com.zhi.widget.list.uti.SimpleImageViewHolder.ImageItem;

public class SimpleImageModel extends SimpleItem<CharSequence> implements ImageItem {

    @DrawableRes
    public final int defaultResId;

    public SimpleImageModel(@NonNull CharSequence imageUrl, @DrawableRes int defaultResId,
            @ViewType int viewType) {
        super(imageUrl, viewType);
        this.defaultResId = defaultResId;
    }

    @Override
    @DrawableRes
    public int getDefaultResId() {
        return defaultResId;
    }

    @Override
    public CharSequence getImageUrl() {
        return data;
    }

    @Override
    public String toString() {
        return "SimpleImageModel{" +
                "defaultResId=" + defaultResId +
                "} " + super.toString();
    }
}
