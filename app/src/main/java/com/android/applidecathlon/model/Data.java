package com.android.applidecathlon.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elias on 05/08/2016.
 */
public class Data {

    @SerializedName("stores")
    private List<Store> stores = new ArrayList<Store>();

    /**
     * @return The stores
     */
    public List<Store> getStores() {
        return stores;
    }

    /**
     * @param stores The stores
     */
    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

}
