package com.kenneth.spoileralert.services;

import com.kenneth.spoileralert.Constants;
import com.kenneth.spoileralert.models.Tweet;

import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

/**
 * Created by Kenneth on 01/06/2017.
 */

public class TwitterService {
    public static void findTweets(String topic, Callback callback){
        OkHttpOAuthConsumer consumer = new OkHttpOAuthConsumer(Constants.CONSUMER_KEY,Constants.CONSUMER_SECRET);
        consumer.setTokenWithSecret(Constants.TOKEN,Constants.TOKEN_SECRET);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new SigningInterceptor(consumer))
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.QUERY_PARAMETERS,topic);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Tweet> processResults(Response response){
        ArrayList<Tweet> tweets = new ArrayList<>();
    }
}
