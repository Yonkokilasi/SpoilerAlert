package com.kenneth.spoileralert;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.categoriesListView) ListView mListView;

    private String[] categories = new String[] {"Sports","Celebrities","Politics","Tech","Music","Food","Fashion","Film","Business"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        CategoriesArrayAdapter adapter = new CategoriesArrayAdapter(this,android.R.layout.simple_list_item_1,categories);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView,View view,int i,long l){
                String categoryname = ((TextView)view).getText().toString();
                Toast.makeText(MainActivity.this,"Viewing "+categoryname,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,SelectedCategoryActivity.class);
                intent.putExtra("categoryname",categoryname);
                startActivity(intent);
            }
        });
    }
}
