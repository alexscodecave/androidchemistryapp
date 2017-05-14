package com.example.alexb.chemistryapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {
    ImageButton btnPeriodicTable;
    ImageButton btnSettings;
    ImageButton btnQuizContent;
    GoogleApiClient googleApiClient;
    SignInButton signInButton;
    TextView txtViewAccount;
    private static int RC_SIGN_IN = 9001;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPeriodicTable = (ImageButton) findViewById(R.id.androidPeriodicTableImageButton);
        btnQuizContent = (ImageButton) findViewById(R.id.androidChemistryContent);
        btnSettings = (ImageButton) findViewById(R.id.androidSettings);
        txtViewAccount = (TextView) findViewById(R.id.txtViewAccount);

        signInButton = (SignInButton) findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        GoogleSignInOptions googleSignIn = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        googleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, googleSignIn)
                .build();

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();

            }
        });
        btnPeriodicTable.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                Intent goToPeriodicTable = new Intent(MainActivity.this, PeriodicTable.class);
                Toast.makeText(getBaseContext(), "Button clicked", Toast.LENGTH_LONG).show();
                Log.d("W", "It works");
                startActivity(goToPeriodicTable);
            }
        });

        btnQuizContent.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                Intent goToQuizContent = new Intent(MainActivity.this, QuizActivity.class);
                startActivity(goToQuizContent);
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                Intent goToSettingsPage = new Intent(MainActivity.this, famouschemists.class);
                //intent is used to traverse to another activity
                startActivity(goToSettingsPage);
            }
        });
    }

    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    private void handleSignInResult(GoogleSignInResult result) {
        if (result.isSuccess()) {
            GoogleSignInAccount account = result.getSignInAccount();
            Toast.makeText(this, "Signed in", Toast.LENGTH_SHORT).show();

        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }

}


