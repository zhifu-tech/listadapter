package com.zhi.widget.list;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;

import com.zhi.widget.list.uti.Logs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class ListAdapter extends BaseAdapter implements ViewHolderFactory {
    public static final String TAG = Logs.makeLogTag("ListAdapter");
    /** List body items. */
    protected final List<Item> mBody;
    /** List header items. */
    protected final List<Item> mHeader;
    /** List footer items */
    protected final List<Item> mFooter;
    /** Factory used to create a new ViewHolder instance. */
    private final ViewHolderFactory mFactory;
    /** Auto-notifyDataSetChanged flag. */
    private boolean mNotifyOnChange = true;

    public ListAdapter() {
        this(null);
    }

    public ListAdapter(ViewHolderFactory factory) {
        mFactory = factory;
        mBody = new ArrayList<>();
        mHeader = new ArrayList<>();
        mFooter = new ArrayList<>();
    }

    /**
     * How many data items are in the data set represented by this Adapter.
     * <em>Include header items and footer items.</em>
     */
    @Override
    public final int getCount() {
        return mHeader.size() + mBody.size() + mFooter.size();
    }

    /** Get list view header items count. */
    public final int getHeaderCount() {
        return mHeader.size();
    }

    /** Get list view footer items count. */
    public final int getFooterCount() {
        return mFooter.size();
    }

    /** Get list view body items count. */
    public final int getBodyCount() {
        return mBody.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @ViewType
    @Override
    public final int getItemViewType(int position) {
        return getItem(position).getViewType();
    }

    /** Get the data item. */
    @NonNull
    @Override
    public final Item getItem(int position) {
        if (position >= 0) {
            int index = position;
            if (index < mHeader.size()) {
                return mHeader.get(index);
            }
            index -= mHeader.size();
            if (index < mBody.size()) {
                return mBody.get(index);
            }
            index -= mBody.size();
            if (index < mFooter.size()) {
                return mFooter.get(index);
            }
        }
        return Item.NULL;
    }

    /** Get the header item. */
    @NonNull
    public final Item getHeaderItem(int index) {
        if (0 <= index && index < mHeader.size()) {
            return mHeader.get(index);
        }
        return Item.NULL;
    }

    /** Get the footer item. */
    @NonNull
    public final Item getFooterItem(int index) {
        if (0 <= index && index < mFooter.size()) {
            return mFooter.get(index);
        }
        return Item.NULL;
    }

    /** Get the body item. */
    @NonNull
    public final Item getBodyItem(int index) {
        if (0 <= index && index < mBody.size()) {
            return mBody.get(index);
        }
        return Item.NULL;
    }

    @Override
    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        mNotifyOnChange = true;
    }

    /** Notify some item state changed. */
    public final void notifyItemChanged(int position, @NonNull AbsListView listView) {
        if (mNotifyOnChange) {
            final int first = listView.getFirstVisiblePosition();
            final int last = listView.getLastVisiblePosition();
            if (first <= position && position <= last) {
                final Item changedItem = getItem(position);
                // changed item is visible. just update it.
                final int viewCount = listView.getChildCount();
                for (int i = 0; i < viewCount; i++) {
                    final View child = listView.getChildAt(0);
                    if (child.getTag() instanceof ViewHolder) {
                        final ViewHolder vh = (ViewHolder) child.getTag();
                        if (vh.position == position) {
                            if (vh.accept(changedItem.getViewType())) {
                                vh.bindView(changedItem, position);
                            } else {
                                notifyDataSetChanged();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Control whether methods that change the list automatically call {@link #notifyDataSetChanged}.
     * If set to false, caller must manually call notifyDataSetChanged() to have the changes
     * reflected in the attached view.
     * <em>The default is true, and calling notifyDataSetChanged() resets the flag to true.</em>
     */
    public final ListAdapter setNotifyOnChange(boolean notifyOnChange) {
        mNotifyOnChange = notifyOnChange;
        return this;
    }

    /** Adds the body item. */
    public final ListAdapter addBodyItem(@NonNull Item item) {
        mBody.add(item);
        if (mNotifyOnChange) notifyDataSetChanged();
        return this;
    }

    /** Adds the header item. */
    public final ListAdapter addHeaderItem(@NonNull Item item) {
        mHeader.add(item);
        if (mNotifyOnChange) notifyDataSetChanged();
        return this;
    }

    /** Adds the footer item */
    public final ListAdapter addFooterItem(@NonNull Item item) {
        mFooter.add(item);
        if (mNotifyOnChange) notifyDataSetChanged();
        return this;
    }

    /** Adds the content Collection at the end of the list body. */
    public final ListAdapter addAllBodyItems(@NonNull Collection<? extends Item> items) {
        mBody.addAll(items);
        if (mNotifyOnChange) notifyDataSetChanged();
        return this;
    }

    /** Adds the specified items at the end of the body. */
    public final ListAdapter addAllBodyItems(@NonNull Item... items) {
        Collections.addAll(mBody, items);
        if (mNotifyOnChange) notifyDataSetChanged();
        return this;
    }

    /** Adds the specified items at the end of the header. */
    public final ListAdapter addAllHeaderItems(@NonNull Item... items) {
        Collections.addAll(mHeader, items);
        if (mNotifyOnChange) notifyDataSetChanged();
        return this;
    }

    /** Adds the specified items at the end of the body. */
    public final ListAdapter addAllFooterItems(@NonNull Item... items) {
        Collections.addAll(mFooter, items);
        if (mNotifyOnChange) notifyDataSetChanged();
        return this;
    }

    /** Inserts the specified object at the specified index in the list content. */
    public final ListAdapter insertBodyItem(int index, @NonNull Item item) {
        mBody.add(index, item);
        if (mNotifyOnChange) notifyDataSetChanged();
        return this;
    }

    /** Inserts the specified object at the specified index in the list headers. */
    public final ListAdapter insertHeaderItem(int index, @NonNull Item item) {
        mHeader.add(index, item);
        if (mNotifyOnChange) notifyDataSetChanged();
        return this;
    }

    /** Inserts the specified object at the specified index in the list footers. */
    public final ListAdapter insertFooterItem(int index, @NonNull Item item) {
        mFooter.add(index, item);
        if (mNotifyOnChange) notifyDataSetChanged();
        return this;
    }

    /** Removes the specified item from the list body. */
    public final ListAdapter removeBodyItem(@NonNull Item item) {
        mBody.remove(item);
        if (mNotifyOnChange) notifyDataSetChanged();
        return this;
    }

    /** Removes the specified item from the list body. */
    public final ListAdapter removeBodyItem(int index) {
        mBody.remove(index);
        if (mNotifyOnChange) notifyDataSetChanged();
        return this;
    }

    /** Removes the specified item from the list headers. */
    public final ListAdapter removeHeaderItem(@NonNull Item item) {
        mHeader.remove(item);
        if (mNotifyOnChange) notifyDataSetChanged();
        return this;
    }

    /** Removes the specified item from the list headers. */
    public final ListAdapter removeHeaderItem(int index) {
        mHeader.remove(index);
        if (mNotifyOnChange) notifyDataSetChanged();
        return this;
    }

    /** Removes the specified item from the list footers. */
    public final ListAdapter removeFooterItem(@NonNull Item item) {
        mFooter.remove(item);
        if (mNotifyOnChange) notifyDataSetChanged();
        return this;
    }

    /** Removes the specified item from the list footers. */
    public final ListAdapter removeFooterItem(int index) {
        mFooter.remove(index);
        if (mNotifyOnChange) notifyDataSetChanged();
        return this;
    }

    /** Remove all items from the list. */
    public final ListAdapter clear() {
        mBody.clear();
        mHeader.clear();
        mFooter.clear();
        if (mNotifyOnChange) notifyDataSetChanged();
        return this;
    }

    /** Remove all body items. */
    public final ListAdapter clearBody() {
        mBody.clear();
        if (mNotifyOnChange) notifyDataSetChanged();
        return this;
    }

    /** Remove all header items */
    public final ListAdapter clearHeader() {
        mHeader.clear();
        if (mNotifyOnChange) notifyDataSetChanged();
        return this;
    }

    /** Remove all footer items. */
    public final ListAdapter clearFooter() {
        mFooter.clear();
        if (mNotifyOnChange) notifyDataSetChanged();
        return this;
    }

    @Override
    public final View getView(int position, View convertView, @NonNull ViewGroup parent) {
        ViewHolder vh = null;
        final Item item = getItem(position);
        if (convertView == null
                || !(convertView.getTag() instanceof ViewHolder)
                || !((ViewHolder) convertView.getTag()).accept(item.getViewType())) {
            // There're two ways to create a ViewHolder instance.
            // 1. Use a custom ViewHolderFactory.
            // 2. Use a Factory method to create a view holder in subclass.
            if (mFactory != null) {
                vh = mFactory.getViewHolder(item.getViewType(), parent);
            }
            if (vh == null) {
                vh = getViewHolder(item.getViewType(), parent);
            }
            if (vh == null) {
                // If error happened, a mock holder will be created.
                vh = MockViewHolder.createViewHolder(parent);
            }
            convertView = vh.view;
            convertView.setTag(vh);

        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        vh.bindView(item, position);
        return convertView;
    }

    @UiThread
    @Nullable
    @Override
    public ViewHolder getViewHolder(@ViewType int viewType, @NonNull ViewGroup parent) {
        return null;
    }
}
