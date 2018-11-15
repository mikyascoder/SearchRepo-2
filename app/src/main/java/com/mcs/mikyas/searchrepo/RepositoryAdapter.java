package com.mcs.mikyas.searchrepo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mcs.mikyas.searchrepo.Model.Repository;

import java.util.List;

public class RepositoryAdapter extends ArrayAdapter<Repository> {

    List<Repository> mrepository;
    LayoutInflater mInflator;
    Context mcontext;
    public RepositoryAdapter(@NonNull Context context,  @NonNull List<Repository> objects) {
        super(context, R.layout.repo_list_item, objects);

        mrepository=objects;
        mInflator=LayoutInflater.from(context);
        mcontext=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView=mInflator.inflate(R.layout.repo_list_item,parent,false);
        }
        TextView reponame=(TextView)convertView.findViewById(R.id.repo_name);
        ImageView avatar=(ImageView) convertView.findViewById(R.id.repo_image);
        TextView rating= convertView.findViewById(R.id.rating);


        Repository repos=mrepository.get(position);
        Glide.with(mcontext).asBitmap().load(repos.getAvatarUrl()).into(avatar);

        reponame.setText(repos.getRepositoryName());

        Double score=repos.getScore();
        String rate;
        if(score<80)
            rate="*";
        else if(score<100)
            rate="**";
        else if(score<115)
            rate="***";
        else if(score<160)
            rate="****";
        else
            rate="*****";
        rating.setText(rate);


        return convertView;


    }
}
