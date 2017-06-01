package com.kenneth.spoileralert;

import android.os.Build;
import android.widget.ListView;

import com.kenneth.spoileralert.ui.SelectedCategoryActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by Kenneth on 27/05/2017.
 */

@Config(constants = BuildConfig.class,sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)
public class SelectedCategoryActivityTest {
    private SelectedCategoryActivity activity;
    private ListView mListView;


    @Before
    public void setup(){
        activity = Robolectric.setupActivity(SelectedCategoryActivity.class);
        mListView = (ListView) activity.findViewById(R.id.contentListView);
    }

    @Test
    public void listViewPopulates(){
        assertNotNull(mListView.getAdapter());
        assertEquals(mListView.getAdapter().getCount(),10);
    }
}
