package com.udacity.gradle.builditbigger;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;


import org.hamcrest.Matchers;
import org.hamcrest.core.IsNot;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class GetJokeTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void clickTellJoke_GetValidJokeFromAsyncTask() {
        Espresso.onView(ViewMatchers.withId(R.id.tell_joke_button)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.joke_tv)).check(ViewAssertions.matches(ViewMatchers.withText(IsNot.not(Matchers.isEmptyOrNullString()))));
    }

}
