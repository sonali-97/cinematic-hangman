package com.sonalirai.moviemania;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Sonali Rai on 6/4/2017.
 */

public class Dictionary {
    private TrieNode root;
    public static final int MIN_WORD_LENGTH = 3;

    public Dictionary(InputStream wordListStream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(wordListStream));
        root = new TrieNode();
        String line = null;
        while((line = in.readLine()) != null) {
            String word = line.trim();
            if (word.length() >= MIN_WORD_LENGTH)
                root.add(word);
        }
    }

    public boolean isMovie(String movie){
        return root.isMovie(movie);
    }

    public String getMovie(){
        return root.getMovie();
    }
}
