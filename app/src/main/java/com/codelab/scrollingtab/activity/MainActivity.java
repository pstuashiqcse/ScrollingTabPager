package com.codelab.scrollingtab.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.codelab.scrollingtab.R;
import com.codelab.scrollingtab.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ashiq on 8/3/16.
 */

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private TabLayout tabLayout;
    private ArrayList<String> mFragmentItems;
    private FloatingActionButton sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initFunctionality();
        loadData();

    }

    private void initView() {
        setContentView(R.layout.activity_main);


        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        sendButton = (FloatingActionButton) findViewById(R.id.sendButton);
        tabLayout = (TabLayout) findViewById(R.id.tabs);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void initFunctionality() {
        mFragmentItems = new ArrayList<>();
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), mFragmentItems);
        mViewPager.setAdapter(viewPagerAdapter);
    }

    private void loadData() {

        //mViewPager.setOffscreenPageLimit(types.length); // use this if you want to preload fragments
        mFragmentItems.add("Tab 1");
        mFragmentItems.add("Tab 2");

        viewPagerAdapter.notifyDataSetChanged();
        tabLayout.setupWithViewPager(mViewPager);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
