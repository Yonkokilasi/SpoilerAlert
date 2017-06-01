package com.kenneth.spoileralert.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

/**
 * Created by Kenneth on 26/05/2017.
 */

public class CustomArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mArrayElements;

    public CustomArrayAdapter(Context mContext,int resource,String[] mArrayElements){
        super(mContext,resource);
        this.mContext = mContext;
        this.mArrayElements = mArrayElements;
    }
    @Override
    public Object getItem(int position){
        String arrayElement = mArrayElements[position];
        return arrayElement;
    }
    @Override
    public int getCount(){
        return mArrayElements.length;
    }
}
