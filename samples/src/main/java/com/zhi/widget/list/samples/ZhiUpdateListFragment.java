package com.zhi.widget.list.samples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatCheckBox;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhi.widget.list.Item;
import com.zhi.widget.list.samples.util.Util;
import com.zhi.widget.list.uti.SimpleImageGifModel;
import com.zhi.widget.list.uti.SimpleImageModel;
import com.zhi.widget.list.uti.SimpleImageUrlModel;
import com.zhi.widget.list.uti.SimpleTextModel;

public class ZhiUpdateListFragment extends ZhiSimpleListFragment {
    public static final String TAG = "ZhiUpdateListFragment";

    public static ZhiUpdateListFragment newInstance() {
        return new ZhiUpdateListFragment();
    }

    private AppCompatCheckBox mLabelUpdate;
    private TextView mPosUpdate;

    public ZhiUpdateListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_update, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mLabelUpdate = findView(R.id.label_update);
        mPosUpdate = findView(R.id.update_pos);
    }

    @Override
    public void onClick(View v) {
        if (mLabelUpdate.isChecked()) {
            Item item = null;
            if (mTypeText.isChecked()) {
                item = new SimpleTextModel("I'm new Text item ",
                        ZhiListAdapter.VIEW_TYPE_SIMPLE_TEXT);

            } else if (mTypeImageRes.isChecked()) {
                item = new SimpleImageModel(R.drawable.image_ads,
                        ZhiListAdapter.VIEW_TYPE_SIMPLE_IMAGE);

            } else if (mTypeImageUrl.isChecked()) {
                item = new SimpleImageUrlModel(R.drawable.image_ads,
                        "http://pic22.nipic.com/20120716/10469458_101024533116_2.jpg",
                        ZhiListAdapter.VIEW_TYPE_SIMPLE_IMAGE_URL);

            } else if (mTypeImageGIF.isChecked()) {
                item = new SimpleImageGifModel(R.drawable.image_ads,
                        "http://pic22.nipic.com/20120716/10469458_101024533116_2.jpg",
                        "http://img4.duitang.com/uploads/item/201410/13/20141013150515_43KCM.gif",
                        ZhiListAdapter.VIEW_TYPE_SIMPLE_IMAGE_GIF);
            }
            if (item != null) {
                int index = 0;
                if (!TextUtils.isEmpty(mPosUpdate.getText())) {
                    index = Util.safeOfInt(mPosUpdate.getText().toString(), 0);
                }

                mListAdapter.setNotifyOnChange(false);

                if (mLabelHeader.isChecked()) {
                    mListAdapter.setHeaderItem(index, item);
                } else if (mLabelBody.isChecked()) {
                    mListAdapter.setBodyItem(index, item);
                } else {
                    mListAdapter.setFooterItem(index, item);
                }

                mListAdapter.setNotifyOnChange(true);

                index = mListAdapter.getItemIndex(item);
                mListAdapter.notifyItemChanged(index, mListView);
            }
        } else {
            super.onClick(v);
        }
    }
}
