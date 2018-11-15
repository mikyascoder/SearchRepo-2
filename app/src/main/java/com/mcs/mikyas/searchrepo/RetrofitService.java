package com.mcs.mikyas.searchrepo;

import com.mcs.mikyas.searchrepo.RepositoryApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private static Retrofit retrofit = null;

    static Retrofit getOMDBClient() {

            /*HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();*/


        retrofit = new Retrofit.Builder()
                .baseUrl(RepositoryApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                //.client(client)
                .build();



        return retrofit;
    }

}
