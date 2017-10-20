package com.developerhaoz.automatedtestdemo;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingResource;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;

/**
 * Created by developerHaoz on 2017/10/20.
 */

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    private IdlingResource mIdlingResource;

    @Before
    public void setUp() throws Exception{
        mIdlingResource = mActivityTestRule.getActivity().getCountingIdingResource();
        Espresso.registerIdlingResources(mIdlingResource);
    }

    @Test
    public void onLoadingFinished() throws Exception {
        onView(withId(R.id.main_btn_say_hello))
                .perform(click());

        onView(withId(R.id.main_tv_hello))
                .check(matches(withText(containsString("true"))));
    }

    @After
    public void release() throws Exception{
        Espresso.unregisterIdlingResources(mIdlingResource);
    }

}





















