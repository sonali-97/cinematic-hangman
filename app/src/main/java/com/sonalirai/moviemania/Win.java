package com.sonalirai.moviemania;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Win extends AppCompatActivity {

    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        img = (ImageView) findViewById(R.id.imageView);
        if(getIntent().getStringExtra("Status").equals("Win"))
            img.setImageResource(R.drawable.win);
        else
            img.setImageResource(R.drawable.lose);
    }

    public void replay(View view) {
        Intent i = new Intent(Win.this, MainActivity.class);
        startActivity(i);
    }
}
