package com.sonalirai.moviemania;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class TrieNode {
    HashMap<String, TrieNode> children;
    boolean isMovie;
    private Random random;

    public TrieNode() {
        children = new HashMap<>();
        isMovie = false;
        random = new Random();
    }

    public void add(String s) {
        TrieNode currentNode = this;
        for(char c: s.toCharArray()){
            if(!currentNode.children.containsKey(String.valueOf(c))){
                currentNode.children.put(String.valueOf(c), new TrieNode());
            }

            currentNode = currentNode.children.get(String.valueOf(c));
        }
        currentNode.isMovie=true;
    }

    public boolean isMovie(String s) {
        TrieNode currentNode = this;
        for(char c: s.toCharArray()){
            if(!currentNode.children.containsKey(String.valueOf(c))){
                return false;
            }
            else{
                currentNode=currentNode.children.get(String.valueOf(c));
            }
        }
        return currentNode.isMovie;
    }

    public String getMovie()
    {
        String movie="";
        TrieNode currentNode = this;
        ArrayList<String> arrayList = new ArrayList<>();

        do {
            Log.d("TAG", "getMovie: ");
            for(char i ='a'; i<='z'; i++)
            {
                if(currentNode.children.containsKey(String.valueOf(i)))
                {
                    arrayList.add(String.valueOf(i));
                }
            }

            for(char i='A'; i<='Z';i++){
                if(currentNode.children.containsKey(String.valueOf(i)))
                {
                    arrayList.add(String.valueOf(i));
                }
            }

            for(char i='0'; i<='9';i++){
                if(currentNode.children.containsKey(String.valueOf(i)))
                    arrayList.add(String.valueOf(i));
            }
            char ch=' ';
            if(currentNode.children.containsKey(String.valueOf(ch)))
            {
                arrayList.add(String.valueOf(ch));
            }
            int n=random.nextInt(arrayList.size());
            movie+=arrayList.get(n);
            currentNode=currentNode.children.get(arrayList.get(n));
            arrayList.clear();
        }
        while(!currentNode.isMovie);
        Log.d("TAG", "getMovie: "+movie);
        return movie;
    }

}
