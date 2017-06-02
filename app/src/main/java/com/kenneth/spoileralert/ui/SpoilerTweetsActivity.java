package com.kenneth.spoileralert.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.kenneth.spoileralert.adapters.CustomArrayAdapter;
import com.kenneth.spoileralert.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SpoilerTweetsActivity extends AppCompatActivity {
    String[] fakeNews = new String[]{"Fake News","More Fake News","Most Fake News","I can't believe you're still reading","API integration coming soon","Keep calm and don't crash this app","This is a list BTW","Expect spolers soon"};
    @Bind(R.id.tweetsHeaderTextView) TextView mTextView;
    @Bind(R.id.tweetsListView) ListView mListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spoiler_tweets);

        ButterKnife.bind(this);

        Typeface titleFont = Typeface.createFromAsset(getAssets(),"fonts/JOURNAL.TTF");

        Intent intent = getIntent();
        String content = intent.getStringExtra("content");
//        CustomArrayAdapter adapter = new CustomArrayAdapter(this,android.R.layout.simple_list_item_1,fakeNews);
//        mListView.setAdapter(adapter);
//        mTextView.setTypeface(titleFont);
//        mTextView.setText(content+": "+adapter.getCount()+" contributions");
    }
}
