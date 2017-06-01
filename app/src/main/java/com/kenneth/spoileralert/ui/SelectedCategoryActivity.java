package com.kenneth.spoileralert.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.kenneth.spoileralert.adapters.CustomArrayAdapter;
import com.kenneth.spoileralert.R;
import com.kenneth.spoileralert.models.Tweet;
import com.kenneth.spoileralert.services.TwitterService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class SelectedCategoryActivity extends AppCompatActivity {
    @Bind(R.id.categoryTextView) TextView mTextView;
    @Bind(R.id.tweetsRecyclerView) RecyclerView mListView;
    public static final String TAG = SelectedCategoryActivity.class.getSimpleName();

    public ArrayList<Tweet> mTweets = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_category);

        ButterKnife.bind(this);
        Intent intent = getIntent();
        String categoryname = intent.getStringExtra("categoryname");

        getTweets(categoryname);
        Typeface titleFont = Typeface.createFromAsset(getAssets(),"fonts/JOURNAL.TTF");

        mTextView.setTypeface(titleFont);
        mTextView.setText(" sub-categories of "+categoryname);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String content = ((TextView)view).getText().toString();
                Intent intent = new Intent(SelectedCategoryActivity.this,SpoilerTweetsActivity.class);
                intent.putExtra("content",content);
                startActivity(intent);
            }
        });
    }

    private void getTweets(String topic){
        final TwitterService twitterService = new TwitterService();
        twitterService.findTweets(topic, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                    String jsonData = response.body().string();
                        Log.v(TAG,jsonData);
                        mTweets = twitterService.processResults(response);

                        SelectedCategoryActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                String [] trendingTweets = new String[mTweets.size()];
                                for (int i = 0; i <trendingTweets.length ; i++) {
                                    trendingTweets[i] = mTweets.get(i).getTweetText();
                                }
                                ArrayAdapter adapter = new ArrayAdapter(SelectedCategoryActivity.this,android.R.layout.simple_list_item_2,trendingTweets);
                                mListView.setAdapter(adapter);
                                for (Tweet tweet:mTweets){
                                    Log.d(TAG,"Tweet: "+tweet.getTweetText());
                                    Log.e(TAG,"Inside the run");
                                }
                            }
                        });
            }
        });
    }
}
