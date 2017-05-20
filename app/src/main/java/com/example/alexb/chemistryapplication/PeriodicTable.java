package com.example.alexb.chemistryapplication;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PeriodicTable extends FragmentActivity implements View.OnClickListener{


    //Column One of periodic table
    Button btnHydrogen;
    Button btnLithium;
    Button btnSodium;
    Button btnPotassium;
    Button btnRubidium;
    Button btnCaesium;
    Button btnFrancium;
    Button btnBerrilium;
    Button btnMagnesium;
    Button btnCalcium;
    Button btnStronium;
    Button btnBarium;
    Button btnRadium;
    Button btnScandium;
    Button btnYttrium;
    Button btnTitanium;
    Button btnZirconium;

    private ImageView imgView;


    private Bundle hydrogenElement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periodic_table);
        //column 1
        btnHydrogen = (Button) findViewById(R.id.btnHydrogen);
        btnLithium = (Button) findViewById(R.id.btnLithium);
        btnSodium = (Button) findViewById(R.id.btnSodium);
        btnPotassium = (Button) findViewById(R.id.btnPotassium);
        btnRubidium = (Button) findViewById(R.id.btnRubidium);
        btnCaesium = (Button) findViewById(R.id.btnCaesium);
        //column 2
        btnBerrilium = (Button) findViewById(R.id.btnBeryllium);
        btnMagnesium = (Button) findViewById(R.id.btnMagnesium);
        btnCalcium = (Button) findViewById(R.id.btnCalcium);
        btnStronium = (Button) findViewById(R.id.btnStronium);
        btnBarium = (Button) findViewById(R.id.btnBarium);
        btnFrancium = (Button) findViewById(R.id.btnFrancium);
        btnRadium = (Button) findViewById(R.id.btnRadium);
        //column 3
        btnScandium = (Button) findViewById(R.id.btnScandium);
        btnYttrium = (Button) findViewById(R.id.btnYttrium);

        //column 4
        btnTitanium = (Button) findViewById(R.id.btnTitanium);
        btnZirconium = (Button) findViewById(R.id.btnZirconium);



        btnOnClickListener(btnHydrogen);
        btnOnClickListener(btnLithium);
        btnOnClickListener(btnSodium);
        btnOnClickListener(btnPotassium);
        btnOnClickListener(btnRubidium);
        btnOnClickListener(btnCaesium);
        btnOnClickListener(btnFrancium);
        btnOnClickListener(btnBerrilium);
        btnOnClickListener(btnMagnesium);
        btnOnClickListener(btnCalcium);
        btnOnClickListener(btnStronium);
        btnOnClickListener(btnBarium);
        btnOnClickListener(btnFrancium);
        btnOnClickListener(btnScandium);
        btnOnClickListener(btnYttrium);
        btnOnClickListener(btnTitanium);
        btnOnClickListener(btnZirconium);
    }
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.btnHydrogen:
                    passDataToFragment("elementName","Hydrogen","elementAN","1","elementDesc","Hydrogen");
                    break;
                case R.id.btnLithium:
                    passDataToFragment("elementName","Lithium","elementAN","3","elementDesc","Lithium");
                    break;
                case R.id.btnSodium:
                    passDataToFragment("elementName","Sodium","elementAN","9","elementDesc","Sodium description");
                    break;
                case R.id.btnPotassium:
                    passDataToFragment("elementName","Potassium","elementAN","15","elementDesc","Potassium description");
                    break;
                case R.id.btnRubidium:
                    passDataToFragment("elementName","Rubidium","elementAN","27","elementDesc","Rubidium description");
                    break;
                case R.id.btnCaesium:
                    passDataToFragment("elementName","Caesium","elementAN","39","elementDesc","Caesium description");
                    break;
                case R.id.btnFrancium:
                    passDataToFragment("elementName","Francium","elementAN","87","elementDesc","Francium description");
                    break;
                case R.id.btnBeryllium:
                    passDataToFragment("elementName","Berillium","elementAN","4","elementDesc","Berillium description");
                    break;
                case R.id.btnMagnesium:
                    passDataToFragment("elementName","Magnesium","elementAN","4","elementDesc","Magnesium description");
                    break;
                case R.id.btnCalcium:
                    passDataToFragment("elementName","Calcium","elementAN","4","elementDesc","Calcium description");
                    break;
                case R.id.btnStronium:
                    passDataToFragment("elementName","Strontium","elementAN","4","elementDesc","Strontium description");
                    break;
                case R.id.btnBarium:
                    passDataToFragment("elementName","Barium","elementAN","4","elementDesc","Barium description");
                    break;
                case R.id.btnRadium:
                    passDataToFragment("elementName","Radium","elementAN","88","elementDesc","Francium description");
                    break;
                case R.id.btnScandium:
                    passDataToFragment("elementName","Scandium","elementAN","21","elementDesc","Scandium description");
                    break;
                case R.id.btnYttrium:
                    passDataToFragment("elementName","Yttrium","elementAN","39","elementDesc","Scandium description");
                    break;
                case R.id.btnTitanium:
                    passDataToFragment("elementName","Titanium","elementAN","39","elementDesc","Titanium description");
                    break;
                case R.id.btnZirconium:
                    passDataToFragment("elementName","Zirconium","elementAN","39","elementDesc","Titanium description");

            }
        }
    };

    public void passDataToFragment(String elementNameKey,String elementNameValue,String elementANKey,
                                   String elementANValue,String elementDescKey,String elementDescValue){
        Bundle hydrogenData = new Bundle();
        hydrogenData.putString(elementNameKey,elementNameValue);

        hydrogenData.putString(elementANKey,elementANValue);
        hydrogenData.putString(elementDescKey,elementDescValue);

        elementProfile elementProfile = new elementProfile();
        elementProfile.setArguments(hydrogenData);
        //elementProfile.setArguments(hydrogenElement);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.periodicTableContainer,elementProfile);
        fragmentManager.popBackStack();
        fragmentTransaction.commit();
    }

    private void btnOnClickListener(Button b){
        b.setOnClickListener(onClickListener);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onBackPressed() {
        if(getFragmentManager().getBackStackEntryCount()>0){
            getSupportFragmentManager().popBackStackImmediate();
        }else{
            super.onBackPressed();
        }
    }
}