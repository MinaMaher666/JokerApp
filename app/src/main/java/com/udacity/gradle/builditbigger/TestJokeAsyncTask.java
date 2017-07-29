package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import android.util.Log;

import com.example.mina.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by mina on 29/07/17.
 */

public class TestJokeAsyncTask extends AsyncTask<JokeListener, Void, String> {
    public MyApi myApiService = null;

    private JokeListener mListener;


    @Override
    protected String doInBackground(JokeListener... params) {
        if (myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory()
                    , null)
                    .setRootUrl(MainActivity.GENYMOTION_ROOTURL)
                    .setApplicationName("Build It Bigger")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });

            myApiService = builder.build();
        }

        mListener = params[0];

        try {
            return  myApiService.testJoke().execute().getData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        mListener.onRecieveJoke(s);
    }
}
