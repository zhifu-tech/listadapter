package com.zhi.widget.list.samples;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.zhi.widget.list.uti.SimpleImageViewHolder;

public class ZhiAdsImageViewHolder extends SimpleImageViewHolder {

    public ZhiAdsImageViewHolder(@NonNull View view) {
        super(view);
    }

    public ZhiAdsImageViewHolder(@NonNull View view, @IdRes int resId, @Nullable ImageLoader loader) {
        super(view, resId, loader);
    }
}
