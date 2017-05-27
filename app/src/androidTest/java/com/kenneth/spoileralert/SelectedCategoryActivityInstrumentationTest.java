package com.kenneth.spoileralert;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;

/**
 * Created by Kenneth on 27/05/2017.
 */

public class SelectedCategoryActivityInstrumentationTest {
    @Rule
    public ActivityTestRule<SelectedCategoryActivity> activityTestRule = new ActivityTestRule<>(SelectedCategoryActivity.class);

    @Test
    public void listItemClickStartsNewActivity(){
        View activityDecorView = activityTestRule.getActivity().getWindow().getDecorView();
        String selectedTopic = "#kenya";
        onData(anything())
                .inAdapterView(withId(R.id.contentListView))
                .atPosition(1)
                .perform(click());
        onView(withId(R.id.tweetsHeaderTextView)).check(matches(withText(selectedTopic+": 8 contributions")));
    }
}
