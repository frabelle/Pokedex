package com.example.pokemones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Start();

    }

    private void Start(){
        hideBar();
        ChangeActivity();
    }
    
    private void ChangeActivity(){

        Button BtnStart = findViewById(R.id.Btn1);
        BtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent();
            }
        });
    }

    private void Intent() {

        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
    }

    private void showMsg(){
        Toast.makeText(
                this,
                "Bienvenido a Pokemon Trainer's Club!",
                Toast.LENGTH_LONG
        ).show();
    }

    private void hideBar() {
        if(getSupportActionBar() == null) return;
        getSupportActionBar().hide();
    }

}