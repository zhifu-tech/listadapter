package com.zhi.widget.list.uti;

import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.zhi.widget.list.Item;
import com.zhi.widget.list.ViewHolder;

public class SimpleImageViewHolder extends ViewHolder<SimpleImageViewHolder.ImageItem> {
    @NonNull
    public final ImageLoader loader;
    @NonNull
    public final ImageView imageView;

    public SimpleImageViewHolder(@NonNull View view) {
        super(view);
        loader = getImageLoader();
        imageView = findView(getImageViewResId());
    }

    @IdRes
    protected int getImageViewResId() {
        return android.R.id.icon1;
    }

    @NonNull
    protected ImageLoader getImageLoader() {
        return ImageLoader.RESOURCE_LOADER;
    }

    @Override
    protected void onBindItemChanged(@Nullable ImageItem oldItem, @NonNull ImageItem item) {
        super.onBindItemChanged(oldItem, item);
        loader.load(item, imageView);
    }

    @Override
    protected void onBindNoChanged() {
        super.onBindNoChanged();
        if (item instanceof ImageGifItem) {
            loader.load(item, imageView);
        }
    }

    public interface ImageItem extends Item {
        @DrawableRes
        int getImageRes();
    }

    public interface ImageItemUrl extends ImageItem {
        @Nullable
        String getImageUrl();
    }

    public interface ImageGifItem extends ImageItemUrl {
        @Nullable
        String getImageGif();
    }

    public interface ImageLoader {
        void load(@NonNull ImageItem item, @NonNull ImageView imageView);

        ImageLoader RESOURCE_LOADER = new ImageLoader() {
            @Override
            public void load(@NonNull ImageItem item, @NonNull ImageView imageView) {
                if (item.getImageRes() > 0) {
                    imageView.setImageResource(item.getImageRes());
                } else {
                    imageView.setImageBitmap(null);
                }
            }
        };
    }
}
