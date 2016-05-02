package com.zhi.widget.list;

/**
 * ListAdapter bound item interface.
 */
public interface Item {
    int VIEW_TYPE_NULL = 0;

    @ViewType
    int getViewType();

    Item NULL = new Item() {
        @ViewType
        @Override
        public int getViewType() {
            return VIEW_TYPE_NULL;
        }
    };
}