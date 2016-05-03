package com.zhi.widget.list;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.view.ViewGroup;

/**
 * This simple factory is used to create view holder instance according
 * view holder's bound items view type.
 */
public interface ViewHolderFactory {
    /** Callback to be invoked when a view holder is needed to be created. */
    @Nullable
    @UiThread
    ViewHolder getViewHolder(@ViewType int viewType, @NonNull ViewGroup parent);
}
