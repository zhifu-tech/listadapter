package com.zhi.widget.list.samples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.zhi.widget.list.ChildItem;
import com.zhi.widget.list.Item;
import com.zhi.widget.list.ListAdapter;
import com.zhi.widget.list.ViewHolderFactory;
import com.zhi.widget.list.uti.SimpleChildItem;
import com.zhi.widget.list.uti.SimpleGroupItem;
import com.zhi.widget.list.uti.SimpleImageModel;
import com.zhi.widget.list.uti.SimpleTextModel;

import static com.zhi.widget.list.samples.ZhiListAdapter.VIEW_TYPE_ADS_GROUP;
import static com.zhi.widget.list.samples.ZhiListAdapter.VIEW_TYPE_ADS_IMAGE;
import static com.zhi.widget.list.samples.ZhiListAdapter.VIEW_TYPE_ADS_TEXT;
import static com.zhi.widget.list.samples.ZhiListAdapter.VIEW_TYPE_SIMPLE_IMAGE;
import static com.zhi.widget.list.samples.ZhiListAdapter.VIEW_TYPE_SIMPLE_TEXT;

public class ZhiListFragment extends BaseFragment {
    private ListView mListView;
    private ListAdapter mListAdapter;

    public ZhiListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mListView = findView(R.id.list);
        ViewHolderFactory holderFactory = new ZhiViewHolderFactory();
        mListAdapter = new ZhiListAdapter(holderFactory);
        mListView.setAdapter(mListAdapter);

        mockTextItems();
        mockImageItems();
        mockGroupItems();
    }

    // Following code used for testing.
    public void mockTextItems() {
        mListAdapter.setNotifyOnChange(false);
        for (int i = 0; i < 10; i++) {
            mListAdapter.addBodyItem(new SimpleTextModel("Body Text #" + i,
                    VIEW_TYPE_SIMPLE_TEXT));
        }
        mListAdapter.notifyDataSetChanged();
    }

    public void mockImageItems() {
        mListAdapter.setNotifyOnChange(false);
        for (int i = 0; i < 10; i++) {
            mListAdapter.addBodyItem(new SimpleImageModel("Body Image #" + i,
                    R.drawable.image_default, VIEW_TYPE_SIMPLE_IMAGE));
        }
        mListAdapter.notifyDataSetChanged();
    }

    public void mockGroupItems() {
        mListAdapter.setNotifyOnChange(false);
        final Item adsText = new SimpleTextModel("Ads Text item", VIEW_TYPE_ADS_TEXT);
        final Item adsImage = new SimpleImageModel("Ads Image", R.drawable.image_ads, VIEW_TYPE_ADS_IMAGE);

        final SimpleGroupItem groupItem = new SimpleGroupItem(VIEW_TYPE_ADS_GROUP);
        final ChildItem childItem0 = new SimpleChildItem(adsText, groupItem);
        final ChildItem childItem1 = new SimpleChildItem(adsImage, groupItem);
        final ChildItem childItem2 = new SimpleChildItem(adsText, groupItem);
        final ChildItem childItem3 = new SimpleChildItem(adsText, groupItem);
        groupItem.addItem(childItem0);
        groupItem.addItem(childItem1);
        groupItem.addItem(childItem2);
        groupItem.addItem(childItem3);
        mListAdapter.insertBodyItem(0, childItem0);
        mListAdapter.insertBodyItem(5, childItem1);
        mListAdapter.insertBodyItem(10, childItem2);
        mListAdapter.insertBodyItem(15, childItem3);
        mListAdapter.notifyDataSetChanged();
    }
}
