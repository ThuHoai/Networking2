package com.example.hoaiktt.bai1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hoaiktt.networking.R;


public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    private EditText mURL;
    private Button mBtnNumberLines, mBtnNumberCharacter;
    private TextView mTvNumberLines, mTvNumberCharacter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mURL = (EditText) findViewById(R.id.edtURL);
        mBtnNumberLines = (Button) findViewById(R.id.btnShowMesseage);
        mTvNumberLines = (TextView) findViewById(R.id.tvMesseageResult);
        mBtnNumberCharacter = (Button) findViewById(R.id.btnShowNumberCharacter);
        mTvNumberCharacter = (TextView) findViewById(R.id.tvMesseageResult2);
        mBtnNumberLines.setOnClickListener(this);
        mBtnNumberCharacter.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String stringURL = mURL.getText().toString();
        if (view.getId() == R.id.btnShowMesseage) {
            new ShowMesseageTask(mTvNumberLines).execute(stringURL);
        }else
        if (view.getId() == R.id.btnShowNumberCharacter){
            new ShowCharacterTask(mTvNumberCharacter).execute(stringURL);
        }

    }

}






