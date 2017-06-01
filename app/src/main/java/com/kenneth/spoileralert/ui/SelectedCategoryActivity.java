package com.kenneth.spoileralert.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.kenneth.spoileralert.CustomArrayAdapter;
import com.kenneth.spoileralert.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SelectedCategoryActivity extends AppCompatActivity {
    @Bind(R.id.categoryTextView) TextView mTextView;
    @Bind(R.id.contentListView) ListView mListView;
    String[] trendingContent = new String[] {"africa","kenya","usa","trump","UCLfinals","UBIE3","RedCarpet","TechCrunch","kotlinInAndroid","Uber"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_category);

        ButterKnife.bind(this);
        Intent intent = getIntent();
        String categoryname = intent.getStringExtra("categoryname");

        CustomArrayAdapter adapter = new CustomArrayAdapter(this,android.R.layout.simple_list_item_1,trendingContent);
        mListView.setAdapter(adapter);

        Typeface titleFont = Typeface.createFromAsset(getAssets(),"fonts/JOURNAL.TTF");

        mTextView.setTypeface(titleFont);
        mTextView.setText(adapter.getCount()+" sub-categories of "+categoryname);

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
}
