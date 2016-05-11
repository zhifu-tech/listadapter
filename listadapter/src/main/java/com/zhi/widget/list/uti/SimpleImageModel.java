package com.zhi.widget.list.uti;

import android.support.annotation.DrawableRes;

import com.zhi.widget.list.ViewType;
import com.zhi.widget.list.uti.SimpleImageViewHolder.ImageItem;

public class SimpleImageModel extends SimpleItem<Integer> implements ImageItem {

    public SimpleImageModel(@DrawableRes int resId, @ViewType int viewType) {
        super(resId, viewType);
    }

    @Override
    @DrawableRes
    public int getImageRes() {
        return data;
    }
}
