package com.android.applidecathlon.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Elias on 05/08/2016.
 */
public class Stores {

    @SerializedName("data")
    private Data data;

    /**
     * @return The data
     */
    public Data getData() {
        return data;
    }

    /**
     * @param data The data
     */
    public void setData(Data data) {
        this.data = data;
    }

}
