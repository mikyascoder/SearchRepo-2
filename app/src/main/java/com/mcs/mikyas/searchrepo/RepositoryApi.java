package com.mcs.mikyas.searchrepo;

import com.mcs.mikyas.searchrepo.Model.RepositoryWrapper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RepositoryApi {
    public static final String BASE_URL="https://api.github.com/";




    @GET("search/repositories")
    Call<RepositoryWrapper> getrepository(@Query("q") String title);





}
