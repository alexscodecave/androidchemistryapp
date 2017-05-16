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
    Integer[] elementImagesGroupOne = {R.drawable.hydrogenxxhdpi,R.drawable.lithiumxxhdpi,R.drawable.sodiumxxhdpi,
            R.drawable.potassiumxxhdpi,R.drawable.rubidiumxxhdpi,R.drawable.caesiumxxhdpi,R.drawable.franciumxxhdpi};
    Integer[] elementImagesGroupTwo = {R.drawable.berilliumxxhdpi,R.drawable.magnesiumxxhdpi,R.drawable.calciumxxhdpi,
    R.drawable.strontiumxxhdpi,R.drawable.bariumxxhdpi};

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
        String name = bundle.getString("elementName");
        String hydrogenAN = bundle.getString("elementAN");
        String hydrogenDesc = bundle.getString("elementDesc");
        imgView = (ImageView) view.findViewById(R.id.imgFragment);
        if (bundle != null) {
            nameOfElementToImage("Hydrogen",elementImagesGroupOne,0);
            nameOfElementToImage("Lithium",elementImagesGroupOne,1);
            nameOfElementToImage("Sodium",elementImagesGroupOne,2);
            nameOfElementToImage("Potassium",elementImagesGroupOne,3);
            nameOfElementToImage("Rubidium",elementImagesGroupOne,4);
            nameOfElementToImage("Caesium",elementImagesGroupOne,5);
            nameOfElementToImage("Francium",elementImagesGroupOne,6);
            nameOfElementToImage("Berillium",elementImagesGroupTwo,0);
            nameOfElementToImage("Magnesium",elementImagesGroupTwo,1);
            nameOfElementToImage("Calcium",elementImagesGroupTwo,2);
            nameOfElementToImage("Strontium",elementImagesGroupTwo,3);
            nameOfElementToImage("Barium",elementImagesGroupTwo,4);

            elementName = (TextView) view.findViewById(R.id.elementNameFragment);
            elementName.setText("Element name: "+name);
            elementAtomicNumber = (TextView) view.findViewById(R.id.elementAtomicNumberFragment);
            elementAtomicNumber.setText("Element atomic number: "+hydrogenAN);
            elementDescription = (TextView) view.findViewById(R.id.elementDescriptionFragment);
            elementDescription.setText("Element description: "+hydrogenDesc);
        }
        else{
            Toast.makeText(getContext(), "Bundle is empty", Toast.LENGTH_SHORT).show();
        }
        return view;

    }

    public String setElementData(String elemName){
        elementName.setText(elemName);
        return elemName;
    }

    /**
     *
     * @param elementName contains element name
     * @param imageArray contains the array in which the element image is heralded
     * @param imageArrayIndex contains the index at which to access the above array
     */

    public void nameOfElementToImage(String elementName,Integer[] imageArray,int imageArrayIndex){
        String name = this.getArguments().get("elementName").toString();
        if(name==elementName){
            imgView.setImageResource(imageArray[imageArrayIndex]);
        }
    }

}
