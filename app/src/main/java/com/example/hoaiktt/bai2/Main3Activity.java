package com.example.hoaiktt.bai2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hoaiktt.networking.R;


public class Main3Activity extends AppCompatActivity implements View.OnClickListener{
    private EditText mBaseUrl;
    private Button mBtnMonthlyPaymentResult;
    private TextView mTvMontlyPaymentResult, mTvJsonOject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mBtnMonthlyPaymentResult = (Button) findViewById(R.id.btn_monthly_payment_result);
        mTvMontlyPaymentResult = (TextView) findViewById(R.id.tv_month_payment);
        mBaseUrl = (EditText) findViewById(R.id.edt_base_url);
        mBaseUrl.setText("http://apps.coreservlets.com/NetworkingSupport/loan-calculator");
        mTvJsonOject = (TextView) findViewById(R.id.tv_json_oject);
        mBtnMonthlyPaymentResult.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String stringURL = mBaseUrl.getText().toString();
        new LoanCalculatorTask(mTvMontlyPaymentResult, mTvJsonOject).execute(stringURL);
    }
}
