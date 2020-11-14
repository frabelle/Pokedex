package com.example.pokemones.adapters.viewholders;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokemones.ItemTapListener;
import com.example.pokemones.R;
import com.google.android.material.button.MaterialButton;

public class PokeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

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
