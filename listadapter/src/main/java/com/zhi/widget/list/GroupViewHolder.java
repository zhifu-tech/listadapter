package com.zhi.widget.list;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class GroupViewHolder<T extends GroupItem>
        extends ViewHolder<T> implements ViewHolderFactory {

    protected final ViewHolderFactory mFactory;

    public GroupViewHolder(@NonNull View view) {
        this(view, null);
    }

    public GroupViewHolder(@NonNull View view, @Nullable ViewHolderFactory factory) {
        super(view);
        mFactory = factory;
    }

    @Override
    protected final void onBindItemChanged(@Nullable T oldItem, @NonNull T item) {
        super.onBindItemChanged(oldItem, item);

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
            if (cvh.item == null || item.hasItem(cvh.item.getViewType())) {
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

    @Override
    protected final void onBindPositionChanged(int oldPos, int position) {
        super.onBindPositionChanged(oldPos, position);

        final Item childItem = item.getItem(position);
        if (childItem != Item.NULL) {
            final int vt = childItem.getViewType();
            ViewHolder vh = null;
            final ViewGroup views = (ViewGroup) view;
            final int childCount = views.getChildCount();
            for (int i = 0; i < childCount; i++) {
                final View child = views.getChildAt(i);
                if (child == null || !(child.getTag() instanceof ViewHolder)) {
                    continue;
                }

                vh = (ViewHolder) child.getTag();
                if (vh.accept(vt)) {
                    break;
                }
            }
            if (vh == null) {
                if (mFactory != null) {
                    vh = mFactory.getViewHolder(vt, views);
                }
                if (vh == null) {
                    vh = getViewHolder(vt, views);
                }
                if (vh == null) {
                    vh = MockViewHolder.createViewHolder(views);
                }
                vh.view.setTag(vh);
            }
            vh.bindView(childItem, position);
        }
    }

    @Nullable
    @Override
    public ViewHolder getViewHolder(@ViewType int viewType, @NonNull ViewGroup parent) {
        return null;
    }
}
