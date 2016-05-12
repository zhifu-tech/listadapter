package com.zhi.widget.list.samples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatCheckBox;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import com.zhi.widget.list.Item;
import com.zhi.widget.list.ListAdapter;
import com.zhi.widget.list.samples.util.Logs;
import com.zhi.widget.list.uti.SimpleImageGifModel;
import com.zhi.widget.list.uti.SimpleImageModel;
import com.zhi.widget.list.uti.SimpleImageUrlModel;
import com.zhi.widget.list.uti.SimpleTextModel;

import static com.zhi.widget.list.samples.ZhiListAdapter.VIEW_TYPE_SIMPLE_IMAGE;
import static com.zhi.widget.list.samples.ZhiListAdapter.VIEW_TYPE_SIMPLE_IMAGE_GIF;
import static com.zhi.widget.list.samples.ZhiListAdapter.VIEW_TYPE_SIMPLE_IMAGE_URL;
import static com.zhi.widget.list.samples.ZhiListAdapter.VIEW_TYPE_SIMPLE_TEXT;
import static com.zhi.widget.list.samples.ZhiListAdapter.VIEW_TYPE_SIMPLE_TEXT_HEADER;

public class ZhiSimpleListFragment extends BaseFragment implements View.OnClickListener {
    public static final String TAG = Logs.makeLogTag("ZhiSimpleListFragment");

    protected ListView mListView;
    protected ListAdapter mListAdapter;
    protected AppCompatCheckBox mLabelHeader;
    protected AppCompatCheckBox mLabelFooter;
    protected AppCompatCheckBox mLabelBody;
    protected EditText mLabelCount;

    protected AppCompatCheckBox mTypeText;
    protected AppCompatCheckBox mTypeImageRes;
    protected AppCompatCheckBox mTypeImageUrl;
    protected AppCompatCheckBox mTypeImageGIF;

