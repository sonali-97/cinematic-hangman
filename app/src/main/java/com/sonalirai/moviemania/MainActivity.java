package com.sonalirai.moviemania;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnH, btnB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void openEasyHardBollywood(View view) {
        Intent i2 = new Intent(MainActivity.this, Easy_Hard.class);
        i2.putExtra("Industry", "Bollywood");
        startActivity(i2);
    }

    public void openEasyHardHollywood(View view) {
        Intent i1 = new Intent(MainActivity.this, Easy_Hard.class);
        i1.putExtra("Industry", "Hollywood");
        startActivity(i1);
    }
}
