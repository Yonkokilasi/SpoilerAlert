package com.kenneth.spoileralert.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.kenneth.spoileralert.adapters.CustomArrayAdapter;
import com.kenneth.spoileralert.R;
import com.kenneth.spoileralert.services.TwitterService;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class SelectedCategoryActivity extends AppCompatActivity {
    @Bind(R.id.categoryTextView) TextView mTextView;
    @Bind(R.id.contentListView) ListView mListView;


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
//        mTextView.setText(adapter.getCount()+" sub-categories of "+categoryname);

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
                try {
                    String jsonData = response.body().string();

                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
    }
}
