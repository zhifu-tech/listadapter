package com.zhi.widget.list.uti;

import android.support.annotation.NonNull;

import com.zhi.widget.list.Item;
import com.zhi.widget.list.ViewType;

public class SimpleItem<T> implements Item {
    @NonNull
    public final T data;
    @ViewType
    public int viewType;

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