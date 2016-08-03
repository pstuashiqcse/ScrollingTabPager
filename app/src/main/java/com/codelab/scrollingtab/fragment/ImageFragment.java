package com.codelab.scrollingtab.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.codelab.scrollingtab.R;
import com.codelab.scrollingtab.adapter.ImageAdapter;
import com.codelab.scrollingtab.data.ImageProvider;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ashiq on 8/3/16.
 */
public class ImageFragment extends Fragment {

    private Context mContext;
    private ProgressBar loadingProgressIndicator;
    private TextView listStatusView;
    private RecyclerView recycleView;
    private ArrayList<String> mContentItems;
    private ImageAdapter imageAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = getActivity();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        initView(v);
        loadData();

        return v;
    }


    private void initView(View view) {
        loadingProgressIndicator = (ProgressBar) view.findViewById(R.id.progressBar);
        listStatusView = (TextView) view.findViewById(R.id.textView);
        recycleView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mContentItems = new ArrayList<>();
        recycleView.setLayoutManager(new GridLayoutManager(mContext, 3));
        imageAdapter = new ImageAdapter(mContentItems, mContext);
        recycleView.setAdapter(imageAdapter);
    }


    private void loadData() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                mContentItems.addAll(Arrays.asList(ImageProvider.imageThumbUrls));
                //refreshList();

                ((Activity)mContext).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        refreshList();
                    }
                });


            }
        }).start();
    }

    public void refreshList() {

        if (loadingProgressIndicator != null) {
            loadingProgressIndicator.setVisibility(View.GONE);
        }
        if (listStatusView != null) {
            if (mContentItems != null && mContentItems.isEmpty()) {
                listStatusView.setText(mContext.getResources().getString(R.string.no_item_found));
            } else {

                listStatusView.setVisibility(View.GONE);

                if (imageAdapter != null) {
                    imageAdapter.notifyDataSetChanged();
                }

            }
        }

    }



}
