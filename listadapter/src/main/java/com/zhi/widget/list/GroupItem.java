package com.zhi.widget.list;

import android.support.annotation.NonNull;

/**
 * This is an special ListAdapter Item, because it may contain more than one normal item.
 * <em>It's a recursive definition.</em>
 */
public interface GroupItem extends Item {

    /** Check whether there's a specific item with specific viewType */
    boolean hasItem(int viewType);

    /** This group item contains items count. */
    int size();

    /** Used to add a item to this group. */
    GroupItem addItem(@NonNull ChildItem item);

    /** Clear this group item */
    GroupItem clear();

    GroupItem NULL = new GroupItem() {
        @Override
        public boolean hasItem(int viewType) {
            return viewType == VIEW_TYPE_NULL;
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public GroupItem addItem(@NonNull ChildItem item) {
            return this;
        }

        @Override
        public GroupItem clear() {
            return this;
        }

        @Override
        public int getViewType() {
            return Item.VIEW_TYPE_NULL;
        }
    };
}
