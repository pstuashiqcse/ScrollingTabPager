package com.codelab.scrollingtab.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.codelab.scrollingtab.fragment.ImageFragment;

import java.util.ArrayList;

/**
 * Created by Ashiq on 8/3/16.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<String> mFragmentItems;


    public ViewPagerAdapter(FragmentManager fm, ArrayList<String> fragmentItems) {
        super(fm);
        this.mFragmentItems = fragmentItems;
    }

    @Override
    public Fragment getItem(int i) {
        return new ImageFragment();
    }

    @Override
    public int getCount() {
        return mFragmentItems.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentItems.get(position);
    }



}
