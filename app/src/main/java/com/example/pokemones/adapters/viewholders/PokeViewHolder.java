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

    public static final int unlove = R.drawable.ic_baseline_favorite_border_24;
    public static final int loveit = R.drawable.ic_baseline_favorite_24;

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

        love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //data = item.get(getAdapterPosition());

                int flag = unlove;

                if(flag == unlove){
                    love.setIconResource(loveit);
                }else{
                    love.setIconResource(unlove);
                }

            }
        });
    }


    @Override
    public void onClick(View view) {
        if(mTapListener == null) return;
        mTapListener.onItemTap(view, getAdapterPosition());
    }

}
