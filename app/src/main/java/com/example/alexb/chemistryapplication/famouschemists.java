package com.example.alexb.chemistryapplication;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

public class famouschemists extends FragmentActivity {

    ViewPager mViewPager;
    famousChemists famousChemistsPagerAdapter;

    private String[] chemistsTabNames = {"Mendeleev", "Curie", "Faraday"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_famouschemists);
        famousChemistsPagerAdapter = new famousChemists(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);

        mViewPager.setAdapter(famousChemistsPagerAdapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(mViewPager);
    }
    private class famousChemists extends FragmentPagerAdapter{
        public famousChemists(FragmentManager fm){
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            switch(position){
                case 0:
                    return new mendeleev();
                case 1:
                    return new mariecurie();
                case 2:
                    return new faraday();

            }

            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position){
            switch (position) {
                case 0:
                    return "Mendeleev";
                case 1:
                    return "Curie";
                case 2:
                    return "Faraday";
            }
            return null;
        };
    }

}

