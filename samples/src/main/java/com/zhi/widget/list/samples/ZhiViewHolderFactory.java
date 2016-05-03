package com.zhi.widget.list.samples;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.zhi.widget.list.ViewHolder;
import com.zhi.widget.list.ViewHolderFactory;
import com.zhi.widget.list.ViewType;

import static com.zhi.widget.list.ViewHolder.of;
import static com.zhi.widget.list.samples.ZhiListAdapter.*;

public class ZhiViewHolderFactory implements ViewHolderFactory {
    @UiThread
    @Nullable
    @Override
    public ViewHolder getViewHolder(@ViewType int viewType, @NonNull ViewGroup parent) {
        ViewHolder vh;
        final Context context = parent.getContext();
        final LayoutInflater inflater = LayoutInflater.from(context);
        switch (viewType) {
            case VIEW_TYPE_SIMPLE_IMAGE:
                vh = of(ZhiSimpleImageViewHolder.class,
                        R.layout.item_simple_image, parent, inflater);
                break;

            case VIEW_TYPE_SIMPLE_TEXT:
                vh = of(ZhiSimpleTextViewHolder.class,
                        R.layout.item_simple_text, parent, inflater);
                break;

            case VIEW_TYPE_ADS_GROUP:
                vh = of(ZhiSimpleChildViewHolder.class,
                        R.layout.item_ads_group, parent, inflater);
                if (vh != null) {
                    ((ZhiSimpleChildViewHolder) vh).setFactory(this);
                }
                break;
            case VIEW_TYPE_ADS_TEXT:
                vh = of(ZhiAdsTextViewHolder.class,
                        R.layout.item_ads_text, parent, inflater);
                break;

            case VIEW_TYPE_ADS_IMAGE:
                vh = of(ZhiAdsImageViewHolder.class,
                        R.layout.item_ads_image, parent, inflater);
                break;

            default:
                vh = null;
        }
        return vh;
    }
}
