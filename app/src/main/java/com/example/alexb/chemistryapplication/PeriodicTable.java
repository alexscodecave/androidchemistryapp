package com.example.alexb.chemistryapplication;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PeriodicTable extends FragmentActivity {
    private ListView listViewGroupOne;
    private ListView listViewGroupTwo;
    private ListView listViewGroupThree;
    private ListView listViewGroupFour;
    private ListView listViewGroupFive;
    private ListView listViewGroupSix;
    private ListView listViewGroupSeven;
    private ListView listViewGroupEight;
    private ListView listViewGroupNine;
    private ListView listViewGroupTen;
    private ListView listViewGroupEleven;
    private ListView listViewGroupTwelve;
    private ListView listViewGroupThirteen;
    private ListView listViewGroupFourteen;
    private ListView listViewGroupFifteen;
    private ListView listViewGroupSixteen;
    private ListView listViewGroupSeventeen;
    private ListView listViewGroupEighteen;
    private ImageView imgView;

    private String[] groupOneElements; //private string array
    private int[] groupOneElementDetails;
    private String[] groupTwoElements;
    private String[] groupThreeElements;
    private String[] groupFourElements;
    private String[] groupFiveElements;
    private String[] groupSixElements;
    private String[] groupSevenElements;
    private String[] groupEightElements;
    private String[] groupNineElements;
    private String[] groupTenElements;
    private String[] groupElevenElements;
    private String[] groupTwelveElements;
    private String[] groupThirteenElements;
    private String[] groupFourteenElements;
    private String[] groupFifteenElements;
    private String[] groupSixteenElements;
    private String[] groupSeventeenElements;
    private String[] groupEighteenElements;
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    private Bundle hydrogenElement;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periodic_table);
        groupOneElements = getResources().getStringArray(R.array.grouponeelements);
        groupTwoElements = getResources().getStringArray(R.array.grouptwoelements);
        groupThreeElements = getResources().getStringArray(R.array.groupthreeelements);
        groupFourElements = getResources().getStringArray(R.array.groupfourelements);
        groupFiveElements = getResources().getStringArray(R.array.groupfiveelements);
        groupSixElements = getResources().getStringArray(R.array.groupsixelements);
        groupSevenElements = getResources().getStringArray(R.array.groupsevenelements);
        groupEightElements = getResources().getStringArray(R.array.groupeightelements);
        groupNineElements = getResources().getStringArray(R.array.groupnineelements);
        groupTenElements = getResources().getStringArray(R.array.grouptenelements);
        groupElevenElements = getResources().getStringArray(R.array.groupelevenelements);
        groupTwelveElements = getResources().getStringArray(R.array.grouptwelveelements);
        groupThirteenElements = getResources().getStringArray(R.array.groupthirteenelements);
        groupFourteenElements = getResources().getStringArray(R.array.groupfourteenelements);
        groupFifteenElements = getResources().getStringArray(R.array.groupfifteenelements);
        groupSixteenElements = getResources().getStringArray(R.array.groupsixteenelements);
        groupSeventeenElements = getResources().getStringArray(R.array.groupseventeenelements);
        groupEighteenElements = getResources().getStringArray(R.array.groupeighteenelements);
        //group one elements is equal to the data found in the string array in the strings.xml
        listViewGroupOne = (ListView) findViewById(R.id.listViewGroupOne);
        listViewGroupTwo = (ListView) findViewById(R.id.listViewGroupTwo);
        listViewGroupThree = (ListView) findViewById(R.id.listViewGroupThree);
        listViewGroupFour = (ListView) findViewById(R.id.listViewGroupFour);
        listViewGroupFive = (ListView) findViewById(R.id.listViewGroupFive);
        listViewGroupSix = (ListView) findViewById(R.id.listViewGroupSix);
        listViewGroupSeven = (ListView) findViewById(R.id.listViewGroupSeven);
        listViewGroupEight = (ListView) findViewById(R.id.listViewGroupEight);
        listViewGroupNine = (ListView) findViewById(R.id.listViewGroupNine);
        listViewGroupTen = (ListView) findViewById(R.id.listViewGroupTen);
        listViewGroupEleven = (ListView) findViewById(R.id.listViewGroupEleven);
