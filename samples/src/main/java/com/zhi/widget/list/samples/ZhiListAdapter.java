package com.zhi.widget.list.samples;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.zhi.widget.list.ListAdapter;
import com.zhi.widget.list.ViewHolder;
import com.zhi.widget.list.ViewHolderFactory;
import com.zhi.widget.list.ViewType;

import static com.zhi.widget.list.ViewHolder.of;

public class ZhiListAdapter extends ListAdapter {
    public static final int VIEW_TYPE_COUNT = 7;
    @ViewType
    public static final int VIEW_TYPE_SIMPLE_TEXT = 0;
    @ViewType
    public static final int VIEW_TYPE_SIMPLE_TEXT_HEADER = 1;
    @ViewType
    public static final int VIEW_TYPE_SIMPLE_TEXT_FOOTER = 2;
    @ViewType
    public static final int VIEW_TYPE_SIMPLE_IMAGE = 3;
    @ViewType
    public static final int VIEW_TYPE_SIMPLE_IMAGE_URL = 4;
    @ViewType
    public static final int VIEW_TYPE_SIMPLE_IMAGE_GIF = 5;
    @ViewType
    public static final int VIEW_TYPE_ADS_GROUP = 6;

    public ZhiListAdapter() {
    }

    public ZhiListAdapter(@NonNull ViewHolderFactory factory) {
        super(factory);
    }

    @Override
    public int getViewTypeCount() {
        return VIEW_TYPE_COUNT;
    }

    @Nullable
    @Override
    public ViewHolder getViewHolder(@ViewType int viewType, @NonNull ViewGroup parent) {
        final ViewHolder vh;
        final Context context = parent.getContext();
        final LayoutInflater inflater = LayoutInflater.from(context);
        switch (viewType) {
            case VIEW_TYPE_SIMPLE_IMAGE:
            case VIEW_TYPE_SIMPLE_IMAGE_URL:
            case VIEW_TYPE_SIMPLE_IMAGE_GIF:
                vh = of(ZhiNetworkImageViewHolder.class,
                        R.layout.item_simple_image, parent, inflater);
                break;

            case VIEW_TYPE_SIMPLE_TEXT:
            case VIEW_TYPE_SIMPLE_TEXT_HEADER:
            case VIEW_TYPE_SIMPLE_TEXT_FOOTER:
                vh = of(ZhiSimpleTextViewHolder.class,
                        R.layout.item_simple_text, parent, inflater);
                break;

            case VIEW_TYPE_ADS_GROUP:
                vh = of(ZhiAdsViewHolder.class,
                        R.layout.item_ads_group, parent, inflater);
                break;

            default:
                vh = null;
        }
        return vh;
    }
}
