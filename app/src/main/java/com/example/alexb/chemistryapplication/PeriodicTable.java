package com.example.alexb.chemistryapplication;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
        listViewGroupTen.setAdapter(arrayAdapterGroupEleven);
        listViewGroupEleven.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==1){
                    passDataToFragment("elementName","Hydrogen","elementAN","1","elementDesc","Hydrogen is an element that is responsible for a lot");
                }
                else if(position==2){
                    passDataToFragment("elementName","Lithium","elementAN","3","elementDesc","Lithium is an element that is responsible for a lot");
                }
                else if(position==3){
                    passDataToFragment("elementName","Sodium","elementAN","11","elementDesc","Sodium is an element that is responsible for a lot");
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
                fragmentTransaction.add(R.id.periodicTableContainer,elementProfile);

                fragmentTransaction.commit();

            }
        });

    }




}
