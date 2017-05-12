package com.example.alexb.chemistryapplication;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class QuizActivity extends AppCompatActivity {
    ViewPager mViewPager;
    quizPages quizPagesPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        quizPagesPagerAdapter = new quizPages(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.quizPager);
        mViewPager.setAdapter(quizPagesPagerAdapter);
    }
    @Override
    public void onBackPressed() {
        if (mViewPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1);
        }
    }


    private class quizPages extends FragmentPagerAdapter {
        public quizPages(FragmentManager fm){
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            switch(position){
                case 0:
                    return new periodictableQuizPage();
                case 1:
                    return new atomsCompoundsQuizPage();

            }

            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }


    }
}
