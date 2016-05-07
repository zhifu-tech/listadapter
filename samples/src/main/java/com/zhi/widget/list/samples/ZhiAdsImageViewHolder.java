package com.zhi.widget.list.samples;

import android.support.annotation.NonNull;
import android.view.View;

import com.zhi.widget.list.uti.SimpleImageViewHolder;

public class ZhiAdsImageViewHolder extends SimpleImageViewHolder {

    public ZhiAdsImageViewHolder(@NonNull View view) {
        super(view, 0, new ZhiSimpleImageViewHolder.VolleyImageLoader());
    }
}
