package com.zhi.widget.list;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import static android.widget.AdapterView.INVALID_POSITION;

/** A View Holder is a controller that's used to load and set data in list view. */
public abstract class ViewHolder<T extends Item> {
    @NonNull
    public final View view;
    public T item;
    public int position = INVALID_POSITION;
    private ViewHolderClickListener mHolderClickListener;

    public ViewHolder(@NonNull View view) {
        this.view = view;
    }

    /** Used to check whether a view acn be accepted by this view holder. */
    public boolean accept(@ViewType int viewType) {
        return item != null && item.getViewType() == viewType;
    }

    /** Look for a child view with the given id. */
    @SuppressWarnings("unchecked")
    public final <VT extends View> VT findView(int id) {
        return (VT) view.findViewById(id);
    }

    /** Bind this view with data item and data position. */
    @CallSuper
    @SuppressWarnings("unchecked")
    public void bindView(@NonNull Item item, int position) {
        boolean changed = false;
        if (this.item == null || !this.item.equals(item)) {
            onBindItemChanged(this.item, (T) item);
            this.item = (T) item;
            changed = true;
        }
        if (this.position != position) {
            onBindPositionChanged(this.position, position);
            this.position = position;
            changed = true;
        }
        if (!changed) {
            onBindNoChanged();
        }
    }

    /** Callback to be invoked when bounded item changed. */
    protected void onBindItemChanged(@Nullable T oldItem, @NonNull T item) {
        // DEFAULT EMPTY
    }

    /** Callback to be vnvoked when bounded position changed */
    protected void onBindPositionChanged(int oldPos, int position) {
        // DEFAULT EMPTY
    }

    /** Callback to be invoked when no changed. */
    protected void onBindNoChanged() {
        // DEFAULT EMPTY
    }

    /** Callback to be invoked when this ViewHolder is clicked. */
    protected boolean onViewHolderClick() {
        return false;
    }

    public boolean performClick() {
        final boolean res;
        if (mHolderClickListener != null) {
            res = mHolderClickListener.onViewHolderClick(this);
        } else {
            res = onViewHolderClick();
        }
        return res;
    }

    public void setClickListener(ViewHolderClickListener clickListener) {
        mHolderClickListener = clickListener;
    }

    /** Callback to be invoked when this view holder is clicked. */
    public interface ViewHolderClickListener {
        boolean onViewHolderClick(@NonNull ViewHolder vh);
    }
}