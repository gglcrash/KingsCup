package com.gglcrash.kingscup.data.managers;

import android.content.SharedPreferences;
import android.net.Uri;

import com.gglcrash.kingscup.utils.ConstantManager;
import com.gglcrash.kingscup.utils.KingsCupApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gglcrash on 20.09.2016.
 */
public class PreferencesManager {
    private SharedPreferences mSharedPreferences;


    public PreferencesManager(){
        this.mSharedPreferences= KingsCupApplication.getSharedPreferences();
    }

    public void saveVibrationValue(boolean vibration){
        SharedPreferences.Editor editor = mSharedPreferences.edit();

        editor.putBoolean(ConstantManager.VIBRATION,vibration);

        editor.apply();
    }

    public boolean loadVibrationValue(){
        return mSharedPreferences.getBoolean(ConstantManager.VIBRATION,true);
    }



    public void saveUserPhoto(Uri uri){
    /*    SharedPreferences.Editor editor = mSharedPreferences.edit();

        editor.putString(ConstantManager.USER_PHOTO_KEY,uri.toString());
        editor.apply();*/
    }

     /*public Uri loadUserPhoto(){
       return Uri.parse(mSharedPreferences.getString(ConstantManager.USER_PHOTO_KEY,
                "android.resource://com.softdesign.devintensive/drawable/user_photo"));
    }*/
}
