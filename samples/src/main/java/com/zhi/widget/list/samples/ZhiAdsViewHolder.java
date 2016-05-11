package com.zhi.widget.list.samples;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhi.widget.list.ChildItem;
import com.zhi.widget.list.ChildViewHolder;
import com.zhi.widget.list.ViewHolder;
import com.zhi.widget.list.ViewHolderFactory;
import com.zhi.widget.list.ViewType;

public class ZhiAdsViewHolder extends ChildViewHolder<ChildItem> {
    @ViewType
    public static final int VIEW_TYPE_ADS_TEXT = 0;
    @ViewType
    public static final int VIEW_TYPE_ADS_IMAGE = 1;
    @ViewType
    public static final int VIEW_TYPE_ADS_IMAGE_URL = 2;
    @ViewType
    public static final int VIEW_TYPE_ADS_IMAGE_GIF = 3;

    public ZhiAdsViewHolder(@NonNull View view) {
        super(view);
    }

    public ZhiAdsViewHolder(@NonNull View view, @Nullable ViewHolderFactory factory) {
        super(view, factory);
    }

    @Nullable
    @Override
    public ViewHolder getViewHolder(@ViewType int viewType, @NonNull ViewGroup parent) {
        final ViewHolder vh;
        final Context context = parent.getContext();
        final LayoutInflater inflater = LayoutInflater.from(context);
        switch (viewType) {
            case VIEW_TYPE_ADS_TEXT:
                vh = of(ZhiSimpleTextViewHolder.class,
                        R.layout.item_simple_text, parent, inflater);
                break;

            case VIEW_TYPE_ADS_IMAGE:
            case VIEW_TYPE_ADS_IMAGE_URL:
            case VIEW_TYPE_ADS_IMAGE_GIF:
                vh = of(ZhiSimpleImageViewHolder.class,
                        R.layout.item_simple_image, parent, inflater);
                break;

            default:
                vh = null;
        }
        return vh;
    }
}
