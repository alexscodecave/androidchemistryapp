package com.example.alexb.chemistryapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.TextViewCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class elementProfile extends Fragment {

    public TextView elementName;
    private TextView elementAtomicNumber;
    private TextView elementDescription;
    private ImageView imgView;
    Integer[] elementImages = {R.drawable.hydrogenhdpi,R.drawable.lithiumhdpi,R.drawable.sodiumhdpi,R.drawable.potassiumhdpi,R.drawable.rubidiumhdpi};

    public elementProfile() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        elementName = (TextView)getView().findViewById(R.id.elementName);
//        elementAtomicNumber = (TextView)getView().findViewById(R.id.elementAtomicNumber);
//        elementDescription = (TextView)getView().findViewById(R.id.elementDescription);
        View view = inflater.inflate(R.layout.fragment_element_profile, container, false);
        Bundle bundle = this.getArguments();
//        String i = bundle.getString("hydrogen");
        String name = this.getArguments().get("elementName").toString();
        String hydrogenAN = this.getArguments().get("elementAN").toString();
        String hydrogenDesc = this.getArguments().get("elementDesc").toString();
        imgView = (ImageView) view.findViewById(R.id.imgFragment);
        if (bundle != null) {
            Log.d("fragment",name);
            if(name=="Hydrogen") {
                imgView.setImageResource(elementImages[0]);
            }
            else if(name=="Lithium") {
                imgView.setImageResource(elementImages[1]);
            }
            else if(name=="Sodium"){
                imgView.setImageResource(elementImages[2]);
            }
            else if(name=="Potassium"){
                imgView.setImageResource(elementImages[3]);
            }
            else if(name=="Rubidium"){
                imgView.setImageResource(elementImages[4]);
            }

            elementName = (TextView) view.findViewById(R.id.elementNameFragment);
            elementName.setText("Element name: "+name);
            elementAtomicNumber = (TextView) view.findViewById(R.id.elementAtomicNumberFragment);
            elementAtomicNumber.setText("Element atomic number: "+hydrogenAN);
            elementDescription = (TextView) view.findViewById(R.id.elementDescriptionFragment);
            elementDescription.setText("Element description: "+hydrogenDesc);
        }
        return view;

    }

    public String setElementData(String elemName){
        elementName.setText(elemName);
        return elemName;
    }

}
