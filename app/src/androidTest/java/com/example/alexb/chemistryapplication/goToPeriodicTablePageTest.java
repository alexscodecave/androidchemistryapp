package com.example.alexb.chemistryapplication;

/**
 * Created by alexb on 16/05/2017.
 */

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class goToPeriodicTablePageTest {

    @Test
    public void doesButtonWork(){
        onView(withId(R.id.androidPeriodicTableImageButton))
                .perform((new ViewAction() {
                    @Override
                    public Matcher<View> getConstraints() {
                        return isDisplayed();
                    }

                    @Override
                    public String getDescription() {
                        return "Performed click functionality";

                    }

                    @Override
                    public void perform(UiController uiController, View view) {

                    }
                }));
    }
}
