package com.kenneth.spoileralert;

import android.content.Context;
import android.widget.ArrayAdapter;

/**
 * Created by Kenneth on 26/05/2017.
 */

public class CategoriesArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mCategories;

    public CategoriesArrayAdapter(Context mContext,int resource,String[] mCategories){
        super(mContext,resource);
        this.mContext = mContext;
        this.mCategories = mCategories;
    }
    @Override
    public Object getItem(int position){
        String category = mCategories[position];
        return String.format("#%s",category);
    }
    @Override
    public int getCount(){
        return mCategories.length;
    }
}