//        listViewGroupTwelve = (ListView) findViewById(R.id.listViewGroupTwelve);
//        listViewGroupThirteen = (ListView) findViewById(R.id.listViewGroupThirteen);
//        listViewGroupFourteen = (ListView) findViewById(R.id.listViewGroupFourteen);
//        listViewGroupFifteen = (ListView) findViewById(R.id.listViewGroupFifteen);
//        listViewGroupSixteen = (ListView) findViewById(R.id.listViewGroupSixteen);
//        listViewGroupSeventeen = (ListView) findViewById(R.id.listViewGroupSeventeen);
//        listViewGroupEighteen = (ListView) findViewById(R.id.listViewGroupEighteen);
        imgView = (ImageView) findViewById(R.id.imgFragment);
        //hydrogenElement.putString("hydrogen","hydrogenContent");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,groupOneElements);
        ArrayAdapter<String> arrayAdapterGroupTwo = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,groupTwoElements);
        ArrayAdapter<String> arrayAdapterGroupThree = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,groupThreeElements);
        ArrayAdapter<String> arrayAdapterGroupFour = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,groupFourElements);
        ArrayAdapter<String> arrayAdapterGroupFive = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,groupFiveElements);
        ArrayAdapter<String> arrayAdapterGroupSix = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,groupSixElements);
        ArrayAdapter<String> arrayAdapterGroupSeven = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,groupSevenElements);
        ArrayAdapter<String> arrayAdapterGroupEight = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,groupEightElements);
        ArrayAdapter<String> arrayAdapterGroupNine = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,groupNineElements);
        ArrayAdapter<String> arrayAdapterGroupTen = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,groupTenElements);
        ArrayAdapter<String> arrayAdapterGroupEleven = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,groupElevenElements);

        ArrayAdapter<String> arrayAdapterGroupTwelve= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,groupTwelveElements);
        ArrayAdapter<String> arrayAdapterGroupThirteen = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,groupThirteenElements);
        ArrayAdapter<String> arrayAdapterGroupFourteen = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,groupFourteenElements);
        ArrayAdapter<String> arrayAdapterGroupFifteen = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,groupFifteenElements);
        ArrayAdapter<String> arrayAdapterGroupSixteen= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,groupSixteenElements);
        ArrayAdapter<String> arrayAdapterGroupSeventeen = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,groupSeventeenElements);
        ArrayAdapter<String> arrayAdapterGroupEighteen = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,groupEighteenElements);

        listViewGroupOne.setAdapter(arrayAdapter);
        listViewGroupTwo.setAdapter(arrayAdapterGroupTwo);
        listViewGroupThree.setAdapter(arrayAdapterGroupThree);
        listViewGroupFour.setAdapter(arrayAdapterGroupFour);
        listViewGroupFive.setAdapter(arrayAdapterGroupFive);
        listViewGroupSix.setAdapter(arrayAdapterGroupSix);
        listViewGroupSeven.setAdapter(arrayAdapterGroupSeven);
        listViewGroupEight.setAdapter(arrayAdapterGroupEight);
        listViewGroupNine.setAdapter(arrayAdapterGroupNine);
        listViewGroupTen.setAdapter(arrayAdapterGroupTen);
        listViewGroupEleven.setAdapter(arrayAdapterGroupEleven);
//        listViewGroupTwelve.setAdapter(arrayAdapterGroupTwelve);
//        listViewGroupThirteen.setAdapter(arrayAdapterGroupThirteen);
//        listViewGroupFourteen.setAdapter(arrayAdapterGroupFourteen);
//        listViewGroupFifteen.setAdapter(arrayAdapterGroupFifteen);
//        listViewGroupSixteen.setAdapter(arrayAdapterGroupSixteen);
//        listViewGroupSeventeen.setAdapter(arrayAdapterGroupSeventeen);
//        listViewGroupEighteen.setAdapter(arrayAdapterGroupEighteen);

        listViewGroupOne.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //switch statement instead of if statement more syntatic sugar

                switch(position){
                    case 0:
                        passDataToFragment("elementName","Hydrogen","elementAN","1","elementDesc","Hydrogen is an element that is responsible for a lot");
                        break;
                    case 1:
                        passDataToFragment("elementName","Lithium","elementAN","3","elementDesc","Lithium is an element that is responsible for a lot");
                        break;
                    case 2:
                        passDataToFragment("elementName","Sodium","elementAN","11","elementDesc","Sodium is an element that is responsible for a lot");
                        break;
                    case 3:
                        passDataToFragment("elementName","Potassium","elementAN","19","elementDesc","Potassium is an element that is responsible for a lot");
                        break;
                    case 4:
                        passDataToFragment("elementName","Rubidium","elementAN","37","elementDesc","Rubidium is an element that is responsible for a lot");
                        break;
                    case 5:
                        passDataToFragment("elementName","Caesium","elementAN","55","elementDesc","Caesium is an element that is responsible for a lot");

                }
            }
            public void passDataToFragment(String elementNameKey,String elementNameValue,String elementANKey,
                                           String elementANValue,String elementDescKey,String elementDescValue){
                Bundle hydrogenData = new Bundle();
                hydrogenData.putString(elementNameKey,elementNameValue);

                hydrogenData.putString(elementANKey,elementANValue);
                hydrogenData.putString(elementDescKey,elementDescValue);

                elementProfile elementProfile = new elementProfile();
                elementProfile.setArguments(hydrogenData);
                //elementProfile.setArguments(hydrogenElement);
                fragmentTransaction.replace(R.id.periodicTableContainer,elementProfile);
                fragmentManager.popBackStack();
                fragmentTransaction.commit();
            }
            public void replaceFragment(String elementNameKey,String elementNameValue,String elementANKey,
                                        String elementANValue,String elementDescKey,String elementDescValue){
                Bundle hydrogenData = new Bundle();
                hydrogenData.putString(elementNameKey,elementNameValue);

                hydrogenData.putString(elementANKey,elementANValue);
                hydrogenData.putString(elementDescKey,elementDescValue);

                elementProfile elementProfile = new elementProfile();
                elementProfile.setArguments(hydrogenData);
                elementProfile elementTwo = new elementProfile();
                fragmentTransaction.replace(R.id.fragmentContainer,elementTwo);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }

            public void populateGroup1(){

            }

            public void onBackPressed(){
                int count = getFragmentManager().getBackStackEntryCount();
                if(count==0){
                    PeriodicTable.super.onBackPressed();
                }else{
                    getFragmentManager().popBackStack();
                }
            }
        });

    }




}