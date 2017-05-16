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

    Button[] rowOneButtons = new Button[2]; //hydrogen and helium
    Button[] rowTwoButtons = new Button[8]; //Lithium and bellium
    Button[] rowThreeButtons = new Button[8];
    Button[] rowFourButtons = new Button[18];
    Button[] rowFiveButtons = new Button[18];
    Button[] rowSixButtons = new Button[18];
    Button[] rowSevenButtons = new Button[9];

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
        btnFrancium = (Button) findViewById(R.id.btnFrancium);
        //column 2
        btnBerrilium = (Button) findViewById(R.id.btnBeryllium);
        btnMagnesium = (Button) findViewById(R.id.btnMagnesium);
        btnCalcium = (Button) findViewById(R.id.btnCalcium);
        btnStronium = (Button) findViewById(R.id.btnStronium);
        btnBarium = (Button) findViewById(R.id.btnBarium);
        btnFrancium = (Button) findViewById(R.id.btnFrancium);

        btnHydrogen.setOnClickListener(onClickListener);
        btnLithium.setOnClickListener(onClickListener);
        btnSodium.setOnClickListener(onClickListener);
        btnPotassium.setOnClickListener(onClickListener);
        btnRubidium.setOnClickListener(onClickListener);
        btnCaesium.setOnClickListener(onClickListener);
        btnFrancium.setOnClickListener(onClickListener);
        btnOnClickListener(btnBerrilium);
        btnOnClickListener(btnMagnesium);
        btnOnClickListener(btnCalcium);
        btnOnClickListener(btnStronium);
        btnOnClickListener(btnBarium);
        btnOnClickListener(btnFrancium);
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

    private void specificButtonClicked(Button btnName){
        btnName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void btnOnClickListener(Button b){
        b.setOnClickListener(onClickListener);
    }


    @Override
    public void onClick(View v) {

    }
}