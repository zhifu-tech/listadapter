package com.zhi.widget.list;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public interface ChildItem extends Item {

    @NonNull
    Item getItem();

    @NonNull
    GroupItem getParent();

    @NonNull
    ChildItem setParent(@Nullable GroupItem parent);

    @ViewType
    int getChildViewType();

    ChildItem NULL = new ChildItem() {

        @NonNull
        @Override
        public Item getItem() {
            return Item.NULL;
        }

        @NonNull
        @Override
        public GroupItem getParent() {
            return GroupItem.NULL;
        }

        @NonNull
        @Override
        public ChildItem setParent(@Nullable GroupItem parent) {
            return this;
        }

        @Override
        public int getChildViewType() {
            return VIEW_TYPE_NULL;
        }

        @Override
        public int getViewType() {
            return VIEW_TYPE_NULL;
        }
    };
}
