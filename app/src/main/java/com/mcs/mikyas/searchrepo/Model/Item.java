package com.mcs.mikyas.searchrepo.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {


    @SerializedName("name")
    @Expose
    private String reponame;

    @SerializedName("score")
    @Expose
    private Double score;

    @SerializedName("owner")
    @Expose
    private Owner owner;

    @Override
    public String toString() {
        return "Item{" +
                "reponame='" + reponame + '\'' +
                ", score=" + score +
                ", owner=" + owner +
                '}';
    }

    public Item(String reponame, Double score, Owner owner) {
        this.reponame = reponame;
        this.score = score;
        this.owner = owner;
    }

    public Owner getOwner() {

        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getReponame() {
        return reponame;
    }

    public void setReponame(String reponame) {
        this.reponame = reponame;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }



}
