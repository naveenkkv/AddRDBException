package com.example.naveenkumark.addrdbexception;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.email),
                        withParent(withId(R.id.content_main)),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("aa@a.com"));

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.password),
                        withParent(withId(R.id.content_main)),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("12345"));

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.signup), withText("Sign Up"),
                        withParent(withId(R.id.content_main)),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.email), withText("aa@a.com"),
                        withParent(withId(R.id.content_main)),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("aa@gmail.com"));

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.signup), withText("Sign Up"),
                        withParent(withId(R.id.content_main)),
                        isDisplayed()));
        appCompatButton2.perform(click());

    }

}
