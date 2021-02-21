package com.example.pokemones.adapters.viewholders;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokemones.ItemTapListener;
import com.example.pokemones.R;
import com.example.pokemones.models.PokeModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class PokeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    List<PokeModel> item;
    PokeModel data;
    public TextView name, descp;
    public ImageView img;
    public MaterialButton love;

    @Nullable
    private final ItemTapListener mTapListener;

    public PokeViewHolder(@NonNull View itemView, @Nullable ItemTapListener tapListener) {
        super(itemView);

        mTapListener = tapListener;
        itemView.setOnClickListener(this);

        name = itemView.findViewById(R.id.namePoke);
        img = itemView.findViewById(R.id.iv_pokemon);
        love = itemView.findViewById(R.id.btnLove);
    }


    @Override
    public void onClick(View view) {
        if(mTapListener == null) return;
        mTapListener.onItemTap(view, getAdapterPosition());
    }

}
