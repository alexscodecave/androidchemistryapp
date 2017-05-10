package com.example.alexb.chemistryapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

public class famouschemists extends FragmentActivity {

    ViewPager mViewPager;
    DemoCollectionPagerAdapter demoCollectionPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_famouschemists);
        demoCollectionPagerAdapter = new DemoCollectionPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(demoCollectionPagerAdapter);
    }
    private class DemoCollectionPagerAdapter extends FragmentPagerAdapter{
        public DemoCollectionPagerAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position){
                case 0:
                    return new mendeleev();

            }

            return null;
        }

        @Override
        public int getCount() {
            return 1;
        }
    }

}

