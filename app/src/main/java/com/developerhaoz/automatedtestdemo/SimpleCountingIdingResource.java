package com.developerhaoz.automatedtestdemo;

import android.support.test.espresso.IdlingResource;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by developerHaoz on 2017/10/20.
 */

public final class SimpleCountingIdingResource implements IdlingResource{

    private final String mResourceName;
    private final AtomicInteger counter = new AtomicInteger(0);

    private volatile ResourceCallback mResourceCallback;

    public SimpleCountingIdingResource(String resourceName){
        this.mResourceName = resourceName;
    }

    @Override
    public String getName() {
        return mResourceName;
    }

    @Override
    public boolean isIdleNow() {
        return counter.get() == 0;
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback callback) {
        this.mResourceCallback = callback;
    }

    public void increment(){
        counter.getAndIncrement();
    }

    public void decrement(){
        int counterVal = counter.decrementAndGet();

        if(counterVal == 0){
            if(null != mResourceCallback){
                mResourceCallback.onTransitionToIdle();
            }
        }

        if(counterVal < 0){
            throw new IllegalArgumentException("Counter has been corrupted!");
        }
    }
















}
