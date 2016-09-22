package com.gglcrash.kingscup.data.managers;

/**
 * Created by gglcrash on 20.09.2016.
 */
public class DataManager {
    private static DataManager INSTANCE = null;
    private PreferencesManager mPreferencesManager;

    public DataManager() {
        this.mPreferencesManager = new PreferencesManager();
    }


    public static DataManager getInstance(){
        if(INSTANCE==null){
            INSTANCE=new DataManager();
        }
        return INSTANCE;
    }

    public PreferencesManager getPreferencesManager() {

        return mPreferencesManager;
    }
}

