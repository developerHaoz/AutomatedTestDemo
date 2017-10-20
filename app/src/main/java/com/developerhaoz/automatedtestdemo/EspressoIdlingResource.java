package com.developerhaoz.automatedtestdemo;

import android.support.test.espresso.IdlingResource;

/**
 * Created by developerHaoz on 2017/10/20.
 */

public class EspressoIdlingResource {

    private static final String RESOURCE = "GLOBAL";

    private static SimpleCountingIdingResource mCountingIdlingResource =
            new SimpleCountingIdingResource(RESOURCE);

    public static void increment() {
        mCountingIdlingResource.increment();
    }

    public static void decrement() {
        mCountingIdlingResource.decrement();
    }

    public static IdlingResource getIdlingResource(){
        return mCountingIdlingResource;
    }

}
