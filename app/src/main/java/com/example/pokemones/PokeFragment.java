package com.example.pokemones;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pokemones.models.PokeModel;
import com.google.android.material.button.MaterialButton;

import java.util.List;

public class PokeFragment extends DialogFragment implements ItemTapListener {

    MaterialButton exit;
    private TextView Nombre, Descripcion;
    private ImageView Pokemon;
    PokeModel model;

    public PokeFragment(PokeModel data) {
        model = data;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return crearDialogo();
    }

    private AlertDialog crearDialogo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v=inflater.inflate(R.layout.fragment_poke, null);
        builder.setView(v);

        exit = v.findViewById(R.id.btnExit);
        Nombre = v.findViewById(R.id.namePokeFrg);
        Descripcion = v.findViewById(R.id.dscpPokeFrg);
        Pokemon = v.findViewById(R.id.imgFrg);

        Nombre.setText(model.getName());
        Pokemon.setImageResource(model.getImg());
        Descripcion.setText(model.getDescription());

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_poke, container, false);
    }

    @Override
    public void onItemTap(View v, int position) {


    }
}