package com.winhill.winhill.Logining;

/**
 * Created by apple on 03.08.15.
 */
import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.os.AsyncTask;


public class AsyncTaskRunner extends  AsyncTask<String,String,String>{

    private String resp;
    @Override
    protected String doInBackground(String... params) {
        int count = params.length;
        if(count==2){
            ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
            postParameters.add(new BasicNameValuePair("username",params[0]));
            postParameters.add(new BasicNameValuePair("password",params[1]));
            String response = null;
            try {
                response = LogIn.executeHttpPost("http://192.168.1.153:8080/", postParameters);
                String res = response.toString();
                resp = res.replaceAll("\\s+", "");
            } catch (Exception e) {
                e.printStackTrace();
                resp = e.getMessage();
            }
        }else{
            resp="Invalid number of arguments-"+count;
        }
        return resp;
    }
}