package com.zhi.widget.list;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class ChildViewHolder<T extends ChildItem> extends ViewHolder<T>
        implements ViewHolderFactory {

    protected ViewHolderFactory mFactory;

    public ChildViewHolder(@NonNull View view) {
        this(view, null);
    }

    public ChildViewHolder(@NonNull View view, @Nullable ViewHolderFactory factory) {
        super(view);
        mFactory = factory;
    }

    public ChildViewHolder<T> setFactory(ViewHolderFactory factory) {
        mFactory = factory;
        return this;
    }

    @Override
    protected final void onBindItemChanged(@Nullable T oldItem, @NonNull T item) {
        super.onBindItemChanged(oldItem, item);
        // 1. Remove unused child views.
        if (oldItem == null
                || oldItem.getParent() != item.getParent()
                || oldItem.getParent().size() != item.getParent().size()) {
            onBindGroupItemChanged(item.getParent());
        }

        // 2. Set the current child item.
        ViewHolder vh = null;
        final ViewGroup views = (ViewGroup) view;
        final int childCount = views.getChildCount();
        final int cvt = item.getChildViewType();

        for (int i = 0; i < childCount; i++) {
            final View child = views.getChildAt(i);
            if (child == null || !(child.getTag() instanceof ViewHolder)) {
                continue;
            }

            final ViewHolder cvh = (ViewHolder) child.getTag();
            if (vh != null || !cvh.accept(cvt)) {
                cvh.view.setVisibility(View.GONE);
            } else {
                cvh.view.setVisibility(View.VISIBLE);
                vh = cvh;
            }
        }
        if (vh == null) {
            if (mFactory != null) {
                vh = mFactory.getViewHolder(cvt, views);
            }
            if (vh == null) {
                vh = getViewHolder(cvt, views);
            }
            if (vh == null) {
                vh = MockViewHolder.createViewHolder(views);
            }
            vh.view.setTag(vh);
            if (vh.view.getParent() == null) {
                views.addView(vh.view);
            }
        }
        vh.bindView(item.getItem(), position);
    }

    protected void onBindGroupItemChanged(@NonNull GroupItem parent) {
        final ViewGroup views = (ViewGroup) view;
        final int childCount = views.getChildCount();
        final List<View> removed = new ArrayList<>();

        for (int i = 0; i < childCount; i++) {
            final View child = views.getChildAt(i);
            // Check whether the child can be reused.
            // 1. child is not a Holder View, left it.
            if (child == null || !(child.getTag() instanceof ViewHolder)) {
                continue;
            }
            // 2. new group item has a item contains the old type.
            final ViewHolder cvh = (ViewHolder) child.getTag();
            if (cvh.item == null || parent.hasItem(cvh.item.getViewType())) {
                // view can be reused.
                continue;
            }
            // 3. Not validate for new item.
            removed.add(child);
        }
        for (View view : removed) {
            views.removeView(view);
        }
    }

    @UiThread
    @Nullable
    @Override
    public ViewHolder getViewHolder(@ViewType int viewType, @NonNull ViewGroup parent) {
        return null;
    }
}
