package com.example.pokemones;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.pokemones.data.UserConfig;
import com.example.pokemones.models.UserModel;
import com.google.android.material.button.MaterialButton;

public class FirstTimeFragment extends DialogFragment {

    MaterialButton Save;
    EditText Username;
    UserModel userModel;

    public FirstTimeFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return crearDialogo();
    }

    private AlertDialog crearDialogo() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v=inflater.inflate(R.layout.fragment_first_time, null);
        builder.setView(v);

        Save = v.findViewById(R.id.saveBtn);
        Username = v.findViewById(R.id.editText);

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUp();
            }
        });

        return builder.create();
    }

    private void SignUp() {
        userModel = new UserModel(Username.getText().toString());
        saveUser(userModel);
        navigateToMain(userModel);
    }

    @SuppressLint("SetTextI18n")
    private void loadDefaultDataIfDebug() {
        Username.setText("");
    }

    private void saveUser(UserModel user) {
        UserConfig userConfig = new UserConfig(this.getActivity().getApplicationContext());
        userConfig.setUser(user);
    }

    private void navigateToMain(UserModel user) {
        Intent intent = new Intent(this.getActivity(), RegistroPokemon.class);

        //la proxima activity ahora será la primera en el back stack
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(RegistroPokemon.FULLNAME_KEY, user.getFullname());
        startActivity(intent);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first_time, container, false);
    }
}