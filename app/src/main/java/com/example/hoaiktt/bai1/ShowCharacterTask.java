package com.example.hoaiktt.bai1;

import android.os.AsyncTask;
import android.widget.TextView;


import com.example.hoaiktt.networking.HttpUntils;

import java.io.IOException;

/**
 * Created by hoaiktt on 7/31/2017.
 */

public class ShowCharacterTask extends AsyncTask<String, Void, Integer> {
    TextView mTvCharacterNumber;

    public ShowCharacterTask(TextView mTvCharacterNumber) {
        this.mTvCharacterNumber = mTvCharacterNumber;
    }

    @Override
    protected Integer doInBackground(String... strings) {
        int number = 0;
        try {
            number = showResult(strings[0]);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return number;
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        mTvCharacterNumber.setText("Số ký tự trong trang là:" + String.valueOf(integer));
    }


    public int showResult(String address) throws IOException {
        String urlContent = HttpUntils.urlContent(address);
        String[] lines = urlContent.split("[\\n\\r]+");
        StringBuilder builder = new StringBuilder();
        for (String line : lines) {
            builder.append(line);
        }
        int count = builder.length();
        return count;
    }

}
