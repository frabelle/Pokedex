package com.example.pokemones.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokemones.ItemTapListener;
import com.example.pokemones.R;
import com.example.pokemones.adapters.viewholders.PokeViewHolder;
import com.example.pokemones.models.PokeModel;
import com.google.android.material.button.MaterialButton;

import java.util.List;

public class PokeAdapter extends RecyclerView.Adapter<PokeViewHolder> {

    List<PokeModel> mModelList;
    @Nullable
    private final ItemTapListener mTapListener;

    public PokeAdapter(List<PokeModel> mModelList, @Nullable ItemTapListener tapListener) {
        this.mModelList = mModelList;
        mTapListener = tapListener;
    }

    @NonNull
    @Override
    public PokeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView= inflater.inflate(R.layout.item_list, parent, false);
        PokeViewHolder vh = new PokeViewHolder(itemView, mTapListener);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull PokeViewHolder holder, int position) {
        PokeModel currentModel = mModelList.get(position);
        holder.name.setText(currentModel.getName());
        holder.img.setImageResource(currentModel.getImg());

    }

    @Override
    public int getItemCount() {
        return mModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView name;
        public ImageView img;
        public MaterialButton love;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.namePoke);
            img = itemView.findViewById(R.id.iv_pokemon);
            love = itemView.findViewById(R.id.btnLove);

            love.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    PokeModel PokeItem = mModelList.get(position);

                    if(PokeItem.getFav() == R.drawable.ic_baseline_favorite_border_24){
                        PokeItem.setFav(R.drawable.ic_baseline_favorite_24);
                        Log.d("1", "FAVS");
                        love.setIconResource(R.drawable.ic_baseline_favorite_24);
                    } else {
                        love.setIconResource(R.drawable.ic_baseline_favorite_24);
                    }

                }
            });

        }
    }
}
