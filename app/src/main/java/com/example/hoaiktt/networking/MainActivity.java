package com.example.hoaiktt.networking;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    private String mHost = "ota.iambic.com";
    private Button mBtnConect;
    private TextView mTvResultDislay;
    private int PORT = 17;
    private static final int MAX = 100000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnConect = (Button) findViewById(R.id.btnConnectQOTD);
        mTvResultDislay = (TextView) findViewById(R.id.tvResultDislay);
        mBtnConect.setOnClickListener(new ShowPithyQuotes());

    }

    private class ShowPithyQuotes implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            new ShowPithyQuotesTask().execute();
        }
    }

    public class ShowPithyQuotesTask extends AsyncTask<Void,Void,String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... voids) {
            String rs = " ";
            try {
                Socket socket = new Socket(mHost,PORT);
                BufferedReader in = SocketUntils.getReader(socket);
                in.readLine();
                rs = in.readLine();
                socket.close();
                in.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return rs;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            mTvResultDislay.setText(s);
        }


    }
}






