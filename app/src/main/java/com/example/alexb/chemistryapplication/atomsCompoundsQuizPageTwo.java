package com.example.alexb.chemistryapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class atomsCompoundsQuizPageTwo extends Fragment {

    Button btnBackToPage1;
    Button btnAtomsGoToPage3;


    public atomsCompoundsQuizPageTwo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_atoms_compounds_quiz_page_two, container, false);
        btnBackToPage1 = (Button) v.findViewById(R.id.btnBackToPage1);
        btnAtomsGoToPage3 = (Button) v.findViewById(R.id.btnAtomsGoToPage3);

        btnBackToPage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragment();
            }
        });
        btnAtomsGoToPage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragmentPageThree();
            }
        });


        return v;

    }
    public void switchFragment() {

        getFragmentManager().beginTransaction().setCustomAnimations(R.anim.slideup,R.anim.slidedown).replace(R.id.quizActivityLayout, new atomsCompoundsQuizPage()).addToBackStack(null).commit();
    }
    public void switchFragmentPageThree() {

        getFragmentManager().beginTransaction().setCustomAnimations(R.anim.slideup,R.anim.slidedown).replace(R.id.quizActivityLayout, new atomsCompoundsQuestionThree()).addToBackStack(null).commit();
    }

}
