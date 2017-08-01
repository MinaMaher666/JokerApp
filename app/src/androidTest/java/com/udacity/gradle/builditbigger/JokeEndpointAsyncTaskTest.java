package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import com.example.JokeProvider;

import java.util.concurrent.ExecutionException;

/**
 * Created by mina on 01/08/17.
 */

public class JokeEndpointAsyncTaskTest extends AndroidTestCase {

    public void getValidJokesFromEndpointAsyncTask() {
        EndpointAsyncTask testTask = new EndpointAsyncTask();
        testTask.execute();

        String joke = "";
        try {
            joke = testTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        String[] jokes = JokeProvider.getJokes();
        boolean flag = false;
        for (int i=0 ; i< jokes.length ; i++) {
            if(joke.equals(jokes[i])) {
                flag = true;
                break;
            }
        }

        assertEquals(flag, true);

    }
}
