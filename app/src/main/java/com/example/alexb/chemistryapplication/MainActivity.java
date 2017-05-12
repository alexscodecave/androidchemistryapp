package com.example.alexb.chemistryapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageButton btnPeriodicTable;
    ImageButton btnSettings;
    ImageButton btnQuizContent;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPeriodicTable = (ImageButton) findViewById(R.id.androidPeriodicTableImageButton);
        btnQuizContent = (ImageButton) findViewById(R.id.androidChemistryContent);
        btnSettings = (ImageButton) findViewById(R.id.androidSettings);


        btnPeriodicTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToPeriodicTable = new Intent(MainActivity.this,PeriodicTable.class);
                Toast.makeText(getBaseContext(),"Button clicked",Toast.LENGTH_LONG).show();
                Log.d("W","It works");
                startActivity(goToPeriodicTable);
            }
        });

        btnQuizContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToQuizContent = new Intent(MainActivity.this,QuizActivity.class);
                startActivity(goToQuizContent);
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToSettingsPage = new Intent(MainActivity.this,famouschemists.class);
                //intent is used to traverse to another activity
                startActivity(goToSettingsPage);
            }
        });
    }


}
