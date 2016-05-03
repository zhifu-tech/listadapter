package com.zhi.widget.list.uti;

import android.support.annotation.NonNull;

import com.zhi.widget.list.ChildItem;
import com.zhi.widget.list.GroupItem;
import com.zhi.widget.list.ViewType;

import java.util.ArrayList;
import java.util.List;

public class SimpleGroupItem extends SimpleItem<List<ChildItem>> implements GroupItem {

    public SimpleGroupItem(@ViewType int viewType) {
        super(new ArrayList<ChildItem>(), viewType);
    }

    @Override
    public boolean hasItem(int viewType) {
        if (viewType == this.viewType) {
            return true;
        }
        for (ChildItem childItem : data) {
            if (childItem.getChildViewType() == viewType) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public GroupItem addItem(@NonNull ChildItem item) {
        data.add(item);
        item.setParent(this);
        return this;
    }

    @Override
    public GroupItem clear() {
        for (ChildItem child : data) {
            child.setParent(null);
        }
        data.clear();
        return this;
    }
}