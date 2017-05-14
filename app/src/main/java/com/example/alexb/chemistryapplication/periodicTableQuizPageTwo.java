package com.example.alexb.chemistryapplication;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.achievement.Achievements;


/**
 * A simple {@link Fragment} subclass.
 */
public class periodicTableQuizPageTwo extends Fragment implements GoogleApiClient.ConnectionCallbacks,GoogleApiClient.OnConnectionFailedListener{

    private float YAxisOne;
    private float YAxisTwo;
    static final int MIN_DISTANCE = 150;

    GoogleApiClient googleGamesApiClient;
    Button btnSubmitAnswer;
    GoogleApiClient googleApiClient;

    TextView txtViewOutputAccountName;


    private boolean mResolvingConnectionFailure = false;
    private boolean mAutoStartSignInflow = true;
    private boolean mSignInClicked = false;




    public periodicTableQuizPageTwo() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_periodic_table_quiz_page_two, container, false);



        googleApiClient = new GoogleApiClient.Builder(getContext())
                .addApi(Games.API)
                .build();

        btnSubmitAnswer = (Button) v.findViewById(R.id.btnQuestionTwo);
        btnSubmitAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Touched the submit button", Toast.LENGTH_SHORT).show();
                Games.Achievements.unlock(googleApiClient," CgkIv6L9ivQIEAIQAQ");
            }
        });
            v.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        YAxisOne = event.getY();
                        Toast.makeText(getContext(), "On click down", Toast.LENGTH_SHORT).show();
                        break;
                    case MotionEvent.ACTION_UP:
                        YAxisTwo = event.getY();
                        float OutcomeY = YAxisTwo-YAxisOne;
                        if(Math.abs(OutcomeY) > MIN_DISTANCE)
                        {
                            if(YAxisTwo>YAxisOne){
                                Toast.makeText(getContext(), "Up to down", Toast.LENGTH_SHORT).show(); //this works!!!!
                                switchFragment();
                            }
                            else{
                                Toast.makeText(getContext(), "Down to up", Toast.LENGTH_SHORT).show(); //this works too!!!!

                            }
                        }
                        break;
                }
                return true;

            }

        });
        return v;


    }
    public void switchFragment() {

        getFragmentManager().beginTransaction().setCustomAnimations(R.anim.slideup,R.anim.slidedown).replace(R.id.quizActivityLayout, new periodictableQuizPage()).addToBackStack(null).commit();
    }


    @Override
    public void onStart(){
        super.onStart();
        googleApiClient.connect();
    }
    @Override
    public void onStop(){
        super.onStop();
        googleApiClient.disconnect();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {
        googleApiClient.connect();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        if(mResolvingConnectionFailure){
            return;
        }
        //if sign in button clicked
        if(mSignInClicked|| mAutoStartSignInflow){
            mAutoStartSignInflow = false;
            mSignInClicked = false;
            mResolvingConnectionFailure = true;
        }
    }





}
