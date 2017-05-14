package com.example.alexb.chemistryapplication;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GestureDetectorCompat;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class periodictableQuizPage extends Fragment {

    private float YAxisOne;
    private float YAxisTwo;
    static final int MIN_DISTANCE = 150;
    Animation animSlideUp;
    Button btnGoToPeriodicTableExplaination;
    FragmentTransaction ft;

    public periodictableQuizPage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_periodictable_quiz_page, container, false);

        v.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        YAxisOne = event.getY();
                        Toast.makeText(getContext(), "On click down", Toast.LENGTH_SHORT).show();
                        break;
                    case MotionEvent.ACTION_UP:
                        YAxisTwo = event.getY();
                        float OutcomeY = YAxisTwo-YAxisOne;
                        if(Math.abs(OutcomeY) > MIN_DISTANCE)
                        {
                            if(YAxisTwo>YAxisOne){
                                Toast.makeText(getContext(), "Up to down", Toast.LENGTH_SHORT).show(); //this works!!!!
                                switchFragment();
                            }
                            else{
                                Toast.makeText(getContext(), "Down to up", Toast.LENGTH_SHORT).show(); //this works too!!!!

                            }
                        }
                        break;
                }
                return true;

            }

        });

        return v;
    }


    public void switchFragment() {

        getFragmentManager().beginTransaction().setCustomAnimations(R.anim.slideup,R.anim.slidedown).replace(R.id.quizActivityLayout, new periodicTableQuizPageTwo()).addToBackStack(null).commit();
    }

}
