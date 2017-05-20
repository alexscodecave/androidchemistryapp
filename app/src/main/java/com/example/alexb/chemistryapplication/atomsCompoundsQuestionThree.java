package com.example.alexb.chemistryapplication;


import android.content.ClipData;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class atomsCompoundsQuestionThree extends Fragment {


    public atomsCompoundsQuestionThree() {
        // Required empty public constructor
    }

    LinearLayout outerLayout;
    ImageView imgViewLeft;
    ImageView imgViewCenter;
    ImageView imgViewRight;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_atoms_compounds_question_three, container, false);
        outerLayout = (LinearLayout) v.findViewById(R.id.outerLayout);
        imgViewLeft = (ImageView) v.findViewById(R.id.leftAtomForLithium);
        imgViewCenter = (ImageView) v.findViewById(R.id.middleAtomForLithium);
        imgViewRight = (ImageView) v.findViewById(R.id.rightAtomForLithium);

        outerLayout.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                final int action = event.getAction();
                switch(action){
                    case DragEvent.ACTION_DRAG_STARTED:
                        Toast.makeText(getContext(), "action started", Toast.LENGTH_SHORT).show();
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        Toast.makeText(getContext(), "action exited", Toast.LENGTH_SHORT).show();
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        Toast.makeText(getContext(), "action entered", Toast.LENGTH_SHORT).show();
                        break;
                    case DragEvent.ACTION_DROP:
                        Toast.makeText(getContext(), "Action dropped", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
        imgViewLeft.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData data = ClipData.newPlainText("","");
                View.DragShadowBuilder shadow = new View.DragShadowBuilder(imgViewLeft);
                v.startDragAndDrop(data,shadow,null,0);
                return true;
            }
        });
        imgViewCenter.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData data = ClipData.newPlainText("","");
                View.DragShadowBuilder shadow = new View.DragShadowBuilder(imgViewCenter);
                v.startDragAndDrop(data,shadow,null,0);
                return true;
            }
        });
        imgViewRight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData data = ClipData.newPlainText("","");
                View.DragShadowBuilder shadow = new View.DragShadowBuilder(imgViewRight);
                v.startDragAndDrop(data,shadow,null,0);
                return true;
            }
        });
        return v;
    }


}
