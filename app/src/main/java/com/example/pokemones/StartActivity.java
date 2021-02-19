package com.example.pokemones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.pokemones.data.UserConfig;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        launchFirstActivity();
    }

    private void launchFirstActivity(){

        UserConfig userConfig = new UserConfig(getApplicationContext());
        Intent intent;

        if (userConfig.userExists()) {
            intent = new Intent(getBaseContext(),  RegistroPokemon.class);
        }else{
            intent = new Intent(getBaseContext(), MainActivity.class);
        }

        startActivity(intent);
        finish();
    }

}