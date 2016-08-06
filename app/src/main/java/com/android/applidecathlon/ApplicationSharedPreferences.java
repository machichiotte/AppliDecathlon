package com.android.applidecathlon;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.applidecathlon.model.Stores;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Elias on 05/08/2016.
 */
public class ApplicationSharedPreferences {

    // Private fields
    // ---------------------------------------------------------------------------------------------
    private static final String LOG_TAG = ApplicationSharedPreferences.class.getSimpleName();
    private static final String PREFS_NAME = "UEFAFansPreferences";
    private static final String STORED_STORES = "storedStores";
    private static ApplicationSharedPreferences instance;
    private static SharedPreferences applicationSharedPreferences;
    private static SharedPreferences.Editor editor;

    // Constructor
    // ---------------------------------------------------------------------------------------------
    private ApplicationSharedPreferences(Context context) {
        applicationSharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = applicationSharedPreferences.edit();
    }

    // Singleton
    // ---------------------------------------------------------------------------------------------
    public static ApplicationSharedPreferences getInstance(Context context) {
        if (instance == null) {
            instance = new ApplicationSharedPreferences(context);
        }
        return instance;
    }

    // Public methods
    // ---------------------------------------------------------------------------------------------
    public Stores getStoredStores() {
        Type listType = new TypeToken<ArrayList<Stores>>() {
        }.getType();
        return new Gson().fromJson(applicationSharedPreferences.getString(STORED_STORES, null), listType);
    }

}