package com.kenneth.spoileralert.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.kenneth.spoileralert.adapters.CustomArrayAdapter;
import com.kenneth.spoileralert.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.categoriesListView) ListView mListView;
    @Bind(R.id.headerTextView) TextView mTextView;

    private String[] categories = new String[] {"Sports","Celebrities","Politics","Tech","Music","Food","Fashion","Film","Business","Gossip","Trump","Conference","News","Gaming"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        Typeface titleFont = Typeface.createFromAsset(getAssets(),"fonts/JOURNAL.TTF");
        mTextView.setTypeface(titleFont);

        mListView.setAdapter(new CustomArrayAdapter(this,categories));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView)view.findViewById(R.id.tweetsCategoryTextView);
                String categoryname = textView.getText().toString();
                Toast.makeText(MainActivity.this,"Viewing "+categoryname,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,SelectedCategoryActivity.class);
                intent.putExtra("categoryname",categoryname);
                startActivity(intent);
            }
        });
    }
}
