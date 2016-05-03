package com.zhi.widget.list.samples;

import android.support.annotation.NonNull;

import com.zhi.widget.list.ListAdapter;
import com.zhi.widget.list.ViewHolderFactory;
import com.zhi.widget.list.ViewType;

public class ZhiListAdapter extends ListAdapter {
    public static final int VIEW_TYPE_COUNT = 5;
    @ViewType
    public static final int VIEW_TYPE_SIMPLE_TEXT = 0;
    @ViewType
    public static final int VIEW_TYPE_SIMPLE_IMAGE = 1;
    @ViewType
    public static final int VIEW_TYPE_ADS_GROUP = 2;
    @ViewType
    public static final int VIEW_TYPE_ADS_TEXT = 3;
    @ViewType
    public static final int VIEW_TYPE_ADS_IMAGE = 4;

    public ZhiListAdapter(@NonNull ViewHolderFactory factory) {
        super(factory);
    }

    @Override
    public int getViewTypeCount() {
        return VIEW_TYPE_COUNT;
    }
}
