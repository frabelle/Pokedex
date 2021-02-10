package com.example.pokemones.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.pokemones.BuildConfig;
import com.example.pokemones.models.UserModel;

import java.util.Locale;

public class UserConfig {
    private static final String USER_PREF_NAME = "user_prefs";
    private static final String PREF_FIRST_TIME = "is_first_time";
    private static final String PREF_USER_NAME = "user_name";


    private final SharedPreferences nPrefs;

    public UserConfig(@NonNull Context context) {

        nPrefs = context.getSharedPreferences(getPrefsName(), Context.MODE_PRIVATE);

    }

    public boolean isFirstTime() {
        return nPrefs.getBoolean(PREF_FIRST_TIME, true);
    }


    public boolean setIsFirstTime(boolean value) {
        SharedPreferences.Editor editor = nPrefs.edit();
        editor.putBoolean(PREF_FIRST_TIME, value);
        editor.apply();

        return true;

    }


    public boolean userExists() {
        return nPrefs.contains(PREF_USER_NAME);
    }

    @Nullable
    public UserModel getUser() {
        final String name = nPrefs.getString(PREF_USER_NAME, null);

        if (TextUtils.isEmpty(name)) {
            return null;
        }

        return new UserModel(name);
    }


    public boolean setUser(@Nullable UserModel user) {
        if (user == null) return false;
        if (TextUtils.isEmpty(user.getFullname()))
            return false;

        SharedPreferences.Editor prefsEditor = nPrefs.edit();
        prefsEditor.putString(PREF_USER_NAME, user.getFullname());
        prefsEditor.apply();
        return true;
    }



    private String getPrefsName(){

        return String.format(
                Locale.getDefault(),
                "%s_%s" ,
                BuildConfig.APPLICATION_ID, USER_PREF_NAME

        );

    }
}
