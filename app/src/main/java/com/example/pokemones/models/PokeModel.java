package com.example.pokemones.models;

import android.text.method.HideReturnsTransformationMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PokeModel {

    private String id;
    private String name;
    private String description;
    private int img;
    private int fav;

    public PokeModel(String id, String name, String description, int img, int fav) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.img = img;
        this.fav = fav;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFav() {
        return fav;
    }

    public void setFav(int fav) {
        this.fav = fav;
    }



}
