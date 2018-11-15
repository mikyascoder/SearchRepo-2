package com.mcs.mikyas.searchrepo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.mcs.mikyas.searchrepo.Model.Item;
import com.mcs.mikyas.searchrepo.Model.RepositoryWrapper;
import com.mcs.mikyas.searchrepo.Model.Repository;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<Repository> dataset=new ArrayList<>();//= MockFactory.getmockedrepositories();
    RepositoryWrapper tempo;
    Repository repository;
    List<Item>items;
    String query="game of life";
    Button mbutton;
    EditText medit_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbutton=(Button) findViewById(R.id.searchbutton);
        medit_text=(EditText) findViewById(R.id.searchbox);

        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                query=medit_text.getText().toString();
                searchrepository(query);
            }
        });





    }

    private void searchrepository(String query) {
        RepositoryApi api= RetrofitService.getOMDBClient().create(RepositoryApi.class);
        Call<RepositoryWrapper> call=api.getrepository( query);

        call.enqueue(new Callback<RepositoryWrapper>() {
            @Override
            public void onResponse(Call<RepositoryWrapper> call, Response<RepositoryWrapper> response) {
                Log.d("RETROFIT", response.body().toString());
                dataset.clear();
                tempo=response.body();
                items=tempo.getItems();

                int n=items.size();
                for(int i=0;i<n;i++) {
                    repository = new Repository(items.get(i).getReponame(), items.get(i).getOwner().getAvatarUrl(), items.get(i).getScore());
                    dataset.add(repository);
                }
                InitAdapter(dataset);
            }

            @Override
            public void onFailure(Call<RepositoryWrapper> call, Throwable t) {
                call.cancel();
                Log.e("RETROFIT_ERROR","TODO handle error");
            }
        });
    }

    private void InitAdapter(List<Repository> dataset) {
        RepositoryAdapter adapter= new RepositoryAdapter(this,dataset);
        ListView listView=(ListView) findViewById(android.R.id.list);
        listView.setAdapter(adapter);
    }
}
