package com.udacity.gradle.builditbigger;

import org.junit.Test;
import static junit.framework.Assert.assertEquals;


public class GetJokeAsyncTaskTest {

    @Test
    public void asyncTask_ReturnValidJoke() {

        JokeListener listener = new JokeListener() {
            @Override
            public void onRecieveJoke(String joke) {
                assertEquals(joke, "Why Android Programmers wear glasses? Because they can't C#");
            }
        };

        new TestJokeAsyncTask().execute(listener);

    }
}