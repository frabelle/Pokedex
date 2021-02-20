package com.example.pokemones;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.pokemones.adapters.PokeAdapter;
import com.example.pokemones.data.UserConfig;
import com.example.pokemones.models.PokeModel;
import com.example.pokemones.models.UserModel;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RegistroPokemon extends AppCompatActivity implements ItemTapListener{

    private List<PokeModel> mModelList;
    private RecyclerView rvPokemon;
    private PokeAdapter pokeAdapter;
    private ViewGroup rootView;
    private Integer p;
    public String username;

    MaterialButton btnLove;

    String id = "Grid";

    public static final String FULLNAME_KEY = "FULLNAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_pokemon);
        SetUp();
    }

    public void SetUp() {
        SetUpViewLineal();
        rootView = findViewById(R.id.ly_root);

        Intent startIntent = getIntent();
        UserModel userModel = getUserModelFromSources(startIntent.getExtras());
        username = userModel.getFullname();

        getSupportActionBar().setTitle("¡Hola de nuevo, " + username + "!");
    }

    @NonNull
    private UserModel getUserModelFromSources(Bundle extras) {
        UserConfig userConfig = new UserConfig(getApplicationContext());
        final UserModel user = userConfig.getUser();
        if(user != null) {
            return user;
        }
        if(extras == null) {
            throw new InvalidParameterException("Extras");
        }
        return new UserModel(extras.getString(FULLNAME_KEY));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.listamenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (id.contentEquals("Grid")) {
            id = "Lineal";
            item.setIcon(R.drawable.menulist);
            SetUpViewGrid();
        } else {
            id = "Grid";
            item.setIcon(R.drawable.menusquare);
            SetUpViewLineal();
        }

        return true;
    }

    private void SetUpViewLineal() {
        rvPokemon = (RecyclerView)findViewById(R.id.rv_points);
        rvPokemon.setLayoutManager(new LinearLayoutManager(this));
        pokeAdapter = new PokeAdapter(getPokemons(), this);
        rvPokemon.setAdapter(pokeAdapter);
    }

    private void SetUpViewGrid() {
        rvPokemon = (RecyclerView)findViewById(R.id.rv_points);
        rvPokemon.setLayoutManager(new GridLayoutManager(this, 2));
        pokeAdapter = new PokeAdapter(getPokemons(), this);
        rvPokemon.setAdapter(pokeAdapter);
    }

    public List<PokeModel> getPokemons(){
        List<PokeModel> pokemon = new ArrayList<>();
        pokemon.add(new PokeModel("1", "Chikorita", getString(R.string.chikorita),R.drawable.chikorita, R.drawable.ic_baseline_favorite_border_24));
        pokemon.add(new PokeModel("2", "Bulbasaur", getString(R.string.bulbasaur),R.drawable.bulbasaur, R.drawable.ic_baseline_favorite_border_24));
        pokemon.add(new PokeModel("3", "Squirtle", getString(R.string.squirtle),R.drawable.squirtle, R.drawable.ic_baseline_favorite_border_24));
        pokemon.add(new PokeModel("4", "Raichu", getString(R.string.raichu),R.drawable.raichu, R.drawable.ic_baseline_favorite_border_24));
        pokemon.add(new PokeModel("5", "Vulpix", getString(R.string.vulpix),R.drawable.vulpix, R.drawable.ic_baseline_favorite_border_24));
        pokemon.add(new PokeModel("6", "Meowth", getString(R.string.meowth),R.drawable.meowth, R.drawable.ic_baseline_favorite_border_24));
        pokemon.add(new PokeModel("7", "Psyduck", getString(R.string.psyduck),R.drawable.psyduck, R.drawable.ic_baseline_favorite_border_24));
        pokemon.add(new PokeModel("8", "Ponyta", getString(R.string.ponyta),R.drawable.ponyta, R.drawable.ic_baseline_favorite_border_24));
        pokemon.add(new PokeModel("9", "Seel", getString(R.string.seel),R.drawable.seel, R.drawable.ic_baseline_favorite_border_24));
        pokemon.add(new PokeModel("10", "Chansey", getString(R.string.chansey),R.drawable.chansey, R.drawable.ic_baseline_favorite_border_24));

        mModelList = pokemon;

        return pokemon;
    }

    @Override
    public void onItemTap(View view, int position) {
        showFragmentPokemon(position);
    }

    private void showFragmentPokemon(int position) {

        PokeModel data = mModelList.get(position);
        Snackbar.make(rootView,
                "Has seleccionado a " + data.getName(),
                Snackbar.LENGTH_LONG
        ).show();

        PokeFragment DialogFrg = new PokeFragment(data);
        //PokeFragment.newInstance(data);
        DialogFrg.show(getSupportFragmentManager(), "Pokemon");

    }

    public void LoveIt(View view){
        Snackbar.make(rootView,
                "Has marcado como favorito a este pokemon!",
                Snackbar.LENGTH_LONG
        ).show();

        btnLove = findViewById(view.getId());
        btnLove.setIconResource(R.drawable.ic_baseline_favorite_24);
    }

}