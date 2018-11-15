package com.mcs.mikyas.searchrepo.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Owner {
    @SerializedName("avatar_url")
    @Expose
    private String avatarUrl;

    @Override
    public String toString() {
        return "Owner{" +
                "avatarUrl='" + avatarUrl + '\'' +
                '}';
    }

    public Owner(String avatarUrl) {

        this.avatarUrl = avatarUrl;
    }

    public String getAvatarUrl() {

        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
