package com.kenneth.spoileralert.models;

import java.util.ArrayList;

/**
 * Created by Kenneth on 01/06/2017.
 */

public class Tweet {
    private String mTweetText;
    private ArrayList<String> mHashTags;
    private String mExternalLink;
    private String mImageLink;

    public Tweet(String tweetText, ArrayList<String> hashTags,String externalLink,String imageLink){
        this.mTweetText = tweetText;
        this.mHashTags = hashTags;
        this.mExternalLink = externalLink;
        this.mImageLink = imageLink;
    }

    public String getTweetText(){
        return mTweetText;
    }

    public ArrayList<String> getHashTags(){
        return mHashTags;
    }

    public String getExternalLink(){
        return mExternalLink;
    }

    public String getImageLink(){
        return mImageLink;
    }
}
