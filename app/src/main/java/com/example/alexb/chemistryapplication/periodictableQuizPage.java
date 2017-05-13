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
public class periodictableQuizPage extends Fragment implements Animation.AnimationListener {

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
        btnGoToPeriodicTableExplaination = (Button) v.findViewById(R.id.btnQuizPeriodicTable);



        btnGoToPeriodicTableExplaination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switchFragment();
                //switch from first periodic table page to periodic table page two
            }
        });

        v.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    Toast.makeText(getContext(), "This has been down since the get go", Toast.LENGTH_SHORT).show();
                }
                return true;
            }

        });

        return v;
    }


    public void switchFragment() {

        getFragmentManager().beginTransaction().setCustomAnimations(R.anim.slideup,R.anim.slidedown).replace(R.id.quizActivityLayout, new periodicTableQuizPageTwo()).addToBackStack(null).commit();
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (animation == animSlideUp) {
            Toast.makeText(getContext(), "Animation finished", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
