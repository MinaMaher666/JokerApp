package com.example.jokelib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class JokeActivity extends AppCompatActivity {
    TextView jokeTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        jokeTV = (TextView) findViewById(R.id.joke_tv);

        String sentJoke = getIntent().getStringExtra("joke");

        jokeTV.setText(sentJoke);
    }
}
