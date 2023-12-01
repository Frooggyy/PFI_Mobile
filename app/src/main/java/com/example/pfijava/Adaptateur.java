package com.example.pfijava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptateur extends RecyclerView.Adapter<Adaptateur.MyViewHolder> {

    Context context;
    ArrayList<Article> articles = new ArrayList<Article>();

    public Adaptateur(Context context, ArrayList<Article> articles) {
        this.context = context;
        this.articles = articles;
    }

    @NonNull
    @Override
    public Adaptateur.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflator = LayoutInflater.from(context);
        View itemView = inflator.inflate(R.layout.ligne_article, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptateur.MyViewHolder holder, int position) {
        String nomArticle = articles.get(position).getNom();
        double prixArticle = articles.get(position).getPrix();

        holder.txtNom.setText(nomArticle);
        holder.txtPrix.setText(String.valueOf(prixArticle));
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtNom;
        TextView txtPrix;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
             txtNom = itemView.findViewById(R.id.LA_txtNomArticle);
             txtPrix = itemView.findViewById(R.id.LA_txtPrix);
        }
    }

}
