package com.example.pokemones.models;

public class UserModel {

    String fullname;

    public UserModel (String fullname){
        this.fullname = fullname;
    }

    public String getFullname(){ return fullname;}

    public void setFullname(String getFullname) {this.fullname = fullname;}
}
