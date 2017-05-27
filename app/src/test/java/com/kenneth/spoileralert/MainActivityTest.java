package com.kenneth.spoileralert;

import android.os.Build;
import android.widget.ListView;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Kenneth on 27/05/2017.
 */

@Config(constants = BuildConfig.class,sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)
public class MainActivityTest {
    private MainActivity activity;
    private ListView mListView;

    @Before
    public void setup(){
        activity = Robolectric.setupActivity(MainActivity.class);
        mListView = (ListView) activity.findViewById(R.id.categoriesListView);
    }

    @Test
    public void validateTextView(){
        TextView mainActivityTextView = (TextView) activity.findViewById(R.id.headerTextView);
        assertTrue("Browse categories".equals(mainActivityTextView.getText().toString()));
    }

    @Test
    public void categoriesListViewPopulates(){
        assertNotNull(mListView.getAdapter());
        assertEquals(mListView.getAdapter().getCount(),9);
    }
}
