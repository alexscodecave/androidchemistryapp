package com.example.alexb.chemistryapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Metals extends Fragment {

    Button btnMetal;

    public Metals() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_metals, container, false);
        btnMetal = (Button) v.findViewById(R.id.metalButton);
        btnMetal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragment();
                //switch from first metal page to metal page two
            }
        });
        return v;
    }
    public void switchFragment() {

        getFragmentManager().beginTransaction().setCustomAnimations(R.anim.slideup,R.anim.slidedown).replace(R.id.quizActivityLayout, new MetalsQuizPageTwo()).addToBackStack(null).commit();
    }

}
