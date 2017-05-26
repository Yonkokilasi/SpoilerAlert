package com.kenneth.spoileralert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import butterknife.Bind;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.categoriesListView) ListView mListView;

    private String[] categories = new String[] {"Sports","Celebrities","Politics","Tech","Music","Food","Fashion","Film","Business"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
