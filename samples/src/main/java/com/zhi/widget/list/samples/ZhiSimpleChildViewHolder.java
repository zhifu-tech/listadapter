package com.zhi.widget.list.samples;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.zhi.widget.list.ChildItem;
import com.zhi.widget.list.ChildViewHolder;
import com.zhi.widget.list.ViewHolderFactory;

public class ZhiSimpleChildViewHolder extends ChildViewHolder<ChildItem> {

    public ZhiSimpleChildViewHolder(@NonNull View view) {
        super(view);
    }

    public ZhiSimpleChildViewHolder(@NonNull View view, @Nullable ViewHolderFactory factory) {
        super(view, factory);
    }
}
