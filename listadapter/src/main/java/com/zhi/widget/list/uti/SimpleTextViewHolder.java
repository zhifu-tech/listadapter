package com.zhi.widget.list.uti;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.zhi.widget.list.Item;
import com.zhi.widget.list.ViewHolder;

public class SimpleTextViewHolder extends ViewHolder<SimpleTextViewHolder.TextItem> {

    public final TextView mTextView;

    public SimpleTextViewHolder(@NonNull View view) {
        super(view);
        mTextView = findView(getTextResId());
    }

    @IdRes
    protected int getTextResId() {
        return android.R.id.text1;
    }

    @Override
    protected void onBindItemChanged(@Nullable TextItem oldItem, @NonNull TextItem item) {
        super.onBindItemChanged(oldItem, item);
        if (!TextUtils.equals(item.getText(), mTextView.getText())) {
            mTextView.setText(item.getText());
        }
    }

    public interface TextItem extends Item {
        CharSequence getText();
    }
}
