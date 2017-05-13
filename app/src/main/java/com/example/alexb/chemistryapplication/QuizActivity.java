package com.example.alexb.chemistryapplication;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity{
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
    public void onBackPressed(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStack();
        } else {

            super.onBackPressed();
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
                case 2:
                    return new Metals();

            }

            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }


    }
}
