package com.example.alexb.chemistryapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageButton btnPeriodicTable;
    ImageButton btnSettings;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSettings = (ImageButton) findViewById(R.id.androidSettings);
        btnPeriodicTable = (ImageButton) findViewById(R.id.androidPeriodicTableImageButton);

        btnPeriodicTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToPeriodicTable = new Intent(MainActivity.this,PeriodicTable.class);
                Toast.makeText(getBaseContext(),"Button clicked",Toast.LENGTH_LONG).show();
                Log.d("W","It works");
                startActivity(goToPeriodicTable);
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToSettingsPage = new Intent(MainActivity.this,settingspage.class);
                //intent is used to traverse to another activity
                startActivity(goToSettingsPage);
            }
        });
    }


}
