package com.zhi.widget.list.uti;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.zhi.widget.list.ChildItem;
import com.zhi.widget.list.GroupItem;
import com.zhi.widget.list.Item;

public class SimpleChildItem extends SimpleItem<Item> implements ChildItem {

    public GroupItem parent;

    public SimpleChildItem(@NonNull Item data, @Nullable GroupItem parent) {
        super(data, parent != null ? parent.getViewType() : VIEW_TYPE_NULL);
        this.parent = parent;
    }

    @NonNull
    @Override
    public Item getItem() {
        return data;
    }

    @NonNull
    @Override
    public GroupItem getParent() {
        return parent;
    }

    @NonNull
    @Override
    public ChildItem setParent(@Nullable GroupItem parent) {
        this.parent = parent;
        this.viewType = parent != null ? parent.getViewType() : VIEW_TYPE_NULL;
        return this;
    }

    @Override
    public int getChildViewType() {
        return data.getViewType();
    }
}
