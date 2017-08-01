package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.example.jokelib.JokeActivity;


public class MainActivity extends AppCompatActivity {
    public static final String JOKE_KEY = "joke";
    private ProgressBar pb;

    public static final String GENYMOTION_ROOTURL   = "http://10.0.3.2:8080/_ah/api/";
    public static final String EMULATOR_ROOTURL     = "http://10.0.2.2:8080/_ah/api/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb = (ProgressBar) findViewById(R.id.progress_bar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        final Context context = MainActivity.this;

        EndpointAsyncTask jokeFetcherTask = new EndpointAsyncTask() {
            @Override
            protected void onPreExecute() {
                pb.setVisibility(View.VISIBLE);
            }

            @Override
            protected void onPostExecute(String s) {
                Class jokeActivityClass = JokeActivity.class;
                Intent jokeTellerIntent = new Intent(context, jokeActivityClass);
                jokeTellerIntent.putExtra(JOKE_KEY, s);
                pb.setVisibility(View.GONE);
                startActivity(jokeTellerIntent);
            }
        };

        jokeFetcherTask.execute();
    }
}
