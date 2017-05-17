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

    Button btnGoToPeriodicTableExplaination;
    FragmentTransaction ft;

    public periodictableQuizPage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_periodictable_quiz_page, container, false);
        btnGoToPeriodicTableExplaination = (Button) v.findViewById(R.id.btnPeriodicGoToPage2);
        btnGoToPeriodicTableExplaination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragment();
            }
        });


        return v;
    }


    public void switchFragment() {

        getFragmentManager().beginTransaction().setCustomAnimations(R.anim.slideup,R.anim.slidedown).replace(R.id.quizActivityLayout, new periodicTableQuizPageTwo()).addToBackStack(null).commit();
    }

}
