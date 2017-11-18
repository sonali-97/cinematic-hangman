package com.sonalirai.moviemania;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Easy_Hard extends AppCompatActivity {

    String ind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy__hard);

        ind = getIntent().getStringExtra("Industry");
    }

    public void openEasy(View view) {
        Intent i1 = new Intent(Easy_Hard.this, Movies.class);
        if(ind.equals("Bollywood")){
            i1.putExtra("Industry", "Bollywood");
            i1.putExtra("level", "easy");
        }
        else{
            i1.putExtra("Industry", "Hollywood");
            i1.putExtra("level", "easy");
        }
        startActivity(i1);
    }

    public void openHard(View view) {
        Intent i2 = new Intent(Easy_Hard.this, Movies.class);
        if(ind.equals("Bollywood")){
            i2.putExtra("Industry", "Bollywood");
            i2.putExtra("level", "hard");
        }
        else{
            i2.putExtra("Industry", "Hollywood");
            i2.putExtra("level", "hard");
        }
        startActivity(i2);
    }
}
