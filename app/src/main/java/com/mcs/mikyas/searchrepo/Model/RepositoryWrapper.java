package com.mcs.mikyas.searchrepo.Model;

import android.content.ClipData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RepositoryWrapper {
    @SerializedName("items")
    @Expose
    private List<Item> items = null;

    @Override
    public String toString() {
        return "RepositoryWrapper{" +
                "items=" + items +
                '}';
    }

    public RepositoryWrapper(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
