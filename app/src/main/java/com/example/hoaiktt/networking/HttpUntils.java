package com.example.hoaiktt.networking;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hoaiktt on 8/1/2017.
 */

public class HttpUntils {

    public static String urlContent(String address) throws IOException {
        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(address);
        ResponseHandler<String> handler = new BasicResponseHandler();
        return client.execute(httpGet, handler);
    }

    public static String urlContentPost(String address, String... paramNamesAndValues) throws IOException {
        HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(address);
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        for (int i = 0; i < paramNamesAndValues.length - 1; i = i + 2) {
            String paramName = paramNamesAndValues[i];
            String paramValue = paramNamesAndValues[i + 1];
            params.add(new BasicNameValuePair(paramName, paramValue));
        }
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, "UTF-8");
        httpPost.setEntity(entity);
        ResponseHandler<String> handler = new BasicResponseHandler();
        return (client.execute(httpPost, handler));

    }
}
