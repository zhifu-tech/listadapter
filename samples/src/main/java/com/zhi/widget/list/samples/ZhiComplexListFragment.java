package com.zhi.widget.list.samples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatCheckBox;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhi.widget.list.ChildItem;
import com.zhi.widget.list.GroupItem;
import com.zhi.widget.list.Item;
import com.zhi.widget.list.samples.util.Util;
import com.zhi.widget.list.uti.SimpleChildItem;
import com.zhi.widget.list.uti.SimpleGroupItem;
import com.zhi.widget.list.uti.SimpleImageGifModel;
import com.zhi.widget.list.uti.SimpleImageModel;
import com.zhi.widget.list.uti.SimpleImageUrlModel;
import com.zhi.widget.list.uti.SimpleTextModel;

import static com.zhi.widget.list.samples.ZhiListAdapter.VIEW_TYPE_ADS_GROUP;

public class ZhiComplexListFragment extends ZhiSimpleListFragment {
    public static final String TAG = "ZhiComplexListFragment";

    public static ZhiComplexListFragment newInstance() {
        return new ZhiComplexListFragment();
    }

    private AppCompatCheckBox mLabelAds;
    private TextView mPosAds;
    private GroupItem mAdsItems;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_complex, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mLabelAds = findView(R.id.label_ads);
        mPosAds = findView(R.id.ads_pos);
        mAdsItems = new SimpleGroupItem(VIEW_TYPE_ADS_GROUP);
    }

    @Override
    public void onClick(View v) {
        boolean callSuper = true;
        if (mLabelAds.isChecked()) {

            ChildItem adsItem = null;
            if (mTypeText.isChecked()) {
                final Item adsTextItem = new SimpleTextModel("I'm Ads Text item " + mAdsItems.size(),
                        ZhiAdsViewHolder.VIEW_TYPE_ADS_TEXT);
                adsItem = new SimpleChildItem(adsTextItem, mAdsItems);

            } else if (mTypeImageRes.isChecked()) {
                final Item adsImage = new SimpleImageModel(R.drawable.image_ads,
                        ZhiAdsViewHolder.VIEW_TYPE_ADS_IMAGE);
                adsItem = new SimpleChildItem(adsImage, mAdsItems);

            } else if (mTypeImageUrl.isChecked()) {
                final Item adsImageUrl = new SimpleImageUrlModel(R.drawable.image_ads,
                        "http://pic22.nipic.com/20120716/10469458_101024533116_2.jpg",
                        ZhiAdsViewHolder.VIEW_TYPE_ADS_IMAGE_URL);
                adsItem = new SimpleChildItem(adsImageUrl, mAdsItems);

            } else if (mTypeImageGIF.isChecked()) {
                final Item adsImageGif = new SimpleImageGifModel(R.drawable.image_ads,
                        "http://pic22.nipic.com/20120716/10469458_101024533116_2.jpg",
                        "http://img4.duitang.com/uploads/item/201410/13/20141013150515_43KCM.gif",
                        ZhiAdsViewHolder.VIEW_TYPE_ADS_IMAGE_GIF);
                adsItem = new SimpleChildItem(adsImageGif, mAdsItems);
            }

            if (adsItem != null) {
                int adsPos = 0;
                if (!TextUtils.isEmpty(mPosAds.getText())) {
                    adsPos = Util.safeOfInt(mPosAds.getText().toString(), 0);
                }
                mAdsItems.addItem(adsItem);
                mListAdapter.insertBodyItem(adsPos, adsItem);
                callSuper = false;
            }
        }
        if (callSuper) {
            super.onClick(v);
        }
    }

}
