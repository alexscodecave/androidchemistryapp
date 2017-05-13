package com.example.alexb.chemistryapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class periodicTableQuizPageTwo extends Fragment {

    private float y1;
    private float y2;
    static final int MIN_DISTANCE = 150;

    public periodicTableQuizPageTwo() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_periodic_table_quiz_page_two, container, false);
        v.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        y1 = event.getY();
                        Toast.makeText(getContext(), "On click down", Toast.LENGTH_SHORT).show();
                        break;
                    case MotionEvent.ACTION_UP:
                        y2 = event.getY();
                        float deltay = y2-y1;
                        if(Math.abs(deltay) > MIN_DISTANCE)
                        {
                            if(y2>y1){
                                Toast.makeText(getContext(), "Up to down", Toast.LENGTH_SHORT).show(); //this works!!!!
                            }
                            else{
                                Toast.makeText(getContext(), "Down to up", Toast.LENGTH_SHORT).show(); //this works too!!!!
                            }
                        }
                        else{

                        }
                        break;
                }
                return true;

            }

        });
        return v;
    }

}
