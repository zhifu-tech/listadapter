package com.zhi.widget.list;

import android.support.annotation.NonNull;
import android.support.v4.widget.Space;
import android.view.View;
import android.view.ViewGroup;

public final class MockViewHolder extends ViewHolder<Item> {

    @NonNull
    public static ViewHolder<?> createViewHolder(@NonNull ViewGroup parent) {
        return new MockViewHolder(new Space(parent.getContext()));
    }

    public MockViewHolder(@NonNull View view) {
        super(view);
    }

    @Override
    public boolean accept(@ViewType int viewType) {
        return true;
    }
}
