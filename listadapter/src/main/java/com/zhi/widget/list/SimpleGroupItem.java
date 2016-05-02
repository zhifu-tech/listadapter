package com.zhi.widget.list;

import android.support.annotation.NonNull;
import android.util.SparseArray;

public class SimpleGroupItem extends SimpleItem<SparseArray<Item>> implements GroupItem {

    public SimpleGroupItem(@ViewType int viewType) {
        super(new SparseArray<Item>(), viewType);
    }

    @Override
    public boolean hasItem(int viewType) {
        return false;
    }

    @Override
    public int size() {
        return data.size();
    }

    @NonNull
    @Override
    public Item getItem(int key) {
        return Item.NULL;
    }

    @Override
    public GroupItem putItem(int key, Item item) {
        data.put(key, item);
        return this;
    }

    @Override
    public GroupItem clear() {
        data.clear();
        return this;
    }
}