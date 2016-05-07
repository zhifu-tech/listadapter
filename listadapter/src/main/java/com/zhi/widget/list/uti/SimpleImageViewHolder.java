package com.zhi.widget.list.uti;

import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.zhi.widget.list.Item;
import com.zhi.widget.list.ViewHolder;

public class SimpleImageViewHolder extends ViewHolder<SimpleImageViewHolder.ImageItem> {
    public final ImageLoader loader;
    public final ImageView imageView;

    public SimpleImageViewHolder(@NonNull View view) {
        this(view, 0, null);
    }

    public SimpleImageViewHolder(@NonNull View view, @IdRes int resId, @Nullable ImageLoader loader) {
        super(view);
        imageView = findView(resId <= 0 ? android.R.id.icon : resId);
        this.loader = loader == null ? new SimpleImageLoader() : loader;
    }

    @Override
    protected void onBindItemChanged(@Nullable ImageItem oldItem, @NonNull ImageItem item) {
        super.onBindItemChanged(oldItem, item);
        if (oldItem == null
                || TextUtils.isEmpty(oldItem.getImageUrl())
                || !TextUtils.equals(oldItem.getImageUrl(), item.getImageUrl())) {
            loader.load(item.getImageUrl()).with(item.getDefaultResId()).into(imageView);
        }
    }

    public interface ImageItem extends Item {
        @DrawableRes
        int getDefaultResId();

        CharSequence getImageUrl();
    }

    public interface ImageLoader {

        ImageLoader load(@Nullable CharSequence imageUrl);

        ImageLoader with(@DrawableRes int defaultResId);

        void into(@NonNull ImageView imageView);

    }

    public static class SimpleImageLoader implements ImageLoader {
        protected int defaultResId;

        @Override
        public ImageLoader load(@Nullable CharSequence imageUrl) {
            return this;
        }

        @Override
        public ImageLoader with(@DrawableRes int defaultResId) {
            this.defaultResId = defaultResId;
            return this;
        }

        @Override
        public void into(@NonNull ImageView imageView) {
            imageView.setImageResource(defaultResId);
        }
    }
}
