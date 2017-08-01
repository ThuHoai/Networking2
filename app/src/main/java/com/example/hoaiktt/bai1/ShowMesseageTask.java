package com.example.hoaiktt.bai1;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by hoaiktt on 7/31/2017.
 */

public class ShowMesseageTask extends AsyncTask<String, Void, Integer> {
    private TextView mTvMesseageResult;

    public ShowMesseageTask() {
    }

    public ShowMesseageTask(TextView mTvMesseageResult) {
        this.mTvMesseageResult = mTvMesseageResult;
    }

    @Override
    protected Integer doInBackground(String... strings) {
        HttpURLConnection urlConnect = null;
        int number = 0;
        try {
            URL url = new URL(strings[0]);
            urlConnect = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnect.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                number++;
            }
            urlConnect.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return number;
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        mTvMesseageResult.setText(String.valueOf(integer));
    }


    private String makeOutputString(List<String> results) {
        StringBuilder output = new StringBuilder();
        for (String s : results) {
            output.append(s + "\n");
        }
        return (output.toString());
    }
}