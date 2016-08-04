package com.android.jamalludin.uadapps4student;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by jamal on 06/06/16.
 */
public class JSONParse {

    public String login(String nim, String pass) {
        String url = "http://perwalian.fti.uad.ac.id/mowo/masukapps";

        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            String param = "username=" + nim + "&password=" + pass;
            DataOutputStream dt = new DataOutputStream(connection.getOutputStream());
            dt.writeBytes(param);
            dt.flush();
            dt.close();
            BufferedReader buf = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuffer hasil = new StringBuffer();
            while ((line = buf.readLine()) != null) {
                hasil.append(line);
            }
            buf.close();
            return hasil.toString();
        } catch (Exception e){

            return e.getMessage();

        }
    }
}


