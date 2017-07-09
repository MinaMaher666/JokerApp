package com.example;

import java.util.Random;

public class JokeProvider {
    private static String[] mJokes = {
            "Why Android Programmers wear glasses? Because they can't C#",
            "Why did a programmer quit his job? Because he didn't get arrays",
            "What is programmer's favorite hangout place? Foo Bar"};


    public static String[] getJokes() {
        Random random = new Random();
        return mJokes;
    }

    public static String getJoke() {
        Random random = new Random();
        return mJokes[random.nextInt(mJokes.length)];
    }
}
