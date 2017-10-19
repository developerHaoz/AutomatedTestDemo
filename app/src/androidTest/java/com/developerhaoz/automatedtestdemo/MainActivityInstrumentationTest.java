package com.developerhaoz.automatedtestdemo;

import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by developerHaoz on 2017/10/18.
 */

public class MainActivityInstrumentationTest {

    private String mStringToBetyped;

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);


    @Before
    public void initValidString(){
        mStringToBetyped = "Espresso";
    }

    @Test
    public void changeText_sameActivity(){
        onView(withId(R.id.main_et_info))
                .perform(typeText(mStringToBetyped), ViewActions.closeSoftKeyboard());

        onView(withId(R.id.main_btn_say_hello)).perform(click());

        onView(withId(R.id.main_tv_hello))
                .check(matches(withText(mStringToBetyped)));
    }

    @Test
    public void listGoesOverTheFold(){
        onView(withText("HelloWorld")).check(matches(isDisplayed()));
    }

}



















