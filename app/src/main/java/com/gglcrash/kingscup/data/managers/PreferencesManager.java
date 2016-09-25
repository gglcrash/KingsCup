package com.gglcrash.kingscup.data.managers;

import android.content.SharedPreferences;
import android.net.Uri;

import com.gglcrash.kingscup.utils.Card;
import com.gglcrash.kingscup.utils.ConstantManager;
import com.gglcrash.kingscup.utils.KingsCupApplication;
import com.google.gson.Gson;

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

    public void savePlayedCardsValue(int count){
        SharedPreferences.Editor editor = mSharedPreferences.edit();

        editor.putInt(ConstantManager.PLAYED_CARDS_COUNT,count);

        editor.apply();
    }

    public int loadPlayedCardsCount(){
        return mSharedPreferences.getInt(ConstantManager.PLAYED_CARDS_COUNT,ConstantManager.ZERO);
    }

    public void saveKingsCount(int count){
        SharedPreferences.Editor editor = mSharedPreferences.edit();

        editor.putInt(ConstantManager.KINGS_COUNT,count);

        editor.apply();
    }

    public int loadKingsCount(){
        return mSharedPreferences.getInt(ConstantManager.KINGS_COUNT,ConstantManager.ZERO);
    }


   private void saveCardsInDeckCount(int count){
        SharedPreferences.Editor editor = mSharedPreferences.edit();

        editor.putInt(ConstantManager.CARDS_IN_DECK_SP,count);

        editor.apply();
    }

    public int loadCardsInDeckCount(){
        return mSharedPreferences.getInt(ConstantManager.CARDS_IN_DECK_SP,ConstantManager.ZERO);
    }


    public void saveDeck(ArrayList<Card> deck){
        saveCardsInDeckCount(deck.size());
        SharedPreferences.Editor editor = mSharedPreferences.edit();

        for(int i = 0;i<deck.size();i++) {
            String cardString = new Gson().toJson(deck.get(i));
            editor.putString(ConstantManager.SAVING_CARDS_SP + i, cardString);
        }
        editor.apply();
    }

    public ArrayList<Card> loadDeck(){
        int size = loadCardsInDeckCount();
        ArrayList<Card> tempList = new ArrayList<>();
        for(int i = 0;i<size;i++) {
            String cardStr = mSharedPreferences.getString(ConstantManager.SAVING_CARDS_SP + i, null);
            Card card = new Gson().fromJson(cardStr, Card.class);
            tempList.add(card);

        }
        if(tempList.size()==0){
            return null;
        }
        else {
            return tempList;
        }
    }


    public void saveCard(Card card){
        SharedPreferences.Editor editor = mSharedPreferences.edit();

            String cardString = new Gson().toJson(card);
            editor.putString(ConstantManager.SAVING_CARDS_SP, cardString);
        editor.apply();
    }

    public Card loadSavedCard(){
            String cardStr = mSharedPreferences.getString(ConstantManager.SAVING_CARDS_SP, null);
            Card card = new Gson().fromJson(cardStr, Card.class);
        return card;


    }

}
