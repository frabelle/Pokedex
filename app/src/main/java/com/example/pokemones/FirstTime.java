package com.example.pokemones;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pokemones.data.UserConfig;
import com.example.pokemones.models.UserModel;
import com.google.android.material.button.MaterialButton;

public class FirstTime extends AppCompatActivity {

    UserModel userModel;
    EditText EtNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_time);

        hideBar();
    }

    private void SetUp(){

        Button LogIn;
        LogIn = findViewById(R.id.btnGo);
        EtNombre = findViewById(R.id.name);

        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUp();
            }
        });

        loadDefaultDataIfDebug();

    }

    private void SignUp() {
        userModel = new UserModel(EtNombre.getText().toString());
        saveUser(userModel);
        navigateToMain(userModel);
    }

    @SuppressLint("SetTextI18n")
    private void loadDefaultDataIfDebug() {
        EtNombre.setText("");
    }

    private void saveUser(UserModel user) {
        UserConfig userConfig = new UserConfig(getApplicationContext());
        userConfig.setUser(user);
    }

    private void navigateToMain(UserModel user) {
        Intent intent = new Intent(this, RegistroPokemon.class);

        //la proxima activity ahora será la primera en el back stack
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(RegistroPokemon.FULLNAME_KEY, user.getFullname());
        startActivity(intent);
    }

    private void hideBar() {
        if(getSupportActionBar() == null) return;
        getSupportActionBar().hide();

        SetUp();
    }
}