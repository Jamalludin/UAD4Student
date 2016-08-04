package com.android.jamalludin.uadapps4student;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by jamal on 01/06/16.
 */
public class LoginActivity extends Activity {

    EditText nim,pass;
    Button masuk;
    ProgressDialog pDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        nim = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);
        masuk = (Button) findViewById(R.id.msubmit);

        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new loginn().execute();
            }
        });

    }
    class loginn extends AsyncTask<Void,Void,String>{

        @Override
        protected String doInBackground(Void... params) {
            int succsess;
            String username = nim.getText().toString();
            String passw = pass.getText().toString();

            JSONParse json = new JSONParse();
            String hasil = json.login(username, passw);

            return hasil;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            pDialog.dismiss();


            try {
                JSONObject obj = new JSONObject(s);
                String st = obj.getString("status");
                String pesan = obj.getString("msg");
                if (st == "true"){
                    String name = obj.getString("nama");
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);

                    Toast.makeText(getApplicationContext(),"Selamat Datang "+name, Toast.LENGTH_LONG).show();

                }else {
                    Toast.makeText(getApplicationContext(), "Gagal Login "+pesan, Toast.LENGTH_SHORT).show();
                }

            }catch (Exception e){
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), e.getMessage()+" ", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pDialog = new ProgressDialog(LoginActivity.this);
            pDialog.setMessage("Masuk Aplikasi...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }
    }
}
