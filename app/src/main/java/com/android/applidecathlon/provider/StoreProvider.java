package com.android.applidecathlon.provider;

import android.content.Context;
import android.util.Log;

import com.android.applidecathlon.ApplicationSharedPreferences;
import com.android.applidecathlon.model.Stores;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.apache.commons.io.IOUtils;

import java.io.IOException;

/**
 * Created by Elias on 05/08/2016.
 */
public class StoreProvider {

    // Private fields
    // ---------------------------------------------------------------------------------------------
    private static final String LOG_TAG = StoreProvider.class.getSimpleName();

    // Implementation
    // --------------------------------------------------------------------------------------------
    public static Stores getStores(Context context) {
        // Get previously-fetched data from preferences
        Stores result = ApplicationSharedPreferences.getInstance(context.getApplicationContext()).getStoredStores();

        if (result == null) {
            result = loadStoresJson(context);
        }
        return result;
    }

    private static Stores loadStoresJson(Context context) {
        Stores result = new Stores();

        try {
            result = new Gson().fromJson(IOUtils.toString(context.getAssets().open("stores.json")), new TypeToken<Stores>() {
            }.getType());
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error when reading City JSON", e);
        }

        return result;
    }

}
