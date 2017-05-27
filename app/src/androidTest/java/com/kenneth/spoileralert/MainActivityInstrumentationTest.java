package com.kenneth.spoileralert;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.not;

/**
 * Created by Kenneth on 27/05/2017.
 */

public class MainActivityInstrumentationTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void listItemlicksDisplaysCorrectToastOfTheTopic(){
        View activityDecorView = activityTestRule.getActivity().getWindow().getDecorView();
        String hashTagTopic = "Viewing #Sports";
        onData(anything())
                .inAdapterView(withId(R.id.categoriesListView))
                .atPosition(0)
                .perform(click());
        onView(withText(hashTagTopic)).inRoot(withDecorView(not(activityDecorView)))
                .check(matches(withText(hashTagTopic)));
    }

    @Test
}
