package com.zhi.widget.list.uti;

import android.support.annotation.NonNull;

import com.zhi.widget.list.ViewType;
import com.zhi.widget.list.uti.SimpleTextViewHolder.TextItem;

public class SimpleTextModel extends SimpleItem<CharSequence> implements TextItem {

    public SimpleTextModel(@NonNull CharSequence data, @ViewType int viewType) {
        super(data, viewType);
    }

    @Override
    public CharSequence getText() {
        return data;
    }
}
