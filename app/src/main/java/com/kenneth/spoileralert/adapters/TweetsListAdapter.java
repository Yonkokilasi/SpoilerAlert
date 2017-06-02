package com.kenneth.spoileralert.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kenneth.spoileralert.R;
import com.kenneth.spoileralert.models.Tweet;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Kenneth on 01/06/2017.
 */

public class TweetsListAdapter extends RecyclerView.Adapter<TweetsListAdapter.TweetViewHolder>{
    private ArrayList<Tweet> mTweets = new ArrayList<>();
    private Context mContext;

    public TweetsListAdapter(Context context,ArrayList<Tweet> tweets){
        mContext = context;
        mTweets = tweets;
    }

    @Override
    public TweetsListAdapter.TweetViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tweets_list_item,parent,false);
        TweetViewHolder viewHolder = new TweetViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TweetsListAdapter.TweetViewHolder holder,int position){
        holder.bindTweet(mTweets.get(position));
    }
    @Override
    public int getItemCount(){
        return mTweets.size();
    }

    public class TweetViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.tweetTextView) TextView mTweetTextView;
        @Bind(R.id.tweetUserTextView) TextView mUserTextView;
        private Context mContext;

        public TweetViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this,itemView);
            mContext=itemView.getContext();
        }
        public void bindTweet(Tweet tweet){
            mUserTextView.setText("@"+tweet.getUser()+"\n says");
            mTweetTextView.setText(tweet.getTweetText());
        }
    }
}
