package com.example.hoaiktt.bai2;

import android.os.AsyncTask;
import android.widget.TextView;


import com.example.hoaiktt.networking.HttpUntils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by hoaiktt on 8/1/2017.
 */

public class LoanCalculatorTask extends AsyncTask<String, Void, JSONObject> {
    TextView  mMontlyPaymentResult, mTvJsonOjectResult;

    public LoanCalculatorTask(TextView mMontlyPaymentResult, TextView mTvJsonOjectResult) {
        this.mMontlyPaymentResult = mMontlyPaymentResult;
        this.mTvJsonOjectResult = mTvJsonOjectResult;
    }

    @Override
    protected JSONObject doInBackground(String... strings) {
        JSONObject jsonObject = null;
        try {
            String jsonString = HttpUntils.urlContent(strings[0]);
            jsonObject = new JSONObject(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        super.onPostExecute(jsonObject);
        if(jsonObject != null){
            try {
                mMontlyPaymentResult.setText("Montly Payment:" + jsonObject.getString("formattedMonthlyPayment"));
                mTvJsonOjectResult.setText(jsonObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }





}
