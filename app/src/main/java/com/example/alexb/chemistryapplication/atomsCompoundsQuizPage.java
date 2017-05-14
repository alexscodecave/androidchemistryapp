package com.example.alexb.chemistryapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.transition.Slide;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class atomsCompoundsQuizPage extends Fragment {


    public atomsCompoundsQuizPage() {
        // Required empty public constructor
    }
    Button btnAtomsCompounds;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=  inflater.inflate(R.layout.fragment_atoms_compounds_quiz_page, container, false);
        btnAtomsCompounds = (Button) v.findViewById(R.id.atomsCompounds);
        btnAtomsCompounds.setOnClickListener(new View.OnClickListener() {
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
