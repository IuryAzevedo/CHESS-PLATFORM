package com.example.chess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {
    DatabaseReference firebaseDb = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void onClickLogin(View v){
//        firebaseDb.child("users").child("2").setValue("usuario2");
        //        testando adicionar um novo usuario ("users") / ("2")

        Intent it = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(it);

    }
}