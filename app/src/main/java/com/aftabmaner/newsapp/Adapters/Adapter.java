package com.aftabmaner.newsapp.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.aftabmaner.newsapp.Models.ModelClass;
import com.aftabmaner.newsapp.R;
import com.aftabmaner.newsapp.webView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    public Adapter(Context context, ArrayList<ModelClass> modelClassArrayList) {
        this.context = context;
        this.modelClassArrayList = modelClassArrayList;
    }

    Context context;
    ArrayList<ModelClass> modelClassArrayList;

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, webView.class);
                intent.putExtra("url", modelClassArrayList.get(position).getUrl());
                context.startActivity(intent);
            }
        });

        holder.ntime.setText("Published At:-" + modelClassArrayList.get(position).getPublishedAt());
        holder.nauthor.setText(modelClassArrayList.get(position).getAuthor());
        holder.nheading.setText(modelClassArrayList.get(position).getTitel());
        holder.ncontetent.setText(modelClassArrayList.get(position).getDiscription());
        Glide.with(context).load(modelClassArrayList.get(position).getUrlToimage()).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return modelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        TextView nheading, ncontetent, nauthor, ntime;
        CardView cardView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nheading = itemView.findViewById(R.id.idmainheading);
            ncontetent = itemView.findViewById(R.id.idcontent);
            nauthor = itemView.findViewById(R.id.idAuthor);
            ntime = itemView.findViewById(R.id.idtime);
            cardView = itemView.findViewById(R.id.idcardview);
        }
    }
}
