package com.example.hoaiktt.bai3_4;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.example.hoaiktt.networking.HttpUntils;
import com.example.hoaiktt.networking.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class Main4Activity extends AppCompatActivity implements View.OnClickListener {
    private EditText mBaseUrl, mLoanAmount, mInterestRate, mLoanPeriod;
    private Button mBtnMonthlyPaymentResult;
    private TextView mTvMontlyPaymentResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        mBaseUrl = (EditText) findViewById(R.id.edt_base_url);
        mBaseUrl.setText("http://apps.coreservlets.com/NetworkingSupport/loan-calculator");
        mBtnMonthlyPaymentResult = (Button) findViewById(R.id.btn_monthly_payment_result);
        mLoanAmount = (EditText) findViewById(R.id.edt_loan_amount);
        mInterestRate = (EditText) findViewById(R.id.edt_interest_rate);
        mLoanPeriod = (EditText) findViewById(R.id.edt_loan_period);
        mTvMontlyPaymentResult = (TextView) findViewById(R.id.tv_month_payment);
        mBtnMonthlyPaymentResult.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String stringJson = mBaseUrl.getText().toString();
        String stringAmount = mLoanAmount.getText().toString();
        String stringRate = mInterestRate.getText().toString();
        String stringPeriod = mLoanPeriod.getText().toString();

        new ClickPaymentTask(mTvMontlyPaymentResult).execute(stringJson, stringAmount, stringRate, stringPeriod);

    }


    public class ClickPaymentTask extends AsyncTask<String, Void, JSONObject> {
        TextView mTvPaymentResult;

        public ClickPaymentTask(TextView mTvPaymentResult) {
            this.mTvPaymentResult = mTvPaymentResult;
        }

        @Override
        protected JSONObject doInBackground(String... strings) {
            JSONObject jsonObject = null;
            LoanInput mInput = new LoanInput(strings[1], strings[2], strings[3]);
            try {
                JSONObject inputJson = new JSONObject(mInput.getInputMap());
                String stringJson = HttpUntils.urlContentPost(strings[0], "loanInputs", inputJson.toString());
                jsonObject = new JSONObject(stringJson);
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
            if (jsonObject != null) {
                try {
                   mTvMontlyPaymentResult.setText("Montly Payment:" + jsonObject.getString("formattedMonthlyPayment"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
