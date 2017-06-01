package com.kenneth.spoileralert;

/**
 * Created by Kenneth on 31/05/2017.
 */

public class Constants {
    public static final String CONSUMER_KEY = BuildConfig.TWITTER_CONSUMER_KEY;
    public static final String CONSUMER_SECRET = BuildConfig.TWITTER_CONSUMER_SECRET;
    public static final String TOKEN = BuildConfig.TWITTER_TOKEN;
    public static final String TOKEN_SECRET = BuildConfig.TWITTER_TOKEN_SECRET;
    public static final String BASE_URL = "https://api.twitter.com/1.1/search/tweets.json?result_type=recent&lang=en&count=50";
    public static final String QUERY_PARAMETERS = "q";
}
