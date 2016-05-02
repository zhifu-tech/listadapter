package com.zhi.widget.list;

import android.support.annotation.NonNull;

public class SimpleItem<T> implements Item {
    @NonNull
    public final T data;
    @ViewType
    public final int viewType;

    public SimpleItem(@NonNull T data, @ViewType int viewType) {
        this.data = data;
        this.viewType = viewType;
    }

    @ViewType
    @Override
    public int getViewType() {
        return viewType;
    }

    @Override
    public String toString() {
        return "SimpleItem{" +
                "data=" + data +
                ", viewType=" + viewType +
                '}';
    }
}