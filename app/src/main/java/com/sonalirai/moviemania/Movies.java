package com.sonalirai.moviemania;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class Movies extends AppCompatActivity {

    TextView industry, movieName;
    Button newMovie, show;
    Dictionary movieDictionary;
    InputStream movieStream;
    EditText singleChar;
    String usedMovie;
    public static final int MAX_CHANCES ="HOLLYWOOD".length();
    int chances=0;
    String temp;
    String characterSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        industry = (TextView) findViewById(R.id.textView4);
        newMovie = (Button) findViewById(R.id.button3);
        show= (Button) findViewById(R.id.button4);
        movieName= (TextView) findViewById(R.id.movie);
        singleChar = (EditText) findViewById(R.id.input);

        characterSet=new String("aeiou 1234567890");

        if(getIntent().getStringExtra("Industry").equals("Bollywood")) {
            if(getIntent().getStringExtra("level").equals("easy")){
                try {
                    movieStream = getAssets().open("bollywoodEasy.txt");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else{
                try {
                    movieStream= getAssets().open("bollywoodHard.txt");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            industry.setText("BOLLYWOOD");

        }
        else{
            if(getIntent().getStringExtra("level").equals("easy")){
                try {
                    movieStream = getAssets().open("hollywoodEasy.txt");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else{
                try {
                    movieStream= getAssets().open("hollywoodHard.txt");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            industry.setText("HOLLYWOOD");
        }

        try {
            movieDictionary = new Dictionary(movieStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        usedMovie=display();
        usedMovie=usedMovie.toLowerCase();

        singleChar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String newString = s.toString();
               // singleChar.setText("");
                if(!newString.equals("")) {
                    char c = newString.charAt(0);
                    match(c, usedMovie);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public String display(){
        characterSet=new String("aeiou 1234567890");
        Log.d("TAG", "display: in display");
       String movie = movieDictionary.getMovie();
        movie=movie.toLowerCase();
        String temp = "";
        for(char c : movie.toCharArray()){
            if(characterSet.contains(String.valueOf(c))){
                temp+=c;
            }
            else{
                temp+="-";
            }
        }
        movieName.setText(temp);
        return movie;
    }

    public void match(char i, String usedMovie){
        boolean flag=false;
        temp = "";
        if(chances>=0 && chances<=MAX_CHANCES) {
            for (char c : usedMovie.toCharArray()) {
                if(i==c)
                    characterSet+=i;
                if (characterSet.contains(String.valueOf(c))) {
                    if(i==c){
                        flag=true;
                    }
                    temp += c;

                } else {
                    temp += "-";
                }
            }
            movieName.setText(temp);
            if(temp.equals(usedMovie)){
                Intent newIntent = new Intent(Movies.this, Win.class);
                newIntent.putExtra("Status", "Win");
                startActivity(newIntent);
            }
        }
        else{
            chances=0;
            //display();/
            show(null);
            Intent nextActivity = new Intent(Movies.this, Win.class);
            nextActivity.putExtra("Status", "Lose");
            nextActivity.putExtra("Movie", usedMovie);
            startActivity(nextActivity);
        }
        if(!flag){
            chances++;
            Toast.makeText(this,""+(MAX_CHANCES-chances+2)+" chances left", Toast.LENGTH_LONG).show();

        }

       // singleChar.setText("");
    }

    public void newPicture(View view) {
        chances=0;
        characterSet=new String("aeiou 1234567890");
        usedMovie=display();
        usedMovie=usedMovie.toLowerCase();
    }

    public void show(View view) {
        movieName.setText(usedMovie);
    }
}
