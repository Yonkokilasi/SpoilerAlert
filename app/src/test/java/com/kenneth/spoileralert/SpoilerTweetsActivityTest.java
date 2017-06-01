package com.kenneth.spoileralert;

import android.os.Build;
import android.widget.ListView;

import com.kenneth.spoileralert.ui.SpoilerTweetsActivity;

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
public class SpoilerTweetsActivityTest {
    private SpoilerTweetsActivity activity;
    private ListView mListView;

    @Before
    public void setup(){
        activity = Robolectric.setupActivity(SpoilerTweetsActivity.class);
        mListView = (ListView) activity.findViewById(R.id.tweetsListView);
    }

    @Test
    public void tweetsListViewPopulates(){
        assertNotNull(mListView.getAdapter());
        assertEquals(mListView.getAdapter().getCount(),8);
    }
}
