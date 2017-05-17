package com.example.alexb.chemistryapplication;


import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
public class periodicTableQuizPageTwo extends Fragment implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private float YAxisOne;
    private float YAxisTwo;
    static final int MIN_DISTANCE = 150;

    GoogleApiClient googleGamesApiClient;
    Button btnSubmitAnswer;
    GoogleApiClient googleApiClient;

    TextView txtViewOutputAccountName;

    Button btnPeriodicGoBackHome;
    private boolean mResolvingConnectionFailure = false;
    private boolean mAutoStartSignInflow = true;
    private boolean mSignInClicked = false;
    RadioGroup periodicTablePageTwoRG;
    int selectedRGElement;
    RadioButton periodicTableQ1A1;
    RadioButton periodicTableQ1A2;
    RadioButton periodicTableQ1A3;
    TextView whetherUserCorrect;


    public periodicTableQuizPageTwo() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_periodic_table_quiz_page_two, container, false);
        periodicTablePageTwoRG = (RadioGroup) v.findViewById(R.id.periodicTableRGQ1);
        periodicTableQ1A1 = (RadioButton) v.findViewById(R.id.periodicTableQ1A1);
        periodicTableQ1A2 = (RadioButton) v.findViewById(R.id.periodicTableQ1A2);
        periodicTableQ1A3 = (RadioButton) v.findViewById(R.id.periodicTableQ1A3);

        googleApiClient = new GoogleApiClient.Builder(getContext())
                .enableAutoManage(getActivity(), 0, this)
                .addApi(Games.API).addScope(Games.SCOPE_GAMES)
                .build();

        whetherUserCorrect = (TextView) v.findViewById(R.id.whetherUserCorrect);

        btnSubmitAnswer = (Button) v.findViewById(R.id.btnQuestionTwo);
        btnPeriodicGoBackHome = (Button) v.findViewById(R.id.btnPeriodicGoBackHome);
        btnSubmitAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedRGElement = periodicTablePageTwoRG.getCheckedRadioButtonId();
                if (googleApiClient.isConnected()) {
                    if (selectedRGElement == -1) {

                        Toast.makeText(getContext(), "Please check an answer", Toast.LENGTH_SHORT).show();
                    }
                    else if (periodicTableQ1A1.isChecked()){
                        ifAnswerCorrect();
                        Games.Achievements.unlock(googleApiClient, " CgkIv6L9ivQIEAIQAQ");
                    } else if (periodicTableQ1A2.isChecked()) {
                        ifAnswerIncorrect();
                    }
                    else if (periodicTableQ1A3.isChecked()) {
                        ifAnswerIncorrect();
                    }
                } else {
                    Toast.makeText(getContext(), "Api not online", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnPeriodicGoBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragment();
            }
        });

        return v;

    }

    public void ifAnswerCorrect(){
        whetherUserCorrect.setVisibility(View.VISIBLE);
        whetherUserCorrect.setBackgroundResource(R.color.FDGreen);
        whetherUserCorrect.setText("Correct");
        whetherUserCorrect.setTextSize(30);
        whetherUserCorrect.setGravity(Gravity.CENTER);
        whetherUserCorrect.setTextColor(Color.WHITE);
    }
    public void ifAnswerIncorrect(){
        whetherUserCorrect.setVisibility(View.VISIBLE);
        whetherUserCorrect.setBackgroundResource(R.color.redColor);
        whetherUserCorrect.setText("Incorrect");
        whetherUserCorrect.setTextSize(30);
        whetherUserCorrect.setGravity(Gravity.CENTER);
        whetherUserCorrect.setTextColor(Color.WHITE);
    }

    public void switchFragment() {

        getFragmentManager().beginTransaction().setCustomAnimations(R.anim.slideup, R.anim.slidedown).replace(R.id.quizActivityLayout, new periodictableQuizPage()).addToBackStack(null).commit();
    }

    public void switchFragmentPageThree() {

        getFragmentManager().beginTransaction().setCustomAnimations(R.anim.slideup,R.anim.slidedown).replace(R.id.quizActivityLayout, new atomsCompoundsQuestionThree()).addToBackStack(null).commit();
    }

    @Override
    public void onStart() {
        super.onStart();
        googleApiClient.connect();
    }

    @Override
    public void onStop() {
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
        if (mResolvingConnectionFailure) {
            return;
        }
        //if sign in button clicked
        if (mSignInClicked || mAutoStartSignInflow) {
            mAutoStartSignInflow = false;
            mSignInClicked = false;
            mResolvingConnectionFailure = true;
        }
    }


}