    public static ZhiSimpleListFragment newInstance() {
        return new ZhiSimpleListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_simple, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mListView = findView(R.id.list);
        mListAdapter = new ZhiListAdapter();
        mListView.setAdapter(mListAdapter);

        mLabelHeader = findView(R.id.label_header);
        mLabelFooter = findView(R.id.label_footer);
        mLabelBody = findView(R.id.label_body);
        mLabelCount = findView(R.id.label_count);

        mTypeText = findView(R.id.type_text);
        mTypeImageRes = findView(R.id.type_image);
        mTypeImageUrl = findView(R.id.type_image_url);
        mTypeImageGIF = findView(R.id.type_image_gif);


        findView(R.id.add).setOnClickListener(this);
        findView(R.id.remove).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        final CharSequence labelCount = mLabelCount.getText();
        final int count;
        if (!TextUtils.isEmpty(labelCount)) {
            count = Integer.parseInt(labelCount.toString());
        } else {
            count = 0;
        }

        final boolean addMore = v.getId() == R.id.add;

        mListAdapter.setNotifyOnChange(false);

        if (mLabelHeader.isChecked()) {
            if (!addMore) {
                final int size = Math.min(count < 0 ? mListAdapter.getHeaderCount() : count, mListAdapter.getHeaderCount());

                for (int i = 0; i < size; i++) {
                    mListAdapter.removeHeaderItem(mListAdapter.getHeaderCount() - 1 - i);
                }
            } else {
                final int index = mListAdapter.getHeaderCount();
                for (int i = 0; i < count; i++) {
                    if (mTypeText.isChecked()) {
                        final Item headerItem = new SimpleTextModel("I'm a HEADER item with index " + (index + i),
                                VIEW_TYPE_SIMPLE_TEXT_HEADER);
                        mListAdapter.addHeaderItem(headerItem);
                    }

                    if (mTypeImageRes.isChecked()) {
                        final Item headerItem = new SimpleImageModel(R.drawable.image_default,
                                VIEW_TYPE_SIMPLE_IMAGE);
                        mListAdapter.addHeaderItem(headerItem);
                    }

                    if (mTypeImageUrl.isChecked()) {
                        final Item headerItem = new SimpleImageUrlModel(R.drawable.image_default,
                                "http://img15.3lian.com/2015/a1/10/d/111.jpg", VIEW_TYPE_SIMPLE_IMAGE_URL);
                        mListAdapter.addHeaderItem(headerItem);
                    }

                    if (mTypeImageGIF.isChecked()) {
                        final Item headerItem = new SimpleImageGifModel(R.drawable.image_default,
                                "http://img15.3lian.com/2015/a1/10/d/111.jpg",
                                "http://img4.duitang.com/uploads/item/201410/13/20141013150515_43KCM.gif",
                                VIEW_TYPE_SIMPLE_IMAGE_GIF);
                        mListAdapter.addHeaderItem(headerItem);
                    }
                }
            }
        }

        if (mLabelFooter.isChecked()) {
            if (!addMore) {
                final int size = Math.min(count < 0 ? mListAdapter.getFooterCount() : count, mListAdapter.getFooterCount());
                for (int i = 0; i < size; i++) {
                    mListAdapter.removeFooterItem(mListAdapter.getFooterCount() - 1 - i);
                }
            } else {
                final int index = mListAdapter.getFooterCount();
                for (int i = 0; i < count; i++) {
                    if (mTypeText.isChecked()) {
                        final Item headerItem = new SimpleTextModel("I'm a FOOTER item with index " + (index + i),
                                VIEW_TYPE_SIMPLE_TEXT_HEADER);
                        mListAdapter.addFooterItem(headerItem);
                    }

                    if (mTypeImageRes.isChecked()) {
                        final Item headerItem = new SimpleImageModel(R.drawable.image_default,
                                VIEW_TYPE_SIMPLE_IMAGE);
                        mListAdapter.addFooterItem(headerItem);
                    }

                    if (mTypeImageUrl.isChecked()) {
                        final Item headerItem = new SimpleImageUrlModel(R.drawable.image_default,
                                "http://img15.3lian.com/2015/a1/10/d/111.jpg", VIEW_TYPE_SIMPLE_IMAGE_URL);
                        mListAdapter.addFooterItem(headerItem);
                    }

                    if (mTypeImageGIF.isChecked()) {
                        final Item headerItem = new SimpleImageGifModel(R.drawable.image_default,
                                "http://img15.3lian.com/2015/a1/10/d/111.jpg",
                                "http://img4.duitang.com/uploads/item/201410/13/20141013150515_43KCM.gif",
                                VIEW_TYPE_SIMPLE_IMAGE_GIF);
                        mListAdapter.addFooterItem(headerItem);
                    }
                }
            }
        }

        if (mLabelBody.isChecked()) {
            if (!addMore) {
                final int size = Math.min(count < 0 ? mListAdapter.getBodyCount() : count, mListAdapter.getBodyCount());
                for (int i = 0; i < size; i++) {
                    mListAdapter.removeBodyItem(mListAdapter.getBodyCount() - 1 - i);
                }
            }
            final int index = mListAdapter.getBodyCount();
            for (int i = 0; i < count; i++) {
                if (mTypeText.isChecked()) {
                    final Item headerItem = new SimpleTextModel("I'm a BODY item with index " + (index + i),
                            VIEW_TYPE_SIMPLE_TEXT);
                    mListAdapter.addBodyItem(headerItem);
                }

                if (mTypeImageRes.isChecked()) {
                    final Item headerItem = new SimpleImageModel(R.drawable.image_default,
                            VIEW_TYPE_SIMPLE_IMAGE);
                    mListAdapter.addBodyItem(headerItem);
                }

                if (mTypeImageUrl.isChecked()) {
                    final Item headerItem = new SimpleImageUrlModel(R.drawable.image_default,
                            "http://img15.3lian.com/2015/a1/10/d/111.jpg", VIEW_TYPE_SIMPLE_IMAGE_URL);
                    mListAdapter.addBodyItem(headerItem);
                }

                if (mTypeImageGIF.isChecked()) {
                    final Item headerItem = new SimpleImageGifModel(R.drawable.image_default,
                            "http://img15.3lian.com/2015/a1/10/d/111.jpg",
                            "http://img4.duitang.com/uploads/item/201410/13/20141013150515_43KCM.gif",
                            VIEW_TYPE_SIMPLE_IMAGE_GIF);
                    mListAdapter.addBodyItem(headerItem);
                }
            }
        }

        mListAdapter.notifyDataSetChanged();
    }
}
