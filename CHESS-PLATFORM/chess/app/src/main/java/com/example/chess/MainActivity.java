package com.example.chess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void play(View v){
        Intent it = new Intent(MainActivity.this, ChessBoardActivity.class);
        startActivity(it);
    }
    public void settings(View v){
        Intent it = new Intent(MainActivity.this, SettingsActivity2.class);
        startActivity(it);
    }
}